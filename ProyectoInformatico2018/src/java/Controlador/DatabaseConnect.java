package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import Modelo.*;

public class DatabaseConnect {
    //Connection conn;
    static String url = "jdbc:postgresql://bdd.inf.udec.cl/pigrupo1?useUnicode=true&characterEncoding=utf8";    
    static String user = "pigrupo1";
    static String password = "pigrupo1";
    
    static Connection conn = null;
    
    public static void connect() throws ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        if (conn != null){
            return;
        }
        try{
            conn = DriverManager.getConnection(url,user,password);
            conn.setSchema("prueba1");
            System.out.println("Connected to PostgreSQL server succesfully");
            //JOptionPane.showMessageDialog(null,"Connected");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            //Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE,null,ex);
            //JOptionPane.showMessageDialog(null, "Failed to Connect");
        }
    }
    
    public static Connection getConn(){
        if (conn == null){
            try{
                DatabaseConnect.connect();
            } catch( Exception ex){
                
            }
        }
        return DatabaseConnect.conn;
    }

    public static ArrayList<String> getUser(String p, String q) throws Exception{
        DatabaseConnect.connect();
        try{
            PreparedStatement statement = null;
            if(q.equals("area")){
                statement = conn.prepareStatement("SELECT u.nombre_usuario, u.correo FROM plataforma_colaborativa.usuario as u, plataforma_colaborativa.usuario_area as ua WHERE ua.tema = '"+p+"' AND ua.correo = u.correo");
            }
            else if(q.equals("depto")){
                statement = conn.prepareStatement("SELECT u.nombre_usuario, u.correo FROM plataforma_colaborativa.usuario as u WHERE u.departamento = '"+p+"'");
            }
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("nombre_usuario"));
                array.add(result.getString("correo"));
            }
            return array;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

}

