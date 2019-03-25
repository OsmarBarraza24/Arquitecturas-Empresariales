/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import DAO.EquipoGPSDAO;
import entity.EquipoGPS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class EquipoGPSDAOImpl implements EquipoGPSDAO{
    
    
    private Connection conexion;

    public EquipoGPSDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.equipogps"
                + "(id, "
                + "modelo,"
                + "modelo,"
                + "numeroSerie,"
                + "imeigps,"
                + "chipTelefono,"
                + "imeichip,"
                + "digitoSeguridad)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        EquipoGPS equipoGPS = (EquipoGPS) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);
        
        st.setInt(1, equipoGPS.getId());
        st.setString(2, equipoGPS.getNombreCompleto());
        st.setString(3, equipoGPS.getMarca());
        st.setString(4, equipoGPS.getNumeroSerie());
        st.setString(5, equipoGPS.getImeiGPS());
        st.setString(6, equipoGPS.getChipTelefono());
        st.setString(7, equipoGPS.getImeiChip());
        st.setString(8, equipoGPS.getDigitoSeguridad());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.equipogps SET"
                + "id = ?"
                + "marca = ?, "
                + "model = ?o,"
                + "numeroSerie = ?,"
                + "imeigps = ?,"
                + "chipTelefono = ?,"
                + "imeichip = ?,"
                + "digitoSeguridad = ?)"
                + "WHERE id = ?;";
        EquipoGPS equipoGPSNuevo = (EquipoGPS) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, equipoGPSNuevo.getId());
        st.setString(2, equipoGPSNuevo.getNombreCompleto());
        st.setString(3, equipoGPSNuevo.getMarca());
        st.setString(4, equipoGPSNuevo.getNumeroSerie());
        st.setString(5, equipoGPSNuevo.getImeiGPS());
        st.setString(6, equipoGPSNuevo.getChipTelefono());
        st.setString(7, equipoGPSNuevo.getImeiChip());
        st.setString(8, equipoGPSNuevo.getDigitoSeguridad());
        st.setInt(9, equipoGPSNuevo.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.equipoGPS WHERE id =?;";
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
        String consulta = "SELECT equipogps.id, "
                + "equipogps.nombreCompleto, "
                + "FROM SDEduardo.equipogps "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        EquipoGPS equipoGPS = new EquipoGPS();

        if (rs.next()) {
            equipoGPS.setId(rs.getInt(1));
            equipoGPS.setNombreCompleto(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) equipoGPS;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT equipoGPS.id, "
                + "equipoGPS.nombreCompleto, "
                + "FROM SDEduardo.equipoGPS ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<EquipoGPS> listaEquipoGPS = new ArrayList<EquipoGPS>();

        EquipoGPS equipoGPS;

        while (rs.next()) {
            equipoGPS = new EquipoGPS();
            equipoGPS.setId(rs.getInt(1));
            equipoGPS.setNombreCompleto(rs.getString(2));
            listaEquipoGPS.add(equipoGPS);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) listaEquipoGPS;
    }
    
}
