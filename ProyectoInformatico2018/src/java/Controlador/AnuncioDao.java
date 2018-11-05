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
    public ArrayList<Anuncio> getAnuncios(ArrayList<AreadeInteres> x){
        ArrayList<Anuncio> res = new ArrayList<Anuncio>();
        try{
            for(AreadeInteres i : x){
                String query = "SELECT a.n_anun, a.contenido, us.nombre_usuario, a.fecha_anuncio FROM plataforma_colaborativa.anuncio as a, plataforma_colaborativa.anuncio_area as x, plataforma_colaborativa.usuario as us WHERE a.n_anun = x.n_anun AND x.tema = '"+i.getTema()+"' AND a.correo = us.correo";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.execute();
                ResultSet rs = ps.getResultSet();
                while (rs.next()){
                    res.add(new Anuncio(rs.getInt("n_anun"),rs.getString("nombre_usuario"),rs.getString("contenido"),rs.getString("fecha_anuncio"),i.getTema()));
                }
            }
            return res;
        } catch (SQLException ex){   
        }
        return null;
    }
}
