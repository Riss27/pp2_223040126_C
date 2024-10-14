package pertemuan3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HelloGridLayout extends JFrame implements ActionListener {
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;    
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;

    private JButton[] buttons;
    private JButton restartButton;
    private boolean gameOver;

    public HelloGridLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        gameOver = false;

        // Initialize buttons
        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");
        buttons = new JButton[9];
        buttons[0] = buttonA;
        buttons[1] = buttonB;
        buttons[2] = buttonC;
        buttons[3] = buttonD;
        buttons[4] = buttonE;
        buttons[5] = buttonF;
        buttons[6] = buttonG;
        buttons[7] = buttonH;
        buttons[8] = buttonI;

        // Add action listeners
        for (JButton button : buttons) {
            button.addActionListener(this);
        }

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (JButton button : buttons) {
            gridPanel.add(button);
        }

        // Add grid panel to the frame
        this.add(gridPanel, BorderLayout.CENTER);

        // Add restart button
        restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        this.add(restartButton, BorderLayout.SOUTH);

        this.setSize(300, 350); // Adjusted size to accommodate restart button
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText("O");
                checkWinner();
                if (!gameOver) {
                    for (int i = 0; i < buttons.length; i++) {
                        if (buttons[i].getText().isEmpty()) {
                            buttons[i].setText("X");
                            break;
                        }
                    }
                    checkWinner();
                }
            }
        }
    }

    private void checkWinner() {
        String winner = "";
        if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonB.getText()) && buttonA.getText().equals(buttonC.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        } else if (!buttonD.getText().isEmpty() && buttonD.getText().equals(buttonE.getText()) && buttonD.getText().equals(buttonF.getText())) {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
        } else if (!buttonG.getText().isEmpty() && buttonG.getText().equals(buttonH.getText()) && buttonG.getText().equals(buttonI.getText())) {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonD.getText()) && buttonA.getText().equals(buttonG.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } else if (!buttonB.getText().isEmpty() && buttonB.getText().equals(buttonE.getText()) && buttonB.getText().equals(buttonH.getText())) {
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty() && buttonC.getText().equals(buttonF.getText()) && buttonC.getText().equals(buttonI.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonE.getText()) && buttonA.getText().equals(buttonI.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty() && buttonC.getText().equals(buttonE.getText()) && buttonC.getText().equals(buttonG.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        }

        gameOver = !winner.isEmpty();
    }

    private void resetGame() {
        gameOver = false;
        for (JButton button : buttons) {
            button.setText("");
            button.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridLayout frame = new HelloGridLayout();
                frame.setVisible(true);
            }
        });
    }
}
