/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelo.Usuario;
/**
 *
 * @author arken
 */
public class RegistrationServlet extends HttpServlet{
    
    private static IDao<Usuario> userDao = new UsuarioDao();
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws Exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset-UTF-8");    
        
        String mail = request.getParameter("correo");
        String pass = request.getParameter("password");
        String interests = request.getParameter("intereses");
        //out.println(p);
        
        System.out.println("received a post request");
        userDao.save(new Usuario(mail, pass, interests));
        
    }

    
}
