package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import COMUN.clsConstantes;
import LN.clsAdministrador;
import LN.clsGestor;
import LN.clsMensaje;
import LN.clsUsuario;
/**
 * 
 * Clase en la que pondremos la interfaz con la que interactuara el usuario para escoger el producto que quiera
 * @author Anne
 *
 */
public class InterfazSeleccionProductos extends JFrame implements ActionListener
{
	String comando= null;
	static String dni_usuario;
	static clsUsuario usuario = new clsUsuario (); 
	private JButton btCoca, btNestea, btBifrutas, btKitKat, btOreo, btAnular, btComprar, btAgua, btSnickers;
	private JLabel lblCoca, lblNestea, lblBifrutas, lblKitKat, lblOreo, lblAgua, lblSnickers;
	private JPanel contentPane;
	private JTextArea txtPantalla;
	static final String COCA= clsConstantes.ID_COCACOLA;
	static final String NESTEA= clsConstantes.ID_NESTEA;
	static final String BIF= clsConstantes.ID_BIFRUTAS;
	static final String OREO= "Oreo";
	static final String KIT= "KitKat";
	static final String SNI= "Snickers";
	static final String AGUA= "Agua";
	static final String AN= "Anular";
	static final String COMPRAR= "Comprar";
	
	public static void usuarioacual ()
	{
		ArrayList<clsUsuario> listausuarios =clsGestor.leerUsuario();
		for (clsUsuario aux : listausuarios)
		{
			if (aux.getDni().equals(dni_usuario))
			{
				usuario= aux;
			}
		}
		
	}
	public InterfazSeleccionProductos(String dni)
	{
		this.dni_usuario= dni;
		usuarioacual();
		
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		contentPane = new JPanel();
        contentPane.setLayout(null);
		
		
		lblCoca= new JLabel ("CocaCola");
		lblCoca.setBounds(15, 105, 67, 40);
		
		lblNestea= new JLabel ("Nestea");
		lblNestea.setBounds(155,105,67,40);
		
		lblBifrutas= new JLabel ("Bifrutas");
		lblBifrutas.setBounds(305,105,67,40);
		
		lblKitKat= new JLabel ("KitKat");
		lblKitKat.setBounds(150,220,67,40);
		
		lblOreo= new JLabel ("Oreo");
		lblOreo.setBounds(30,220,67,40);
		
		lblAgua= new JLabel ("Agua");
		lblAgua.setBounds(450,105,67,40);
		
		lblSnickers= new JLabel ("Snickers");
		lblSnickers.setBounds(300,220,67,40);
		
		
		btNestea = new JButton ();
		btNestea.setBounds(150, 10, 90, 90);
		ImageIcon icono0 = new ImageIcon(getClass().getResource("/img/nest.jpg"));
		 Image imagen0 = icono0.getImage();
		 ImageIcon iconoEsc0 = new ImageIcon (imagen0.getScaledInstance(90,90,Image.SCALE_SMOOTH));
	    btNestea.setIcon(iconoEsc0);
	    btNestea.setActionCommand(NESTEA);
	    btNestea.addActionListener((ActionListener)this);
	    
	    
	    btBifrutas = new JButton ();
		btBifrutas.setBounds(300, 10, 90, 90);
		ImageIcon icono2 = new ImageIcon(getClass().getResource("/img/bif.png"));
		Image imagen2 = icono2.getImage();
		ImageIcon iconoEsc2 = new ImageIcon (imagen2.getScaledInstance(90,90,Image.SCALE_SMOOTH));
		btBifrutas.setIcon(iconoEsc2);
	    btBifrutas.setActionCommand(BIF);
	    btBifrutas.addActionListener((ActionListener)this);
	    
	    btSnickers = new JButton ();
	  	btSnickers.setBounds(280, 150, 90, 70);
	  	ImageIcon icono3 = new ImageIcon(getClass().getResource("/img/snickers.jpg"));
	  	Image imagen3 = icono3.getImage();
	  	ImageIcon iconoEsc3 = new ImageIcon (imagen3.getScaledInstance(90,70,Image.SCALE_SMOOTH));
	  	btSnickers.setIcon(iconoEsc3);
	    btSnickers.setActionCommand(SNI);
	  	btSnickers.addActionListener((ActionListener)this);
	  	    
	  	btAgua = new JButton ();
	    btAgua.setBounds(450, 10, 90, 90);
	  	ImageIcon icono4 = new ImageIcon(getClass().getResource("/img/agua.jpg"));
	  	Image imagen4 = icono4.getImage();
	    ImageIcon iconoEsc4 = new ImageIcon (imagen4.getScaledInstance(90,90,Image.SCALE_SMOOTH));
	  	btAgua.setIcon(iconoEsc4);
	  	btAgua.setActionCommand(AGUA);
	  	btAgua.addActionListener((ActionListener)this);
		
		btCoca = new JButton ();
		btCoca.setBounds(10, 10, 90, 90);
		ImageIcon icono1 = new ImageIcon(getClass().getResource("/img/cocacola.jpg"));
		Image imagen1 = icono1.getImage();
		ImageIcon iconoEsc1 = new ImageIcon (imagen1.getScaledInstance(90,90,Image.SCALE_SMOOTH));
	    btCoca.setIcon(iconoEsc1);
	    btCoca.setActionCommand(COCA);
	    btCoca.addActionListener((ActionListener)this);
	    
	    btOreo = new JButton ();
		btOreo.setBounds(10, 150, 90, 70);
		ImageIcon icono5 = new ImageIcon(getClass().getResource("/img/oreo.jpg"));
		Image imagen5 = icono5.getImage();
		ImageIcon iconoEsc5 = new ImageIcon (imagen5.getScaledInstance(90,70,Image.SCALE_SMOOTH));
	    btOreo.setIcon(iconoEsc5);
	    btOreo.setActionCommand(OREO);
	    btOreo.addActionListener((ActionListener)this);
	    
	    btKitKat = new JButton ();
		btKitKat.setBounds(130, 150, 100, 60);
		Image img5 = null;
			try {
				img5 = ImageIO.read(getClass().getResource("/img/kitkat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    btKitKat.setIcon(new ImageIcon(img5));
		btKitKat.setActionCommand(KIT);
		btKitKat.addActionListener((ActionListener)this);
	    
	
	    
	    btComprar = new JButton();
	    btComprar.setBounds(410,320,90,50);
	    btComprar.setActionCommand(COMPRAR);
	    btComprar.addActionListener((ActionListener)this);
	    btComprar.setText(COMPRAR);
		
	    JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(600, 35, 100, 50);
		contentPane.add(scrollPane_1);
		
		txtPantalla = new JTextArea();
		scrollPane_1.setViewportView(txtPantalla);
		
	
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(30, 50, 550, 400);
		panel1.setLayout(null);
		panel1.add(lblCoca); panel1.add(btCoca); panel1.add(lblNestea);panel1.add(btNestea);panel1.add(lblBifrutas);panel1.add(btBifrutas); 
		panel1.add(lblKitKat);panel1.add(lblOreo); panel1.add(btOreo); panel1.add(btCoca);panel1.add(btKitKat); panel1.add(btSnickers);panel1.add(lblAgua);
		panel1.add(lblSnickers); panel1.add(btAgua);
		panel1.add(btComprar);//panel1.add(btAnular);
		panel1.setBackground(Color.red);
		contentPane.add(panel1);
		
		
		JLabel nombre = new JLabel (usuario.getNombre());
		nombre.setBounds(0, 0, 100, 30);
		
		JLabel dinero = new JLabel (Float.toString(usuario.getDinero()));
		dinero.setBounds(0,50,100,30);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(750, 50, 200, 400);
		panel2.setLayout(null);
		panel2.add(nombre);panel2.add(dinero);
		contentPane.add(panel2);
		
		
		
		
		
		setContentPane(contentPane);
	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.txtPantalla.setText(""); //Para que se vacie el textArea cada vez
		
		String comando_anterior = comando;
        comando = e.getActionCommand();
		
		switch(comando)
		{
			case COCA:
				
				this.txtPantalla.append("CocaCola"+" 1,30 €");
				break;
			case NESTEA:
				this.txtPantalla.append("Nestea"+" 1,20 €");
				break;
			case BIF:
				this.txtPantalla.append("Bifrutas"+" 1,20 €");
				break;
				
			case AGUA:
				this.txtPantalla.append("Agua "+" 0,80 €");
				break;

			case SNI:
				this.txtPantalla.append("Snickers "+" 1,10 €");
				break;
			case OREO:
				this.txtPantalla.append("Oreos"+" 1,20 €");
				break;
			
			case KIT:
				this.txtPantalla.append("KitKat"+" 1,20 €");
				break;
				
			case COMPRAR :
				compra(comando_anterior);
				break;
				
				
			
		
	}
	
	
	
	

	}
	public void compra (String bebida)
	{
		
		
	}

	}