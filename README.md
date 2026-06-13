# Sumber Ilmu

Aplikasi Android pembelajaran multi-jenjang. Vertical slice pertama berisi **Matematika SD Kelas 5 Kurikulum Merdeka** berdasarkan buku siswa tahun 2022.

## Fitur saat ini

- Katalog SD → Kelas 5 → Matematika → Semester 1.
- Sembilan bab dan seluruh subbab utama.
- Bab 1–3 sudah dikurasi langsung dari PDF sumber:
  - Bilangan Cacah sampai 100.000.
  - KPK dan FPB.
  - Bilangan Pecahan.
- Total 75 soal terkurasi dengan empat opsi, jawaban benar, penjelasan, tingkat kesulitan, dan halaman sumber.
- Bab lainnya tetap tersedia melalui konten awal sambil menunggu proses kurasi.
- Tujuan pembelajaran, kata kunci, ringkasan, contoh soal, dan langkah pembahasan.
- Nilai kelulusan 75.
- Umpan balik langsung ketika jawaban benar atau salah.
- Halaman skor dan pembahasan seluruh jawaban.
- Progres materi, nilai terakhir, nilai terbaik, percobaan, dan badge.
- Penyimpanan progres lokal.
- UI/UX Material 3 dengan dashboard progres, kartu bab visual, materi yang dapat diperluas, quiz interaktif, dark mode, dan target sentuh yang nyaman.
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

Validator memeriksa identitas aplikasi, sembilan definisi bab, konfigurasi nilai lulus, struktur Bab 1–3, urutan ID soal 1–25, metadata kesulitan, opsi jawaban, dan halaman sumber.

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
│   ├── ChapterOneQuiz.kt
│   ├── ChapterTwoQuiz.kt
│   ├── ChapterThreeQuiz.kt
│   ├── GeneratedContent.kt
│   ├── Models.kt
│   └── ProgressRepository.kt
├── domain/
└── ui/
```

## Tahap pengembangan berikutnya

- Kurasi Bab 4–9 dari pipeline PDF.
- Pindahkan konten terkurasi ke JSON per bab.
- Tambahkan Room untuk cache dan progres terstruktur.
- Tambahkan Supabase Auth, PostgreSQL, dan Storage.
- Sinkronisasi progres lintas perangkat.
- Dashboard admin web.
- Upload PDF dengan status draft, review, dan published.
- Quiz gabungan beberapa bab.
- Dukungan mata pelajaran dan jenjang tambahan.
