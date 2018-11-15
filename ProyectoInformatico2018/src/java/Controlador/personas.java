/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AnuncioDao;
import Modelo.DepartamentoDao;
import Modelo.AreaDao;
import Modelo.UsuarioDao;
import Modelo.AreadeInteres;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vanes
 */
@WebServlet(name = "personas", urlPatterns = {"/personas"})
public class personas extends HttpServlet {
    private static UsuarioDao userDao = new UsuarioDao();
    private static AreaDao areaDao = new AreaDao();
    private static DepartamentoDao depaDao = new DepartamentoDao();
    private static AnuncioDao anuncioDao = new AnuncioDao();
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
        response.setContentType("text/html;charset=ISO-8859-9");    
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

         response.setContentType("text/html;charset-UTF-8");  
         String userCorreo = request.getParameter("person"); 
         Usuario u1 = userDao.getUser(userCorreo);
         System.out.println("AQUIII EN PERSONAS"+userCorreo);
         if(request.getAttribute("person2")!=null){
             System.out.println("EL PERSON2 NO ESTA VACIO -------------------"+((Usuario)request.getAttribute("person2")).getNombreUsuario());
         }
        String depa = Integer.toString(u1.getDepartamento());
        System.out.println("AQUIII EL DEPARTAMENTO");
        request.getSession().setAttribute("depa_usuario2",depaDao.get_nombre(depa));
        request.getSession().setAttribute("usuario2", u1);   
        request.getSession().setAttribute("usuario_nombre2", u1.getNombreUsuario());
        request.getSession().setAttribute("usuario_tipo2", u1.getTipoUsuario());
        request.getSession().setAttribute("usuario_correo2", u1.getCorreo());
        request.getSession().setAttribute("areas_existentes2", areaDao.getAll());
        request.getSession().setAttribute("areas_usuario2", areaDao.getAll(u1));
        request.setAttribute("anuncios_usuario2", anuncioDao.getAll(u1));
        request.getRequestDispatcher("perfilSimple.jsp").forward(request, response);
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
