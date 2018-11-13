/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DocumentoDao;
import Modelo.AreaDao;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.*;
import javax.servlet.http.Part;

/**
 *
 * @author arken
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    
    private final static Logger LOGGER = 
            Logger.getLogger(FileUploadServlet.class.getCanonicalName());
    
    private static DocumentoDao docDao = new DocumentoDao();

    private static AreaDao areaDao = new AreaDao();


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {   

    
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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

        Set allTemas = areaDao.getAll();

        request.getSession().setAttribute("temas", allTemas);
        request.getRequestDispatcher("upload.jsp").forward(request, response);        
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
        response.setContentType("text/html;charset=UTF-8");

        // Create path components to save the file
        ServletContext sc = getServletContext();
        String contextpath = sc.getRealPath(File.separator);
        //final String mail = request.getParameter("correo");
        final String mail = ((Usuario)request.getSession().
                        getAttribute("usuario_perfil")).getCorreo();    
        String tema = request.getParameter("tema");
        final String checkotro = request.getParameter("checkotro");
        if (checkotro != null){
            tema = request.getParameter("otro");
        }        
        final String path = contextpath+"docs";
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);    

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        
        if (tema == null || tema.equals("")){
            request.getSession().setAttribute("success", false);
            request.getSession().setAttribute("message", "Debe seleccionar un tema");
            request.getRequestDispatcher("upload.jsp").forward(request, response);     
            return;
        }
        if (fileName.equals("") || fileName.equals("")){
            request.getSession().setAttribute("success", false);
            request.getSession().setAttribute("message", "Debe seleccionar un archivo");
            request.getRequestDispatcher("upload.jsp").forward(request, response);    
            return;
        }

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                    new Object[]{fileName, path});
            docDao.save(mail, tema, fileName, "/docs/"+fileName);
        } catch (FileNotFoundException fne) {
            request.getSession().setAttribute("success", false);            
            String message = "You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.";
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("upload.jsp").forward(request, response);        
            

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                    new Object[]{fne.getMessage()});
        } finally {
            
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            request.getSession().setAttribute("success", true);            
            request.getRequestDispatcher("upload.jsp").forward(request, response);        
            if (writer != null) {
                writer.close();
            }            
        }
        
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
