package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainButtonActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mengecek apakah sumber event berasal dari tombol jenis member
        if (e.getSource() == mainFrame.getButtonjenisMember()) {
            mainFrame.showJenisMemberFrame();
        } else {
            mainFrame.showMemberFrame();
        }
    }
}
