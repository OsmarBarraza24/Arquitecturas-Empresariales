/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.baseDatos;
import entity.PerfilUsuario;
import entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mario
 */
@WebServlet(name = "tipoUsuarioServlet", urlPatterns = {"/tipoUsuarioServlet"})
public class tipoUsuarioServlet extends HttpServlet {

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
         baseDatos _baseDatos = new baseDatos();
        perfilUsuarioDAOImpl _perfilUsuarioDao = new perfilUsuarioDAOImpl(_baseDatos.getConnection());
        
        int _opcion = (request.getParameter("op")!= null && !request.getParameter("op").isEmpty()? Integer.valueOf(request.getParameter("op")):0);
        String _nombreCompleto = (request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty() ? request.getParameter("nombre"): new String());
        String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion"): new String());
        
        try {
            switch(_opcion){
                case 1 :{
                    //Agregar
                    PerfilUsuario _perfilUsuario = new PerfilUsuario();
                    _perfilUsuario.setNombreCompleto(_nombreCompleto.toUpperCase());
                    _perfilUsuario.setDescripcion(_descripcion);
                    
                    _perfilUsuarioDao.agregarRegistro(_perfilUsuario);
                    break;
                }
                case 2 :{
                    //Editar
                   PerfilUsuario _perfilUsuario = new PerfilUsuario();
                    _perfilUsuario.setNombreCompleto(_nombreCompleto.toUpperCase());
                    _perfilUsuario.setDescripcion(_descripcion);
                    
                    _perfilUsuarioDao.modificarRegistro(_perfilUsuario);
                    break;
                }
                case 3: {
                   PerfilUsuario _perfilUsuario = new PerfilUsuario();
                    _perfilUsuarioDao.eliminarRegistro(_perfilUsuario);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            /* TODO output your page here. You may use following sample code. */
        /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet tipoUsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tipoUsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
/*
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
}