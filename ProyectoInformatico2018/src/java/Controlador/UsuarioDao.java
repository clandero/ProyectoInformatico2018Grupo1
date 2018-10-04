/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.util.*;
import java.sql.*;
/**
 *
 * @author arken
 */
public class UsuarioDao implements IDao<Usuario>{
    
    private static Connection conn = null;
    
    public UsuarioDao(){
        if (conn == null){
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced userdao");
    }
    
    @Override
    public Optional<Usuario> get(long id){
        Connection conn = DatabaseConnect.getConn();
        try{
            PreparedStatement ps = 
                    conn.prepareStatement("select * "
                                        + "from Usuario"
                                        + "where id=(?)");           
            ps.setInt(1, (int) id);
            boolean status = ps.execute();
            ResultSet result = ps.getResultSet();
        } 
        catch (SQLException s){            
        }        
        return Optional.ofNullable(new Usuario());
    }
    
     
    @Override
    public List<Usuario> getAll() {
        return new ArrayList<Usuario>();
    }
     
    @Override
    public void save(Usuario user) {
        System.out.println("userdao wants to save");
        try{
            PreparedStatement ps = 
                    conn.prepareStatement(
                            "insert into usuario(correo, password)"
                           +"values ((?),(?))");
            ps.setString(1, user.getCorreo());
            ps.setString(2, user.getPassword());
            boolean status = ps.execute();
            System.out.println("finished save");
            System.out.println(status);
        } 
        catch (SQLException s){  
            System.out.println(s);
        }
        
    }
    
    public Hashtable<String, ArrayList<String>> getUser(String p, String q) throws Exception{
        try{
            PreparedStatement statement = null;
            Hashtable<String, ArrayList<String>> personas = new Hashtable<String, ArrayList<String>>();
            if(q.equals("area")){
                if(p.equals("ia") || p.equals("ai") || p.equals("inteligencia artificial")){
                    p = "Inteligencia Artificial";
                }
                if(p.equals("robotica")){
                    p = "Robotica";
                }
                statement = conn.prepareStatement("SELECT u.nombre_usuario, u.correo FROM plataforma_colaborativa.usuario as u, plataforma_colaborativa.usuario_area as ua WHERE ua.tema = '"+p+"' AND ua.correo = u.correo");
                ResultSet result = statement.executeQuery();
                while(result.next()){
                    ArrayList<String> datos = new ArrayList<String>();
                    datos.add(result.getString("correo"));
                    personas.put(result.getString("nombre_usuario"), datos);
                }
            }
            else if(q.equals("depto")){
                if(p.equals("informatica") || p.equals("informática") || p.equals("Informática") || p.equals("Informatica")){
                    p = "Ingeniería Informática";
                }
                statement = conn.prepareStatement("SELECT u.nombre_usuario, u.correo, area.tema FROM plataforma_colaborativa.usuario as u, plataforma_colaborativa.usuario_area as area WHERE u.departamento = '"+p+"' AND u.correo = area.correo");
                ResultSet result = statement.executeQuery();
                while(result.next()){
                    ArrayList<String> datos = new ArrayList<String>();
                    if(personas.containsKey(result.getString("nombre_usuario"))){
                        datos = personas.get(result.getString("nombre_usuario"));
                        datos.add(result.getString("tema"));
                        personas.put(result.getString("nombre_usuario"), datos);
                    }
                    else{
                        datos.add(result.getString("correo"));
                        datos.add(result.getString("tema"));
                        personas.put(result.getString("nombre_usuario"), datos);
                    }
                }
            }
            return personas;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
     
    @Override
    public void update(Usuario user, String[][] params) {
        
        
    }
     
    @Override
    public void delete(Usuario user) {
        
    }
    
}
