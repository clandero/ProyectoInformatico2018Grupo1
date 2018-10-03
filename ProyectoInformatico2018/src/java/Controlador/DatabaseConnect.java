package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseConnect {
    //Connection conn;
    static String url = "jdbc:postgresql://bdd.inf.udec.cl/pigrupo1";
    static String user = "pigrupo1";
    static String password = "pigrupo1";
    
    private static Connection conn = null;
    
    static{
        try{           
            conn = DriverManager.getConnection(url, user, password);
            conn.setSchema("prueba");
            System.out.println("Connected to PostgreSQL server succesfully");
            JOptionPane.showMessageDialog(null,"Connected");
        } catch (SQLException ex){
            System.out.println("error");
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static Connection getConn(){
        System.out.println("fucking hell");
        return conn;
    }
}



