/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import entity.Conductores;
import DAO.ConductoresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ConductoresDAOImpl implements ConductoresDAO {

    private Connection conexion;

    public ConductoresDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.conductores"
                + "(id, "
                + " nombreCompleto,"
                + "Descripcion,"
                + "ife,"
                + "rfc,"
                + "licencia,"
                + "vigenciaLicencia,"
                + "telefono)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        Conductores conductores = (Conductores) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);
        
        st.setInt(1, conductores.getId());
        st.setString(2, conductores.getNombreCompleto());
        st.setString(3, conductores.getDescripcion());
        st.setString(4, conductores.getIfe());
        st.setString(5, conductores.getRfc());
        st.setString(6, conductores.getDescripcion());
        st.setString(7, conductores.getIfe());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.conductores SET"
                + "id = ?"
                + "nombreCompleto = ?, "
                + " Descripcion = ?,"
                + "ife = ?,"
                + "rfc = ?,"
                + "licencia = ?,"
                + "vigenciaLicencia = ?,"
                + "telefono = ?)"
                + "WHERE id = ?;";
        Conductores conductoresNuevo = (Conductores) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, conductoresNuevo.getId());
        st.setString(2, conductoresNuevo.getNombreCompleto());
        st.setString(3, conductoresNuevo.getDescripcion());
        st.setString(4, conductoresNuevo.getIfe());
        st.setString(5, conductoresNuevo.getRfc());
        st.setString(6, conductoresNuevo.getDescripcion());
        st.setString(7, conductoresNuevo.getIfe());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.conductores WHERE id =?;";
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
        String consulta = "SELECT conductores.id, "
                + "conductores.nombreCompleto, "
                + "FROM SDEduardo.conductores "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        Conductores conductores = new Conductores();

        if (rs.next()) {
            conductores.setId(rs.getInt(1));
            conductores.setNombreCompleto(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) conductores;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT conductores.id, "
                + "conductores.nombreCompleto, "
                + "FROM SDEduardo.conductores ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<Conductores> listaConductores = new ArrayList<Conductores>();

        Conductores conductores;

        while (rs.next()) {
            conductores = new Conductores();
            conductores.setId(rs.getInt(1));
            conductores.setNombreCompleto(rs.getString(2));
            listaConductores.add(conductores);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) listaConductores;
    }

}
