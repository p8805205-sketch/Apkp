# Sumber Ilmu

Aplikasi Android pembelajaran multi-jenjang. Vertical slice pertama berisi **Matematika SD Kelas 5 Kurikulum Merdeka** berdasarkan buku siswa tahun 2022.

## Fitur yang sudah tersedia

- Katalog SD → Kelas 5 → Matematika → Semester 1.
- Sembilan bab dan seluruh subbab utama.
- Tujuan pembelajaran, kata kunci, ringkasan, pembahasan, dan contoh soal.
- Quiz 25 soal untuk setiap bab, total 225 soal.
- Nilai kelulusan 75.
- Umpan balik langsung untuk jawaban salah.
- Halaman hasil dan pembahasan seluruh jawaban.
- Progres materi, nilai terakhir, nilai terbaik, percobaan, dan badge.
- Penyimpanan progres lokal.
- GitHub Actions untuk validasi, lint, test, APK debug, APK/AAB release.

## Teknologi

- Kotlin 2.1.21
- Jetpack Compose + Material 3
- Android Gradle Plugin 8.11.1
- Gradle 8.13
- Minimum Android 8.0 / API 26
- Compile dan target SDK 36

## Menjalankan secara lokal

### Android Studio

1. Buka folder repository.
2. Gunakan JDK 17.
3. Tunggu Gradle sync.
4. Jalankan konfigurasi `app`.

### Command line

Linux/macOS:

```bash
chmod +x gradlew
./gradlew assembleDebug
```

Windows:

```bat
gradlew.bat assembleDebug
```

Script bootstrap akan mengunduh Gradle 8.13 pada penggunaan pertama.

APK debug:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Validasi konten

```bash
python scripts/validate_content.py
```

Validator memastikan:

- sembilan bab tersedia;
- setiap bab memiliki 25 soal;
- seluruh ID unik;
- setiap soal memiliki empat pilihan;
- indeks jawaban benar valid;
- penjelasan jawaban tersedia.

## GitHub Actions

### Android CI

Berjalan pada push dan pull request:

```text
Validasi konten → Lint → Unit test → Build APK debug → Upload artifact
```

### Android Release

Berjalan ketika tag `v*` dibuat. Tambahkan secrets:

```text
ANDROID_KEYSTORE_BASE64
ANDROID_KEYSTORE_PASSWORD
ANDROID_KEY_ALIAS
ANDROID_KEY_PASSWORD
```

Contoh rilis:

```bash
git tag v0.1.0
git push origin v0.1.0
```

Workflow menghasilkan APK dan AAB bertanda tangan lalu membuat GitHub Release.

## Struktur utama

```text
app/src/main/
├── assets/content.json
├── java/com/sumberilmu/app/
│   ├── AppViewModel.kt
│   ├── MainActivity.kt
│   ├── data/
│   ├── domain/
│   └── ui/
└── res/
```

## Tahap pengembangan berikutnya

- Room untuk cache dan progres terstruktur.
- Supabase Auth, PostgreSQL, dan Storage.
- Sinkronisasi progres lintas perangkat.
- Dashboard admin web.
- Upload PDF dan status draft/review/published.
- Quiz gabungan beberapa bab.
- Dukungan mata pelajaran dan jenjang tambahan.
