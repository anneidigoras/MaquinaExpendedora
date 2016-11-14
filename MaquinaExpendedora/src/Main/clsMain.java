package Main;

import javax.swing.ImageIcon;

import LN.clsGestor;
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
				
				ventana.setIconImage(new ImageIcon(getClass().getResource("/img/maquina.jpg")).getImage());
				
				//clsGestor.creabebidas(); ----> ponemos aqui este metodo??
			}
		}
		);
	}
}
