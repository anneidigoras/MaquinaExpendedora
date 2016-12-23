package LD;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


import LN.clsUsuario;




public class ConexionSql 
{
	private static Exception lastError = null;  // Informaci�n de �ltimo error SQL ocurrido
	static Connection conn = null;
	private static Logger logger = null;
	    
	

	
	public static Connection dbConnector (String nombreBD)
	{
		try
		{ 
			Class.forName("org.sqlite.JDBC");
            File fichero = new File("MaquinaExpendedora(DataBase).s3db");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fichero.getAbsolutePath());
			Statement st = conn.createStatement();      // (1) Solo para foreign keys
		    st.execute( "PRAGMA foreign_keys = ON" );  // (1)
		    st.close();                                // (1)
			log( Level.INFO, "Conectada base de datos " + nombreBD, null );
	

			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}
		catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexi�n de base de datos " + nombreBD, e );
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuario " +
					// "(nick string "  // (2) Esto ser�a sin borrado en cascada ni relaci�n de claves ajenas
					"(dni string PRIMARY KEY" // (1) Solo para foreign keys
					+ ", apellido string, apellido string" +
					", edad integer)");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table adquisicion " +
					"(usuario_nick string REFERENCES usuario(nick) ON DELETE CASCADE, fechapartida bigint, puntuacion integer)"); // (1) Solo para foreign keys
					// "(usuario_nick string, fechapartida bigint, puntuacion integer)"); // (2) Esto ser�a sin borrado en cascada
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			log( Level.INFO, "Creada base de datos", null );
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en creaci�n de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE M�TODO CON PRECAUCI�N. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexi�n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists usuario");
			statement.executeUpdate("drop table if exists partida");
			log( Level.INFO, "Reiniciada base de datos", null );
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	/** Cierra la base de datos abierta
	 * @param con	Conexi�n abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en cierre de base de datos", e );
			e.printStackTrace();
		}
	}
	
	/** Devuelve la informaci�n de excepci�n del �ltimo error producido por cualquiera 
	 * de los m�todos de gesti�n de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}
	
	
	/** A�ade un usuario a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a a�adir en la base de datos
	 * @return	true si la inserci�n es correcta, false en caso contrario
	 */
	public static boolean usuarioInsert( Statement st, clsUsuario u ) {
		String sentSQL = "";
		try {
			String listaEms = "";
			String sep = "";
			
			sentSQL = "insert into usuario values(" +
					"'" + secu(u.getDni()) + "', " +
					"'" + secu(u.getPassword()) + "', " +
					"'" + secu(u.getNombre()) + "', " +
					"'" + secu(u.getApellido()) + "', " +
					u.getEdad() +  "')";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que a�adir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
	/** Realiza una consulta a la tabla abierta de usuarios de la BD, usando la sentencia SELECT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param codigoSelect	Sentencia correcta de WHERE (sin incluirlo) para filtrar la b�squeda (vac�a si no se usa)
	 * @return	lista de usuarios cargados desde la base de datos, null si hay cualquier error
	 */
	public static ArrayList<clsUsuario> usuarioSelect( Statement st, String codigoSelect ) {
		String sentSQL = "";
		ArrayList<clsUsuario> ret = new ArrayList<>();
		try {
			sentSQL = "select * from usuario";
			if (codigoSelect!=null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			// System.out.println( sentSQL );  // Para ver lo que se hace en consola
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				clsUsuario u =  new clsUsuario(sentSQL, sentSQL, sentSQL, 0, sentSQL);
				u.setDni( rs.getString( "dni" ) );
				
				u.setNombre( rs.getString( "nombre" ) );
				u.setApellido( rs.getString( "apellidos" ) );
				u.setEdad( rs.getInt( "edad" ) );
				
				
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			log( Level.SEVERE, "Error en BD en tipo de usuario\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	/** Modifica un usuario en la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a modificar en la base de datos. Se toma su nick como clave
	 * @return	true si la inserci�n es correcta, false en caso contrario
	 */
	public static boolean usuarioUpdate( Statement st, clsUsuario u ) {
		String sentSQL = "";
		try {
			String listaEms = "";
			String sep = "";
			
			sentSQL = "update usuario set" +
					// " nick='" + u.getNick() + "', " +  // No hay que actualizar el nick, solo el resto de campos
					" password='" + u.getPassword() + "', " +
					" nombre='" + u.getNombre() + "', " +
					" apellidos='" + u.getApellido() + "', " +
					" edad=" + u.getEdad() + ", " +
					
					" emails='" + listaEms + "'" +
					" where dni='" + u.getDni() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	/** Borrar un usuario de la tabla abierta de BD, usando la sentencia DELETE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a borrar de la base de datos  (se toma su nick para el borrado)
	 * @return	true si el borrado es correcto, false en caso contrario
	 */
	public static boolean usuarioDelete( Statement st, clsUsuario u ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from usuario where dni='" + secu(u.getDni()) + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	
	


	public static String DirectorioActual()
	{
	    String directorio = System.getProperty("java.class.path");
	    File dir = new File(directorio);
	    String directorioPadre = dir.getParent();
	    return directorioPadre;
	}
	
	private static String secu( String string ) {
		// Implementaci�n (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementaci�n (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ��������������.,:;-_(){}[]-+*=<>'\"�?�!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}
	

	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( ConexionSql.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
	

    
	
}
