package controller;

import DAO.databaseImpl.usuariosDAOImpl;
import database.baseDatos;
import entity.EquipoGPS;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EquipoGPSServlet", urlPatterns = {"/EquipoGPSServlet"})
public class gpsServlet extends HttpServlet {

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
        String _marca = (request.getParameter("marca") != null && !request.getParameter("marca").isEmpty() ? request.getParameter("marca") : new String());
        String _modelo = (request.getParameter("modelo") != null && !request.getParameter("modelo").isEmpty() ? request.getParameter("modelo") : new String());
        String _numeroSerie = (request.getParameter("numeroSerie") != null && !request.getParameter("numeroSerie").isEmpty() ? request.getParameter("numeroSerie") : new String());
        String _imeiGPS = (request.getParameter("imeiGPS") != null && !request.getParameter("imeiGPS").isEmpty() ? request.getParameter("imeiGPS") : new String());
        String _chipTelefono = (request.getParameter("chipTelefono") != null && !request.getParameter("chipTelefono").isEmpty() ? request.getParameter("chipTelefono") : new String());
        String _imeiChip = (request.getParameter("imeiChip") != null && !request.getParameter("imeiChip").isEmpty() ? request.getParameter("imeiChip") : new String());
        String _digitoSeguridad = (request.getParameter("digitoSeguridad") != null && !request.getParameter("digitoSeguridad").isEmpty() ? request.getParameter("digitoSeguridad") : new String());

        try {

            switch (_opcion) {
                case 1: {

                    // Agregar
                    EquipoGPS _EquipoGPS = new EquipoGPS();

                    _EquipoGPS.setNombreCompleto(_nombreCompleto.toUpperCase());
                    _EquipoGPS.setMarca(_marca.toUpperCase());
                    _EquipoGPS.setModelo(_modelo.toUpperCase());
                    _EquipoGPS.setNumeroSerie(_numeroSerie.toUpperCase());
                    _EquipoGPS.setImeiGPS(_imeiGPS.toUpperCase());
                    _EquipoGPS.setChipTelefono(_chipTelefono.toUpperCase());
                    _EquipoGPS.setImeiChip(_imeiChip.toUpperCase());
                    _EquipoGPS.setDigitoSeguridad(_digitoSeguridad.toUpperCase());

                    _usuarioDAO.agregarRegistro(_EquipoGPS);

                    break;
                }
                case 2: {

                    // Editar
                    
                    break;
                }
                case 3: {

                    // Eliminar
                    
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
