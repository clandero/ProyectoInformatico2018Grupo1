/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreadeInteres;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
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

        //cambiar a usar daos
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String[] areas = request.getParameterValues("interes");
        Connection connect;
        PreparedStatement insert_stmt, delete_stmt;
        Set<AreadeInteres> areas_usuario = (TreeSet<AreadeInteres>) request.getSession().getAttribute("areas_usuario");
        Set<AreadeInteres> areas_olvidadas = new TreeSet<>();
        connect = DatabaseConnect.getConn();
        AreadeInteres tmp;
        // Delete areas que el usuario poseia y no fueron seleccionadas
        try {
            String delete_query = "DELETE FROM usuario_area WHERE correo=\'" + usuario.getCorreo() + "\' AND tema = ?";
            delete_stmt = connect.prepareStatement(delete_query);

            for (AreadeInteres area : areas_usuario) {
                if (areas == null || !Arrays.asList(areas).contains(area.getTema())) {
                    delete_stmt.setString(1, area.getTema());
                    delete_stmt.addBatch();
                    areas_olvidadas.add(area);
                }
            }
            //actualizar BD y areas del usuario
            delete_stmt.executeBatch();
            areas_usuario.removeAll(areas_olvidadas);
            //No se puede actuaizar si no hay elementos
            if (areas != null) {
                //Insertar areas que el usuario selecciono
                //No se deben insertar las que el usuario ya poseia previamente
                //para evitar excepcion
                String insert_query = "INSERT INTO usuario_area(correo, tema) " + "VALUES('" + usuario.getCorreo() + "', ?)";
                insert_stmt = connect.prepareStatement(insert_query);
                for (String area : areas) {
                    tmp = new AreadeInteres(area);
                    if (!areas_usuario.contains(tmp)) {
                        insert_stmt.setString(1, area);
                        insert_stmt.addBatch();
                        areas_usuario.add(tmp);

                    }
                }
                insert_stmt.executeBatch();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("areas_usuario", areas_usuario);
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