import javax.swing.*;

public class Tugas1 {
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("HelloWorldSwing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // teks yg berubah menjadi nama sendiri
    JLabel label = new JLabel("Hello, Faris");
    frame.getContentPane().add(label);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}