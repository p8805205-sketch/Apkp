# Sumber Ilmu

Aplikasi Android pembelajaran multi-jenjang. Vertical slice pertama berisi **Matematika SD Kelas 5 Kurikulum Merdeka** berdasarkan buku siswa tahun 2022.

## Fitur awal

- Katalog SD → Kelas 5 → Matematika → Semester 1.
- Sembilan bab dan seluruh subbab utama.
- Tujuan pembelajaran, kata kunci, ringkasan, contoh soal, dan langkah pembahasan.
- Quiz 25 soal per bab, total 225 soal yang dibentuk dari bank generator offline.
- Nilai kelulusan 75.
- Umpan balik ketika jawaban benar atau salah.
- Halaman skor dan pembahasan seluruh jawaban.
- Progres materi, nilai terakhir, nilai terbaik, percobaan, dan badge.
- Penyimpanan progres lokal.
- GitHub Actions untuk validasi, lint, unit test, build APK debug, dan upload artifact.

## Teknologi

- Kotlin 2.1.21
- Jetpack Compose + Material 3
- Android Gradle Plugin 8.11.1
- Gradle 8.13
- Minimum Android 8.0 / API 26
- Compile dan target SDK 36

## Menjalankan secara lokal

Gunakan Android Studio dengan JDK 17, lalu jalankan konfigurasi `app`.

Linux/macOS:

```bash
chmod +x gradlew
./gradlew assembleDebug
```

Windows:

```bat
gradlew.bat assembleDebug
```

APK debug tersedia di:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Validasi konten

```bash
python scripts/validate_content.py
```

Validator memastikan identitas aplikasi, sembilan definisi bab, 25 soal per bab, dan batas nilai 75 tersedia pada katalog offline.

## GitHub Actions

Workflow `Android CI` berjalan pada branch utama, branch fitur, dan pull request:

```text
Validasi konten → Lint → Unit test → Build APK debug → Upload artifact
```

## Struktur utama

```text
app/src/main/java/com/sumberilmu/app/
├── AppViewModel.kt
├── MainActivity.kt
├── data/
│   ├── GeneratedContent.kt
│   ├── Models.kt
│   └── ProgressRepository.kt
├── domain/
└── ui/
```

## Tahap pengembangan berikutnya

- Ganti konten generator dengan data terkurasi per soal dari pipeline PDF.
- Tambahkan Room untuk cache dan progres terstruktur.
- Tambahkan Supabase Auth, PostgreSQL, dan Storage.
- Sinkronisasi progres lintas perangkat.
- Dashboard admin web.
- Upload PDF dengan status draft, review, dan published.
- Quiz gabungan beberapa bab.
- Dukungan mata pelajaran dan jenjang tambahan.
