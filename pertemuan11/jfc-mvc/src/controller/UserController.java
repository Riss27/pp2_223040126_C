/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import view.UserPdf;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.List;
/**
 *
 * @author thega
 */
public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;
    
    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;
        
        this.view.addAddUserListener(new AddUserListener()); 
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
        this.view.addStartButtonListener(new startButtonListener());
    }
    
    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "please fill in all fields");
            }
        }
    }
    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            String[] userArray = users.stream()
                                    .map(u -> u.getName()+ " (" + u.getEmail() + ")")
                                    .toArray(String[]::new);
            view.setUserList(userArray);
        }
    }
    
    class ExportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            List<User>users = mapper.getAllUsers();
            pdf.exportPdf(users);
        }
    }
    
    public class startButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            view.getStartButton().setEnabled(false);
            view.getStatusLabel().setText("Tugas sedang diproses");
            
            SwingWorker<Void, Integer> worker = new SwingWorker<>(){
                @Override
                protected Void doInBackground() throws Exception{
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50);
                        publish(i);
                    }
                    return null;
                }
                
                @Override
                 protected void process(List<Integer> chunks) {
                    int latestProgress = chunks.get(chunks.size() - 1);
                    view.getProgressBar().setValue(latestProgress);
                }
                 
                @Override
                 protected void done() {
                    view.getStartButton().setEnabled(true);
                    view.getStatusLabel().setText("Tugas selesai");
                }
            };
            worker.execute();
        }
    }
}
