

import java.util.Set;

import org.junit.Test;

import Main.clsMain;


public class testMain {

	@Test
	public void test() {
		clsMain.main(null);
		// Espera a que Swing acabe para acabar el test (ojo: así este test tiene 
		// que ser interactivo... en contra de la propia filosofía de JUnit)
		boolean estaSwing = true;
		while (estaSwing) {
			try {
				Thread.sleep( 100 );  // Cada décima de segundo comprueba que sigue abierto Swing
			} catch (InterruptedException e) {	}
			Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
			estaSwing = false;
			for (Thread t : threadSet) {
				if ( t.getName().startsWith( "AWT-EventQueue" ) )  {
					estaSwing = true;
					break;
				}
			}
			if (estaSwing) {
				// TODO: Test a realizar sobre las ventanas cada décima de segundo
			}
		}
	}

}