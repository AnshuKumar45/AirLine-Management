/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anshu
 */
public class JourneyDetails extends JFrame implements ActionListener{
    JTextField pnr;
    JButton show;
    JTable table;
    public JourneyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1000, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(1000, 600);
        setLocation(400, 150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            String query = "Select * from reservation where PNR = '"+pnr.getText()+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.getMessage();
        }
    }
    public static void main(String[] args) {
        new JourneyDetails();
    }
}
