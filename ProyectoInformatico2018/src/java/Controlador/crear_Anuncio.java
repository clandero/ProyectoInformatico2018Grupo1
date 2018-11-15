/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AnuncioDao;
import Modelo.Anuncio;
import Modelo.AreadeInteres;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanes
 */
@WebServlet(name = "crear_Anuncio", urlPatterns = {"/crear_Anuncio"})
public class crear_Anuncio extends HttpServlet {

    private AnuncioDao anuncioDao = new AnuncioDao();
    
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
        response.setContentType("text/html;charset-ISO-8859-1");
        String titulo = request.getParameter("txtTitulo");
        String area = request.getParameter("txtArea");
        String contenido = request.getParameter("txtContenido");
        System.out.println("AQUIIIIIIIIIIIIIIIII EN DOPOST"+titulo);
        System.out.println("AQUIIIIIIIIIIIIIIIII EN DOPOST"+area);
        System.out.println("AQUIIIIIIIIIIIIIIIII EN DOPOST"+contenido);
        Anuncio an = new Anuncio(titulo, contenido);
        an.setTitulo(titulo);
        an.setContent(contenido);
        //Agregar tema fecha
        an.setFecha(LocalDate.now().toString());
        an.setTema(area);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        AreadeInteres areadeinteres = new AreadeInteres(area);
        anuncioDao.save(an, usuario, areadeinteres);
        //Actualizar anuncios usuario(no va a tener info de tema/fecha
        Set anuncios_usuario = (Set) request.getSession().getAttribute("anuncios_usuario");
        anuncios_usuario.add(an);
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
