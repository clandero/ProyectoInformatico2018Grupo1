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
    
    private Connection conn = null;
    
    public UsuarioDao(){
        conn = DatabaseConnect.getConn();
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
                            "insert into usuario(email, password)"
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
     
    @Override
    public void update(Usuario user, String[][] params) {
        
        
    }
     
    @Override
    public void delete(Usuario user) {
        
    }
    
}
