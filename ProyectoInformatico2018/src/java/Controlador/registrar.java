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
import javax.servlet.annotation.WebServlet;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author vanes
 */
@WebServlet(
        name = "Registrar",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/registrar"}
)

public class registrar extends HttpServlet {

    private static UsuarioDao userDao = new UsuarioDao();

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
        response.setContentType("text/html;charset-UTF-8");
        String nombre = request.getParameter("txtNombre");
        String correo = request.getParameter("txtCorreo");
        String pass = request.getParameter("txtPassword");
        String passencript = DigestUtils.md5Hex(pass);
        String depa = request.getParameter("radio");
        String tipo = request.getParameter("search_categories");
        Usuario u1 = new Usuario(nombre, correo, pass, depa, tipo);
        try {
            userDao.save(u1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("datos no insertados");
        }
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
