/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author anshu
 */
public class Login extends JFrame implements ActionListener{
    JButton reset,close,submit;
    JTextField tUsername;
    JPasswordField tPassword;
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);
        JLabel lblUserName = new JLabel("username");
        lblUserName.setBounds(20, 20, 100, 20);
        add(lblUserName);
        
        tUsername = new JTextField();
        tUsername.setBounds(130,20,200,20);
        add(tUsername);
        
        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        
        tPassword = new JPasswordField();
        tPassword.setBounds(130,60,200,20);
        add(tPassword);
        
        reset = new JButton("reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("close");
        close.setBounds(115,160,120,20);
        close.addActionListener(this);
        add(close);
        
        setLocation(600, 300);
        setSize(400,250);
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == submit){
            String username = tUsername.getText();
            String password = tPassword.getText();
            try{
                Conn c =  new Conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            }catch(Exception e){
             e.getMessage();
            }
         }else if(ae.getSource() == reset){
            tUsername.setText("");
            tPassword.setText("");
         }else if(ae.getSource() == close){
            setVisible(false);
         }
     }
    public static void main(String[] args) {
        new Login();
    }
}
