/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;

import java.util.List;
import java.util.Optional;
import java.util.*;
import java.sql.*;

/**
 *
 * @author berko
 */
public class AreaDao implements IDao<AreadeInteres>{
    
    private static Connection conn = null;
    
    public AreaDao(){
        if (conn == null){
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced areadao");
    }

    @Override
    public Optional get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save(AreadeInteres t) {
        throw new UnsupportedOperationException("Need user_email! Use method save(Area, email) instead."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(AreadeInteres t, String user_email) {
        try{
            PreparedStatement ps = 
                conn.prepareStatement("insert on conflict ignore "
                                + "into area_de_interes"
                                + "values ((?))");
            ps.setString(1,t.getTema());
            PreparedStatement ps2 = conn.prepareStatement("insert"
                                + "into usuario_area(correo, tema)"
                                + "value (?),(?))");
            ps.setString(1, user_email);
            ps.setString(2, t.getTema());            
        } catch (SQLException s){            
        }
    }

    @Override
    public void update(AreadeInteres t, String[][] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AreadeInteres t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
