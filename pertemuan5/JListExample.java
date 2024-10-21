package pertemuan5;

import javax.swing.*;  
import javax.swing.event.ListSelectionEvent;  
import javax.swing.event.ListSelectionListener;  

public class JListExample {  
    public static void main(String[] args) {  
        // Membuat frame baru
        JFrame frame = new JFrame("JList Example");  

        // Data yang akan ditampilkan dalam JList
        String[] items = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };  

        // Membuat JList dengan data yang sudah ada
        JList<String> list = new JList<>(items);  

        // Mengatur mode seleksi JList, dalam hal ini hanya satu item bisa dipilih (SINGLE_SELECTION)
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  

        // Menambahkan listener untuk menangani seleksi item dalam JList
        list.addListSelectionListener(new ListSelectionListener() {  
            public void valueChanged(ListSelectionEvent e) {  
                if (!e.getValueIsAdjusting()) { // Mencegah pemicu ganda saat seleksi berubah
                    String selectedItem = list.getSelectedValue();  
                    System.out.println("Selected: " + selectedItem);  
                }  
            }  
        });  

        // Membungkus JList dalam JScrollPane untuk menangani banyak item
        JScrollPane scrollPane = new JScrollPane(list);  

        // Mengatur tata letak dan ukuran JScrollPane di dalam frame
        frame.setLayout(null);  
        scrollPane.setBounds(50, 50, 150, 100);  
        frame.add(scrollPane);  

        // Mengatur ukuran dan pengaturan lain untuk frame
        frame.setSize(300, 200);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}
