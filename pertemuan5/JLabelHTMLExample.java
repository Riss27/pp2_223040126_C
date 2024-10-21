package pertemuan5;

import javax.swing.*;

public class JLabelHTMLExample {
    public static void main(String[] args) {
        // Membuat frame baru
        JFrame frame = new JFrame("JLabel HTML Example");

        // Membuat JLabel dengan teks HTML yang diformat
        JLabel label = new JLabel("<html><b>Bold Text</b>, <i>Italic Text</i>, and <u>Underlined Text</u></html>");

        // Menambahkan JLabel ke frame
        frame.add(label);

        // Mengatur ukuran dan pengaturan lain untuk frame
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

