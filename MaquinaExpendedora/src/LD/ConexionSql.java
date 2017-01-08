package LD;
/**
 * 
 * @author Mayi, Anne y Andoni Eguiluz
 * 
 * Hemos tomado como base un proyecto que tenia hecho Andoni con base de datos 
 */

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import LN.clsAdquisicion;
import LN.clsUsuario;




public class ConexionSql 
{
	private static Exception lastError = null;  // Información de último error SQL ocurrido
	static Connection conn = null;
	private static Logger logger = null;
	static Statement st;
	
	
	/** Inicializa una BD SQLITE y devuelve una conexión con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    Statement st = con.createStatement();      // (1) Solo para foreign keys
		    st.execute( "PRAGMA foreign_keys = ON" );  // (1)
		    st.close();                                // (1)
			//log( Level.INFO, "Conectada base de datos " + nombreBD, null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			//log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarBD( Connection con ) 
	{
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			//log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuario " +
					// "(nick string "  // (2) Esto sería sin borrado en cascada ni relación de claves ajenas
					"(dni string PRIMARY KEY" // (1) Solo para foreign keys
					+ ", password string, nombre string, apellido string" +
					", edad integer, )");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table adquisicion " +
					// "(nick string "  // (2) Esto sería sin borrado en cascada ni relación de claves ajenas
					"(ID_producto string " // (1) Solo para foreign keys
					+ ",nombre_producto string, DNI_cliente string, nombre_cliente string,primary key(ID_producto, dni_cliente ))");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table bebida " +
					"(id string PRIMARY KEY"+", precio integer, num integer)"); // (1) Solo para foreign keys
					// "(usuario_nick string, fechapartida bigint, puntuacion integer)"); // (2) Esto sería sin borrado en cascada
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
		//	log( Level.INFO, "Creada base de datos", null );
			return statement;
		} catch (SQLException e) {
			lastError = e;
			//log( Level.SEVERE, "Error en creación de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	

	
	/** Cierra la base de datos abierta
	 * @param con	Conexión abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			//log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			lastError = e;
			//log( Level.SEVERE, "Error en cierre de base de datos", e );
			e.printStackTrace();
		}
	}
	
	/** Devuelve la información de excepción del último error producido por cualquiera 
	 * de los métodos de gestión de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}
	
	/////////////////////////////////////////////////////////////////////
	//                      Operaciones de usuario                     //
	/////////////////////////////////////////////////////////////////////
	
	/** Añade un usuario a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a añadir en la base de datos
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public static boolean usuarioInsert( Statement st, clsUsuario u ) {
		String sentSQL = "";
		try {
			String listaEms = "";
			String sep = "";
//			for (String email : u.getListaEmails()) 
//			{
//				listaEms = listaEms + sep + secu(email);
//				sep = ",";
//			}
			sentSQL = "insert into usuario values(" +
					"'" +u.getDni() + "', " +
					"'" + u.getPassword() + "', " +
					"'" + u.getNombre() + "', " +
					"'" + u.getApellido() + "', " +
					"'" +u.getEdad()   + "')";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			//log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				//log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
		//	log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean adquisicionInsert( Statement st, clsAdquisicion a ) {
		String sentSQL = "";
		try {
			String listaEms = "";
			String sep = "";
//			for (String email : u.getListaEmails()) 
//			{
//				listaEms = listaEms + sep + secu(email);
//				sep = ",";
//			}
			sentSQL = "insert into adquisicion values(" +
					"'" +a.getId_producto() + "', " +
					"'" + a.getNombre_p() + "', " +
					"'" + a.getDni_usuario()+ "', " +
					"'" + a.getNombre_u() + "')";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			//log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				//log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
		//	log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}

	/** Realiza una consulta a la tabla abierta de usuarios de la BD, usando la sentencia SELECT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param codigoSelect	Sentencia correcta de WHERE (sin incluirlo) para filtrar la búsqueda (vacía si no se usa)
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
				clsUsuario u = new clsUsuario();
				u.setDni( rs.getString( "dni" ) );
				u.setPassword( rs.getString( "password" ) );
				u.setNombre( rs.getString( "nombre" ) );
				u.setApellido( rs.getString( "apellido" ) );
				u.setEdad( rs.getInt( "Edad" ) );
				
				
			}
			rs.close();
			//log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			//log( Level.SEVERE, "Error en BD en tipo de usuario\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			//log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

	/** Modifica un usuario en la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a modificar en la base de datos. Se toma su nick como clave
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public static boolean usuarioUpdate( Statement st, clsUsuario u ) {
		String sentSQL = "";
		try {
			String listaEms = "";
			String sep = "";
//			for (String email : u.getListaEmails()) {
//				listaEms = listaEms + sep + email;
//				sep = ",";
//			}
			sentSQL = "update usuario set" +
					// " nick='" + u.getNick() + "', " +  // No hay que actualizar el nick, solo el resto de campos
					" password='" + u.getPassword() + "', " +
					" nombre='" + u.getNombre() + "', " +
					" apellidos='" + u.getApellido() + "', " +
					" edad=" + u.getEdad() +
					" where dni='" + u.getDni() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			//log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				//log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			//log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
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
			sentSQL = "delete from usuario where dni='" + u.getDni() + "'";
			int val = st.executeUpdate( sentSQL );
			//log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			//log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	

	

}
	
	
