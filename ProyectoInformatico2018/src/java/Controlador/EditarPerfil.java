/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreadeInteres;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author alexis
 */
@WebServlet(
        name = "Editar Perfil",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/EditarPerfil"}
)

public class EditarPerfil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarPerfil</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarPerfil at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Not working yet
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String[] areas = request.getParameterValues("interes");
        //Iterar y añadir a base de datos
        //Si un antiguo interes no se encuentra en los nuevos, remover de la base de datos

        // DatabaseConnect db_connect = null;
        Connection connect;
        Statement stmt = null;
        PreparedStatement update_stmt = null;
        PreparedStatement delete_stmt = null;
        HashMap<String, Boolean> is_interest = new HashMap();
        List<AreadeInteres> areas_usuario = new ArrayList<>();

        try {
            connect = DatabaseConnect.getConn();
            stmt = connect.createStatement();
            //add where mail coincides with user provided
            String query = "SELECT * FROM usuario_area WHERE correo='" + usuario.getCorreo() + "'";
            System.out.println(usuario.getCorreo());
            String query_delete = "DELETE FROM usuario_area WHERE correo=? AND tema=?";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.isBeforeFirst()) {
                System.out.println("No existen intereses previos");
            } else {
                while (rs.next()) {
                    String actual_area = rs.getString("tema");
                    boolean is_area = Arrays.asList(areas).contains(actual_area);
                    if (!is_area) {
                        if (delete_stmt == null) {
                            delete_stmt = connect.prepareStatement(query_delete);
                        }
                        System.out.println(actual_area + " sera eliminada de los intereses del usuario");
                        delete_stmt.setString(1, usuario.getCorreo());
                        delete_stmt.setString(2, actual_area);
                        delete_stmt.addBatch();

                    } else {
                        is_interest.put(actual_area, true);

                    }
                }
            }
            if (delete_stmt != null) {
                delete_stmt.executeBatch();
            }

            //Insert new interests in the Database
            String new_interest = "INSERT INTO plataforma_colaborativa.usuario_area(correo, tema) " + "VALUES(?, ?)";
            update_stmt = connect.prepareStatement(new_interest);
            for (String area : areas) {
                //if its already in database skip
                areas_usuario.add(new AreadeInteres(area));
                if (is_interest.containsKey(area)) {
                    continue;
                }
                update_stmt.setString(1, usuario.getCorreo());
                update_stmt.setString(2, area);
                update_stmt.addBatch();
            }
            //should check return value
            update_stmt.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(EditarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditarPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Actualizar areas en la sesion del usuario actual
        if (areas_usuario != null) {
            request.getSession().setAttribute("areas_usuario", areas_usuario);

        }
        request.getRequestDispatcher("perfil.jsp").forward(request, response);

      //  response.sendRedirect("perfil.jsp");
        // processRequest(request, response);
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
