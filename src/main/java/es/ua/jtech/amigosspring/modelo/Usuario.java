package es.ua.jtech.amigosspring.modelo;

import java.util.*;


/**
 * Representa un usuario del sistema.
 */
public class Usuario {
	
	
	private String login;
	private String password;
	private String localidad;
	private Date fechaNac;
	private boolean varon;
	private String descripcion;
	/**
	 * Credito actual. Se mide en unidades monetarias ficticias
	 */
	private int credito;
	/**
	 * Creditos iniciales de regalo al darse de alta.
	 */
	public static final int CRED_INICIAL = 10;
	
	
	/**
	 * Devuelve el credito actual del usuario. 
	 */
	public int getCredito() {
		return credito;
	}
	/**
	 * Cambia el credito actual del usuario.
	 * @param credito nuevo credito.
	 */
	public void setCredito(int credito) {
		this.credito = credito;
	}
	/**
	 * Obtiene la descripcion del usuario.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Obtiene la edad del usuario
	 */
	public int getEdad() {
		long ms;

	     ms = new java.util.Date().getTime() - getFechaNac().getTime();
	     return (int)(ms/(365L*24L*60L*60L*1000L));
	}
	/**
	 * Cambia la descripcion del usuario.
	 * @param descripcion la nueva descripcion.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtiene la lista de mensajes enviados por el usuario
	 * @return una lista de objetos {@link es.ua.jtech.amigosSpring.modelo.Mensaje}
	 */

	/**
	 * Obtiene la fecha de nacimiento del usuario
	 */
	public Date getFechaNac() {
		return fechaNac;
	}
	/**
	 * Cambia la fecha de nacimiento del usuario.
	 * @param fechaNac la nueva fecha.
	 */
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	/**
	 * Obtiene la localidad de residencia del usuario.
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * Cambia la localidad de residencia del usuario.
	 * @param localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * Obtiene el login del usuario.
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Cambia el login del usuario.
	 * @param login el nuevo login.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Obtiene el password del usuario.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Cambia el password del usuario.
	 * @param password el nuevo password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Devuelve <tt>true</tt> si el usuario es un varon. <tt>false</tt> en caso contrario.
	 */
	public boolean isVaron() {
		return varon;
	}
	
	/**
	 * Permite especificar si el usuario es un varon
	 * @param varon <tt>true</tt> si es un varon. <tt>false</tt> en caso contrario.
	 */
	public void setVaron(boolean varon) {
		this.varon = varon;
	}
	
	/**
	 * Devuelve el sexo del usuario como una cadena: "hombre" o "mujer"
	 */
	public Sexo getSexo() {
		if (isVaron())
			return Sexo.hombre;
		return Sexo.mujer;
	}
	

	
}