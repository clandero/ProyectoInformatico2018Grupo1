/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;

import java.util.Optional;
import java.util.*;
import java.sql.*;

/**
 *
 * @author berko
 */
public class AreaDao{
    
    private static Connection conn = null;
    
    public AreaDao(){
        if (conn == null){
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced areadao");
    }

    public Optional get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set getAll() {
        String query = "SELECT * FROM area_de_interes";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //PreparedStatement ps = conn.prepareStatement(query);
            //ps.execute();
            //ResultSet rs = ps.getResultSet();
           // List ls = new ArrayList<AreadeInteres>();
            Set<AreadeInteres> ls = new TreeSet();
            while (rs.next()){
                ls.add(new AreadeInteres(rs.getString("tema")));
            }
            return ls;
        } catch(SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    
    public Set getAll(Usuario u) {
        String query = "SELECT tema "
                     + "FROM usuario_area "
                     + "WHERE correo=(?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, u.getCorreo());
            ps.execute();
            ResultSet rs = ps.getResultSet();
            Set<AreadeInteres> ls = new TreeSet();
            while (rs.next()){
                ls.add(new AreadeInteres(rs.getString("tema")));
            }
            return ls;
        } catch(SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    
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

    public void update(AreadeInteres t, String[][] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(AreadeInteres t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}