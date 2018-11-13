/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Anuncio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexis
 */
@WebServlet(name = "EditarAnuncio", urlPatterns = {"/editar_anuncio"})
public class EditarAnuncioServlet extends HttpServlet {

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
        //Retirar numero de anuncio
        int num_anuncio = Integer.parseInt(request.getParameter("anuncio"));
        Set<Anuncio> anuncios_usuario = (Set<Anuncio>) request.getSession().getAttribute("anuncios_usuario");
        request.getSession().setAttribute("num_anuncio_editar", num_anuncio);
        //Iterar o consultar directo en BD?
        for (Anuncio anuncio : anuncios_usuario) {
            if (anuncio.getNumero() == num_anuncio) {
                request.setAttribute("anuncio_editar", anuncio);
                break;
            }
        }

        request.getRequestDispatcher("editar_anuncio.jsp").forward(request, response);
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

        String titulo = request.getParameter("titulo_anuncio");
        String contenido = request.getParameter("contenido_anuncio");
        String tema = request.getParameter("area_anuncio");
        int num_anuncio = (int) request.getSession().getAttribute("num_anuncio_editar");

        AnuncioDao dao = new AnuncioDao();
        dao.update(num_anuncio, titulo, contenido, tema);
        
        //Hay que actualizar datos en el TreeSet de anuncios de usuario.
        Set<Anuncio> anuncios_usuario = (Set<Anuncio>) request.getSession().getAttribute("anuncios_usuario");
        for (Anuncio anuncio : anuncios_usuario) {
            if (anuncio.getNumero() == num_anuncio) {
                anuncio.setTitulo(titulo);
                anuncio.setContent(contenido);
                anuncio.setTema(tema);
                break;
            }
        }

        request.getSession().removeAttribute("num_anuncio_editar");
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
