@echo off
setlocal
set GRADLE_VERSION=8.13
if "%GRADLE_USER_HOME%"=="" (
  set BOOTSTRAP_HOME=%USERPROFILE%\.gradle\bootstrap
) else (
  set BOOTSTRAP_HOME=%GRADLE_USER_HOME%\bootstrap
)
set GRADLE_HOME=%BOOTSTRAP_HOME%\gradle-%GRADLE_VERSION%
set ARCHIVE=%BOOTSTRAP_HOME%\gradle-%GRADLE_VERSION%-bin.zip
set URL=https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip

if not exist "%GRADLE_HOME%\bin\gradle.bat" (
  if not exist "%BOOTSTRAP_HOME%" mkdir "%BOOTSTRAP_HOME%"
  if not exist "%ARCHIVE%" (
    powershell -NoProfile -ExecutionPolicy Bypass -Command ^
      "Invoke-WebRequest -UseBasicParsing '%URL%' -OutFile '%ARCHIVE%'"
    if errorlevel 1 exit /b 1
  )
  powershell -NoProfile -ExecutionPolicy Bypass -Command ^
    "Expand-Archive -Force '%ARCHIVE%' '%BOOTSTRAP_HOME%'"
  if errorlevel 1 exit /b 1
)

call "%GRADLE_HOME%\bin\gradle.bat" %*
