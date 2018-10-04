/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import Modelo.Usuario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author vanes
 */
public class registrar extends HttpServlet {
    Connection con;
    Statement st;
    String nombre,correo,pass,depa,tipo;
    String urlbd = "jdbc:postgresql://bdd.inf.udec.cl/pigrupo1";
    String userbd = "pigrupo1";
    String passwordbd = "pigrupo1";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset-ISO-8859-1");
                nombre=request.getParameter("txtNombre");
                correo=request.getParameter("txtCorreo");
                pass=request.getParameter("txtPassword");
                String passencript=DigestUtils.md5Hex(pass);
                depa=request.getParameter("radio");
                tipo=request.getParameter("search_categories");
        try{
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(urlbd,userbd,passwordbd);
                st=con.createStatement();
                String query="insert into plataforma_colaborativa.usuario values ('"+correo+"','"+nombre+"','"+tipo+"','"+depa+"','"+passencript+"');";
                st.execute(query);
                System.out.println("datos insertados");
                }
                catch(Exception e){
                    e.printStackTrace();
                    System.out.println("datos no insertados");
                }
        Usuario u1 = new Usuario(nombre,correo,pass,depa,tipo);
        request.getSession().setAttribute("usuario1", u1);
        request.getRequestDispatcher("perfil.jsp").forward(request, response);
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
