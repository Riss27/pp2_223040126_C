package pertemuan6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ToDoListApp extends JFrame {
    private JTextField taskField; // judul tugas
    private JTextArea descriptionArea; // deskripsi tugas
    private JRadioButton rbPending, rbCompleted; // status tugas
    private JCheckBox cbImportant; // menandai tugas penting
    private JComboBox<String> categoryComboBox; // kategori tugas
    private JList<String> priorityList; // prioritas tugas
    private JSlider progressSlider; // tingkat kemajuan tugas
    private JSpinner durationSpinner; // durasi estimasi
    private JTable taskTable; // menampilkan daftar tugas
    private DefaultTableModel tableModel; // Model untuk JTable
    private CardLayout cardLayout; // Layout navigasi antar panel
    private JPanel cardPanel; // menampung halaman

    public ToDoListApp() {
        setTitle("Aplikasi To-Do List");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // menu bar untuk navigasi
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navigasi");
        JMenuItem addTaskItem = new JMenuItem("Tambah Tugas");
        JMenuItem viewTasksItem = new JMenuItem("Daftar Tugas");
        
        // Action untuk menu item
        addTaskItem.addActionListener(e -> cardLayout.show(cardPanel, "Tambah Tugas"));
        viewTasksItem.addActionListener(e -> cardLayout.show(cardPanel, "Daftar Tugas"));

        menu.add(addTaskItem);
        menu.add(viewTasksItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel input untuk form tugas
        JPanel inputPanel = createInputPanel();
        cardPanel.add(inputPanel, "Tambah Tugas");

        // Panel untuk menampilkan tabel tugas
        JPanel tablePanel = createTablePanel();
        cardPanel.add(tablePanel, "Daftar Tugas");

        // Menambahkan panel dengan CardLayout ke dalam frame
        add(cardPanel);
        setVisible(true);
    }

    // Membuat panel input tugas
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9, 2, 10, 10)); // Grid dengan padding

        // JTextField untuk judul tugas
        inputPanel.add(new JLabel("Judul Tugas :"));
        taskField = new JTextField(20);
        inputPanel.add(taskField);

        // JTextArea untuk deskripsi tugas
        inputPanel.add(new JLabel("Deskripsi Tugas :"));
        descriptionArea = new JTextArea(3, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        inputPanel.add(new JScrollPane(descriptionArea));

        // JRadioButton untuk status tugas
        inputPanel.add(new JLabel("Status Pengerjaan :"));
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbPending = new JRadioButton("Belum Selesai");
        rbCompleted = new JRadioButton("Selesai");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(rbPending);
        statusGroup.add(rbCompleted);
        rbPending.setSelected(true);
        statusPanel.add(rbPending);
        statusPanel.add(rbCompleted);
        inputPanel.add(statusPanel);

        // JCheckBox untuk tanda tugas penting
        inputPanel.add(new JLabel("Penting :"));
        cbImportant = new JCheckBox("Tandai sebagai penting");
        inputPanel.add(cbImportant);

        // JComboBox untuk kategori tugas
        inputPanel.add(new JLabel("Kategori Tugas :"));
        String[] categories = {"Kelompok", "Project", "Individu"};
        categoryComboBox = new JComboBox<>(categories);
        inputPanel.add(categoryComboBox);

        // JList untuk prioritas tugas
        inputPanel.add(new JLabel("Prioritas :"));
        String[] priorities = {"Tinggi", "Sedang", "Rendah"};
        priorityList = new JList<>(priorities);
        priorityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        priorityList.setVisibleRowCount(3);
        inputPanel.add(new JScrollPane(priorityList));

        // JSlider untuk tingkat kemajuan tugas
        inputPanel.add(new JLabel("Kemajuan Tugas (%) :"));
        progressSlider = new JSlider(0, 100, 0);
        progressSlider.setMajorTickSpacing(20);
        progressSlider.setMinorTickSpacing(5);
        progressSlider.setPaintTicks(true);
        progressSlider.setPaintLabels(true);
        inputPanel.add(progressSlider);

        // JSpinner untuk durasi estimasi (dalam jam)
        inputPanel.add(new JLabel("Estimasi Durasi (jam) :"));
        SpinnerNumberModel durationModel = new SpinnerNumberModel(1, 1, 24, 1); // dari 1 hingga 24 jam
        durationSpinner = new JSpinner(durationModel);
        inputPanel.add(durationSpinner);

        // Tombol untuk menambahkan tugas
        JButton addButton = new JButton("Tambah Tugas");
        addButton.addActionListener(new AddTaskActionListener());
        inputPanel.add(new JLabel()); // Placeholder untuk mengisi grid kosong
        inputPanel.add(addButton);

        return inputPanel;
    }

    // Membuat panel untuk menampilkan daftar tugas
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        
        // Model untuk JTable
        tableModel = new DefaultTableModel(new String[]{"Judul", "Deskripsi", "Status", "Penting", "Kategori", "Prioritas", "Kemajuan", "Durasi (jam)"}, 0);
        taskTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(taskTable);

        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        return tablePanel;
    }

    // ActionListener untuk menambahkan tugas ke dalam tabel
    private class AddTaskActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = taskField.getText();
            String description = descriptionArea.getText();
            String status = rbPending.isSelected() ? "Belum Selesai" : "Selesai";
            String important = cbImportant.isSelected() ? "Ya" : "Tidak";
            String category = (String) categoryComboBox.getSelectedItem();
            String priority = priorityList.getSelectedValue();
            int progress = progressSlider.getValue();
            int duration = (int) durationSpinner.getValue();

            // Memastikan prioritas dipilih sebelum menambah tugas
            if (priority == null) {
                JOptionPane.showMessageDialog(ToDoListApp.this, "Silakan pilih prioritas tugas!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Menambahkan data ke dalam JTable
            tableModel.addRow(new Object[]{title, description, status, important, category, priority, progress + "%", duration + " jam"});

            // Reset input setelah ditambahkan
            taskField.setText("");
            descriptionArea.setText("");
            rbPending.setSelected(true);
            cbImportant.setSelected(false);
            categoryComboBox.setSelectedIndex(0);
            priorityList.clearSelection();
            progressSlider.setValue(0);
            durationSpinner.setValue(1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListApp::new);
    }
}
