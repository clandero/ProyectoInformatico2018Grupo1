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
        return null;
    }

    public Optional<Usuario> get(String correo, String pass){
        try{
            String query = "SELECT * "
                         + "FROM plataforma_colaborativa.usuario"
                         + "WHERE correo=(?) AND "
                         + "password=(?);";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            st.setString(2, pass);
            st.execute();
            ResultSet rs = st.getResultSet();
            Usuario user = new Usuario(rs.getString("nombre_usuario"),rs.getString("correo"), 
                                       rs.getString("password"), rs.getString("departamento"),
                                       rs.getString("tipo_usuario"));
            return Optional.ofNullable(user);
        } catch (SQLException ex){
            return Optional.ofNullable(null);
        }
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
                            "insert into usuario(nombre_usuario, correo, password, departamento, tipo_usuario)"
                           +"values ((?), (?), (?), (?), (?))");
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getCorreo());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getDepartamento());
            ps.setString(5, user.getTipoUsuario());            
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
    
    public void upFile(String correo, String tema, String titulo, String sv_path){
        try{
            String query = 
                "INSERT INTO documento(sv_path,correo,titulo) "
              + "VALUES ((?),(?),(?)) "
              + "RETURNING n_doc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sv_path);
            ps.setString(2, correo);
            ps.setString(3, titulo);
            ps.execute();            
            ResultSet rs = ps.getResultSet();
            int n_doc = 10000;
            if (rs.next()){
                n_doc = rs.getInt("n_doc");
            }
            query = 
                    "INSERT "
                  + "INTO documento_area(n_doc, tema) "
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
     
    @Override
    public void update(Usuario user, String[][] params) {
        
        
    }
     
    @Override
    public void delete(Usuario user) {
        
    }
    
}
