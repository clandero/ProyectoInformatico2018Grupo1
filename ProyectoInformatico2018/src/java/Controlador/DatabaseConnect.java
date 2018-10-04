package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

    //Connection conn;
    static String url = "jdbc:postgresql://bdd.inf.udec.cl/pigrupo1?useUnicode=true&characterEncoding=utf8";
    static String user = "pigrupo1";
    static String password = "pigrupo1";

    static Connection conn = null;

    public static void connect() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        if (conn != null) {
            return;
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setSchema("plataforma_colaborativa");
            System.out.println("Connected to PostgreSQL server succesfully");
            //JOptionPane.showMessageDialog(null,"Connected");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE,null,ex);
            //JOptionPane.showMessageDialog(null, "Failed to Connect");
        }
    }

    public static Connection getConn() {
        if (conn == null) {
            try {
                DatabaseConnect.connect();
            } catch (Exception ex) {

            }
        }
        return DatabaseConnect.conn;
    }

}
