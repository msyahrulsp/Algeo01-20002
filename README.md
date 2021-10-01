## Tugas Besar 1 IF2123 - Kelompok 31 "I Am Geprek"
Sebuah program Java yang bisa mencari solusi dari Sistem Persamaan Linier, Determinan, menemukan balikan dari suatu matriks, menyelesaikan persoalan interpolasi dan regresi linier. Untuk mencari solusi dari SPL, bisa menggunakan eliminasi Gauss, elimintasi Gauss-Jordan, menggunakan matriks balikan, dan kaidah Crammer. Untuk mencari determinan bisa menggunakan reduksi baris dan ekspansi kofaktor. Dan untuk balikan matriks, bisa menggunakan Gauss-Jordan dan Adjoin.

## Struktur Folder
```sh
Algeo01-20002
├── bin                     # Berisi java byte code (*.class)
├── src                     # Berisi source code dari program java
│   ├── Library             # Berisi method utama dari matriks
│   ├── matriks             # Berisi class matriks
│   └── util                # Berisi class utilitas
├── test                    # Berisi data uji
├── doc                     # Berisi laporan
└── lib                     # Berisi library (*.jar) yang dibuat
```

## Cara pakai
- Pastikan versi JDK anda [JDK 16](https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.12+7/OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi)
- Pastikan ada [Git](https://git-scm.com/) juga
### Menjalankan Program Langsung
1. Clone repo ini: `git clone https://github.com/msyahrulsp/Algeo01-20002.git Algeo01-20002`
2. Pergi ke Algeo01-20002: `cd Algeo01-20002`
3. Jalankan run.bat: `run.bat`

### Jika Ingin Mengedit Program, Lakukan Langkah di bawah (Setelah diclone)
1. Pergi ke src: `cd src`
2. Compile Program yang telah diedit: `javac -d ../bin ./Main.java`
3. Pergi ke bin: `cd ../bin`
4. Jalankan Main.class: `java Main`

## Anggota Kelompok:
| NIM      | NAMA                   |
|----------|------------------------|
| 13520002 | Muhammad Fikri Ranjabi | 
| 13520066 | Putri Nurhaliza        | 
| 13520161 | M Syahrul Surya Putra  |