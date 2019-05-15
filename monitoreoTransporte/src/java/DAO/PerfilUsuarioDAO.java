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
public interface PerfilUsuarioDAO {
    
    public boolean agregar(Object objeto) throws Exception;
    public boolean modificar(Object objeto) throws Exception;
    public boolean eliminar(int indice) throws Exception;
    
    public Object buscarPorId(int indice) throws Exception;
    public Object buscarTodos() throws Exception;
}
