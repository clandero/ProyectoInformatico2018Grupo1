/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreadeInteres;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author vanes
 */
@WebServlet(
        name = "Ingresasr",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/ingresar"}
)

public class ingresar extends HttpServlet {

    Connection con;
    Statement st;
    String correo, pass;
    String urlbd = "jdbc:postgresql://bdd.inf.udec.cl/pigrupo1";
    String userbd = "pigrupo1";
    String passwordbd = "pigrupo1";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        System.err.println("aaaaaaaaaaaaaaaaaaaa");
        correo = request.getParameter("txtCorreo");
        pass = request.getParameter("txtPassword");
        String passencript = DigestUtils.md5Hex(pass);
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(urlbd, userbd, passwordbd);
            st = con.createStatement();
            String query = "SELECT * FROM plataforma_colaborativa.usuario WHERE correo='" + correo + "' AND password='" + passencript + "';";
            st.executeQuery(query);
            //System.out.println("usuario valido valido");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("datos no insertados");
        }
        String datos = "SELECT * FROM plataforma_colaborativa.usuario WHERE correo='" + correo + "';";
        String consulta_areas = "SELECT * FROM plataforma_colaborativa.area_de_interes";
        String consulta_areas_usuario = "SELECT * FROM plataforma_colaborativa.usuario_area WHERE correo='" + correo + "'";
        List<AreadeInteres> areas_existentes = new ArrayList<>();
        List<AreadeInteres> areas_usuario = new ArrayList<>();
        Statement s = null;
        ResultSet res_areas;
        try {
            s = con.createStatement();
            ResultSet res = s.executeQuery(datos);
            while (res.next()) {
                String nombre = res.getString("nombre_usuario");
                String tipo = res.getString("tipo_usuario");
                String depa = res.getString("departamento");
                Usuario u1 = new Usuario(nombre, correo, pass, depa, tipo);
                request.getSession().setAttribute("usuario_existente", u1);
                request.getSession().setAttribute("usuario_perfil", u1);

            }
            res_areas = s.executeQuery(consulta_areas);
            while (res_areas.next()) {
                areas_existentes.add(new AreadeInteres(res_areas.getString("tema")));
            }
            request.getSession().setAttribute("areas_existentes", areas_existentes);

            res_areas = s.executeQuery(consulta_areas_usuario);
            while (res_areas.next()) {
                areas_usuario.add(new AreadeInteres(res_areas.getString("tema")));
            }

            request.getSession().setAttribute("areas_usuario", areas_usuario);
            request.getRequestDispatcher("perfil.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ingresar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
