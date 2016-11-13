package Main;

import javax.swing.ImageIcon;

import LP.FrmPrincipal;




public class clsMain 
{
	public static void main(String[]args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				FrmPrincipal ventana = new FrmPrincipal("Maquina Expendedora");
				ventana.createAndShowGUI();
				//CON ESTA LÍNEA CREO EL ICONO DEL PANDA QUE APARECE AL EJECUTAR EL PROGRAMA Y PULSAR DESPUÉS DE LA BIENVENIDA.
				ventana.setIconImage(new ImageIcon(getClass().getResource("/img/maquina.jpg")).getImage());
			}
		}
		);
	}
}
