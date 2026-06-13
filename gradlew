#!/usr/bin/env sh
set -eu

GRADLE_VERSION="8.13"
BOOTSTRAP_HOME="${GRADLE_USER_HOME:-$HOME/.gradle}/bootstrap"
GRADLE_HOME="$BOOTSTRAP_HOME/gradle-$GRADLE_VERSION"
ARCHIVE="$BOOTSTRAP_HOME/gradle-$GRADLE_VERSION-bin.zip"
URL="https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip"

if [ ! -x "$GRADLE_HOME/bin/gradle" ]; then
  mkdir -p "$BOOTSTRAP_HOME"
  if [ ! -f "$ARCHIVE" ]; then
    if command -v curl >/dev/null 2>&1; then
      curl -fL "$URL" -o "$ARCHIVE"
    elif command -v wget >/dev/null 2>&1; then
      wget "$URL" -O "$ARCHIVE"
    else
      echo "curl or wget is required to bootstrap Gradle." >&2
      exit 1
    fi
  fi
  rm -rf "$GRADLE_HOME"
  unzip -q "$ARCHIVE" -d "$BOOTSTRAP_HOME"
fi

exec "$GRADLE_HOME/bin/gradle" "$@"
