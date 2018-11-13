/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DepartamentoDao;
import Modelo.DocumentoDao;
import Modelo.AreaDao;
import Modelo.UsuarioDao;
import Modelo.AreadeInteres;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vanes
 */
@WebServlet(
        name = "Registrar",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/registrar"}
)

public class registrar extends HttpServlet {

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
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("ISO-8859-9");
        String nombre = request.getParameter("txtNombre");
        String correo = request.getParameter("txtCorreo");
        String pass = request.getParameter("txtPassword");
        String passencript = DigestUtils.md5Hex(pass);
        String depa = request.getParameter("radio");
        out.println(depa);
        String tipo = request.getParameter("search_categories");
        //Buscar en BD departamento por nombre departamento para obtener numero
        Usuario u1 = new Usuario(nombre, correo, passencript, depa,
                new DepartamentoDao().get(depa), tipo);
        boolean correo_valido=true;
        try {
            String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
            Pattern pattern = Pattern.compile(emailPattern);
            if (correo != null) {
                Matcher matcher = pattern.matcher(correo);
                if (matcher.matches()) {
                    System.out.println("válido");
                }
                else {
                    correo_valido=false;
                    String message = "Correo en formato incorrecto. Por favor, intente nuevamente.";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                }
            }
            if(correo_valido==true){
            boolean chequeo=userDao.save(u1);
            if(chequeo==false){
                String message = "El correo ya se encuentra registrado.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("depa_usuario", depa);
        request.getSession().setAttribute("usuario", u1);
        request.getSession().setAttribute("usuario_perfil", u1);     
        request.getSession().setAttribute("usuario_nombre", u1.getNombreUsuario());
        request.getSession().setAttribute("usuario_tipo", u1.getTipoUsuario());
        request.getSession().setAttribute("usuario_correo", u1.getCorreo());
        request.getSession().setAttribute("areas_existentes", areaDao.getAll());
        request.getSession().setAttribute("areas_usuario", areaDao.getAll(u1));

        try{
        Vector<Usuario> v= new Vector<Usuario>();
        v = userDao.getPersonasComun((TreeSet)areaDao.getAll(u1),u1);
        for(int i=0;i<v.size();i++){
            List<AreadeInteres> l = new ArrayList<AreadeInteres>();
            l.addAll(areaDao.getAll(v.get(i)));
            v.get(i).setIntereses(l);
        }
        request.getSession().setAttribute("personasInteresesComun",v);
       
        }catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("documentos_usuario", documentoDao.search(u1.getCorreo()));

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
