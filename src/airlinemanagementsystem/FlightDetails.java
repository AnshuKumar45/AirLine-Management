/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anshu
 */
public class FlightDetails extends JFrame{
    public FlightDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JTable jtable = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from flight");
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.getMessage();
        }
        JScrollPane jsb = new JScrollPane(jtable);
        jsb.setBounds(0, 0, 800, 500);
        add(jsb);
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FlightDetails();
    }
}
