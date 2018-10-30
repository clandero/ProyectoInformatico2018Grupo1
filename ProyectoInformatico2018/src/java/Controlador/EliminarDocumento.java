/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author Martin
 */
@WebServlet(
        name = "Eliminar Documento",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/EliminarDocumento"}
)
public class EliminarDocumento extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarDocumento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarDocumento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Not working yet
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String[] documentos = request.getParameterValues("documento");
        //Iterar y añadir a base de datos
        //Si un antiguo interes no se encuentra en los nuevos, remover de la base de datos

        // DatabaseConnect db_connect = null;
        Connection connect;
        Statement stmt = null;
        PreparedStatement update_stmt = null;
        DocumentoDao documento_usuario = new DocumentoDao();

        try {
            connect = DatabaseConnect.getConn();
            stmt = connect.createStatement();
            //add where mail coincides with user provided

            String del_doc = "DELETE FROM plataforma_colaborativa.documento WHERE correo=? AND titulo=?";
            update_stmt = connect.prepareStatement(del_doc);
            for (String documento : documentos) {
                update_stmt.setString(1, usuario.getCorreo());
                update_stmt.setString(2, documento);
                update_stmt.addBatch();
            }
            //should check return value
            update_stmt.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(EliminarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EliminarDocumento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Actualizar los documentos del usuario
        
        if (documento_usuario != null) {
            request.getSession().setAttribute("documentos_usuario", documento_usuario.search(usuario.getCorreo()));

        }
        request.getRequestDispatcher("perfil.jsp").forward(request, response);

      //  response.sendRedirect("perfil.jsp");
        // processRequest(request, response);
    }    
}
