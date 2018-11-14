/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AreaDao;
import Modelo.AreadeInteres;
import Modelo.DepartamentoDao;
import Modelo.DocumentoDao;
import Modelo.Usuario;
import Modelo.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arken
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/perfil"})
public class ProfileServlet extends HttpServlet {
    
    private static UsuarioDao userDao = new UsuarioDao();
    private static AreaDao areaDao = new AreaDao();
    private static DepartamentoDao depaDao = new DepartamentoDao();
    private static DocumentoDao documentoDao = new DocumentoDao();

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
        
        Usuario u1 = (Usuario) request.getSession().getAttribute("usuario");
        try {
            Vector<Usuario> v = new Vector<Usuario>();
            v = userDao.getPersonasComun((TreeSet) areaDao.getAll(u1), u1);
            for (int i = 0; i < v.size(); i++) {
                List<AreadeInteres> l = new ArrayList<AreadeInteres>();
                l.addAll(areaDao.getAll(v.get(i)));
                v.get(i).setIntereses(l);

            }
            request.getSession().setAttribute("personasInteresComun", v);

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("documentos_usuario", documentoDao.search(u1.getCorreo()));
        request.getRequestDispatcher("perfil.jsp").forward(request, response);
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
