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
 
}
