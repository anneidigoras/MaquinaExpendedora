package Main;

import javax.swing.ImageIcon;

import LN.clsGestor;

import LP.VentanaPrincipal;




public class clsMain 
{
	
	public static void main(String[]args)
	{
		
		clsGestor.creabebidas();
		clsGestor.cargaradmin();
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				
				VentanaPrincipal ventana = new VentanaPrincipal("Maquina Expendedora");
			    ventana.setVisible(true);
			    ventana.setIconImage(new ImageIcon(getClass().getResource("/img/maquina.jpg")).getImage());
				
		
//				
				
			}
		}
		);
	}
}