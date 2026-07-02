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
                    "Panduan komprehensif penentuan rute penyelamatan diri, identifikasi tanda darurat, dan prosedur keselamatan keluar dari gedung.",
                    "Jalur evakuasi merupakan rute penyelamatan yang dirancang secara khusus untuk memfasilitasi pergerakan cepat dan aman bagi seluruh penghuni gedung dari dalam bangunan menuju ke area titik kumpul (Assembly Point) di luar gedung saat terjadi keadaan darurat, seperti kebakaran, gempa bumi, atau ancaman bahaya lainnya. Pemahaman mendalam mengenai jalur ini sangat krusial karena dalam situasi darurat, setiap detik sangatlah berharga untuk meminimalkan risiko cedera dan korban jiwa.\n\n" +
                    "Secara struktural, jalur evakuasi wajib memenuhi standar keselamatan internasional maupun regulasi lokal (seperti standar damkar dan keselamatan kerja). Jalur ini harus bebas dari hambatan fisik, memiliki pencahayaan darurat (emergency lighting) yang aktif saat listrik padam, serta dilengkapi dengan papan penunjuk arah darurat (exit sign) berwarna hijau neon yang menyala terus-menerus.\n\n" +
                    "<strong>Beberapa prinsip utama dalam menggunakan jalur evakuasi meliputi:</strong>\n\n" +
                    "1. <strong>Identifikasi Tanda Keluar (EXIT):</strong> Selalu perhatikan rambu evakuasi berbentuk simbol orang berlari berwarna hijau. Rambu ini diletakkan di atas pintu darurat, koridor utama, dan persimpangan lorong untuk menunjukkan arah tercepat keluar dari gedung.\n\n" +
                    "2. <strong>Hindari Lift saat Kebakaran:</strong> Ketika alarm kebakaran berbunyi, jangan pernah sekali-kali menggunakan lift atau eskalator. Lift rentan macet akibat pemadaman listrik darurat atau menjadi cerobong gas beracun. Gunakanlah selalu tangga darurat khusus yang didesain kedap asap dan tahan api.\n\n" +
                    "3. <strong>Sterilisasi Rute Evakuasi:</strong> Koridor, tangga darurat, dan akses keluar harus selalu bersih dari tumpukan barang, kardus, atau inventaris kantor. Hambatan kecil sekalipun dapat menyebabkan kepanikan atau tabrakan antar penghuni saat evakuasi massal terjadi.\n\n" +
                    "4. <strong>Lari Merunduk saat Asap Tebal:</strong> Asap kebakaran mengandung gas monoksida yang mematikan dan cenderung naik ke atas karena perbedaan suhu. Jika rute evakuasi Anda mulai dipenuhi asap, merangkaklah atau berjalan merunduk sedekat mungkin dengan lantai (sekitar 10-20 cm dari lantai), karena udara bersih dan dingin berada di bagian bawah.\n\n" +
                    "5. <strong>Menuju Titik Kumpul (Assembly Point):</strong> Evakuasi belum selesai sebelum Anda mencapai Titik Kumpul Utama di luar gedung. Tempat ini berada di lapangan terbuka yang jauh dari potensi runtuhan material bangunan atau kaca.",
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
                    "Alat Pemadam Api Ringan (APAR) atau fire extinguisher adalah peralatan pemadam kebakaran portabel yang wajib disediakan di setiap ruangan strategis untuk mengatasi kebakaran tahap awal (mula). APAR hanya efektif digunakan untuk mengendalikan api berskala kecil sebelum api menyebar di luar kendali. Menggunakan APAR memerlukan keterampilan teknis yang benar agar media pemadam bekerja maksimal dan keselamatan pengguna tetap terjaga.\n\n" +
                    "Sebelum memadamkan api, Anda harus memahami jenis kelas kebakaran yang sedang dihadapi (misalnya Kelas A untuk kertas/kayu, Kelas B untuk cairan bahan bakar, Kelas C untuk korsleting listrik, atau Kelas D untuk logam). Menggunakan media pemadam yang salah (seperti menyiramkan air pada kebakaran minyak atau listrik) justru dapat memperburuk situasi dan membahayakan nyawa Anda.\n\n" +
                    "<strong>Teknik memadamkan api menggunakan APAR didasarkan pada metode standar internasional P.A.S.S:</strong>\n\n" +
                    "1. <strong>P - Pull (Tarik Pin Pengaman):</strong> Letakkan APAR di lantai agar stabil, pegang leher tabung, lalu tarik segel pengaman dan cabut pin pengunci tuas. Pastikan Anda tidak menekan tuas saat mencabut pin agar pin tidak terjepit.\n\n" +
                    "2. <strong>A - Aim (Arahkan Nozzle/Selang):</strong> Angkat selang APAR dengan memegang bagian ujung corong (nozzle). Jangan memegang bagian tengah selang karena dapat mengurangi kontrol arah semburan. Arahkan corong tepat ke pangkal api (sumber bahan bakar yang terbakar), bukan ke bagian ujung lidah api yang berkobar di atas.\n\n" +
                    "3. <strong>S - Squeeze (Tekan Tuas):</strong> Tekan tuas secara penuh dan mantap untuk menyemburkan bahan pemadam (seperti dry chemical powder, CO2, atau foam). Tekanan tuas secara perlahan-lahan justru akan mengurangi daya dorong media pemadam.\n\n" +
                    "4. <strong>S - Sweep (Sapukan ke Kiri dan Kanan):</strong> Sapukan semburan media secara merata dari sisi ke sisi lainnya, secara perlahan menyelimuti seluruh area permukaan api. Majulah mendekat secara perlahan seiring dengan mulai padamnya api.\n\n" +
                    "<strong>Aturan Keselamatan Tambahan saat Memadamkan Api:</strong>\n\n" +
                    "Selalu posisikan diri Anda membelakangi arah angin (jangan menantang arah angin) agar asap dan panas tidak meniup ke arah wajah Anda. Selain itu, pastikan selalu ada rute pelarian yang aman di belakang Anda. Jika api membesar secara tiba-tiba, Anda harus segera mundur dan mengevakuasi diri menggunakan rute tersebut.",
                    15,
                    40,
                    false,
                    "materi-icon-apar",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M8 19h8v3H8z\"/><path d=\"M12 2v6\"/><path d=\"M9 5h6\"/><rect x=\"7\" y=\"8\" width=\"10\" height=\"11\" rx=\"2\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Manajemen Titik Kumpul",
                    "Prosedur keselamatan setelah berhasil keluar dari gedung, headcount, dan koordinasi darurat.",
                    "Titik Kumpul (Assembly Point) adalah area terbuka yang ditentukan dan dirancang khusus sebagai tempat berkumpulnya seluruh penghuni gedung setelah berhasil dievakuasi dari dalam bangunan saat terjadi keadaan darurat. Manajemen titik kumpul yang efektif adalah kunci untuk memastikan tidak ada korban yang tertinggal di dalam gedung dan mempermudah proses koordinasi dengan tim penyelamat eksternal.\n\n" +
                    "Banyak orang salah mengira bahwa setelah melangkahkan kaki keluar pintu gedung, proses evakuasi telah selesai. Faktanya, kepanikan yang tidak terkendali di luar gedung dapat menghalangi akses masuk mobil pemadam kebakaran atau ambulans, serta membahayakan keselamatan korban yang panik.\n\n" +
                    "<strong>Langkah Prosedural Penting di Area Titik Kumpul:</strong>\n\n" +
                    "1. <strong>Lakukan Headcount (Penghitungan Jumlah Orang):</strong> Setiap unit kerja atau lantai gedung biasanya dipimpin oleh seorang Floor Captain atau koordinator K3. Sesampainya di titik kumpul, segera laporkan diri Anda ke petugas terkait untuk dicatat dalam proses pencocokan daftar hadir (headcount).\n\n" +
                    "2. <strong>Laporkan Korban yang Hilang:</strong> Jika Anda mengetahui atau melihat rekan kerja/keluarga yang masih tertinggal di dalam gedung, segera sampaikan nama dan lokasi terakhir mereka kepada petugas penyelamat. Jangan sekali-kali mencoba masuk kembali ke dalam gedung sendiri untuk melakukan aksi penyelamatan personal.\n\n" +
                    "3. <strong>Patuhi Instruksi Petugas K3:</strong> Tetaplah berada di area titik kumpul yang ditentukan hingga kondisi dinyatakan benar-benar aman oleh otoritas pemadam kebakaran. Jangan membubarkan diri atau pulang ke rumah tanpa memberi tahu koordinator, karena hal ini dapat menimbulkan kepanikan akibat asumsi bahwa Anda masih terjebak di dalam reruntuhan.\n\n" +
                    "4. <strong>Berikan Jalur Bebas Hambatan:</strong> Pastikan kendaraan darurat memiliki akses masuk yang bersih menuju ke lokasi kebakaran. Jauhi jalan masuk mobil damkar dan jangan berkerumun menghalangi petugas medis yang sedang merawat korban luka.",
                    8,
                    0,
                    false,
                    "materi-icon-titik",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2\"/><circle cx=\"9\" cy=\"7\" r=\"4\"/><path d=\"M23 21v-2a4 4 0 0 0-3-3.87\"/><path d=\"M16 3.13a4 4 0 0 1 0 7.75\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "P3K Luka Bakar",
                    "Langkah awal menangani luka bakar ringan hingga berat sebelum bantuan medis tiba secara tepat.",
                    "Pertolongan Pertama pada Kecelakaan (P3K) untuk luka bakar merupakan tindakan medis awal yang bertujuan menghentikan proses pembakaran, mengurangi rasa sakit, mencegah timbulnya infeksi, serta meminimalkan derajat kerusakan jaringan kulit. Luka bakar dapat terjadi akibat paparan suhu panas kering (seperti api), panas basah (seperti air mendidih), zat kimia korosif, radiasi, maupun arus listrik.\n\n" +
                    "Kesalahan fatal dalam penanganan pertama luka bakar sering kali disebabkan oleh mitos masyarakat yang mempercayai penggunaan bahan-bahan rumahan yang sebenarnya berbahaya. Penanganan yang tidak tepat dapat menyebabkan infeksi bakteri serius, memperdalam kerusakan kulit, hingga meninggalkan bekas luka permanen (keloid).\n\n" +
                    "<strong>Langkah-Langkah Penanganan Luka Bakar Ringan (Derajat 1 & 2 Kecil):</strong>\n\n" +
                    "1. <strong>Dinginkan Luka dengan Air Mengalir:</strong> Segera siram bagian kulit yang terbakar dengan air mengalir bersuhu ruang selama minimal 10 hingga 20 menit. Hindari menggunakan air es atau es batu, karena perubahan suhu dingin yang ekstrem dapat merusak sel-sel kulit sehat di sekitarnya dan memicu radang dingin (frostbite).\n\n" +
                    "2. <strong>Lepaskan Benda di Sekitar Luka:</strong> Sebelum bagian tubuh yang terkena luka bakar mulai membengkak, segera lepaskan cincin, gelang, jam tangan, atau pakaian yang menempel erat di sekitar area tersebut. Namun, jika pakaian telah melekat erat pada luka bakar, jangan dipaksa lepas; biarkan tenaga medis profesional yang menanganinya.\n\n" +
                    "3. <strong>Jangan Memecahkan Lepuhan Kulit:</strong> Jika luka bakar menimbulkan gelembung kulit berisi cairan (bula), jangan pernah memecahkannya. Kulit gelembung tersebut berfungsi sebagai pelindung alami dari masuknya kuman dan bakteri. Jika gelembung pecah secara tidak sengaja, bersihkan dengan air mengalir dan oleskan salep antiseptik yang aman.\n\n" +
                    "4. <strong>Tutup Luka Secara Longgar:</strong> Tutup area luka bakar menggunakan kasa steril atau perban bersih basah secara longgar. Jangan mengikat perban terlalu kencang agar tidak menekan kulit yang sensitif dan bengkak.\n\n" +
                    "5. <strong>PENTING: Jauhi Bahan Mitos:</strong> Jangan pernah mengoleskan mentega, minyak goreng, kecap, pasta gigi (odol), atau sabun ke luka bakar. Bahan-bahan tersebut bersifat memerangkap panas di dalam kulit, menyumbat pori-pori, dan menjadi media pertumbuhan bakteri yang subur.",
                    12,
                    0,
                    false,
                    "materi-icon-p3k",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><rect x=\"2\" y=\"6\" width=\"20\" height=\"14\" rx=\"2\" ry=\"2\"/><path d=\"M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16\"/><path d=\"M12 10v6\"/><path d=\"M9 13h6\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Identifikasi Risiko",
                    "Mengenali potensi bahaya arus pendek dan kebocoran gas di lingkungan rumah tangga dan kantor.",
                    "Pencegahan kebakaran yang paling efektif berakar pada kemampuan untuk mengidentifikasi dan mengeliminasi potensi bahaya sejak dini di lingkungan sekitar kita, terutama di rumah tangga dan perkantoran. Sebagian besar kebakaran besar berawal dari kelalaian kecil yang diabaikan dalam waktu lama, seperti kabel listrik yang mengelupas atau regulator gas yang bocor.\n\n" +
                    "Mengembangkan budaya peduli bahaya (safety awareness) di rumah tangga melibatkan seluruh anggota keluarga untuk mengenali tanda-tanda awal risiko kebocoran gas maupun kegagalan sistem kelistrikan.\n\n" +
                    "<strong>Cara Mengidentifikasi dan Mengatasi Risiko Kebakaran Utama:</strong>\n\n" +
                    "1. <strong>Korsleting Listrik (Hubungan Pendek):</strong> Periksa steker dan stopkontak secara rutin. Hindari kebiasaan menumpuk steker terlalu banyak pada satu colokan (overload), karena akumulasi arus listrik dapat memicu panas berlebih yang melelehkan kabel. Ganti segera kabel peralatan elektronik yang sudah terkelupas atau retak guna mencegah percikan api.\n\n" +
                    "2. <strong>Kebocoran Gas LPG/LNG:</strong> Gas LPG telah dicampur dengan senyawa merkaptan khusus agar berbau menyengat seperti belerang atau telur busuk. Jika Anda mencium bau menyengat ini, <strong>jangan pernah menyalakan korek api, menghidupkan kompor, atau bahkan menyalakan/mematikan sakelar lampu listrik</strong> (perubahan sakelar dapat memicu percikan listrik terkecil yang bisa meledakkan gas di udara). Segera buka pintu dan jendela lebar-lebar, lepaskan regulator tabung gas, dan bawa tabung ke luar ruangan terbuka.\n\n" +
                    "3. <strong>Penyimpanan Bahan Kimia Mudah Terbakar:</strong> Bahan-bahan seperti alkohol medis, minyak tanah, cairan pembersih, aerosol (piloks/pewangi semprot), dan bensin harus disimpan di wadah tertutup rapat, jauh dari jangkauan anak-anak, serta dijauhkan dari sumber panas langsung seperti kompor atau sinar matahari terik.\n\n" +
                    "4. <strong>Lilin dan Obat Nyamuk Bakar:</strong> Jika menggunakan lilin atau obat nyamuk bakar, selalu tempatkan pada tatakan kaca atau logam yang stabil. Jauhkan dari benda-benda yang mudah terbakar seperti gorden, seprai kasur, atau kertas.",
                    15,
                    100,
                    false,
                    "materi-icon-risiko",
                    "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"><path d=\"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3Z\"/><line x1=\"12\" y1=\"9\" x2=\"12\" y2=\"13\"/><line x1=\"12\" y1=\"17\" x2=\"12.01\" y2=\"17\"/></svg>"
            ));

            moduleRepository.save(new Module(
                    null,
                    "Sistem Alarm Gedung",
                    "Mengenal berbagai jenis bunyi peringatan, detektor panas/asap, dan cara kerja sistem deteksi dini.",
                    "Sistem alarm kebakaran gedung (Fire Alarm System) adalah instalasi terpadu yang dirancang untuk memantau, mendeteksi, dan memperingatkan seluruh penghuni gedung secara dini mengenai adanya indikasi kebakaran. Sistem ini bekerja secara otomatis maupun manual untuk memfasilitasi waktu evakuasi secepat mungkin sebelum api menyebar secara eksponensial.\n\n" +
                    "Mengenali komponen dan jenis sensor pada sistem alarm gedung membantu kita merespons sinyal bahaya dengan cepat tanpa perlu mengalami kepanikan yang berlebih.\n\n" +
                    "<strong>Komponen Utama Sistem Alarm Kebakaran Gedung:</strong>\n\n" +
                    "1. <strong>Smoke Detector (Detektor Asap):</strong> Merupakan sensor langit-langit yang bekerja mendeteksi partikel asap di udara. Detektor ini sangat efektif ditempatkan di kamar tidur, lorong kantor, atau area yang minim debu/uap normal.\n\n" +
                    "2. <strong>Heat Detector (Detektor Panas):</strong> Sensor ini akan aktif apabila mendeteksi kenaikan suhu ruangan secara ekstrem (biasanya di atas 58°C - 65°C). Detektor ini ideal dipasang di dapur, bengkel kerja, atau ruang genset di mana uap panas atau debu biasa sering terjadi.\n\n" +
                    "3. <strong>Manual Call Point (MCP / Breakglass):</strong> Tombol darurat manual berbentuk kotak merah yang dipasang di dinding koridor atau dekat pintu keluar. Jika Anda melihat api berkobar sebelum sensor otomatis berbunyi, Anda dapat memecahkan kaca pelindung dan menekan tombol di dalamnya untuk membunyikan alarm ke seluruh gedung secara instan.\n\n" +
                    "4. <strong>Panel Kontrol Alarm (FACP):</strong> Merupakan 'otak' dari sistem alarm yang menerima sinyal dari sensor-sensor di seluruh lantai. FACP akan menunjukkan lokasi tepat (lantai dan ruangan) di mana sensor aktif, sehingga memudahkan petugas keamanan (security) untuk memverifikasi bahaya.\n\n" +
                    "5. <strong>Horn, Bell, & Strobe (Indikator Alarm):</strong> Bunyi sirine/lonceng yang nyaring disertai lampu kilat (strobe) visual untuk memberi tahu seluruh penghuni gedung agar segera melakukan evakuasi secara serentak.",
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
