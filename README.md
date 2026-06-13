# Sumber Ilmu

Aplikasi Android pembelajaran multi-jenjang. Vertical slice pertama berisi **Matematika SD Kelas 5 Kurikulum Merdeka** berdasarkan buku siswa tahun 2022.

## Fitur saat ini

- Katalog SD → Kelas 5 → Matematika → Semester 1.
- Seluruh sembilan bab dan subbab utama sudah dikurasi dari PDF sumber:
  - Bilangan Cacah sampai 100.000.
  - KPK dan FPB.
  - Bilangan Pecahan.
  - Keliling Bangun Datar.
  - Luas Daerah Bangun Datar.
  - Sudut.
  - Membandingkan Ciri-Ciri Bangun Datar.
  - Data.
  - Bilangan Cacah Sampai 1.000.000.
- Total 225 soal terkurasi dengan empat opsi, jawaban benar, penjelasan, tingkat kesulitan, dan halaman sumber.
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
- Laboratorium Nilai Tempat dengan pengubah digit, pembacaan bilangan Indonesia, dekomposisi, perbandingan, dan pengurutan pada Bab 9.
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

Validator memeriksa identitas aplikasi, seluruh sembilan bab, nilai lulus, urutan ID soal 1–25, 25 set opsi per bab, audit sumber Bab 7 dan Bab 9, hasil numerik Bab 8–9, formatter bilangan 0–1.000.000, serta koneksi laboratorium visual Bab 6–9.

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
│   ├── CuratedChapterNine.kt
│   ├── Chapter*Quiz*.kt
│   ├── CuratedQuestionFactory.kt
│   ├── IndonesianNumberFormatter.kt
│   ├── GeneratedContent.kt
│   ├── Models.kt
│   └── ProgressRepository.kt
├── domain/
└── ui/
    ├── AngleLearningVisual.kt
    ├── ShapeComparisonVisual.kt
    ├── DataLearningVisual.kt
    ├── PlaceValueLearningVisual.kt
    └── ...
```

## Tahap pengembangan berikutnya

- Migrasikan konten terkurasi dari objek Kotlin ke JSON per bab dengan schema versioning.
- Tambahkan Room untuk cache materi dan progres terstruktur.
- Tambahkan Supabase Auth, PostgreSQL, Storage, dan Row Level Security.
- Sinkronisasi progres lintas perangkat.
- Bangun dashboard admin web untuk upload PDF, review konten, dan publikasi.
- Tambahkan quiz gabungan beberapa bab dan asesmen semester.
- Tambahkan dukungan mata pelajaran, kelas, dan jenjang lain.
