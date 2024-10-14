package pertemuan2; // Menentukan package dari kelas

import javax.swing.*; // Mengimpor kelas untuk membuat antarmuka grafis pengguna (GUI)
import java.awt.event.*; // Mengimpor kelas untuk menangani peristiwa (event)
import java.util.Calendar; // Mengimpor kelas untuk mengelola tanggal dan waktu

public class TugasModul2 extends JFrame { // Kelas utama mewarisi JFrame untuk membuat jendela aplikasi

    // Constructor untuk menginisialisasi jendela dan komponen
    public TugasModul2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menutup aplikasi saat jendela ditutup
        setTitle("Form Pendaftaran Nasabah Bank"); // Menetapkan judul jendela
        setSize(500, 800); // Mengatur ukuran jendela
        setLayout(null); // Mengatur tata letak manual (null layout)

        // Menginisialisasi komponen GUI
        initComponents();
    }

    private void initComponents() {
        // Label dan text field untuk input nama
        JLabel labelInputNama = new JLabel("Nama: "); // Membuat label untuk nama
        labelInputNama.setBounds(20, 20, 150, 30); // Mengatur posisi dan ukuran label
        JTextField textFieldNama = new JTextField(); // Membuat text field untuk nama
        textFieldNama.setBounds(180, 20, 150, 30); // Mengatur posisi dan ukuran text field
        
        // Label dan text field untuk input nomor telepon
        JLabel labelInputTelp = new JLabel("Nomor Telepon: "); // Membuat label untuk nomor telepon
        labelInputTelp.setBounds(20, 60, 150, 30); // Mengatur posisi dan ukuran label
        JTextField textFieldTelp = new JTextField(); // Membuat text field untuk nomor telepon
        textFieldTelp.setBounds(180, 60, 150, 30); // Mengatur posisi dan ukuran text field
        
        // Radio button untuk jenis kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:"); // Membuat label untuk jenis kelamin
        labelRadio.setBounds(20, 100, 150, 30); // Mengatur posisi dan ukuran label
        JRadioButton radioButtonLK = new JRadioButton("Laki-Laki", true); // Radio button untuk Laki-Laki (default)
        radioButtonLK.setBounds(180, 100, 100, 30); // Mengatur posisi dan ukuran radio button
        JRadioButton radioButtonPR = new JRadioButton("Perempuan"); // Radio button untuk Perempuan
        radioButtonPR.setBounds(280, 100, 100, 30); // Mengatur posisi dan ukuran radio button
        
        // Mengelompokkan radio button agar hanya satu yang dapat dipilih
        ButtonGroup bg = new ButtonGroup(); // Membuat grup untuk radio button
        bg.add(radioButtonLK); // Menambahkan radio button Laki-Laki ke grup
        bg.add(radioButtonPR); // Menambahkan radio button Perempuan ke grup
        
        // Checkbox status WNA
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing"); // Membuat checkbox untuk WNA
        checkBoxWNA.setBounds(180, 140, 180, 30); // Mengatur posisi dan ukuran checkbox
        
        // JList untuk memilih jenis tabungan
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:"); // Membuat label untuk jenis tabungan
        labelJenisTabungan.setBounds(20, 180, 150, 30); // Mengatur posisi dan ukuran label
        String[] jenisTabungan = {"Tabungan Reguler", "Tabungan Berjangka", "Tabungan Pendidikan", "Tabungan Haji",
                                   "Tabungan Emas", "Tabungan Pensiun", "Tabungan Khusus", "Tabungan Anak"}; // Daftar pilihan tabungan
        JList<String> listTabungan = new JList<>(jenisTabungan); // Membuat JList untuk pilihan tabungan
        
        // Membungkus JList dalam JScrollPane untuk memungkinkan scrolling
        JScrollPane scrollPaneTabungan = new JScrollPane(listTabungan); // Membuat JScrollPane untuk JList
        scrollPaneTabungan.setBounds(180, 180, 150, 60); // Mengatur posisi dan ukuran JScrollPane
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Memungkinkan hanya satu pilihan
        
        // JSpinner untuk frekuensi transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi per Bulan:"); // Membuat label untuk frekuensi transaksi
        labelFrekuensi.setBounds(20, 250, 200, 30); // Mengatur posisi dan ukuran label
        JSlider sliderFrekuensi = new JSlider(1, 100, 1); // Membuat JSlider dengan batas 1 hingga 100 dan nilai awal 1
        sliderFrekuensi.setMajorTickSpacing(10); // Mengatur jarak tick besar setiap 10
        sliderFrekuensi.setMinorTickSpacing(1); // Mengatur jarak tick kecil setiap 1
        sliderFrekuensi.setPaintTicks(true); // Menggambar ticks pada slider
        sliderFrekuensi.setPaintLabels(true); // Menampilkan label pada slider
        sliderFrekuensi.setBounds(20, 290, 400, 50); // Mengatur posisi dan ukuran slider
        
        // JSpinner untuk tanggal lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:"); // Membuat label untuk tanggal lahir
        labelTanggalLahir.setBounds(20, 350, 150, 30); // Mengatur posisi dan ukuran label
        JSpinner spinnerTanggalLahir = new JSpinner(new SpinnerDateModel()); // Membuat JSpinner untuk tanggal lahir
        spinnerTanggalLahir.setBounds(180, 350, 150, 30); // Mengatur posisi dan ukuran spinner
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy"); // Mengatur format tanggal
        spinnerTanggalLahir.setEditor(dateEditor); // Menetapkan editor untuk JSpinner
        
        // JPasswordField untuk password
        JLabel labelPassword = new JLabel("Password:"); // Membuat label untuk password
        labelPassword.setBounds(20, 390, 150, 30); // Mengatur posisi dan ukuran label
        JPasswordField passwordField = new JPasswordField(); // Membuat JPasswordField untuk input password
        passwordField.setBounds(180, 390, 150, 30); // Mengatur posisi dan ukuran password field
        
        // JPasswordField untuk konfirmasi password
        JLabel labelConfirmPassword = new JLabel("Confirm Password:"); // Membuat label untuk konfirmasi password
        labelConfirmPassword.setBounds(20, 430, 150, 30); // Mengatur posisi dan ukuran label
        JPasswordField confirmPasswordField = new JPasswordField(); // Membuat JPasswordField untuk konfirmasi password
        confirmPasswordField.setBounds(180, 430, 150, 30); // Mengatur posisi dan ukuran confirm password field
        
        // JTextArea untuk output
        JTextArea textFieldOutput = new JTextArea(); // Membuat JTextArea untuk menampilkan output
        textFieldOutput.setBounds(20, 470, 400, 200); // Mengatur posisi dan ukuran text area
        textFieldOutput.setEditable(false); // Mengatur agar text area tidak dapat diedit
        
        // Tombol Simpan
        JButton buttonSimpan = new JButton("Simpan"); // Membuat tombol Simpan
        buttonSimpan.setBounds(180, 680, 150, 30); // Mengatur posisi dan ukuran tombol
        
        // ActionListener untuk tombol Simpan
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil data dari input
                String nama = textFieldNama.getText(); // Mendapatkan teks dari textFieldNama
                String telp = textFieldTelp.getText(); // Mendapatkan teks dari textFieldTelp
                String jenisKelamin = radioButtonLK.isSelected() ? "Laki-Laki" : "Perempuan"; // Mendapatkan pilihan jenis kelamin
                String wna = checkBoxWNA.isSelected() ? "Iya" : "Tidak"; // Mendapatkan status WNA
                String jenisTabungan = listTabungan.getSelectedValue(); // Mendapatkan pilihan jenis tabungan
                int frekuensiTransaksi = sliderFrekuensi.getValue(); // Mendapatkan nilai frekuensi transaksi dari slider
                String tanggalLahir = dateEditor.getFormat().format(spinnerTanggalLahir.getValue()); // Mendapatkan tanggal lahir
                String password = new String(passwordField.getPassword()); // Mendapatkan password sebagai String
                String confirmPassword = new String(confirmPasswordField.getPassword()); // Mendapatkan confirm password

                // Validasi password
                String passwordStatus = password.equals(confirmPassword) ? "Password cocok" : "Password tidak cocok"; // Memeriksa kesamaan password

                // Output pada TextArea
                textFieldOutput.setText("Nama: " + nama + "\n"
                        + "Nomor HP: " + telp + "\n"
                        + "Jenis Kelamin: " + jenisKelamin + "\n"
                        + "WNA: " + wna + "\n"
                        + "Jenis Tabungan: " + jenisTabungan + "\n"
                        + "Frekuensi Transaksi per Bulan: " + frekuensiTransaksi + "\n"
                        + "Tanggal Lahir: " + tanggalLahir + "\n"
                        + passwordStatus); // Menampilkan hasil input pada textFieldOutput
            }
        });
        
        // Menu bar
        JMenuBar menuBar = new JMenuBar(); // Membuat menu bar utama
        JMenu menu = new JMenu("Menu"); // Membuat menu "Menu"
        
        // Reset Menu Item
        JMenuItem resetMenu = new JMenuItem("Reset"); // Membuat item "Reset"
        resetMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menghapus semua inputan dan output
                textFieldNama.setText(""); // Mengosongkan textFieldNama
                textFieldTelp.setText(""); // Mengosongkan textFieldTelp
                bg.clearSelection(); // Menghapus pilihan radio button
                checkBoxWNA.setSelected(false); // Mengosongkan checkbox WNA
                listTabungan.clearSelection(); // Menghapus pilihan JList
                sliderFrekuensi.setValue(1); // Mereset slider frekuensi ke 1
                spinnerTanggalLahir.setValue(Calendar.getInstance().getTime()); // Mereset spinner tanggal lahir ke tanggal sekarang
                passwordField.setText(""); // Mengosongkan password field
                confirmPasswordField.setText(""); // Mengosongkan confirm password field
                textFieldOutput.setText(""); // Mengosongkan text area output
            }
        });
        
        // Exit Menu Item
        JMenuItem exitMenu = new JMenuItem("Exit"); // Membuat item "Exit"
        exitMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Keluar dari aplikasi
                System.exit(0); // Keluar dari program
            }
        });

        // Menambahkan menu item ke menu
        menu.add(resetMenu); // Menambahkan item reset ke menu
        menu.add(exitMenu); // Menambahkan item exit ke menu
        menuBar.add(menu); // Menambahkan menu ke menu bar
        setJMenuBar(menuBar); // Mengatur menu bar di JFrame
        
        // Menambahkan semua komponen ke frame
        add(labelInputNama);
        add(textFieldNama);
        add(labelInputTelp);
        add(textFieldTelp);
        add(labelRadio);
        add(radioButtonLK);
        add(radioButtonPR);
        add(checkBoxWNA);
        add(labelJenisTabungan);
        add(scrollPaneTabungan); // Menambahkan JScrollPane untuk pilihan tabungan
        add(labelFrekuensi);
        add(sliderFrekuensi); // Menambahkan JSlider untuk frekuensi transaksi
        add(labelTanggalLahir);
        add(spinnerTanggalLahir);
        add(labelPassword);
        add(passwordField);
        add(labelConfirmPassword);
        add(confirmPasswordField);
        add(buttonSimpan);
        add(textFieldOutput);
    }

    // Metode utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TugasModul2 frame = new TugasModul2(); // Membuat instance dari TugasModul2
                frame.setVisible(true); // Menampilkan frame
            }
        });
    }
}
