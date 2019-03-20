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
public interface ConductoresDAO {
    
    public boolean agregarConductor(Object objeto) throws Exception;
    public boolean editarConductor(Object objeto) throws Exception;
    public boolean eliminarConductor(int indice) throws Exception;
    
    // Falta revisión de métodos de cada interface, acorde requerimientos
    
}
