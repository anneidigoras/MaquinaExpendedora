package Main;

import LP.FrmPrincipal;

public class clsMain 
{

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	//Create and set up the window.
                FrmPrincipal frame = new FrmPrincipal();
                frame.createAndShowGUI();
                
            }
        });


	}

}
