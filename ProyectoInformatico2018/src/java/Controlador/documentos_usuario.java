/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DocumentoDao;
import Modelo.Documento;
import Modelo.Usuario;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin
 */
@WebServlet(name = "documentos_usuario", urlPatterns = {"/documentos_usuario"})
public class documentos_usuario extends HttpServlet {
    
    private static DocumentoDao documentodao = new DocumentoDao();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, Exception {
        //response.setContentType("text/html;charset-UTF-8");

        //out.println(p);
        Usuario usuario_perfil = (Usuario) request.getSession().getAttribute("usuario_perfil");

        List<Documento> res = documentodao.search(usuario_perfil.getCorreo());
        request.getSession().setAttribute("resultados", res);
        request.getRequestDispatcher("/documentos.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(documentos_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(documentos_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
