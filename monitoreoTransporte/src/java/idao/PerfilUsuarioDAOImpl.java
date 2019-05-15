/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import DAO.PerfilUsuarioDAO;
import entity.PerfilUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class PerfilUsuarioDAOImpl implements PerfilUsuarioDAO {

    private Connection conexion;

    public PerfilUsuarioDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.perfilUsuario"
                + "(nombreCompleto, "
                + "descripcion,"
                + "crear,"
                + "guardar,"
                + "editar,"
                + "eliminar,"
                + "configuracion,"
                + "usuarios)"
                + "VALUES(?,?,?,?,?,?,?,?)";

        PerfilUsuario perfilUsuario = (PerfilUsuario) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setString(1, perfilUsuario.getNombreCompleto());
        st.setString(2, perfilUsuario.getDescripcion());
        st.setBoolean(3, perfilUsuario.isCrear());
        st.setBoolean(4, perfilUsuario.isGuardar());
        st.setBoolean(5, perfilUsuario.isEditar());
        st.setBoolean(6, perfilUsuario.isEliminar());
        st.setBoolean(7, perfilUsuario.isConfiguracion());
        st.setBoolean(8, perfilUsuario.isUsuarios());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.perfilUsuario SET"
                + "id = ?"
                + "nombreCompleto, "
                + "descripcion,"
                + "crear,"
                + "guardar,"
                + "editar,"
                + "eliminar,"
                + "configuracion,"
                + "usuarios)"
                + "WHERE id = ?;";
        PerfilUsuario perfilUsuarioNuevo = (PerfilUsuario) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setString(1, perfilUsuarioNuevo.getNombreCompleto());
        st.setString(2, perfilUsuarioNuevo.getDescripcion());
        st.setBoolean(3, perfilUsuarioNuevo.isCrear());
        st.setBoolean(4, perfilUsuarioNuevo.isGuardar());
        st.setBoolean(5, perfilUsuarioNuevo.isEditar());
        st.setBoolean(6, perfilUsuarioNuevo.isEliminar());
        st.setBoolean(7, perfilUsuarioNuevo.isConfiguracion());
        st.setBoolean(8, perfilUsuarioNuevo.isUsuarios());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.perfilUsuario WHERE id =?;";
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
        String consulta = "SELECT perfilUsuario.id, "
                + "perfilUsuario.nombreCompleto, "
                + "FROM SDEduardo.perfilUsuario "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        PerfilUsuario perfilUsuario = new PerfilUsuario();

        if (rs.next()) {
            perfilUsuario.setId(rs.getInt(1));
            perfilUsuario.setNombreCompleto(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) perfilUsuario;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT perfilUsuario.id, "
                + "perfilUsuario.nombreCompleto, "
                + "FROM SDEduardo.perfilUsuario ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<PerfilUsuario> ListaPerfilUsuario = new ArrayList<PerfilUsuario>();

        PerfilUsuario perfilUsuario;

        while (rs.next()) {
            perfilUsuario = new PerfilUsuario();
            perfilUsuario.setId(rs.getInt(1));
            perfilUsuario.setNombreCompleto(rs.getString(2));
            ListaPerfilUsuario.add(perfilUsuario);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) ListaPerfilUsuario;
    }
}
