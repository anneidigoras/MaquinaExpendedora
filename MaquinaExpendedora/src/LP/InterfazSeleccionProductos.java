package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import COMUN.clsConstantes;
import LN.clsAdministrador;
import LN.clsAdquisicion;
import LN.clsBebida;
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
	private JButton btCoca, btNestea, btBifrutas, btKitKat, btOreo, btComprar, btAgua, btSnickers, btCerrar, btReponer;
	private JLabel lblCoca, lblNestea, lblBifrutas, lblKitKat, lblOreo, lblAgua, lblSnickers,lblCerrar;
	private JPanel contentPane;
	private JTextArea txtPantalla;
	
	JLabel dinero;JLabel nombre;
	
	static final String COCA= clsConstantes.ID_COCACOLA;
	static final String NESTEA= clsConstantes.ID_NESTEA;
	static final String BIF= clsConstantes.ID_BIFRUTAS;
	static final String AGUA= clsConstantes.ID_AGUA;
	
	static final String OREO= clsConstantes.ID_OREO;
	static final String KIT= clsConstantes.ID_KITKAT;
	static final String SNI= clsConstantes.ID_SNICKERS;

	static final String AN= "Anular";
	static final String COMPRAR= "Comprar";
	static final String REPONER= "Reponer";
    static final String SALIR = "Cerrar Sesion";
    static final String EDITAR = "Editar";

    clsBebida objBebida= new clsBebida();
	
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
		
		//PANEL 1
		lblCoca= new JLabel ("CocaCola");
		lblCoca.setBounds(15, 105, 67, 40);
		
		lblNestea= new JLabel ("Nestea");
		lblNestea.setBounds(155,105,67,40);
		
		lblBifrutas= new JLabel ("Bifrutas");
		lblBifrutas.setBounds(305,105,67,40);
		
		lblKitKat= new JLabel ("KitKat");
		lblKitKat.setBounds(170,220,67,40);
		
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
	  	btSnickers.setBounds(290, 150, 90, 70);
	  	ImageIcon icono3 = new ImageIcon(getClass().getResource("/img/snickers.jpg"));
	  	Image imagen3 = icono3.getImage();
	  	ImageIcon iconoEsc3 = new ImageIcon (imagen3.getScaledInstance(90,70,Image.SCALE_SMOOTH));
	  	btSnickers.setIcon(iconoEsc3);
	    btSnickers.setActionCommand(SNI);
	  	btSnickers.addActionListener((ActionListener)this);
	  	    
	  	btAgua = new JButton ();
	    btAgua.setBounds(450, 10, 80,90);
	  	ImageIcon icono4 = new ImageIcon(getClass().getResource("/img/agua.jpg"));
	  	Image imagen4 = icono4.getImage();
	    ImageIcon iconoEsc4 = new ImageIcon (imagen4.getScaledInstance(80,90,Image.SCALE_SMOOTH));
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
		btOreo.setBounds(10, 150, 90,70);
		ImageIcon icono5 = new ImageIcon(getClass().getResource("/img/oreo.jpg"));
		Image imagen5 = icono5.getImage();
		ImageIcon iconoEsc5 = new ImageIcon (imagen5.getScaledInstance(90,70,Image.SCALE_SMOOTH));
	    btOreo.setIcon(iconoEsc5);
	    btOreo.setActionCommand(OREO);
	    btOreo.addActionListener((ActionListener)this);
	    
	    btKitKat = new JButton ();
		btKitKat.setBounds(140, 150, 90, 70);
		ImageIcon icono7 = new ImageIcon(getClass().getResource("/img/kitkat.png"));
		Image imagen7 = icono7.getImage();
		ImageIcon iconoEsc7 = new ImageIcon (imagen7.getScaledInstance(90,70,Image.SCALE_SMOOTH));
	    btKitKat.setIcon(iconoEsc7);
		btKitKat.setActionCommand(KIT);
		btKitKat.addActionListener((ActionListener)this);
	    
	    btComprar = new JButton();
	    btComprar.setBounds(410,320,90,50);
	    btComprar.setActionCommand(COMPRAR);
	    btComprar.addActionListener((ActionListener)this);
	    btComprar.setText(COMPRAR);
	    
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(30, 50, 550, 400);
		panel1.setLayout(null);
		panel1.add(lblCoca); panel1.add(btCoca); panel1.add(lblNestea);panel1.add(btNestea);panel1.add(lblBifrutas);panel1.add(btBifrutas); 
		panel1.add(lblKitKat);panel1.add(lblOreo); panel1.add(btOreo); panel1.add(btCoca);panel1.add(btKitKat); panel1.add(btSnickers);panel1.add(lblAgua);
		panel1.add(lblSnickers); panel1.add(btAgua);
		panel1.add(btComprar);
		panel1.setBackground(Color.red);
		contentPane.add(panel1);
		
		//PANTALLA CON DATO DE PRODUCTO SELECCIONADO
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(600, 70, 150, 50);
		contentPane.add(scrollPane_1);
		
		txtPantalla = new JTextArea();
		scrollPane_1.setViewportView(txtPantalla);
		
		
				
		//PANEL 2
		
		dinero = new JLabel ("Saldo: "+ String.format(java.util.Locale.US,"%.2f", usuario.getDinero())+ " €");
		dinero.setBounds(10,100,100,30);
	
 		btReponer = new JButton();
 		btReponer.setBounds(10,140,90,50);
 		btReponer.setActionCommand(REPONER);
        btReponer.addActionListener((ActionListener)this);
 	    btReponer.setText(REPONER);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(600, 100, 200, 400);
		panel2.setLayout(null);
		panel2.add(dinero); panel2.add(btReponer);
		contentPane.add(panel2);
		
		
		// BOTON Y LABEL PARA SALIR
		
		btCerrar = new JButton();
		btCerrar.setActionCommand(SALIR);
		ImageIcon icono6 = new ImageIcon(getClass().getResource("/img/logout.jpg"));
		Image imagen6 = icono6.getImage();
		ImageIcon iconoEsc6 = new ImageIcon (imagen6.getScaledInstance(70,70,Image.SCALE_SMOOTH));
		btCerrar.setIcon(iconoEsc6);
		btCerrar.addActionListener((ActionListener) this);
		btCerrar.setBounds(1300,0,70,70);
		
		
		lblCerrar= new JLabel ("Log Out");
		lblCerrar.setBounds(1305,75,67,40);
		
		contentPane.add(btCerrar);contentPane.add(lblCerrar);
		
		
		
	    //PANEL 3
		
		JLabel lbldatos = new JLabel ("MIS DATOS");
		lbldatos.setBounds(20,0,200,50);
		lbldatos.setFont(new Font("Serif", Font.PLAIN, 22));
		
		JLabel lbldni = new JLabel("DNI: " +usuario.getDni());
		lbldni.setBounds(0,70,150,30);
		
		JLabel lblnombre = new JLabel ("Nombre: "+usuario.getNombre());
		lblnombre.setBounds(0,120,150,30);
		
		JLabel lblape= new JLabel ("Apellido: "+ usuario.getApellido());
		lblape.setBounds(0,170,150,30);
		
		JLabel lbledad= new JLabel ("Edad: "+ usuario.getEdad());
		lbledad.setBounds(0,220,150,30);
		
		JLabel lblpass = new JLabel("Contraseña: "+usuario.getPassword());
		lblpass.setBounds(0,270,150,30);
		
		
		JButton bteditar = new JButton();
		bteditar.setBounds(20, 350, 100, 30);
		bteditar.setActionCommand(EDITAR);
		bteditar.addActionListener((ActionListener)this);
		bteditar.setText(EDITAR);
		
		
		JPanel panel3 = new JPanel ();
		panel3.setBounds(900,50, 250,400);
		panel3.setLayout(null);
		panel3.add(lbldatos);panel3.add(lblnombre);panel3.add(lblape);panel3.add(lbldni);panel3.add(lbledad);panel3.add(lblpass);panel3.add(bteditar);
		contentPane.add(panel3);
		
		
		
		
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
				
				this.txtPantalla.append("CocaCola:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_COCACOLA)+" €");
				break;
			case NESTEA:
				this.txtPantalla.append("Nestea:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_NESTEA)+" €");
				break;
			case BIF:
				this.txtPantalla.append("Bifrutas:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_BIFRUTAS)+" €");
				break;
				
			case AGUA:
				this.txtPantalla.append("Agua:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_AGUA)+" €");
				break;

			case SNI:
				this.txtPantalla.append("Snickers:	 "+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_SNICKERS)+" €");
				break;
			case OREO:
				this.txtPantalla.append("Oreos:	 "+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_OREO)+" €");
				break;
			
			case KIT:
				this.txtPantalla.append("KitKat:	 "+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_KITKAT)+" €");
				break;
				
			case COMPRAR :
				compra(comando_anterior);
				break;
				
			case SALIR:
				 int salir;

				 salir= JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la sesion?","Confirmar ", JOptionPane.OK_CANCEL_OPTION);
				 if(salir==0)
					 {this.dispose();
				   VentanaPrincipal frame = new VentanaPrincipal("");
				   frame.setVisible(true);}
			
			     break;
			 
			case REPONER:
				ReponerSaldo frame= new ReponerSaldo();
				frame.setVisible(true);
				
				
			
		
	}
	
	
	
	

	}
	
	//metodo para que el usuario pueda cambiar sus datos
	
	//metodo para que el usuario recargue dinero
	
	//metodo para que cuando no queden mas existencias de un producto el usuario no pueda consumir más : que el boton no funcione o poner una etiqueta de agotado.
	
	public void compra (String bebida)
	{
		float precio =0;
		clsBebida bebidaconsumida = new clsBebida();
		LinkedList<clsBebida>listaBebidas= new LinkedList<clsBebida>();
		listaBebidas=clsGestor.BebidasGuardadas();
		for (clsBebida aux: listaBebidas)
		{
			if(aux.getId().equals(bebida)) bebidaconsumida = aux;
		}
		precio = bebidaconsumida.getPrecioP();
		if (usuario.getDinero()<precio)
		{
			JOptionPane.showMessageDialog(null, "No tiene suficiente saldo",
				    "SALDO INSUFICIENTE",
				    JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if (bebidaconsumida.getNum()>0) 
			{
				usuario.setDinero((float) (usuario.getDinero()- bebidaconsumida.getPrecioP()));
				clsGestor.gastadinero(usuario.getDni(), bebida);
				
				dinero.setText("Saldo: "+ String.format(java.util.Locale.US,"%.2f", usuario.getDinero())+ " €");
				clsGestor.consumobebida(bebida);
			}
			else {
					JOptionPane.showMessageDialog(null, "No quedan más " +bebidaconsumida.getNombreP(),
				    "ESTE PRODUCTO SE HA AGOTADO",
				    JOptionPane.ERROR_MESSAGE);
			}
		
		
		}
	ArrayList<clsAdquisicion> listaAdq= new ArrayList<clsAdquisicion>();
	for(clsAdquisicion aux:listaAdq){
			
	clsGestor.crearAdquisicion(aux.getId_producto(),aux.getDni_usuario() );	
	}}

	}