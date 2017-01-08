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

		Connection nueva_conexion =ConexionSql.initBD("src\\BD\\BaseDeDatoos.db" );
		Statement st =ConexionSql.usarCrearTablasBD(nueva_conexion); 
		
		
		
		ConexionSql bd=new ConexionSql();
		clsAdquisicion u= new clsAdquisicion();
		u.setDni_usuario(dni);u.setId_producto(idP);u.setNombre_p(nombreP);u.setNombre_u(nombreU);
		
	    ConexionSql.adquisicionInsert(st, u);
		
		assertNotNull(bd);
		

}
}