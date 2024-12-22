package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MahasiswaView extends JFrame {
    private JTextField txtNama = new JTextField(20);
    private JTextField txtNim = new JTextField(20);
    private JTextField txtJurusan = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JButton btnAdd = new JButton("Add Mahasiswa");
    private JButton btnUpdate = new JButton("Update Mahasiswa");
    private JButton btnDelete = new JButton("Delete Mahasiswa");
    private JButton btnRefresh = new JButton("Refresh");
    private JButton btnExport = new JButton("Export");
    private JList<String> mahasiswaList = new JList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public MahasiswaView() {
        setTitle("Mahasiswa Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(txtNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("NIM:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(txtNim, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Jurusan:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(txtJurusan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(txtEmail, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnExport);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.NORTH);

        mahasiswaList.setModel(listModel);
        JScrollPane listScrollPane = new JScrollPane(mahasiswaList);
        add(listScrollPane, BorderLayout.CENTER);
    }

    public String getName() {
        return txtNama.getText();
    }

    public String getNim() {
        return txtNim.getText();
    }

    public String getJurusan() {
        return txtJurusan.getText();
    }

    public String getEmail() {
        return txtEmail.getText();
    }

    public void setMahasiswaList(String[] mahasiswaArray) {
        listModel.clear();
        for (String m : mahasiswaArray) {
            listModel.addElement(m);
        }
    }

    public void addAddMahasiswaListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addUpdateMahasiswaListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void addDeleteMahasiswaListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    public void addRefreshListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }

    public void addExportListener(ActionListener listener) {
        btnExport.addActionListener(listener);
    }

    public int getSelectedMahasiswaId() {
        int selectedIndex = mahasiswaList.getSelectedIndex();
        if (selectedIndex != -1) {
            // Gunakan ID mahasiswa yang disimpan (buat map atau array ID untuk mendukung ini)
            return selectedIndex; // Ganti dengan cara mendapatkan ID yang sesuai
        }
        return -1; // Tidak ada yang dipilih
    }
}
