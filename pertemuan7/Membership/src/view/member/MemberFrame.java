package view.member;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;
import dao.*;

public class MemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    private JTextField textFieldNama;
    private MemberTableModel tableModel;
    private JComboBox<String> comboJenis;
    private MemberDao memberDao;
    private JenisMemberDao jenisMemberDao;
    private JTable table; // Tambahkan deklarasi untuk JTable

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;

        this.memberList = this.memberDao.findAll();
        this.jenisMemberList = this.jenisMemberDao.findAll();

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 20, 350, 20);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 40, 350, 30);

        JLabel labelJenis = new JLabel("Jenis Member:");
        labelJenis.setBounds(15, 80, 350, 20);

        comboJenis = new JComboBox<>();
        comboJenis.setBounds(15, 100, 150, 30);

        // Tombol Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 140, 100, 40);

        // Tombol Update
        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(130, 140, 100, 40);

        // Tombol Delete
        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(245, 140, 100, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 200, 350, 200);

        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);

        // Listener untuk tombol Simpan
        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);
        buttonSimpan.addActionListener(actionListener);

        // Listener untuk tombol Update
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Member member = memberList.get(selectedRow);
                    member.setNama(getNama());
                    member.setJenisMember(getJenisMember());

                    int result = memberDao.update(member);
                    if (result > 0) {
                        tableModel.fireTableRowsUpdated(selectedRow, selectedRow);
                        showAlert("Data berhasil diupdate");
                    } else {
                        showAlert("Gagal mengupdate data");
                    }
                } else {
                    showAlert("Pilih data yang ingin diupdate");
                }
            }
        });

        // Listener untuk tombol Delete
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Member member = memberList.get(selectedRow);

                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        int result = memberDao.delete(member);
                        if (result > 0) {
                            memberList.remove(selectedRow);
                            tableModel.fireTableRowsDeleted(selectedRow, selectedRow);
                            showAlert("Data berhasil dihapus");
                        } else {
                            showAlert("Gagal menghapus data");
                        }
                    }
                } else {
                    showAlert("Pilih data yang ingin dihapus");
                }
            }
        });

        this.add(buttonSimpan);
        this.add(buttonUpdate);
        this.add(buttonDelete);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public void populateComboJenis() {
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for (JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public JenisMember getJenisMember() {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }

    public void addMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
