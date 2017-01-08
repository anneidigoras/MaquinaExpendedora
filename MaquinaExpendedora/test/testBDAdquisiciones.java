import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import LD.ConexionSql;
import LN.clsAdquisicion;


public class testBDAdquisiciones {

	@Test
	public void adquisicionInsert() throws SQLException {
		String nombreP = "CocaCola"	;
		String nombreU = "Mayi";		
		String idP = "cc";
	String dni = "12345678";

	
	    
clsAdquisicion compra = new clsAdquisicion(idP,dni,nombreP,nombreU);
		ConexionSql bd= new ConexionSql();
		Connection nueva_conexion =ConexionSql.initBD("src\\BD\\Adquisiciones.db" );
		Statement st =ConexionSql.usarCrearTablasBD(nueva_conexion);
		ConexionSql.adquisicionInsert(st, compra);
		ConexionSql.cerrarBD(nueva_conexion, st);
		try {
			   //Y para terminar cerramos la conexión
			
			   nueva_conexion.close();
			
			  }

			  catch (SQLException e) {

			   //Esto se ejecuta si hay algún problema al realizar la conexión.

			   e.printStackTrace();
			  }
		
		

	assertNotNull(bd);
	}
		



}