package pertemuan4;

import java.awt.event.*;
import javax.swing.*;

public class KeyListenerExample {
  public static void main(String[] args) {
    // Membuat frame
    JFrame frame = new JFrame("Key Listener Example");

    // Membuat label untuk menampilkan pesan
    JLabel label = new JLabel("Tekan tombol pada keyboard");
    label.setBounds(50, 50, 300, 30);

    // membuat text field untuk fokus keeyboard
    JTextField textField = new JTextField();
    textField.setBounds(50, 100, 200, 30);

    // Menambahkan keylistener pada text field
    textField.addKeyListener(new KeyListener() {
      // dijalankan ketika tombol ditekan
      public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
      }

      // dijalankan ketika tombol dilepas
      public void keyReleased(KeyEvent e) {
        label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
      }

      // dijalankan ketika tombol ditekan dan dilepas 
      public void keyTyped(KeyEvent e) {
        label.setText("Key Typed: " + e.getKeyChar());
      }
    });

    // Menambahkan label dan text field ke frame
    frame.add(label);
    frame.add(textField);

    // Setting frame
    frame.setSize(400, 200);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}
