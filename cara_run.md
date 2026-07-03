### Cara 1: Menggunakan Terminal (Command Line)                                                
                                                                                                 
  1. Buka terminal atau command prompt Anda.                                                     
  2. Masuk ke direktori/folder project ini:                                                      
    cd /yourdirectory/EduFire                                                 
  
  3. Jalankan perintah berikut untuk mengompilasi dan memulai server Spring Boot:
    ./mvnw spring-boot:run
    (Gunakan  mvnw.cmd spring-boot:run  jika Anda menggunakan OS Windows).
  4. Untuk menghentikan server, tekan tombol  Ctrl + C  di terminal tersebut.
  ──────
  ### Cara 2: Menggunakan IDE (IntelliJ IDEA / VS Code / Eclipse)
  
  1. Buka folder project EduFire di IDE pilihan Anda.
  2. Tunggu hingga IDE selesai memuat dependensi Maven (biasanya ditandai dengan proses indexing 
  atau downloading di bagian bawah).
  3. Cari berkas class utama aplikasi di:
  EdufireApplication.java
  4. Klik kanan pada berkas tersebut, lalu pilih Run 'EdufireApplication' (atau klik tombol ikon 
  segitiga Play berwarna hijau di IDE Anda).