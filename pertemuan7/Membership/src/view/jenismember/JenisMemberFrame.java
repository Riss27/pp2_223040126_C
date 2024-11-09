package view.jenismember;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;
import model.JenisMember;
import dao.JenisMemberDao;

public class JenisMemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private JTextField textFieldNama; // Field input nama
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 20, 350, 10);

        textFieldNama = new JTextField(); // Inisialisasi JTextField untuk input nama
        textFieldNama.setBounds(15, 40, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 80, 100, 40);

        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table); // Menambahkan tabel dalam scroll pane
        scrollableTable.setBounds(15, 130, 350, 200);

        // Mengatur model tabel
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);

        // Listener untuk button "Simpan"
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);
        button.addActionListener(actionListener);

        // Menambahkan komponen ke frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        this.setSize(400, 400);
        this.setLayout(null);
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}
