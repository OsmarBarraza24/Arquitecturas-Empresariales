/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import DAO.LineasTransportistasDAO;
import entity.LineasTransportistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class LineasTransportistasDAOImpl implements LineasTransportistasDAO{
    
    private Connection conexion;

    public LineasTransportistasDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.lineasTransportistas"
                + "(id, "
                + "descripcion,"
                + "descripcion,"
                + "contacto,"
                + "domicilio,"
                + "telefonoOficina)"
                + "VALUES(?,?,?,?,?,?)";
        
        LineasTransportistas lineasTransportistas = (LineasTransportistas) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);
        
        st.setInt(1, lineasTransportistas.getId());
        st.setString(2, lineasTransportistas.getNombreCompleto());
        st.setString(3, lineasTransportistas.getDescripcion());
        st.setString(4, lineasTransportistas.getContacto());
        st.setString(5, lineasTransportistas.getDomicilio());
        st.setString(6, lineasTransportistas.getTelefonoOficina());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.lineasTransportistas SET"
                + "id = ?"
                + "nombreCompleto, "
                + "descripcion,"
                + "contacto,"
                + "domicilio,"
                + "telefonoOficina)"
                + "WHERE id = ?;";
        LineasTransportistas lineasTransportistasNuevo = (LineasTransportistas) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setString(1, lineasTransportistasNuevo.getNombreCompleto());
        st.setString(2, lineasTransportistasNuevo.getDescripcion());
        st.setString(3, lineasTransportistasNuevo.getContacto());
        st.setString(4, lineasTransportistasNuevo.getDomicilio());
        st.setString(5, lineasTransportistasNuevo.getTelefonoOficina());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.lineasTransportistas WHERE id =?;";
        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);
        st.setInt(1, indice);

        boolean resultado = st.execute();
        if (st != null) {
            st.close();
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(int indice) throws Exception {
        String consulta = "SELECT lineasTransportistas.id, "
                + "lineasTransportistas.nombreCompleto, "
                + "FROM SDEduardo.lineasTransportistas "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        LineasTransportistas lineasTransportistas = new LineasTransportistas();

        if (rs.next()) {
            lineasTransportistas.setId(rs.getInt(1));
            lineasTransportistas.setNombreCompleto(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) lineasTransportistas;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT lineasTransportistas.id, "
                + "lineasTransportistas.nombreCompleto, "
                + "FROM SDEduardo.lineasTransportistas ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<LineasTransportistas> ListaLineasTransportistas = new ArrayList<LineasTransportistas>();

        LineasTransportistas lineasTransportistas;

        while (rs.next()) {
            lineasTransportistas = new LineasTransportistas();
            lineasTransportistas.setId(rs.getInt(1));
            lineasTransportistas.setNombreCompleto(rs.getString(2));
            ListaLineasTransportistas.add(lineasTransportistas);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) ListaLineasTransportistas;
    }
}
