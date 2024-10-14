package pertemuan2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Latihan4 extends JFrame {
    public Latihan4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(50, 40, 100, 30);

        JTextField textField = new JTextField();
        textField.setBounds(150, 40, 200, 30);

        JLabel phoneLabel = new JLabel("No. Hp: ");
        phoneLabel.setBounds(50, 90, 100, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(150, 140, 190, 30);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 90, 200, 30);

        JTextArea textOutput = new JTextArea();
        textOutput.setBounds(50, 190, 300, 150);
        textOutput.setEditable(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String phone = phoneField.getText();
                textOutput.append("Nama: " + name + "\nNo. Hp: " + phone + "\n" + "______________________\n");
                textField.setText("");
                phoneField.setText("");
            }
        });

        this.add(labelInput);
        this.add(textField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(button);
        this.add(textOutput);

        this.setSize(400, 400);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Latihan4 frame = new Latihan4();
                frame.setVisible(true);
            }
        });
    }
}
