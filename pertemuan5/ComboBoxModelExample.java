package pertemuan5;

import javax.swing.*;  
import java.awt.event.*;  

public class ComboBoxModelExample {  
    public static void main(String[] args) {  
        // Membuat frame baru
        JFrame frame = new JFrame("ComboBoxModel Example");  

        // Membuat model JComboBox
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();  
        comboBoxModel.addElement("Item 1");  
        comboBoxModel.addElement("Item 2");  
        comboBoxModel.addElement("Item 3");  
        comboBoxModel.addElement("Item 4");  

        // Membuat JComboBox dengan model yang sudah dibuat
        JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);  

        // Menambahkan ActionListener untuk menangani pilihan pengguna
        comboBox.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                // Mendapatkan item yang dipilih
                String selectedItem = (String) comboBox.getSelectedItem();  
                System.out.println("Selected: " + selectedItem);  
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
