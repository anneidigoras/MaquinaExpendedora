package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class FrmPrincipal extends JFrame implements ActionListener

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	JTextArea display;
    JDesktopPane desktop;
    
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;
    
    static final String SHOW = "show";
    static final String CLEAR = "clear";
    String newline = "\n";
    static final int desktopWidth = 500;
    static final int desktopHeight = 300;

	public void createAndShowGUI() 
	{
		
		
	}

	
	

}
