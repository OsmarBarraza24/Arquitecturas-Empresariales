/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.baseDatos;
import entity.Transportes;
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
@WebServlet(name = "transporteServlet", urlPatterns = {"/transporteServlet"})
public class transporteServlet extends HttpServlet {

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
        transporteDAOImpl _transporteDao = new  transporteDAOImpl(_baseDatos.getConnection());
        
        int _opcion = (request.getParameter("op")!= null && !request.getParameter("op").isEmpty()? Integer.valueOf(request.getParameter("op")):0);
        String _placas = (request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty() ? request.getParameter("nombre"): new String());
        String _marca = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion"): new String());
        String _modelo = (request.getParameter("contacto") != null && !request.getParameter("contacto").isEmpty() ? request.getParameter("contacto"): new String());
        String _descripcion = (request.getParameter("domicilio") != null && !request.getParameter("domicilio").isEmpty() ? request.getParameter("domicilio"): new String());
        
        try {
            switch(_opcion){
                case 1 :{
                    //Agregar
                    Transportes _transporte = new Transportes();
                    _transporte.setPlacas(_placas);
                    _transporte.setMarca(_marca);
                    _transporte.setModelo(_modelo);
                    _transporte.setDescripcion(_descripcion);
                    
                    _transporteDao.agregarRegistro(_transporte);
                    break;
                }
                case 2 :{
                    //Editar
                    Transportes _transporte = new Transportes();
                    _transporte.setPlacas(_placas);
                    _transporte.setMarca(_marca);
                    _transporte.setModelo(_modelo);
                    _transporte.setDescripcion(_descripcion);
                    
                    _transporteDao.modificarRegistro(_transporte);
                    break;
                }
                case 3: {
                    Transportes _transporte = new Transportes();
                     _transporteDao.eliminarRegistro(_transporte);
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
            out.println("<title>Servlet transporteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet transporteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
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
