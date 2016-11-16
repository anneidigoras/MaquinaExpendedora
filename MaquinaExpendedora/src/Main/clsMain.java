package Main;

import javax.swing.ImageIcon;

import LN.clsGestor;
import LP.FrmPrincipal;
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
				VentanaPrincipal ventana = new VentanaPrincipal("Maquina Expendedora");
				ventana.setVisible(true);
			
				
				ventana.setIconImage(new ImageIcon(getClass().getResource("/img/maquina.jpg")).getImage());
				
				//clsGestor.creabebidas(); ----> ponemos aqui este metodo??
			}
		}
		);
	}
}