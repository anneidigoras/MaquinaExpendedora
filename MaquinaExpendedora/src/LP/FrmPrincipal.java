package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import LN.clsGestor;
import net.miginfocom.swing.MigLayout;

public class FrmPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JFrame frame;
    JTextArea display;
    JDesktopPane desktop;
    
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;
    
    static final String SHOW = "show";
    static final String CLEAR = "clear";
    String newline = "\n";
    static final int desktopWidth = 500;
    static final int desktopHeight = 300;
    
    static final String CREAR_USUARIO = "Nuevo usuario";
    static final String CREARADMINISTRADOR = "Nuevo admin";
    static final String CREARBEBIDA = "Nueva bebida";
    
	public FrmPrincipal(String title)
	{
		
		super(title);
		desktop = new JDesktopPane();
	    desktop.setPreferredSize(new Dimension(desktopWidth, desktopHeight));
	    setContentPane(desktop);
	    
	 

	}
	
	protected JMenuBar createMenuBar() 
    {
		JMenuBar menuBar = new JMenuBar();

        JMenu menugestion = new JMenu("Gestionar Datos");
        menugestion.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menugestion);
        
        JMenu menuborra=new JMenu("Eliminar Ficheros");
        menuborra.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuborra);
       
        JMenuItem GestionarUsuarios = new JMenuItem("Usuario");
        GestionarUsuarios.setMnemonic(KeyEvent.VK_N);
        GestionarUsuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        GestionarUsuarios.setActionCommand(CREAR_USUARIO);
        GestionarUsuarios.addActionListener(this);
        menugestion.add(GestionarUsuarios);
        
        

      
      

        return menuBar;
    }
	
	 public void createAndShowGUI() 
	    {
	       
	        
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setJMenuBar(createMenuBar());
	        //Display the window.
	        this.pack();
	       
	        JLabel background = new JLabel();
	        background.setBounds(0, 0, desktopWidth, desktopHeight);
	        desktop.add(background);
	        desktop.setBackground(Color.GRAY);
	        this.setVisible(true);
	      
           JOptionPane.showMessageDialog(this,"BIENVENIDO");
        
           
   	    JPanel panel= new JPanel();
   	   	
   		
   		JButton coca= new JButton(new ImageIcon (getClass().getResource("/img/cocacola.jpg")));
   		coca.addActionListener(this);
   		coca.setActionCommand("");
   		
   		JButton nestea1= new JButton(new ImageIcon (getClass().getResource("/img/nest.jpg")));
   		nestea1.addActionListener(this);
   		nestea1.setActionCommand("");
   		
   		   
   	    JPanel basePanel= new JPanel(new GridLayout());
   	    basePanel.add(coca); basePanel.add(nestea1);
   	    panel.add(basePanel,BorderLayout.SOUTH);
   	    this.setContentPane(panel);
           
          
   	
	    }
	 
	   protected void createFrameUsuario() 
	    {
//	        InternalUsuario frame = new InternalUsuario();
//	      
//	        frame.setVisible(true); //necessary as of 1.3
//	        desktop.add(frame);
//	        try 
//	        {
//	            frame.setSelected(true);
//	        } catch (java.beans.PropertyVetoException e) {}
		   
				FrmNuevoUsuario ventana = new FrmNuevoUsuario();
				ventana.createandshowGUI();
				
				ventana.setIconImage(new ImageIcon(getClass().getResource("/img/maquina.jpg")).getImage());
				
				//clsGestor.creabebidas(); ----> ponemos aqui este metodo??
			
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		clsGestor objGestor = new clsGestor();
    	String comando = e.getActionCommand();
		 switch(comando)
	        {
		 
		 case("Usuario"):
		  {
			 createFrameUsuario();
		     break;
		  }
		 case(CREARADMINISTRADOR):
		 {

		 
	        }
	
	        }
		
	
	
	}
	}