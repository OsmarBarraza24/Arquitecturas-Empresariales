/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import DAO.UsuariosDAO;
import entity.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class UsuariosDAOImpl implements UsuariosDAO{
    
    private Connection conexion;

    public UsuariosDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.usuarios"
                + "(id, "
                + "nombreCompleto,"
                + "cuentaCorreo,"
                + "contrasena,"
                + "perfilUsuario,"
                + "puntoCaptura,"
                + "VALUES(?,?,?,?,?,?)";
        Usuarios usuarios = (Usuarios) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, usuarios.getId());
        st.setString(2, usuarios.getNombreCompleto());
        st.setString(3, usuarios.getCuentaCorreo());
        st.setString(4, usuarios.getContrasena());
        st.setObject(5, usuarios.getPerfilUsuario());
        st.setObject(6, usuarios.getPuntoCaptura());
 
        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificar(Object objeto) throws Exception {
        String consulta = "UPDATE SDEduardo.usuarios SET"
                 + "(id, "
                + "nombreCompleto,"
                + "cuentaCorreo,"
                + "contraseña,"
                + "perfilUsuario,"
                + "puntoCaptura,"
                + "WHERE id = ?;";
        Usuarios usuariosNuevo = (Usuarios) objeto;

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

       st.setInt(1, usuariosNuevo.getId());
        st.setString(2, usuariosNuevo.getNombreCompleto());
        st.setString(3, usuariosNuevo.getCuentaCorreo());
        st.setString(4, usuariosNuevo.getContrasena());
        st.setObject(5, usuariosNuevo.getPerfilUsuario());
        st.setObject(6, usuariosNuevo.getPuntoCaptura());
        st.setInt(7, usuariosNuevo.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminar(int indice) throws Exception {
        String consulta = "DELETE FROM SDEduardo.usuarios WHERE id =?;";
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
        String consulta = "SELECT usuarios.id, "
                + "usuarios.nombreCompleto, "
                + "FROM SDEduardo.usuarios "
                + "WHERE id = ?;";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setInt(1, indice);

        ResultSet rs = st.executeQuery();

        Usuarios usuarios = new Usuarios();

        if (rs.next()) {
            usuarios.setId(rs.getInt(1));
            usuarios.setNombreCompleto(rs.getString(2));
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) usuarios;
    }

    @Override
    public Object buscarTodos() throws Exception {
        String consulta = "SELECT usuarios.id, "
                + "usuarios.nombreCompleto, "
                + "FROM SDEduardo.usuarios ORDER BY nombre ASC";

        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        ResultSet rs = st.executeQuery();

        List<Usuarios> ListaUsuarios = new ArrayList<Usuarios>();

        Usuarios usuarios;

        while (rs.next()) {
            usuarios = new Usuarios();
            usuarios.setId(rs.getInt(1));
            usuarios.setNombreCompleto(rs.getString(2));
            ListaUsuarios.add(usuarios);
        }

        if (rs != null) {
            rs.close();
        }

        if (st != null) {
            st.close();
        }

        return (Object) ListaUsuarios;
    }
    
}
