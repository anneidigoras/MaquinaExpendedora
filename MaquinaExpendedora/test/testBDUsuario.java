

	import static org.junit.Assert.*;

	import org.junit.Test;

	import LD.ConexionSql;

public class testBDUsuario 
{

		@Test
		public void testAñadir() {
			String nombre = "Anne"	;
			String ape = "Idigoras";		
			String dni = "12345678";
			int edad = 20;
			
			
			ConexionSql bd=new ConexionSql();
			bd.anyadirUsuario(nombre, ape, dni, edad);
			
			assertNotNull(bd);
			
			
			
		}

	}


