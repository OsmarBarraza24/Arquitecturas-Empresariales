/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import DAO.TransportesDAO;
import entity.Transportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class TransportesDAOImpl implements TransportesDAO{
    
    private Connection conexion;

    public TransportesDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.transportes"
                + "(id, "
                + " placas,"
                + " marca,"
                + "modelo,"
                + "descripcion,"
                + "lineasTransportistas)"
                + "VALUES(?,?,?,?,?,?)";
        Transportes transportes = (Transportes) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);
        
        st.setInt(1, transportes.getId());
        st.setString(1, transportes.getPlacas());
        st.setString(2, transportes.getMarca());
        st.setString(3, transportes.getModelo());
        st.setString(4, transportes.getDescripcion());
        st.setObject(4, transportes.getLineasTransportistas());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.transportes SET"
                + "id = ?"
                + "placas = ?, "
                + "marca = ?,"
                + "modelo = ?,"
                + "descripcion = ?,"
                + "lineasTransportistas = ?,"
                + "WHERE id = ?;";
        Transportes transportesNuevo = (Transportes) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, transportesNuevo.getId());
        st.setString(2, transportesNuevo.getPlacas());
        st.setString(3, transportesNuevo.getMarca());
        st.setString(4, transportesNuevo.getModelo());
        st.setString(5, transportesNuevo.getDescripcion());
        st.setObject(6, transportesNuevo.getLineasTransportistas());
        
        boolean resultado = st.execute();
        

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.transportes WHERE id =?;";
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
        String consulta = "SELECT transportes.id, "
                + "transportes.placas, "
                + "FROM SDEduardo.transportes "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        Transportes transportes = new Transportes();

        if (rs.next()) {
            transportes.setId(rs.getInt(1));
            transportes.setPlacas(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) transportes;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT transportes.id, "
                + "transportes.nombreCompleto, "
                + "FROM SDEduardo.transportes ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<Transportes> ListaTransportes = new ArrayList<Transportes>();

        Transportes transportes;

        while (rs.next()) {
            transportes = new Transportes();
            transportes.setId(rs.getInt(1));
            transportes.setPlacas(rs.getString(2));
            ListaTransportes.add(transportes);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) ListaTransportes;
    }
}
