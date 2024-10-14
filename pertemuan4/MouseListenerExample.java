package pertemuan4;

import java.awt.event.*;
import javax.swing.*;

public class MouseListenerExample {

  public MouseListenerExample() {
    // Membuat frame
    JFrame frame = new JFrame("Mouse Listener Example");

    // Membuat label untuk menampilkan pesan
    JLabel label = new JLabel("Arahkan dan klik mouse pada area ini");
    label.setBounds(50, 50, 300, 30);

    // Menambahkan mouselistener pada label
    label.addMouseListener(new MouseListener() {
      // dijalankan ketika mouse diklik (klik kiri, kanan, atau tengah)
      public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
      }

      // dijalankan ketika mouse ditekan (tanpa dilepas)
      public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed at: (" + e.getX() + ", " + e.getY() + ")");
      }

      // dijalankan ketika mouse dilepas setelah ditekan
      public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released at: (" + e.getX() + ", " + e.getY() + ")");
      }

      // dijalankan ketika mouse masuk ke area komponen
      public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered the area.");
      }

      // dijalankan ketika mouse keluar dari area komponen
      public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited the area.");
      }
    });

    // Menambahkan label ke frame
    frame.add(label);

    // Setting frame
    frame.setSize(400, 200);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new MouseListenerExample();
  }
}
