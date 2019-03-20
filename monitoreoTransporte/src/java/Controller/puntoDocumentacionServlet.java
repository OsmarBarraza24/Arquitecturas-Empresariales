package controller;

import DAO.databaseImpl.usuariosDAOImpl;
import database.baseDatos;
import entity.Conductores;
import entity.EquipoGPS;
import entity.PuntoCaptura;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PuntoCapturaServlet", urlPatterns = {"/PuntoCapturaServlet"})
public class puntoDocumentacionServlet extends HttpServlet {

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
        usuariosDAOImpl _usuarioDAO = new usuariosDAOImpl(_baseDatos.getConnection());

        int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op")) : 0);

        int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id")) : 0);

        String _nombreCompleto = (request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty() ? request.getParameter("nombre") : new String());
        String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion") : new String());
        String _direccion = (request.getParameter("direccion") != null && !request.getParameter("direccion").isEmpty() ? request.getParameter("direccion") : new String());

        try {

            switch (_opcion) {
                case 1: {

                    // Agregar
                    PuntoCaptura _PuntoCaptura = new PuntoCaptura();

                    _PuntoCaptura.setNombreCompleto(_nombreCompleto.toUpperCase());
                    _PuntoCaptura.setDescripcion(_descripcion.toUpperCase());
                    _PuntoCaptura.setDireccion(_direccion.toUpperCase());

                    _usuarioDAO.agregarRegistro(_PuntoCaptura);

                    break;
                }
                case 2: {

                    // Editar
                    PuntoCaptura _PuntoCaptura = new PuntoCaptura();

                    _PuntoCaptura.getNombreCompleto();
                    _PuntoCaptura.getDescripcion();
                    _PuntoCaptura.getDireccion();

                    _usuarioDAO.actualizarRegistro(_PuntoCaptura);
                    break;
                }
                case 3: {

                    // Eliminar
                    PuntoCaptura _PuntoCaptura = new PuntoCaptura();
                    int fila = _PuntoCaptura.getId();
                    String cod = "";
                    
                    break;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (_baseDatos != null) {
                _baseDatos.closeConnection();
            }

            response.sendRedirect("/ejemploWS/views/catalogos/usuarios/usuariosVistaTabla.jsp");
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


