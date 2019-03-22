/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Conductores;
import DAO.ConductoresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author dell
 */
public class conductorDAOImpl implements ConductoresDAO{

    private Connection conexion;

    public conductorDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public boolean agregarConductor(Object objeto) throws Exception {
        String consulta = "INSERT INTO SDEduardo.conductores"
                +"(nombreCompleto, "
                +" Descripcion,"
                + "ife,"
                + "rfc,"
                + "licencia,"
                + "vigenciaLicencia,"
                + "telefono)"
                + "VALUES(?,?,?,?,?,?,?)";
        Conductores conductores = (Conductores) objeto;
        
        
        PreparedStatement st = (PreparedStatement) this.conexion.prepareStatement(consulta);

        st.setString(1, conductores.getNombreCompleto());
        st.setString(2, conductores.getDescripcion());
        st.setString(3, conductores.getIfe());
        st.setString(4, conductores.getRfc());
        st.setString(5, conductores.getDescripcion());
        st.setString(6, conductores.getIfe());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean editarConductor(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarConductor(int indice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
