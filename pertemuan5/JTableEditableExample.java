package pertemuan5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableEditableExample {
    public static void main(String[] args) {
        // Membuat frame baru
        JFrame frame = new JFrame("JTable Editable Example");

        // Nama kolom untuk JTable
        String[] columnNames = { "ID", "Name", "Age" };

        // Data awal untuk tabel
        Object[][] data = {
            { 1, "John", 25 },
            { 2, "Anna", 30 },
            { 3, "Mike", 35 }
        };

        // Membuat model untuk JTable dengan kolom 'Name' yang bisa diedit
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hanya kolom 'Name' yang dapat diedit
                return column == 1;
            }
        };

        // Membuat JTable dengan model
        JTable table = new JTable(model);

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

