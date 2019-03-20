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
public interface PuntoCapturaDAO {
    
    public boolean agregarPuntoCaptura(Object objeto) throws Exception;
    public boolean editarPuntoCaptura(Object objeto) throws Exception;
    public boolean eliminarPuntoCaptura(int indice) throws Exception;
    
    // Falta revisión de métodos de cada interface, acorde requerimientos
    
}
