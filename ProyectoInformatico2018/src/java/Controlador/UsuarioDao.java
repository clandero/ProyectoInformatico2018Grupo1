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
    
    public UsuarioDao(){
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
        Connection conn = DatabaseConnect.getConn();
        try{
            PreparedStatement ps = 
                    conn.prepareStatement(
                            "insert into usuario((?),(?))"
                           +"values ((?),(?))");
            ps.setString(1, "name");
            ps.setString(2, "pass");
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getPassword());
            boolean status = ps.execute();
        } 
        catch (SQLException s){            
        }
        
    }
     
    @Override
    public void update(Usuario user, String[][] params) {
        
        
    }
     
    @Override
    public void delete(Usuario user) {
        
    }
    
}
