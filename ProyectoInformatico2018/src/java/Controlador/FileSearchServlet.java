/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author berko
 */
@WebServlet(name = "FileSearchServlet", urlPatterns = {"/buscarTrabajo"})
public class FileSearchServlet extends HttpServlet {

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
        Connection conn = DatabaseConnect.getConn();
        String keyword = request.getParameter("keyword");
        String topic = request.getParameter("topic");
        try{
            String query = 
                "SELECT a.tema, d.titulo " +
                "FROM area_de_interes as a, documento_area as d_a, documento as d " +
                "WHERE a.tema = d_a.tema " +
                "AND d.n_doc = d_a.n_doc ";
            
              //+ "AND a.tema = (?)"
              //+ "AND d.title LIKE %(?)%"
            PreparedStatement ps = conn.prepareStatement(query);
            //ps.setString(1, topic);
            //ps.setString(2, keyword);
            ResultSet result = ps.executeQuery();
            Hashtable<String, ArrayList<String>> files = new Hashtable<String, ArrayList<String>>();

            while(result.next()){
                ArrayList<String> datos = new ArrayList<String>();
                datos.add(result.getString("titulo"));
                files.put(result.getString("tema"), datos);                    
            }
            request.getSession().setAttribute("resultados", files);
            request.getRequestDispatcher("resultadosBusqueda.jsp").forward(request, response);
        
        } catch(SQLException | NullPointerException ex){
            System.out.println(ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
