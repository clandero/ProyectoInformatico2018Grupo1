/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;


/**
 *
 * @author alexis
 */
public class DepartamentoDao {

    private static Connection conn = null;

    public DepartamentoDao() {
        if (conn == null) {
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced userdao");
    }

    public int get(String nombre) {
        try {
            String query = "SELECT * "
                    + "FROM departamento "
                    + "WHERE nombre_departamento=(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nombre);
            st.execute();
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                int res = rs.getInt("n_departamento");
                return res;
            } else {
                System.out.println("no more rs");
                return -1;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
        }
    }
    public String get_nombre(String num){
        try {
            int numero=Integer.parseInt(num);
            String query = "SELECT * "
                    + "FROM departamento "
                    + "WHERE n_departamento=(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, numero);
            st.execute();
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                String res = rs.getString("nombre_departamento");
                return res;
            } else {
                System.out.println("no more rs");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public List<String> getDepartamentos(){
        try {
            String query = "SELECT nombre_departamento "
                    + "FROM departamento";
            PreparedStatement st = conn.prepareStatement(query);
            st.execute();
            ResultSet rs = st.getResultSet();
            List<String> listaDepartamentos = new ArrayList<String>();
            while (rs.next()) {
                String nombre_depa=rs.getString("nombre_departamento");
                listaDepartamentos.add(nombre_depa);
            }
            System.out.println("AQUI LOS NOMBRES :  "+listaDepartamentos);
            return listaDepartamentos;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
 
}
