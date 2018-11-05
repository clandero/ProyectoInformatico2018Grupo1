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
                         + "(titulo, contenido, correo, fecha_anuncio)"
                         + "VALUES ((?),(?),(?),(?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, a.getTitulo());
            ps.setString(2, a.getContent());
            ps.setString(3, u.getCorreo());
            ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.execute();
            query = "SELECT * "
                    + "FROM anuncio "
                    + "WHERE titulo=(?) and  contenido=(?) and correo=(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, a.getTitulo());
            st.setString(2, a.getContent());
            st.setString(3, u.getCorreo());
            st.execute();
            ResultSet rs = st.getResultSet();
            System.out.println("AQUIIIIIIIIIIIIIIIII EN ANUNCIODAOdeRS"+rs);
            if(rs.next()){
            int n_anun = rs.getInt("n_anun");
            java.sql.Date fecha = rs.getDate("fecha_anuncio");
            a.setN_anun(n_anun);
            a.setFecha_anuncio(fecha);
            a.setCorreo(u.getCorreo());
            System.out.println("AQUIIIIIIIIIIIIIIIII EN ANUNCIODAO"+area.getTema());
            query = "INSERT INTO anuncio_area(n_anun, tema)"
                  + "VALUES ((?),(?))";
            ps = conn.prepareStatement(query);
            ps.setInt(1, n_anun);
            ps.setString(2, area.getTema());
            ps.execute();
            }
            else{
                System.out.println("AQUIIIIIIIIIIIIIIIII EN ANUNCIODAO de NEXT"+rs.next());
            }
            //
        } catch (SQLException ex){
            System.out.println(ex);
        }
        
    }
}