package pertemuan5;

import javax.swing.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class DynamicJListExample {  
    public static void main(String[] args) {  
        // Membuat frame baru
        JFrame frame = new JFrame("Dynamic JList Example");  

        // Membuat model untuk JList dengan elemen dinamis
        DefaultListModel<String> listModel = new DefaultListModel<>();  
        listModel.addElement("Dynamic Item 1");  
        listModel.addElement("Dynamic Item 2");  
        listModel.addElement("Dynamic Item 3");  

        // Membuat JList menggunakan model
        JList<String> list = new JList<>(listModel);  
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  

        // JScrollPane untuk JList
        JScrollPane scrollPane = new JScrollPane(list);  

        // Tombol untuk menambahkan item baru ke dalam JList
        JButton addButton = new JButton("Add Item");  
        addButton.setBounds(50, 170, 100, 30);  
        addButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                listModel.addElement("New Item");  // Menambahkan elemen baru
            }  
        });  

        // Tombol untuk menghapus item yang dipilih dalam JList
        JButton removeButton = new JButton("Remove Item");  
        removeButton.setBounds(160, 170, 120, 30);  
        removeButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                int selectedIndex = list.getSelectedIndex();  
                if (selectedIndex != -1) {  
                    listModel.remove(selectedIndex);  // Menghapus elemen yang dipilih
                }  
            }  
        });  

        // Mengatur tata letak dan ukuran komponen dalam frame
        frame.setLayout(null);  
        scrollPane.setBounds(50, 50, 150, 100);  
        frame.add(scrollPane);  
        frame.add(addButton);  
        frame.add(removeButton);  

        // Mengatur ukuran dan pengaturan lain untuk frame
        frame.setSize(350, 250);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}

