
import javax.swing.*;
import java.awt.*;
import java.util.List;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author justz
 */
public class MainFrame {
    public static void main(String[] args){
        
        //frame utama
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("contoh konkurensi di swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,200);
            frame.setLayout(new BorderLayout());
            
            //status label
            JLabel statusLabel = new JLabel("tekan tombol untuk mulai tugas berat", JLabel.CENTER);
            
            //start process btn
            JButton startButton = new JButton("Mulai");
            
            //Progress bar
           JProgressBar progressBar = new JProgressBar(0,60);
           progressBar.setValue(0);
           progressBar.setStringPainted(true);
           
           //add component to frame
           frame.add(statusLabel, BorderLayout.NORTH);
           frame.add(progressBar, BorderLayout.CENTER);
           frame.add(startButton, BorderLayout.SOUTH);
           
           //action btn
           startButton.addActionListener(e->{
              
               //update progressbar 1%/s
               for(int i = 0; i <= 60; i++){
                   progressBar.setValue(i);
                   try{
                       Thread.sleep(1000);
                   }catch(Exception ex){
                       System.err.println(ex.getMessage());
                   }
               }
           });
           
           //nampilin frame
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
        });
    }
}
