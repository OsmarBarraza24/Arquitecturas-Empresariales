/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import idao.ConductoresDAOImpl;
import database.baseDatos;
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
@WebServlet(name = "conductorServlet", urlPatterns = {"/conductorServlet"})
public class conductorServlet extends HttpServlet {

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
        ConductoresDAOImpl _usuarioDao = new ConductoresDAOImpl(_baseDatos.getConnection());
        
        int _opcion = (request.getParameter("op")!= null && !request.getParameter("op").isEmpty()? Integer.valueOf(request.getParameter("op")):0);
        int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id")): 0);
        String _nombreCompleto = (request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty() ? request.getParameter("nombre"): new String());
        int _edad = (request.getParameter("edad") != null && !request.getParameter("edad").isEmpty() ? Integer.valueOf(request.getParameter("edad")): 0);
        String _correo = (request.getParameter("correo") != null && !request.getParameter("correo").isEmpty() ? request.getParameter("correo"): new String());
        String _contrasena = (request.getParameter("contrasena") != null && !request.getParameter("contrasena").isEmpty() ? request.getParameter("contrasena"): new String());
        String _puntoCaptura = (request.getParameter("telefono") != null && !request.getParameter("telefono").isEmpty() ? request.getParameter("telefono"): new String());
        
        try {
            switch(_opcion){
                case 1 :{
                    //Agregar
                    Usuarios _usuario = new Usuarios();
                    _usuario.setNombreCompleto(_nombreCompleto.toUpperCase());
                    _usuario.setCuentaCorreo(_correo);
                    _usuario.setContrasena(_contrasena);
                    
                    _usuarioDao.agregarRegistro(_usuario);
                    break;
                }
                case 2 :{
                    //Editar
                    Usuarios _usuario = new Usuarios();
                    _usuario.setNombreCompleto(_nombreCompleto.toUpperCase());
                    _usuario.setCuentaCorreo(_correo);
                    _usuario.setContrasena(_contrasena);
                    
                    _usuarioDao.modificarRegistro(_usuario);
                    break;
                }
                case 3: {
                   
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        /*  
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet conductorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet conductorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
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
