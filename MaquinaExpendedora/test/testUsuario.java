import static org.junit.Assert.*;

import org.junit.Test;

import LP.RegistroAdmin;

public class testUsuario {

	RegistroAdmin clsAd= new RegistroAdmin();
	@Test
	public void testisPasswordCorrect() 
	{
		char[] pass= { 'h', 'o', 'l' };
		String nombre="pepe";
		boolean real=clsAd.isPasswordCorrect(pass , nombre);
		boolean esperado=false;
		
		if(real=esperado)
		{
			fail();
		}
		
	}

}
