# Skor Badminton

Aplikasi web sederhana untuk membantu wasit mencatat skor pertandingan badminton secara real-time.

## Preview

🌐 **Coba aplikasi secara langsung:**  
<https://hitung-skor-badminton--azimaf.replit.app/>

![Preview aplikasi Skor Badminton](https://image.thum.io/get/width/1280/crop/900/https://hitung-skor-badminton--azimaf.replit.app/)

> Jika gambar preview belum muncul saat pertama kali membuka README, tunggu beberapa saat lalu refresh halaman GitHub. Preview dibuat dari URL aplikasi publik di Replit.

## Fitur

- Mengisi nama Tim A dan Tim B.
- Memilih warna kotak skor untuk masing-masing tim.
- Preview warna kotak secara langsung sebelum disimpan.
- Menambah skor dengan tombol `+1`.
- Mengurangi skor dengan tombol `-1`.
- Mencegah skor menjadi negatif.
- Menampilkan status pertandingan dan pemenang.
- Mendukung aturan deuce pada skor `20 - 20`.
- Pertandingan selesai jika salah satu tim unggul minimal 2 poin setelah mencapai 21.
- Tombol reset untuk mengembalikan skor dan warna ke kondisi awal.
- Tampilan responsif untuk desktop, tablet, dan mobile.

## Aturan skor

1. Pertandingan dimulai dari skor `0 - 0`.
2. Saat skor mencapai `20 - 20`, status berubah menjadi **Deuce**.
3. Setelah deuce, tim harus unggul 2 poin untuk memenangkan game.
4. Contoh skor menang: `21 - 19`, `22 - 20`, atau `24 - 22`.
5. Tombol skor tidak dapat digunakan lagi setelah game selesai.

## Teknologi

- Java 17+
- Spring Boot 3
- Spring MVC
- Thymeleaf
- Maven
- HTML, CSS, dan JavaScript

## Menjalankan di komputer lokal

Pastikan Java JDK dan Maven tersedia, lalu jalankan:

```powershell
cd F:\Kerjaan\hitung-skor-badminton
mvn spring-boot:run
```

Jika Maven lokal belum tersedia, gunakan Maven yang tersedia di repository:

```powershell
cd F:\Kerjaan\hitung-skor-badminton
.\maven\apache-maven-3.9.9\bin\mvn.cmd spring-boot:run
```

Buka browser ke:

<http://localhost:8080>

Port dapat diubah melalui environment variable `PORT`:

```powershell
$env:PORT = 8081
.\maven\apache-maven-3.9.9\bin\mvn.cmd spring-boot:run
```

## Struktur utama

```text
src/
├── main/
│   ├── java/com/badminton/score/
│   │   ├── BadmintonScoreApplication.java
│   │   ├── controller/MatchController.java
│   │   ├── model/MatchScore.java
│   │   └── service/MatchService.java
│   └── resources/
│       ├── templates/index.html
│       └── application.properties
└── test/
    └── java/com/badminton/score/service/MatchServiceTest.java
```

## Menjalankan test

```powershell
mvn test
```

Atau menggunakan Maven lokal di repository:

```powershell
.\maven\apache-maven-3.9.9\bin\mvn.cmd test
```

## Deployment

Aplikasi saat ini tersedia secara publik melalui Replit:

<https://hitung-skor-badminton--azimaf.replit.app/>

Konfigurasi `.replit` sudah menyediakan perintah build dan start dengan port yang diberikan oleh platform:

```bash
mvn -B -DskipTests package && java -Dserver.port=$PORT -jar target/*.jar
```

Repository GitHub:

<https://github.com/AzimaF/hitung-skor-badminton>

## Lisensi

Project ini dibuat untuk pembelajaran dan penggunaan demo.
