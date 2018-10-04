package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect {
    //Connection conn;
    String url = "jdbc:postgresql://bdd.inf.udec.cl/pigrupo1";
    String user = "pigrupo1";
    String password = "pigrupo1";
    
public Connection connect() throws ClassNotFoundException{
    Class.forName("org.postgresql.Driver");
    Connection conn = null;
    try{
        conn = DriverManager.getConnection(url,user,password);
        System.out.println("Connected to PostgreSQL server succesfully");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE,null,ex);
        //JOptionPane.showMessageDialog(null, "Failed to Connect");
    }
    return conn;
}   
}



