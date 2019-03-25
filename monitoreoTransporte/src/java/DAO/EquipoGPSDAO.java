/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author dell
 */
public interface EquipoGPSDAO {
    
    public boolean agregarGPS(Object objeto) throws Exception;
    public boolean editarGPS(Object objeto) throws Exception;
    public boolean eliminarGPS(int indice) throws Exception;
    
    // Falta revisión de métodos de cada interface, acorde requerimientos
    
}
