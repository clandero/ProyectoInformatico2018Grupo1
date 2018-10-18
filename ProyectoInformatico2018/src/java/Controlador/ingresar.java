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
        name = "Ingresar",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/ingresar"}
)

public class ingresar extends HttpServlet {

    
    private static UsuarioDao userDao = new UsuarioDao();
    private static AreaDao areaDao = new AreaDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        System.err.println("aaaaaaaaaaaaaaaaaaaa");
        String correo = request.getParameter("txtCorreo");
        String pass = request.getParameter("txtPassword");
        String passencript = DigestUtils.md5Hex(pass);
        System.out.println("want to get "+ correo + ", "+pass+ "->"+passencript);
        Usuario u1 = userDao.get(correo, passencript);
        if (u1 == null){
            return;
        } else{
            System.out.println("listo lito");
        }
        
        request.getSession().setAttribute("usuario", u1);
        request.getSession().setAttribute("usuario_perfil", u1);            
        request.getSession().setAttribute("areas_existentes", areaDao.getAll());
        request.getSession().setAttribute("areas_usuario", areaDao.getAll(u1));
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
