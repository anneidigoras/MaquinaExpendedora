package LP;



import java.awt.Color;

import static COMUN.clsConstantes.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import LN.clsGestor;



public class VentanaPrincipal  extends JFrame implements ActionListener,ItemListener, InternalFrameListener
{

	private static final long serialVersionUID = 1L;
	
	clsGestor objGestor= new clsGestor();
	
	JLabel bienv ;
	JLabel imagenlbl;
	
	JMenuBar MenuPrincipal;
	JMenu Cliente;
	JMenuItem C_Ingresar;
	JMenuItem C_Registrarse;
	JMenu Admin;
	JMenuItem A_Ingresar;
	JMenuItem A_Registrarse;
	JButton Salir;
	JButton usuario;
	
	   JFrame miVentana;
	     JPanel p1;
	     JPanel p2;
	     JPanel p3;
	     JPanel p4;
	     JPanel p5;
	     JPanel p6;
	     JPanel p7;
	
	static final String SOY_CLIENTE = "Ingresar como cliente";
    static final String SOY_ADMIN= "Ingresar como administrador";
    static final String CREAR_CLIENTE = "Registrarse cliente";
    static final String CREAR_ADMIN= "Entrar admin";
    static final String CREARBEBIDA = "Nueva bebida";
    static final String SALIR = "Salir";
    

    public VentanaPrincipal(String title)
    {
   
    	this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		bienv = new JLabel ("¡BIENVENIDO!");
		bienv.setFont(new Font("Algerian", Font.BOLD, 30));
		bienv.setForeground(new Color(51, 102, 153));
		bienv.setBounds(540,100,300,20);
		bienv.setLocation(200,100);
		getContentPane().add(bienv);
		
		
			
		ImageIcon icono = new ImageIcon(getClass().getResource("/img/portada.jpg"));
		Image imagen = icono.getImage();
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(400,400,Image.SCALE_SMOOTH));
        imagenlbl = new JLabel (iconoEscalado);
        this.getContentPane().setPreferredSize(this.getSize());
        getContentPane().add(imagenlbl);
		getContentPane().setBackground(new Color(204, 204, 255));
		
		MenuPrincipal = new JMenuBar();
		MenuPrincipal.setBackground(new Color(51, 102, 153));
		this.setJMenuBar(MenuPrincipal);
		
		Cliente = new JMenu("CLIENTE");
		Cliente.setForeground(Color.WHITE);
		MenuPrincipal.add(Cliente);
		
		C_Ingresar = new JMenuItem("Ingresar");
		C_Ingresar.setForeground(new Color(0, 255, 0));
		C_Ingresar.setActionCommand(SOY_CLIENTE);
		C_Ingresar.addActionListener(this);
		Cliente.add(C_Ingresar);
		
		C_Registrarse = new JMenuItem("Registrarse");
		C_Registrarse.setForeground(new Color(200, 255, 0));
		C_Registrarse.setActionCommand(CREAR_CLIENTE);
		C_Registrarse.addActionListener(this);
		Cliente.add(C_Registrarse);
    	
		Admin = new JMenu("ADMINISTRADOR");
		Admin.setForeground(Color.WHITE);
		MenuPrincipal.add(Admin);
		
		A_Ingresar = new JMenuItem("Ingresar");
		A_Ingresar.setForeground(new Color(0, 128, 0));
		A_Ingresar.setActionCommand(SOY_ADMIN);
		A_Ingresar.addActionListener(this);
		Admin.add(A_Ingresar);
		
		A_Registrarse = new JMenuItem("Registrarse");
		A_Registrarse.setForeground(new Color(0, 128, 0));
		A_Registrarse.setActionCommand(CREAR_ADMIN);
		A_Registrarse.addActionListener(this);
		Admin.add(A_Registrarse);
		
		Salir = new JButton("SALIR");;
        Salir.setActionCommand(SALIR);
        Salir.addActionListener(this);
        MenuPrincipal.add(Salir);

    
        
        
        
    }
    
 
	
	 
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			
		 case SOY_CLIENTE:
			 IngresoCliente();
			 break;
		
		 case SOY_ADMIN:
//			 IngresoAdmin();
			 break;
			 
		 case CREAR_CLIENTE:
			 CrearCliente();
			 break;
			 
		 case CREAR_ADMIN:
//			 CrearAdmin();
			 break;
			 
		// Utilizo ImageIcon, Image para hacer la foto más pequeña-- sino era más grande que la pantalla
		case SALIR:
			 int salir;
			 ImageIcon icono = new ImageIcon(getClass().getResource("/img/maquina.jpg"));
			 Image imagen = icono.getImage();
			 ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(200,200,Image.SCALE_SMOOTH));
			 salir= JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir del programa?","Confirmar salida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, iconoEscalado);
			 if(salir==0)
			    System.exit(0);
			 else
		     break;
		

		
		}
			
	}

	protected void IngresoCliente()
	{
		InternalUsuario frame = new InternalUsuario();
        frame.setVisible(true); //necessary as of 1.3
        getContentPane().add(frame);
 
       try 
       {
		frame.setSelected(true);
	   }
       catch (PropertyVetoException e) 
       {
		
		e.printStackTrace();
	   }
       
	}
	
	protected void CrearCliente()
	{
//		FrmNuevoUsuario frame = new FrmNuevoUsuario();
//		frame.setVisible(true); //necessary as of 1.3
//        getContentPane().add(frame);
  
//       try 
//       {
//		frame.setSelected(true);
//	   }
//       catch (PropertyVetoException e) 
//       {
//		
//		e.printStackTrace();
//	   }
       
	}
	
	

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
 
   
     /**
	     * Método que creará la JInternalFrame de los alumnos
	     * @return void
	     */
    
	 public  void crearYMostrarGUI() 
	 {
	    	// Crear ventana inicial
	      miVentana = new JFrame();        
	      miVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	      
	        
        usuario= new JButton ("Usuario");
        usuario.setActionCommand(SOY_CLIENTE);
        usuario.addActionListener(this);
        
	      
	      p1 = new JPanel();
      	  p1.setName( "p1" );
	      p1.setBorder( BorderFactory.createMatteBorder( 2, 5, 2, 5, Color.green ) );
		  p1.setBounds( 10, 10, 400, 150 );
		  p1.add(usuario);
	      
		  miVentana.add(p1);
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	 }  

}