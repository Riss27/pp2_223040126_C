package pertemuan5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableSortExample {
    public static void main(String[] args) {
        // Membuat frame baru
        JFrame frame = new JFrame("JTable Sorting Example");

        // Nama kolom untuk JTable
        String[] columnNames = { "ID", "Name", "Age" };

        // Data awal untuk tabel
        Object[][] data = {
            { 1, "John", 25 },
            { 3, "Mike", 35 },
            { 2, "Anna", 30 }
        };

        // Membuat model untuk JTable
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Membuat JTable dengan model
        JTable table = new JTable(model);

        // Mengaktifkan pengurutan otomatis pada tabel
        table.setAutoCreateRowSorter(true);

        // Membungkus JTable dengan JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Menambahkan JScrollPane ke frame
        frame.add(scrollPane);

        // Mengatur ukuran dan pengaturan lain untuk frame
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

