/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class BookFlight extends JFrame implements ActionListener{
    JTextField jtaadhar;
    JLabel tfname,tfantion,tfaddress,tfgender,labelfname,labelfcode;
    Choice src,dest;
    JButton jbfetch,flight,bookFlight;
    JDateChooser dcdate;
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblheading = new JLabel("BOOK FLIGHT");
        lblheading.setBounds(420, 20, 500, 35);
        lblheading.setForeground(Color.blue);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(lblheading);
        
        JLabel lblaadhar = new JLabel("Enter Aadhar No.");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        jtaadhar = new JTextField();
        jtaadhar.setBounds(220,80,180,25);
        add(jtaadhar);
        
        jbfetch = new JButton("Fetch");
        jbfetch.setBounds(410,80,100,25);
        jbfetch.setBackground(Color.black);
        jbfetch.setForeground(Color.WHITE);
        jbfetch.addActionListener(this);
        add(jbfetch);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        JLabel lblnation = new JLabel("Nationality");
        lblnation.setBounds(60, 180, 150, 25);
        lblnation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnation);
        
        tfantion = new JLabel();
        tfantion.setBounds(220,180,150,25);
        add(tfantion);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        tfgender = new JLabel();
        tfgender.setBounds(220,280,150,25);
        add(tfgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        src = new Choice();
        src.setBounds(220,330,150,25);
        add(src);
        
        JLabel lbldestination = new JLabel("Destination");
        lbldestination.setBounds(60, 380, 150, 25);
        lbldestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldestination);
        
        dest = new Choice();
        dest.setBounds(220,380,150,25);
        add(dest);
        
        try{
            Conn c = new Conn();
            String query = "Select source,destination from flight";
            ResultSet rs = c.s.executeQuery(query);
            HashSet<String> sets = new HashSet();
            HashSet<String> setd = new HashSet();
            while(rs.next()){
                sets.add(rs.getString("source"));
                setd.add(rs.getString("destination"));
            }
            for(String s:sets){
                src.add(s);
            }
            for(String s:setd){
                dest.add(s);
            }
        }catch(Exception e){
            e.getMessage();
        }
        
        flight = new JButton("Fetch flights");
        flight.setBounds(410,380,120,25);
        flight.setBackground(Color.black);
        flight.setForeground(Color.WHITE);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,430,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Journey");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        bookFlight = new JButton("Book Flight");
        bookFlight.setBounds(220,580,120,25);
        bookFlight.setBackground(Color.black);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.addActionListener(this);
        add(bookFlight);
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jbfetch){
            String aadhar = jtaadhar.getText();
            try{
                Conn c = new Conn();
                String query = "select * from passenger where aadhar = '"+ aadhar+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    tfname.setText(rs.getString("pname"));
                    tfantion.setText(rs.getString("nation"));
                    tfaddress.setText(rs.getString("address"));
                    tfgender.setText(rs.getString("gender"));
                    
                }else{
                    tfname.setText("");
                    tfaddress.setText("");
                    tfantion.setText("");
                    tfgender.setText("");
                    JOptionPane.showMessageDialog(null, "Please enter correct adhhar");
                }
            }catch(Exception e){
                e.getMessage();
            }
        }else if(ae.getSource() == flight){
            String source = src.getSelectedItem();
            String destination = dest.getSelectedItem();
            try{
                Conn c = new Conn();
                String query = "Select * from flight where source = '"+source+"' and destination = '"+destination+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    labelfname.setText(rs.getString("Fname"));
                    labelfcode.setText(rs.getString("Fcode"));
                }else{
                    labelfname.setText("");
                    labelfcode.setText("");
                    JOptionPane.showMessageDialog(null,"Sorry,No flights are avilable");
                            
                }
            }catch(Exception e){
                e.getMessage();
            }
        }else{
            Random random = new Random();
            String aadhar = jtaadhar.getText();
            String name =  tfname.getText();
            String nation = tfantion.getText();
            String gender = tfgender.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String source = src.getSelectedItem();
            String destination = dest.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            try{
                Conn c = new Conn();
                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nation+"','"+gender+"','"+flightname+"','"+flightcode+"','"+source+"','"+destination+"','"+date+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Ticket Booked successfully");
                setVisible(false);
            }catch(Exception e){
                e.getMessage();
            }
        }
    }
    public static void main(String[] args) {
        new BookFlight();
    }
}
