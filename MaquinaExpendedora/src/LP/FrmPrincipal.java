package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class FrmPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    JTextArea display;
    JDesktopPane desktop;
    
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;
    
    static final String SHOW = "show";
    static final String CLEAR = "clear";
    String newline = "\n";
    static final int desktopWidth = 500;
    static final int desktopHeight = 300;
    
    static final String CREARUSUARIO = "Nuevo usuario";
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

        //Set up the lone menu.
        JMenu menualta = new JMenu("Gestionar datos");
        menualta.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menualta);
        
        JMenu menumodi=new JMenu("Mostrar datos");
        menumodi.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menumodi);
        
        JMenu menuelim=new JMenu("Eliminar");
        menuelim.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuelim);
        
        

        //Set up the first menu item.
        JMenuItem CrearUsuario = new JMenuItem("Usuario");
        CrearUsuario.setMnemonic(KeyEvent.VK_N);
        CrearUsuario.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        CrearUsuario.setActionCommand("Nuevo usuario");
        CrearUsuario.addActionListener(this);
        menualta.add(CrearUsuario);
        
        JMenuItem CreaAdmin = new JMenuItem("Admin");
        CreaAdmin.setMnemonic(KeyEvent.VK_N);
        CreaAdmin.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        CreaAdmin.setActionCommand("Nuevo admin");
        CreaAdmin.addActionListener(this);
        menualta.add(CreaAdmin);
        
      
      

        return menuBar;
    }
	
	 public void createAndShowGUI() 
	    {
	       
	        
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setJMenuBar(createMenuBar());
	        //Display the window.
	        this.pack();
	        this.setVisible(true);
	        
	       JLabel fondo= new JLabel(new ImageIcon (getClass().getResource("/img/coca.jpeg")));
	        JLabel fondo2= new JLabel (new ImageIcon (getClass().getResource("/img/nestea1.jpg")));
	       fondo.setBounds(100,100,100,100);
	        fondo2.setBounds(200,200,200,200);
 		   desktop.add(fondo,fondo2);
           //desktop.setBackground(Color.blue);
           JOptionPane.showMessageDialog(this,"BIENVENIDO");
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//this.setVisible(false);
		 switch(e.getActionCommand())
	        {
		 
		 case(CREARUSUARIO):
			 {
			
	
			 this.setVisible(true);
		 break;
			 }
		 case(CREARADMINISTRADOR):
		 {

		 
	        }
	}}}


