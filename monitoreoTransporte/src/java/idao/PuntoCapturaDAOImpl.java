/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import DAO.PuntoCapturaDAO;
import entity.PuntoCaptura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class PuntoCapturaDAOImpl implements PuntoCapturaDAO{
    
    private Connection conexion;

    public PuntoCapturaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.nombreCaptura"
                + "(nombreCompleto, "
                + " Descripcion,"
                + "direccion,"
                + "contacto)"
                + "VALUES(?,?,?,?)";
        PuntoCaptura puntoCaptura = (PuntoCaptura) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setString(1, puntoCaptura.getNombreCompleto());
        st.setString(2, puntoCaptura.getDescripcion());
        st.setString(3, puntoCaptura.getDireccion());
        st.setString(4, puntoCaptura.getContacto());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.puntoCaptura SET"
                + "id = ?"
                + "nombreCompleto = ?, "
                + "Descripcion = ?,"
                + "direccion = ?,"
                + "contacto = ?,"
                + "WHERE id = ?;";
        PuntoCaptura puntoCapturaNuevo = (PuntoCaptura) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, puntoCapturaNuevo.getId());
        st.setString(2, puntoCapturaNuevo.getNombreCompleto());
        st.setString(3, puntoCapturaNuevo.getDescripcion());
        st.setString(4, puntoCapturaNuevo.getDireccion());
        st.setString(5, puntoCapturaNuevo.getContacto());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.puntoCaptura WHERE id =?;";
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
        String consulta = "SELECT puntoCaptura.id, "
                + "puntoCaptura.nombreCompleto, "
                + "FROM SDEduardo.puntoCaptura "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        PuntoCaptura puntoCaptura = new PuntoCaptura();

        if (rs.next()) {
            puntoCaptura.setId(rs.getInt(1));
            puntoCaptura.setNombreCompleto(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) puntoCaptura;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT puntoCaptura.id, "
                + "puntoCaptura.nombreCompleto, "
                + "FROM SDEduardo.puntoCaptura ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<PuntoCaptura> ListaPuntoCaptura = new ArrayList<PuntoCaptura>();

        PuntoCaptura puntoCaptura;

        while (rs.next()) {
            puntoCaptura = new PuntoCaptura();
            puntoCaptura.setId(rs.getInt(1));
            puntoCaptura.setNombreCompleto(rs.getString(2));
            ListaPuntoCaptura.add(puntoCaptura);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) ListaPuntoCaptura;
    }
    
}
