package airlinemanagementsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author anshu
 */
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///AirlineManagementSystem","root","Anshu@123");
            s = c.createStatement();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
