

import java.util.Set;

import org.junit.Test;

import Main.clsMain;


public class testMain {

	@Test
	public void test() {
		clsMain.main(null);
		// Espera a que Swing acabe para acabar el test (ojo: as� este test tiene 
		// que ser interactivo... en contra de la propia filosof�a de JUnit)
		boolean esta = true;
		while (esta) {
			try {
				Thread.sleep( 100 );  // Cada d�cima de segundo comprueba que sigue abierto Swing
			} catch (InterruptedException e) {	}
			Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
			esta = false;
			for (Thread t : threadSet) {
				if ( t.getName().startsWith( "AWT-EventQueue" ) )  {
					esta= true;
					break;
				}
			}
			if (esta)
			{
				// TODO: Test a realizar sobre las ventanas cada d�cima de segundo
			}
		}
	}

}