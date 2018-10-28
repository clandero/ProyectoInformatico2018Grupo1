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
    
    public void save(Anuncio a, Usuario u, AreadeInteres area){
        try{
            // crear anuncio en bd
            String query = "INSERT INTO anuncio (contenido, "
                                              + "correo, fecha_anuncio)"
                         + "VALUES ((?),(?),(?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, a.getNumero());
            ps.setString(2, a.getContent());
            ps.setString(3, u.getCorreo());
            ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.execute();
            
            //
        } catch (SQLException ex){   
        }   
    }
}
