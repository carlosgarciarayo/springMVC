package es.ua.jtech.amigosspring.datos;

import java.sql.*;
import java.util.*;
import java.text.*;

import es.ua.jtech.amigosspring.modelo.Sexo;
import es.ua.jtech.amigosspring.modelo.Usuario;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementa las operaciones de acceso a datos relativas a usuarios
 */
@Repository
public class UsuariosDAO implements IUsuariosDAO {

    @Autowired
    private DataSource ds;
    private String GETUSUARIO_SQL = "SELECT * FROM usuarios WHERE login=?";
    private String INSERTUSUARIO_SQL = "INSERT INTO usuarios VALUES (?,?,?,?,?,?,?)";
    private String BUSCAR_POR_LOGIN_SQL = "SELECT * FROM usuarios WHERE login LIKE ?";


    public void crearUsuario(Usuario u) {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = ds.getConnection();
            ps = con.prepareStatement(INSERTUSUARIO_SQL);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getLogin());
            ps.setBoolean(3, u.isVaron());
            ps.setDate(4, new java.sql.Date(u.getFechaNac().getTime()));
            ps.setString(5, u.getLocalidad());
            ps.setString(6,  u.getDescripcion());
            ps.setInt(7, Usuario.CRED_INICIAL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } //cerrar la conexión si es que está abierta
        finally {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    
    /**
     * Devuelve un usuario sabiendo su login, <tt>null</tt> en caso contrario
     * @param login login del usuario a buscar.
     * @return un usuario, <tt>null</tt> si no existe.
     * @throws DAOException si se produce una excepci�n de acceso a datos.
     */
    public Usuario getUsuario(String login) {
        PreparedStatement ps;
        Connection con = null;
        ResultSet datos;

        try {
            con = ds.getConnection();
            ps = con.prepareStatement(GETUSUARIO_SQL);
            ps.setString(1, login);
            datos = ps.executeQuery();
            if (datos.next()) {
                return crearUsuario(datos);
            } else {
                return null;
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } //cerrar la conexion si es que esta abierta
        finally {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    
    public List<Usuario> buscarPorLogin(String cad) {
        PreparedStatement ps;
        Connection con = null;
        ResultSet datos;
        List<Usuario> lista;
        
        try {
        	lista = new ArrayList<Usuario>();
            con = ds.getConnection();
            ps = con.prepareStatement(BUSCAR_POR_LOGIN_SQL);
            ps.setString(1, "%"+cad+"%");
            datos = ps.executeQuery();
            while (datos.next()) {
            	lista.add(crearUsuario(datos));
            } 
            return lista;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } //cerrar la conexión si es que está abierta
        finally {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    

    /**
     * Obtiene una lista de usuarios que cumplen los criterios especificados.
     * @param localidad localidad de procedencia
     * @param edadMin edad minima
     * @param edadMax edad maxima
     * @param sexo sexo
     * @return la lista de usuarios que cumplen todas las condiciones, vac�a en caso
     * de que no haya ninguno.
     */
    @SuppressWarnings("incomplete-switch")
	public List<Usuario> buscar(String localidad, int edadMin, int edadMax, String sexo) {
        java.util.Date fechaInicio, fechaFin;
        GregorianCalendar cal;
        String fechaInicioCad, fechaFinCad;
        SimpleDateFormat df;
        ResultSet res;
        Connection con = null;
        String sqlCad;
        Statement sql;
        ArrayList<Usuario> usuarios;

        df = new SimpleDateFormat("yyyy-MM-dd");

        //calcular fechas minima y maxima de nacimiento a partir del rango de edad deseado
        cal = new GregorianCalendar();
        //fecha minima (ahora - edadMaxima)
        cal.setTime(new java.util.Date());
        cal.set(GregorianCalendar.YEAR, cal.get(GregorianCalendar.YEAR) - edadMax);
        fechaInicio = cal.getTime();
        //fecha maxima (ahora - edadMinima)
        cal.setTime(new java.util.Date());
        cal.set(GregorianCalendar.YEAR, cal.get(GregorianCalendar.YEAR) - edadMin);
        fechaFin = cal.getTime();
        //pasar las fechas a formato aaaa-mm-dd para utilizarlas en SQL
        fechaInicioCad = df.format(fechaInicio);
        fechaFinCad = df.format(fechaFin);
        sqlCad = "SELECT * from usuarios WHERE fechaNac>='" + fechaInicioCad
                + "' AND fechaNac<= '" + fechaFinCad + "'";
        //busqueda por localidad
        if (localidad != null && !localidad.equals("")) {
            sqlCad = sqlCad + "AND localidad LIKE '%" + localidad + "%'";
        }
        //busqueda por sexo
        switch (Sexo.valueOf(sexo)) {
            case hombre:
                sqlCad = sqlCad + "AND varon=1";
                break;
            case mujer:
                sqlCad = sqlCad + "AND varon=0";
                break;
        }
        //ordenar por login
        sqlCad = sqlCad + " ORDER BY login";
        try {
            con = ds.getConnection();
            sql = con.createStatement();
            res = sql.executeQuery(sqlCad);
            usuarios = new ArrayList<Usuario>();
            while (res.next()) {
                usuarios.add(crearUsuario(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema al buscar usuario", e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return usuarios;
    }

    /**
     * Crea un objeto usuario a partir de la informaci�n contenida en un registro de la base de datos.
     * @param datos el conjunto de registros cuyo registro actual contiene la informaci�n del usuario.
     * @return el usuario
     * @throws SQLException si se produce un error con la base de datos.
     */
    private Usuario crearUsuario(ResultSet datos) throws SQLException {
        Usuario u;

        u = new Usuario();
        u.setLogin(datos.getString("login"));
        u.setPassword(datos.getString("password"));
        u.setVaron(datos.getBoolean("varon"));
        u.setFechaNac(datos.getDate("fechaNac"));
        u.setLocalidad(datos.getString("localidad"));
        u.setDescripcion(datos.getString("descripcion"));
        u.setCredito(datos.getInt("credito"));
        return u;
    }

}
