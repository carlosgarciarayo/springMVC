/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ua.jtech.amigosspring.datos;

import es.ua.jtech.amigosspring.modelo.Usuario;

import java.util.List;

/**
 *
 * @author especialista
 */
public interface IUsuariosDAO {

    /**
     * Obtiene una lista de usuarios que cumplen los criterios especificados.
     * @param localidad localidad de procedencia
     * @param edadMin edad minima
     * @param edadMax edad maxima
     * @param sexo sexo
     * @return la lista de usuarios que cumplen todas las condiciones, vac�a en caso
     * de que no haya ninguno.
     */
    List<Usuario> buscar(String localidad, int edadMin, int edadMax, String sexo);

    /**
     * Obtiene los usuarios cuyo login comienza por la cadena de caracteres especificada
     * @param cadena cadena por la que debe comenzar el login
     * @return
     */
    List<Usuario> buscarPorLogin(String cadena);

    /**
     * Devuelve un usuario sabiendo su login, <tt>null</tt> en caso contrario
     * @param login login del usuario a buscar.
     * @return un usuario, <tt>null</tt> si no existe.
     * @throws DAOException si se produce una excepci�n de acceso a datos.
     */
    Usuario getUsuario(String login);
    
    void crearUsuario(Usuario u);
 
}
