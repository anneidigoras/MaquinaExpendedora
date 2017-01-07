package LP;

/**
 * 
 * Ventana principal de nuestro proyecto
 * @author Mayi y Anne
 */

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JMenuBar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import LD.ConexionSql;
import LN.clsGestor;
import LN.clsUsuario;



public class VentanaPrincipal  extends JFrame implements ActionListener,ItemListener
{

	private static final long serialVersionUID = 1L;
	
	clsGestor objGestor= new clsGestor(null);
	
	private JLabel bienv ;
    private	JLabel imagenlbl;
	private JPanel contentPane;
	private JMenuBar MenuPrincipal;
//	private JMenu Cliente;
//	private JMenuItem C_Ingresar;
//	private JMenuItem C_Registrarse;
//	private JMenu Admin;
//	private JMenuItem A_Ingresar;

	private JButton Salir, btIngresar, btRegistro, btAdmin, btUsuario;
	Connection connection = null;
	

	
	static final String SOY_CLIENTE = "Ingresar como cliente";
    static final String SOY_ADMIN= "Ingresar como administrador";
    static final String CREAR_CLIENTE = "Registrarse cliente";
    static final String CREAR_ADMIN= "Entrar admin";
    static final String CREARBEBIDA = "Nueva bebida";
    static final String SALIR = "Salir";
    static final String REGISTRO = "Registrarse";
    static final String ADMIN = "Administrador";
    

    

    public VentanaPrincipal(String title)
    {
   
    	this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	connection = ConexionSql.dbConnector("");
		
		contentPane = new JPanel();
        contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 204, 255));		
		contentPane.setBounds(100,100,1000,700);
		
		bienv = new JLabel ("¡BIENVENIDO!");
		bienv.setFont(new Font("Algerian", Font.BOLD, 45));
		bienv.setForeground(Color.WHITE);
		bienv.setBounds(contentPane.getWidth()/2 +50,50,500,150);
		
		
		
		
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/img/portada.jpg"));
		Image imagen = icono.getImage();
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(350,600,Image.SCALE_SMOOTH));
        imagenlbl = new JLabel (iconoEscalado);
        imagenlbl.setBounds(contentPane.getWidth()/2 -50,200,500,600);
        
        
        btUsuario = new JButton ();
		btUsuario.setBounds(contentPane.getWidth()/6, 350, 200, 200);
		ImageIcon icono2 = new ImageIcon(getClass().getResource("/img/usuario.png"));
		 Image imagen2 = icono2.getImage();
		 ImageIcon iconoEsc2 = new ImageIcon (imagen2.getScaledInstance(200,200,Image.SCALE_SMOOTH));
	    btUsuario.setIcon(iconoEsc2);
	   
	  
	
		MenuPrincipal = new JMenuBar();
		MenuPrincipal.setBackground(new Color(51, 102, 153));
		this.setJMenuBar(MenuPrincipal);

		
		btIngresar = new JButton ();
		btIngresar.setBounds(contentPane.getWidth()/6, 550, 90, 90);
		ImageIcon icono0 = new ImageIcon(getClass().getResource("/img/login.png"));
		 Image imagen0 = icono0.getImage();
		 ImageIcon iconoEsc0 = new ImageIcon (imagen0.getScaledInstance(90,90,Image.SCALE_SMOOTH));
	    btIngresar.setIcon(iconoEsc0);
	    btIngresar.setActionCommand(SOY_CLIENTE);
	    btIngresar.addActionListener((ActionListener)this);
	    
		btAdmin = new JButton ();
		btAdmin.setBounds(contentPane.getWidth(),350, 200,200);
		ImageIcon icono3 = new ImageIcon(getClass().getResource("/img/admin.png"));
		 Image imagen3 = icono3.getImage();
		 ImageIcon iconoEsc3 = new ImageIcon (imagen3.getScaledInstance(200,200,Image.SCALE_SMOOTH));
	    btAdmin.setIcon(iconoEsc3);
	    btAdmin.setActionCommand(SOY_ADMIN);
	    btAdmin.addActionListener((ActionListener)this);
	    
	    btRegistro = new JButton ();
		btRegistro.setBounds(contentPane.getWidth()/6 +110, 550, 90, 90);
		ImageIcon icono1 = new ImageIcon(getClass().getResource("/img/registro.jpg"));
		 Image imagen1 = icono1.getImage();
		 ImageIcon iconoEsc1 = new ImageIcon (imagen1.getScaledInstance(90,90,Image.SCALE_SMOOTH));
	    btRegistro.setIcon(iconoEsc1);
	    btRegistro.setActionCommand(REGISTRO);
	    btRegistro.addActionListener((ActionListener)this);
	
		
		Salir = new JButton("SALIR");;
        Salir.setActionCommand(SALIR);
        Salir.addActionListener(this);
        MenuPrincipal.add(Salir);
        
        
 
        contentPane.add(btIngresar); contentPane.add(btRegistro);contentPane.add(btUsuario); contentPane.add(imagenlbl);contentPane.add(bienv);
        contentPane.add(btAdmin);
        
      
        setContentPane(contentPane);
    }
    
 
	
	 
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			
		 case SOY_CLIENTE:
//			 getContentPane().removeAll();
			 IdentificaciónCliente frame1= new IdentificaciónCliente();
			 frame1.setVisible(true);
//			 getContentPane().add(frame1);
			 break;
		
		 case SOY_ADMIN:
             RegistroAdmin frame2= new RegistroAdmin();
             frame2.setVisible(true);
             this.setVisible(false);
			 break;
			 
		 case REGISTRO:
			 RegistroUsuario frame3= new RegistroUsuario();
			 frame3.setVisible(true);
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


	





	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@SuppressWarnings("unchecked")
	public void cargarLista()
	{
				
		Connection conn=ConexionSql.dbConnector("Base datos Usuarios");
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();
			
						
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select nombre_e from usuario");
					     
		      while(rs.next())
		      { 
		    	  // Leer el resultset
		    	  ArrayList<clsUsuario>usuario;
		    	  usuario= clsGestor.leerUsuario();
		    	 clsModeloListaUsuario objM= new clsModeloListaUsuario(usuario);
		    	//  objM.añadirElemento((clsUsuario) rs.getString());
		    	  		    

		      }
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	




}
	