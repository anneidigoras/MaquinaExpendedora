package Main;

import javax.swing.ImageIcon;

import LN.clsGestor;
import LP.RegistroUsuario;
import LP.VentanaPrincipal;




public class clsMain 
{
	public static void main(String[]args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
//				VentanaPrincipal ventana = new VentanaPrincipal("Maquina Expendedora");
//				ventana.crearYMostrarGUI();
//				ventana.setVisible(true);
//			
//				
//				ventana.setIconImage(new ImageIcon(getClass().getResource("/img/maquina.jpg")).getImage());
			/**
			 * Preuba para ver que funciona lo de inicio de sesion
			 */
				RegistroUsuario frame = new RegistroUsuario();
				
				frame.setVisible(true);
				
			}
		}
		);
	}
}