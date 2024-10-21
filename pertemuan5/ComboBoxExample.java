package pertemuan5;

import javax.swing.*;  
import java.awt.event.*;  

public class ComboBoxExample {  
    public static void main(String[] args) {  
        // Membuat frame baru
        JFrame frame = new JFrame("JComboBox Example");  

        // Opsi yang akan ditampilkan dalam JComboBox
        String[] options = { "Option 1", "Option 2", "Option 3", "Option 4" };  

        // Membuat JComboBox dengan opsi yang sudah ditentukan
        JComboBox<String> comboBox = new JComboBox<>(options);  

        // Menambahkan ActionListener untuk mendeteksi item yang dipilih
        comboBox.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                // Mengambil item yang dipilih oleh pengguna
                String selected = (String) comboBox.getSelectedItem();  
                System.out.println("Selected: " + selected);  
            }  
        });  

        // Mengatur tata letak dan ukuran JComboBox di dalam frame
        frame.setLayout(null);  
        comboBox.setBounds(50, 50, 150, 20);  
        frame.add(comboBox);  

        // Mengatur ukuran dan pengaturan lain untuk frame
        frame.setSize(300, 200);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}
