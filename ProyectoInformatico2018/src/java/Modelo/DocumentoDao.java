/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DatabaseConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

import java.io.File;

import java.nio.file.NoSuchFileException;


import Modelo.*;
import java.util.List;


/**
 *
 * @author berko
 */
public class DocumentoDao {
    
    private static Connection conn;

    // FALTA SABER EL PATH DEL SERVIDOR, PARA BORRAR LOS ARCHIVOS EN /DOCS/
    private static String contextPath = null;
    
    public DocumentoDao(){
        if (conn == null){
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced docdao");
    }
    
    public void save(String correo, String tema, String titulo, String sv_path){
        try{
            String query = 

                "INSERT INTO documento(sv_path, correo,titulo, fecha_documento) "
              + "VALUES ((?),(?),(?), (?)) "

              + "RETURNING n_doc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sv_path);
            ps.setString(2, correo);
            ps.setString(3, titulo);

            ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));

            ps.execute();            
            ResultSet rs = ps.getResultSet();
            int n_doc = 10000;
            if (rs.next()){
                n_doc = rs.getInt("n_doc");

            } else{
                System.out.println("Error adding document");
                return;
            }
            // Verificar si el tema dado existe
            query = "SELECT tema FROM area_de_interes WHERE tema = (?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, tema);
            ps.execute();
            rs = ps.getResultSet();
            if (!(rs.next())){
                // Si no existe, agregarlo
                query = "INSERT INTO area_de_interes "
                        + "VALUES ((?))";
                ps = conn.prepareStatement(query);
                ps.setString(1, tema);
                ps.execute();
            }
            
            query = 
                    "INSERT INTO documento_area(n_doc, tema) "
                  + "VALUES ((?),(?))";
            ps = conn.prepareStatement(query);
            ps.setInt(1, n_doc);
            ps.setString(2, tema);
            ps.execute();
            query = 
                    "INSERT "
                  + "INTO usuario_area(correo, tema) "
                  + "VALUES ((?),(?))";
            ps = conn.prepareStatement(query);
            ps.setString(1, correo);
            ps.setString(2, tema);
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<String> search(String correo){
        try{
            String query = 
                "SELECT d.titulo " +
                "FROM documento as d " +
                "WHERE d.correo = (?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, correo);
            //ps.setString(1, topic);
            //ps.setString(2, keyword);
            ResultSet result = ps.executeQuery();
            ArrayList<String> datos = new ArrayList<String>();
            while(result.next()){                
                datos.add(result.getString("titulo"));
            }
            return datos;
        } catch(SQLException ex){
            System.out.println(ex);
        }
        return null;

    }
    
    public Hashtable<String, ArrayList<String>> search(String keyword, String tema){
        try{
            String query = 
                "SELECT a.tema, d.titulo " +
                "FROM area_de_interes as a, documento_area as d_a, documento as d " +
                "WHERE a.tema = d_a.tema " +
                "AND d.n_doc = d_a.n_doc " +
                "AND d.title LIKE %(?)%" +
                "AND a.tema LIKE %(?)%";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, keyword);
            ps.setString(2, tema);
               
            ResultSet result = ps.executeQuery();
            Hashtable<String, ArrayList<String>> files = new Hashtable<String, ArrayList<String>>();

            while(result.next()){
                ArrayList<String> datos = new ArrayList<String>();
                datos.add(result.getString("titulo"));
                files.put(result.getString("tema"), datos);                    
            }
            return files;
        } catch(SQLException ex){
            System.out.println(ex);
        }
        return null;
    }
    
    public ArrayList<ArrayList<String>> genSearch(String keyword, String term){
        try{
            String query;
            if(term.equals("titulo")){
                query=
                        "SELECT a.tema, d.titulo, d.correo "+
                        "FROM area_de_interes as a, documento_area as d_a, documento as d "+
                        "WHERE a.tema=d_a.tema "+
                        "AND d.n_doc = d_a.n_doc " +
                        "AND d.titulo ILIKE ?";
                System.out.println("titulo searched");
            }
            else if(term.equals("tema")){
                query=
                        "SELECT a.tema, d.titulo, d.correo "+
                        "FROM area_de_interes as a, documento_area as d_a, documento as d "+
                        "WHERE a.tema=d_a.tema "+
                        "AND d.n_doc = d_a.n_doc " +
                        "AND a.tema ILIKE ?";
            }
            else{
                query="Invalid query";
                System.out.println("Invalid search term type");
            }
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%"+keyword+"%");
               
            ResultSet result = ps.executeQuery();
            ArrayList<ArrayList<String>> files = new ArrayList<ArrayList<String>>();
            
            while(result.next()){
                ArrayList<String> datos = new ArrayList<String>();
                datos.add(result.getString("titulo"));
                datos.add(result.getString("tema"));
                datos.add(result.getString("correo"));
                files.add(datos);
            }
            
            return files;
        } catch(SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    public static void setContext(String cPath){
        if (contextPath == null){
            contextPath = cPath;
        }
        
    }
    
    public void delete(int n_doc, String correo){
        String query = "SELECT * "
                     + "FROM documento "
                     + "WHERE n_doc = (?) AND "
                     + "correo = (?) ";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, n_doc);
            ps.setString(2, correo);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (!(rs.next())){
                System.out.println("File does not exist, "
                        + "or is not owned by "+ correo);
                return;
            }
            query = "DELETE FROM documento_area "
                     + "WHERE n_doc = (?) ";
            ps = conn.prepareStatement(query);
            ps.setInt(1, n_doc);
            ps.execute();
            query = "DELETE FROM documento "
                    + "WHERE n_doc = (?) ";
            ps = conn.prepareStatement(query);
            ps.setInt(1, n_doc);
            ps.execute();
            File to_delete = new File(contextPath + File.separator +
                                     rs.getString("sv_path"));
            to_delete.delete();
            
        } catch(SQLException ex){
            System.out.println(ex);
        }      
        
    }
    
}

