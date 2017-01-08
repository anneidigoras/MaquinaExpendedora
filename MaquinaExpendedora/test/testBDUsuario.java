
/**
 * clase que usamos para verificar que funciona la base de datos de usuarios 
 */
	import static org.junit.Assert.*;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

	import LD.ConexionSql;
import LN.clsUsuario;

public class testBDUsuario 
{

		@Test
		public void usuarioInsert() throws SQLException {
			String nombre = "Anne"	;
			String ape = "Idigoras";		
			String dni = "12345678";
			int edad = 20;

			Connection nueva_conexion =ConexionSql.initBD("src\\BD\\BaseDeDatoos.db" );
			Statement st =ConexionSql.usarCrearTablasBD(nueva_conexion); 
			
			
			
			ConexionSql bd=new ConexionSql();
			clsUsuario u= new clsUsuario();
			u.setNombre(nombre);u.setDni(dni);u.setApellido(ape);u.setEdad(edad);
		    ConexionSql.usuarioInsert(st, u);
			
			assertNotNull(bd);
			
			
			
		}

	}


