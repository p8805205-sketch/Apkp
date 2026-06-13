# Audit Runtime Quiz

Branch ini menjalankan audit semantik terhadap 225 soal Bab 1–9 untuk menemukan prompt fragmen, opsi tidak valid, pembahasan terlalu pendek, dan referensi halaman yang tidak sesuai.

Laporan lengkap ditulis ke `lint-debug.log` pada root workspace agar tetap tersedia melalui artifact diagnostik ketika unit test sengaja gagal.
