/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Anuncio;
import Modelo.Usuario;
import Modelo.AreadeInteres;

import java.util.List;
import java.util.Optional;
import java.util.*;
import java.sql.*;

/**
 *
 * @author berko
 */
public class AnuncioDao {
    
    private static Connection conn = null;
    
    public AnuncioDao(){
         if (conn == null){
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced anunciodao");
    }
    
    public void addTema(int n_anun, AreadeInteres area){
        try{
            String query = "INSERT INTO anuncio_area(n_anun, tema)"
                      + "VALUES ((?),(?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, n_anun);
            ps.setString(2, area.getTema());
            ps.execute();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void save(Anuncio a, Usuario u, AreadeInteres area){
        try{
            // crear anuncio en bd
            String query = "INSERT INTO anuncio "
                         + "(contenido, correo, fecha_anuncio)"
                         + "VALUES ((?),(?),(?))"
                         + "RETURNING n_anun";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, a.getNumero());
            ps.setString(2, a.getContent());
            ps.setString(3, u.getCorreo());
            ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            int n_anun = rs.getInt("n_anun");
            query = "INSERT INTO anuncio_area(n_anun, tema)"
                  + "VALUES ((?),(?))";
            ps = conn.prepareStatement(query);
            ps.setInt(1, n_anun);
            ps.setString(2, area.getTema());
            ps.execute();
            //
        } catch (SQLException ex){
            System.out.println(ex);
        }
        
    }
}
