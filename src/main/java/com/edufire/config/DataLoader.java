package com.edufire.config;

import com.edufire.model.ActivityLog;
import com.edufire.model.FireHydrant;
import com.edufire.model.Module;
import com.edufire.model.QuizQuestion;
import com.edufire.model.User;
import com.edufire.repository.ActivityLogRepository;
import com.edufire.repository.FireHydrantRepository;
import com.edufire.repository.ModuleRepository;
import com.edufire.repository.QuizQuestionRepository;
import com.edufire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private FireHydrantRepository fireHydrantRepository;

    @Override
    public void run(String... args) throws Exception {
        // 1. Seed User
        if (userRepository.count() == 0) {
            User budi = new User(
                    null,
                    "Budi",
                    "Budi13311",
                    "2006-01-16",
                    "budigaming01@gmail.com",
                    "081234563271",
                    "password123",
                    159,
                    3,
                    65,
                    "#12",
                    "Pahlawan Pemula"
            );
            userRepository.save(budi);

            // Seed Activity Logs
            activityLogRepository.save(new ActivityLog(null, 1L, "Menyelesaikan Kuis 2", "2 jam yang lalu", "+10 Poin"));
            activityLogRepository.save(new ActivityLog(null, 1L, "Membuka Modul 3", "Kemarin", "+5 Poin"));
            activityLogRepository.save(new ActivityLog(null, 1L, "Menyelesaikan Modul 5", "3 hari yang lalu", "+25 Poin"));
            activityLogRepository.save(new ActivityLog(null, 1L, "Mendaftar Akun", "5 hari yang lalu", "+50 Poin"));
        }

        // 2. Seed Modules
        if (moduleRepository.count() == 0) {
            moduleRepository.save(new Module(
                    null,
                    "Pengenalan Jalur Evakuasi",
                    "Pelajari cara menemukan pintu dan jendela darurat dengan cepat di berbagai kondisi gedung.",
                    "Jalur evakuasi adalah rute perjalanan yang aman, terencana, dan terarah dari setiap tempat dalam bangunan atau gedung menuju ke tempat yang aman di luar gedung pada saat terjadi keadaan darurat, seperti kebakaran.\n\n" +
                    "Beberapa hal penting terkait jalur evakuasi:\n" +
                    "1. Perhatikan tanda penunjuk arah bertuliskan EXIT atau EVAKUASI yang biasanya menyala hijau di dinding atau koridor.\n" +
                    "2. Hindari menggunakan lift saat terjadi kebakaran; selalu gunakan tangga darurat.\n" +
                    "3. Jaga tangga darurat dan koridor tetap bersih dari barang-barang yang dapat menghalangi jalan.\n" +
                    "4. Pahami titik kumpul utama (Assembly Point) di luar gedung sebagai tujuan akhir evakuasi.",
                    10,
                    85,
                    true,
                    "materi-icon-evakuasi",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M18 8h4v12h-4z\"/><path d=\"M2 20h12v-6H2z\"/><path d=\"M6 14v-4a4 4 0 0 1 4-4h2\"/><path d=\"m10 2 4 4-4 4\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Teknik Dasar APAR",
                    "Metode PASS: Pull, Aim, Squeeze, dan Sweep untuk memadamkan api kecil secara efektif.",
                    "APAR (Alat Pemadam Api Ringan) adalah alat perlindungan kebakaran aktif yang digunakan untuk memadamkan api kecil atau mengendalikan kebakaran kecil dalam situasi darurat.\n\n" +
                    "Langkah menggunakan APAR dengan metode P.A.S.S:\n" +
                    "1. **P - Pull (Tarik pin pengaman):** Tarik segel plastik dan cabut pin pengaman yang mengunci tuas APAR.\n" +
                    "2. **A - Aim (Arahkan nozzle):** Arahkan corong atau selang pemadam ke sumber api (pangkal api), bukan ke lidah api.\n" +
                    "3. **S - Squeeze (Tekan tuas):** Tekan tuas APAR untuk menyemburkan media pemadam.\n" +
                    "4. **S - Sweep (Sapukan ke kiri dan kanan):** Sapukan semburan media secara merata dari satu sisi ke sisi lain hingga api padam.",
                    15,
                    40,
                    false,
                    "materi-icon-apar",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M8 19h8v3H8z\"/><path d=\"M12 2v6\"/><path d=\"M9 5h6\"/><rect x=\"7\" y=\"8\" width=\"10\" height=\"11\" rx=\"2\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Manajemen Titik Kumpul",
                    "Apa yang harus dilakukan setelah berhasil keluar dari gedung dan melapor ke petugas.",
                    "Setelah berhasil keluar dari gedung melalui jalur evakuasi, tindakan berikutnya sangat menentukan keselamatan semua orang.\n\n" +
                    "Langkah di Titik Kumpul:\n" +
                    "1. Segera menuju ke area lapang yang ditandai dengan rambu 'Titik Kumpul' (Assembly Point).\n" +
                    "2. Jangan kembali masuk ke dalam gedung yang terbakar dengan alasan apa pun untuk mengambil barang.\n" +
                    "3. Laporkan diri Anda ke petugas keselamatan gedung atau kapten lantai (Floor Captain) untuk proses penghitungan jumlah orang (headcount).\n" +
                    "4. Laporkan segera jika Anda mengetahui ada rekan kerja atau anggota keluarga yang masih terjebak di dalam gedung agar tim pemadam dapat memprioritaskan penyelamatan.",
                    8,
                    0,
                    false,
                    "materi-icon-titik",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2\"/><circle cx=\"9\" cy=\"7\" r=\"4\"/><path d=\"M23 21v-2a4 4 0 0 0-3-3.87\"/><path d=\"M16 3.13a4 4 0 0 1 0 7.75\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "P3K Luka Bakar",
                    "Langkah awal menangani luka bakar ringan hingga berat sebelum bantuan medis tiba.",
                    "Luka bakar memerlukan penanganan pertama yang cepat dan benar untuk mencegah kerusakan jaringan kulit yang lebih parah.\n\n" +
                    "Pertolongan Pertama Luka Bakar:\n" +
                    "1. **Dinginkan luka:** Siram bagian yang terbakar dengan air mengalir (bukan air es) selama 10-20 menit.\n" +
                    "2. **Lepaskan perhiasan:** Segera lepaskan cincin, gelang, atau pakaian yang menempel di dekat luka sebelum bengkak terjadi.\n" +
                    "3. **Jangan pecahkan lepuhan:** Jika kulit menggelembung berisi cairan, jangan memecahkannya karena berisiko infeksi.\n" +
                    "4. **Tutup luka:** Tutup luka bakar secara longgar dengan perban steril atau kain bersih basah.\n" +
                    "5. **Hindari bahan rumahan:** Jangan pernah mengoleskan mentega, pasta gigi, kecap, atau es batu ke atas luka bakar.",
                    12,
                    0,
                    false,
                    "materi-icon-p3k",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><rect x=\"2\" y=\"6\" width=\"20\" height=\"14\" rx=\"2\" ry=\"2\"/><path d=\"M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16\"/><path d=\"M12 10v6\"/><path d=\"M9 13h6\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Identifikasi Risiko",
                    "Mengenali potensi bahaya arus pendek dan kebocoran gas di lingkungan rumah tangga.",
                    "Pencegahan kebakaran dimulai dari rumah. Dua penyebab utama kebakaran rumah tangga adalah korsleting listrik dan kebocoran tabung gas LPG.\n\n" +
                    "Langkah Pencegahan:\n" +
                    "1. Hindari menumpuk steker (colokan) terlalu banyak pada satu stopkontak.\n" +
                    "2. Ganti kabel listrik yang terkelupas atau stopkontak yang sudah longgar.\n" +
                    "3. Bersihkan debu pada kipas angin, kulkas, dan perangkat elektronik lainnya agar tidak panas berlebih.\n" +
                    "4. Selalu periksa selang dan regulator tabung gas. Jika tercium bau gas (belerang), jangan menyalakan kompor atau sakelar lampu; segera buka pintu dan jendela lebar-lebar.",
                    15,
                    100,
                    false,
                    "materi-icon-risiko",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3Z\"/><line x1=\"12\" y1=\"9\" x2=\"12\" y2=\"13\"/><line x1=\"12\" y1=\"17\" x2=\"12.01\" y2=\"17\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Sistem Alarm Gedung",
                    "Mengenal berbagai jenis bunyi peringatan dan cara kerja sistem deteksi dini.",
                    "Sistem alarm gedung dirancang untuk mendeteksi tanda-tanda kebakaran sejak dini dan memperingatkan seluruh penghuni gedung secara otomatis.\n\n" +
                    "Jenis Komponen Sistem Alarm:\n" +
                    "1. **Detektor Asap (Smoke Detector):** Alat sensor langit-langit yang mendeteksi partikel asap.\n" +
                    "2. **Detektor Panas (Heat Detector):** Sensor yang aktif apabila suhu ruangan naik drastis melampaui batas tertentu (biasanya 58°C - 65°C).\n" +
                    "3. **Manual Call Point (MCP / Breakglass):** Tombol darurat di dinding yang dapat dipecahkan kacanya untuk menyalakan alarm secara manual saat Anda mendeteksi kebakaran.\n" +
                    "4. **Horn/Strobe:** Bell, klakson, atau lampu kilat darurat yang berbunyi nyaring untuk memerintahkan evakuasi.",
                    10,
                    5,
                    false,
                    "materi-icon-alarm",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M10.29 3.86L1.82 18a2 2 0 0 0 1.71 3h16.94a2 2 0 0 0 1.71-3L13.71 3.86a2 2 0 0 0-3.42 0z\"/><line x1=\"12\" y1=\"9\" x2=\"12\" y2=\"13\"/><line x1=\"12\" y1=\"17\" x2=\"12.01\" y2=\"17\"/></svg>"
            ));
        }

        // 3. Seed Quiz Questions for Module 1
        if (quizQuestionRepository.count() == 0) {
            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    1,
                    "Apa kepanjangan dari APAR?",
                    "Alat Pemadam Api Ringan",
                    "Alat Pembuat Angin Rata",
                    "Alat Penolong Air Runtuh",
                    "Alat Pengaman Api Rumah",
                    "A",
                    "APAR adalah singkatan dari Alat Pemadam Api Ringan."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    2,
                    "Saat terjadi kebakaran di gedung bertingkat, fasilitas apa yang TIDAK boleh digunakan untuk evakuasi?",
                    "Tangga darurat",
                    "Lift / Elevator",
                    "Jendela darurat",
                    "Pintu darurat lantai bawah",
                    "B",
                    "Lift tidak boleh digunakan saat kebakaran karena berisiko terjebak akibat pemadaman listrik atau asap racun yang masuk ke lorong lift."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    3,
                    "Apa yang harus dilakukan jika terjebak di ruangan penuh asap?",
                    "Berdiri dan berlari secepat mungkin ke pintu keluar terdekat.",
                    "Merangkak rendah di bawah asap untuk mencari jalan keluar.",
                    "Membuka semua jendela untuk membiarkan asap keluar sebelum bergerak.",
                    "Bersembunyi di dalam lemari atau di bawah tempat tidur sampai bantuan datang.",
                    "B",
                    "Asap kebakaran cenderung membumbung ke atas. Udara bersih dan dingin berada dekat lantai, sehingga merangkak di bawah asap meminimalisir menghirup gas beracun."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    4,
                    "Berapa durasi minimal menyiram luka bakar ringan dengan air mengalir?",
                    "1-2 menit",
                    "5 menit",
                    "10-20 menit",
                    "1 jam",
                    "C",
                    "Menyiram luka bakar dengan air mengalir selama minimal 10-20 menit membantu menurunkan suhu jaringan kulit secara efektif."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    5,
                    "Manakah di bawah ini bahan yang aman dioleskan pada luka bakar baru?",
                    "Pasta gigi",
                    "Mentega",
                    "Kecap",
                    "Tidak ada yang di atas (hanya air bersih mengalir)",
                    "D",
                    "Mengoleskan bahan dapur seperti pasta gigi, kecap, atau mentega justru memerangkap panas di dalam kulit dan meningkatkan risiko infeksi bakteri."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    6,
                    "Huruf 'A' pada metode P.A.S.S dalam penggunaan APAR singkatan dari...",
                    "Aim (Arahkan corong ke dasar api)",
                    "Action (Ambil tindakan memadamkan)",
                    "Alert (Bunyikan tanda bahaya)",
                    "Allow (Izinkan api menyebar)",
                    "A",
                    "Aim berarti arahkan nozzle/corong pemadam ke pangkal sumber api."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    7,
                    "Di mana lokasi yang aman sebagai tujuan akhir proses evakuasi?",
                    "Kamar mandi terdekat",
                    "Titik Kumpul (Assembly Point) di luar gedung",
                    "Parkiran basemen",
                    "Rooftop gedung",
                    "B",
                    "Titik Kumpul berada di area luar terbuka yang aman dari runtuhan puing dan kobaran api."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    8,
                    "Jika mencium bau gas bocor yang pekat di dapur, tindakan pertama yang benar adalah...",
                    "Menyalakan lampu dapur untuk melihat tabung gas",
                    "Menghubungi pemadam menggunakan telepon di dapur",
                    "Membuka pintu dan jendela selebar-lebarnya agar gas keluar",
                    "Menyiram kompor gas dengan air",
                    "C",
                    "Membuka pintu/jendela membantu ventilasi gas agar tidak menumpuk. Menyalakan sakelar listrik (lampu) dapat menimbulkan percikan api terkecil yang bisa memicu ledakan gas."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    9,
                    "Alat di langit-langit yang mendeteksi partikel hasil pembakaran disebut...",
                    "Heat Detector (Detektor Panas)",
                    "Smoke Detector (Detektor Asap)",
                    "Manual Call Point (MCP)",
                    "Sprinkler",
                    "B",
                    "Smoke Detector dirancang untuk memantau keberadaan partikel asap secara otomatis."
            ));

            quizQuestionRepository.save(new QuizQuestion(
                    null,
                    1L,
                    10,
                    "Mengapa kita tidak boleh menumpuk terlalu banyak steker pada satu stopkontak?",
                    "Dapat menyebabkan beban listrik berlebih (overload) dan memicu kebakaran korsleting.",
                    "Dapat merusak steker secara mekanis.",
                    "Dapat membuat tagihan listrik menjadi sangat mahal.",
                    "Dapat memperlambat jaringan internet rumah.",
                    "A",
                    "Beban berlebih dapat menimbulkan panas berlebih pada kabel listrik, melelehkan isolasi pelindung, dan memicu korsleting listrik penyebab utama kebakaran."
            ));
        }

        // 4. Seed Fire Hydrants
        if (fireHydrantRepository.count() == 0) {
            // Seed points centered around North/West Jakarta
            fireHydrantRepository.save(new FireHydrant(null, "HID-061", "Hidran Gajah Mada 1", -6.1550, 106.8140, "Aktif"));
            fireHydrantRepository.save(new FireHydrant(null, "HID-001", "Hidran Istiqlal", -6.1685, 106.8315, "Aktif"));
            fireHydrantRepository.save(new FireHydrant(null, "HID-002", "Hidran Mangga Dua", -6.1360, 106.8250, "Aktif"));
            fireHydrantRepository.save(new FireHydrant(null, "HID-003", "Hidran Kota Tua", -6.1345, 106.8133, "Aktif"));
            fireHydrantRepository.save(new FireHydrant(null, "HID-004", "Hidran Sunter", -6.1400, 106.8700, "Aktif"));
            fireHydrantRepository.save(new FireHydrant(null, "HID-005", "Hidran Senayan", -6.2185, 106.8020, "Rusak"));
            fireHydrantRepository.save(new FireHydrant(null, "HID-006", "Hidran Kemayoran", -6.1600, 106.8450, "Aktif"));
        }
    }
}
