# Sumber Ilmu

Aplikasi Android pembelajaran multi-jenjang. Vertical slice pertama berisi **Matematika SD Kelas 5 Kurikulum Merdeka** berdasarkan buku siswa tahun 2022.

## Fitur saat ini

- Katalog SD → Kelas 5 → Matematika → Semester 1.
- Sembilan bab dan seluruh subbab utama.
- Bab 1–8 sudah dikurasi:
  - Bilangan Cacah sampai 100.000.
  - KPK dan FPB.
  - Bilangan Pecahan.
  - Keliling Bangun Datar.
  - Luas Daerah Bangun Datar.
  - Sudut.
  - Membandingkan Ciri-Ciri Bangun Datar.
  - Data.
- Total 200 soal terkurasi dengan empat opsi, jawaban benar, penjelasan, tingkat kesulitan, dan halaman sumber.
- Bab 9 tetap tersedia melalui konten awal sambil menunggu kurasi.
- Tujuan pembelajaran, kata kunci, ringkasan, contoh soal, dan langkah pembahasan.
- Nilai kelulusan 75.
- Umpan balik langsung ketika jawaban benar atau salah.
- Halaman skor dan pembahasan seluruh jawaban.
- Progres materi, nilai terakhir, nilai terbaik, percobaan, dan badge.
- Penyimpanan progres lokal.
- UI/UX Material 3 dengan dashboard progres, learning path, pencarian katalog, kartu bab visual, materi yang dapat diperluas, quiz interaktif, dark mode, dan target sentuh yang nyaman.
- Laboratorium Sudut berbasis Compose Canvas pada Bab 6.
- Laboratorium Pembanding Bangun Datar berbasis Compose Canvas pada Bab 7.
- Laboratorium Data dengan tabel, piktogram, batang vertikal, batang horizontal, dan batang ganda pada Bab 8.
- GitHub Actions untuk validasi, lint, unit test, build APK debug, diagnostik lint, dan upload artifact.

## Kontrak arsitektur konten

- [Struktur akademik](docs/academic-structure.md)
- [Alur PDF menjadi materi](docs/pdf-content-pipeline.md)
- [Tata letak proyek](docs/project-layout.md)

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

Validator memeriksa identitas aplikasi, sembilan definisi bab, nilai lulus, struktur Bab 1–8, urutan ID soal 1–25, 25 set opsi per bab, audit sumber Bab 7, angka dan hasil Bab 8, serta koneksi laboratorium visual Bab 6–8.

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
│   ├── CuratedChapterOne.kt
│   ├── CuratedChapterTwo.kt
│   ├── CuratedChapterThree.kt
│   ├── CuratedChapterFour.kt
│   ├── CuratedChapterFive.kt
│   ├── CuratedChapterSix.kt
│   ├── CuratedChapterSeven.kt
│   ├── CuratedChapterEight.kt
│   ├── Chapter*Quiz*.kt
│   ├── CuratedQuestionFactory.kt
│   ├── GeneratedContent.kt
│   ├── Models.kt
│   └── ProgressRepository.kt
├── domain/
└── ui/
    ├── AngleLearningVisual.kt
    ├── ShapeComparisonVisual.kt
    ├── DataLearningVisual.kt
    └── ...
```

## Tahap pengembangan berikutnya

- Kurasi Bab 9 dari pipeline PDF.
- Pindahkan konten terkurasi ke JSON per bab.
- Tambahkan Room untuk cache dan progres terstruktur.
- Tambahkan Supabase Auth, PostgreSQL, dan Storage.
- Sinkronisasi progres lintas perangkat.
- Dashboard admin web.
- Upload PDF dengan status draft, review, dan published.
- Quiz gabungan beberapa bab.
- Dukungan mata pelajaran dan jenjang tambahan.
