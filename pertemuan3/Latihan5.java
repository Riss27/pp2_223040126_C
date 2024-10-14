package pertemuan3;

import java.awt.*;
import javax.swing.*;

public class Latihan5 extends JFrame {

  public Latihan5() {
    // Set default close operation
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 300);

    // Create a panel with GridBagLayout
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    // Create components
    JLabel titleLabel = new JLabel("Form Biodata");
    JLabel nameLabel = new JLabel("Nama:");
    JTextField nameField = new JTextField(15);

    JLabel phoneLabel = new JLabel("Nomor HP:");
    JTextField phoneField = new JTextField(15);

    JLabel genderLabel = new JLabel("Jenis Kelamin:");
    JRadioButton maleButton = new JRadioButton("Laki-Laki");
    JRadioButton femaleButton = new JRadioButton("Perempuan");

    // Group the gender buttons
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(maleButton);
    genderGroup.add(femaleButton);

    JCheckBox foreignerCheck = new JCheckBox("Warga Negara Asing");
    JButton saveButton = new JButton("Simpan");

    // Title position
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(titleLabel, gbc);

    // Reset gridwidth for the following components
    gbc.gridwidth = 1;

    // Name label
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    panel.add(nameLabel, gbc);

    // Name text field
    gbc.gridx = 1;
    gbc.gridy = 1;
    panel.add(nameField, gbc);

    // Phone label
    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(phoneLabel, gbc);

    // Phone text field
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(phoneField, gbc);

    // Gender label
    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(genderLabel, gbc);

    // Male radio button
    gbc.gridx = 1;
    gbc.gridy = 3;
    panel.add(maleButton, gbc);

    // Female radio button
    gbc.gridx = 1;
    gbc.gridy = 4;
    panel.add(femaleButton, gbc);

    // Foreigner checkbox
    gbc.gridx = 1;
    gbc.gridy = 5;
    panel.add(foreignerCheck, gbc);

    // Save button
    gbc.gridx = 1;
    gbc.gridy = 6;
    panel.add(saveButton, gbc);

    // Add panel to frame
    this.add(panel);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        Latihan5 form = new Latihan5();
        form.setVisible(true);
      }
    });
  }
}
