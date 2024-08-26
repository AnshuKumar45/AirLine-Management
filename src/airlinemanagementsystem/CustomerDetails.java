/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author anshu
 */
public class CustomerDetails extends JFrame implements ActionListener{
    JTextField jtname,jtnationality,jtaadhar,jtaddress,jtphone;
    JRadioButton jrmale,jrfemale;
    public CustomerDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblheading = new JLabel("ADD CUSTOMER DETAILS");
        lblheading.setBounds(220, 20, 500, 35);
        lblheading.setForeground(Color.black);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(lblheading);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,80,100,25);
        add(lblname);
        
        jtname = new JTextField();
        jtname.setBounds(170,80,180,25);
        add(jtname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,120,100,25);
        add(lblnationality);
        
        jtnationality = new JTextField();
        jtnationality.setBounds(170,120,180,25);
        add(jtnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(60,160,100,25);
        add(lblaadhar);
        
        jtaadhar = new JTextField();
        jtaadhar.setBounds(170,160,180,25);
        add(jtaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,200,100,25);
        add(lbladdress);
        
        jtaddress = new JTextField();
        jtaddress.setBounds(170,200,180,25);
        add(jtaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,240,100,25);
        add(lblgender);
        
        ButtonGroup brgroup = new ButtonGroup();
        
        jrmale = new JRadioButton("Male");
        jrmale.setBounds(170,240,90,25);
        jrmale.setBackground(Color.WHITE);
        add(jrmale);
        
        jrfemale = new JRadioButton("Female");
        jrfemale.setBounds(270,240,80,25);
        jrfemale.setBackground(Color.WHITE);
        add(jrfemale);
        
        brgroup.add(jrmale);
        brgroup.add(jrfemale);
        
        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(60,280,100,25);
        add(lblphone);
        
        jtphone = new JTextField();
        jtphone.setBounds(170,280,180,25);
        add(jtphone);
        
        JButton jbsave = new JButton("save");
        jbsave.setBackground(Color.black);
        jbsave.setForeground(Color.white);
        jbsave.setBounds(180,340,150,30);
        jbsave.addActionListener(this);
        add(jbsave);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = jtname.getText();
        String nation = jtnationality.getText();
        String aadhar = jtaadhar.getText();
        String address = jtaddress.getText();
        String phone = jtphone.getText();
        String gender = null;
        if(jrmale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        try{
            Conn c = new Conn();
            String query = "Insert into passenger values('"+name+"','"+nation+"','"+aadhar+"','"+address+"','"+gender+"','"+phone+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            setVisible(false);
            
            
        }catch(Exception e){
            e.getMessage();
        }
    }
    public static void main(String[] args) {
        new CustomerDetails();
    }
}
