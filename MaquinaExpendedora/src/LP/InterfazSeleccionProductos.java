package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import COMUN.clsConstantes;
import LD.ConexionSql;
import LN.clsAdministrador;
import LN.clsAdquisicion;
import LN.clsAlimento;
import LN.clsBebida;
import LN.clsGestor;
import LN.clsMensaje;
import LN.clsUsuario;
/**
 * 
 * Clase de interaccion del usuario con los productos. 
 * En esta clase tendra la opcion de comprar , recargar su saldo y de poder cerrar sesion
 * @author Anne y Mayi
 *
 */
public class InterfazSeleccionProductos extends JFrame implements ActionListener
{
	JLabel lbldni, lblnombre,lbledad, lblpass,lblape;
	
	
	String comando= null;
	static String dni_usuario;
	static clsUsuario usuario = new clsUsuario (); 
	private JButton btCoca, btNestea, btBifrutas, btKitKat, btOreo, btComprar, btAgua, btSnickers, btCerrar, btReponer;
	private JLabel lblCoca, lblNestea, lblBifrutas, lblKitKat, lblOreo, lblAgua, lblSnickers,lblCerrar;
	private JPanel contentPane;
	private JTextArea txtPantalla;
	
	JPanel panel4;
	
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
    
    static final String ED_DNI= "Edito DNI";
	static final String ED_NOMBRE= "Edito nombre";
	static final String ED_APE= "Edito apellido";
    static final String ED_EDAD = "Edito edad";
    static final String ED_PASS = "Edito contrase�a";
    
    JTextField txtdni,txtnombre,txtape,txtpass,txtedad;
    
    

    clsBebida objBebida= new clsBebida();
	/**
	 * 
	 * Metodo que nos indica el usuario que esta usando actualmente la interfaz
	 */
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
	/**
	 * 
	 * Constructor con todo el tema de swing
	 * @param dni: pasamos el dni del usuario 
	 */
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
		
		dinero = new JLabel ("Saldo: "+ String.format(java.util.Locale.US,"%.2f", usuario.getDinero())+ " �");
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
		lbldatos.setBounds(20,0,150,50);
		lbldatos.setFont(new Font("Serif", Font.PLAIN, 22));
		
		lbldni = new JLabel("DNI: " +usuario.getDni());
		lbldni.setBounds(0,70,150,30);
		
		lblnombre = new JLabel ("Nombre: "+usuario.getNombre());
		lblnombre.setBounds(0,120,150,30);
		
		lblape= new JLabel ("Apellido: "+ usuario.getApellido());
		lblape.setBounds(0,170,150,30);
		
		lbledad= new JLabel ("Edad: "+ usuario.getEdad());
		lbledad.setBounds(0,220,150,30);
		
		lblpass = new JLabel("Contrase�a: "+usuario.getPassword());
		lblpass.setBounds(0,270,150,30);
		
		
		JButton bteditar = new JButton();
		bteditar.setBounds(20, 350, 100, 30);
		bteditar.setActionCommand(EDITAR);
		bteditar.addActionListener((ActionListener)this);
		bteditar.setText(EDITAR);
		
		
		JPanel panel3 = new JPanel ();
		panel3.setBounds(900,50, 175,400);
		panel3.setLayout(null);
		panel3.add(lbldatos);panel3.add(lblnombre);panel3.add(lblape);panel3.add(lbldni);panel3.add(lbledad);panel3.add(lblpass);panel3.add(bteditar);
		contentPane.add(panel3);
		
		
		//PANEL 4
		
		txtdni = new JTextField ("nuevo DNI");
		txtdni.setBounds(0,0,150,30);
		
		txtnombre = new JTextField ("nuevo nombre");
		txtnombre.setBounds(0,50,150,30);
		
		txtape = new JTextField ("nuevo apellido");
		txtape.setBounds(0,100,150,30);
		
		txtedad = new JTextField ("nueva edad");
		txtedad.setBounds(0,150,150,30);
		
		txtpass = new JTextField ("nueva contrase�a");
		txtpass.setBounds(0,200,150,30);
		
		
		ImageIcon check = new ImageIcon(getClass().getResource("/img/checkmark.png"));
		Image imagencheck = check.getImage();
		ImageIcon checkEsc = new ImageIcon (imagencheck.getScaledInstance(30,30,Image.SCALE_SMOOTH));
		
		JButton bdni,bnombre,bape,bedad,bpass;
		
		bdni = new JButton();
		bdni.setBounds(170,0,30,30);
		bdni.setIcon(checkEsc);
		bdni.setActionCommand(ED_DNI);
		bdni.addActionListener((ActionListener) this);
		
		
		bnombre = new JButton();
		bnombre.setBounds(170,50,30,30);
		bnombre.setIcon(checkEsc);
		bnombre.setActionCommand(ED_NOMBRE);
		bnombre.addActionListener((ActionListener) this);
		
		bape = new JButton();
		bape.setBounds(170,100,30,30);
		bape.setIcon(checkEsc);
		bape.setActionCommand(ED_APE);
		bape.addActionListener((ActionListener) this);
		
		bedad = new JButton();
		bedad.setBounds(170,150,30,30);
		bedad.setIcon(checkEsc);
		bedad.setActionCommand(ED_EDAD);
		bedad.addActionListener((ActionListener) this);
		
		bpass = new JButton();
		bpass.setBounds(170,200,30,30);
		bpass.setIcon(checkEsc);
		bpass.setActionCommand(ED_PASS);
		bpass.addActionListener((ActionListener) this);
		
		panel4 = new JPanel();
		panel4.setBounds(1075, 120, 250, 400);
		panel4.setLayout(null);
		panel4.add(txtnombre);panel4.add(txtdni);panel4.add(txtape);panel4.add(txtedad);panel4.add(txtpass);
		panel4.add(bdni);panel4.add(bnombre);panel4.add(bedad);panel4.add(bape);panel4.add(bpass);
		panel4.setVisible(false);
		contentPane.add(panel4);
		
		setContentPane(contentPane);
	
	}

	/**
	 * 
	 * Metodo que nos permite hacer uso de las acciones indicadas
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.txtPantalla.setText(""); //Para que se vacie el textArea cada vez
		
		String comando_anterior = comando;
        comando = e.getActionCommand();
		
		switch(comando)
		{
			case COCA:
				
				this.txtPantalla.append("CocaCola:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_COCACOLA)+" �");
				break;
			case NESTEA:
				this.txtPantalla.append("Nestea:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_NESTEA)+" �");
				break;
			case BIF:
				this.txtPantalla.append("Bifrutas:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_BIFRUTAS)+" �");
				break;
				
			case AGUA:
				this.txtPantalla.append("Agua:	"+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_AGUA)+" �");
				break;

			case SNI:
				this.txtPantalla.append("Snickers:	 "+String.format(java.util.Locale.US,"%.2f",0.8)+" �");
				break;
			case OREO:
				this.txtPantalla.append("Oreos:	 "+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_OREO)+" �");
				break;
			
			case KIT:
				this.txtPantalla.append("KitKat:	 "+String.format(java.util.Locale.US,"%.2f",clsConstantes.PRECIO_KITKAT)+" �");
				break;
				
			case COMPRAR :
				compra(comando_anterior);
				break;
			
			case EDITAR: 
				panel4.setVisible(true);
				break;
				
			case SALIR:
				int salir;

				 salir= JOptionPane.showConfirmDialog(null, "�Seguro que quiere cerrar la sesion?","Confirmar ", JOptionPane.OK_CANCEL_OPTION);
				 if(salir==0)
					 {this.dispose();
				   VentanaPrincipal frame = new VentanaPrincipal("");
				   frame.setVisible(true);}
			     break;
			 
			case REPONER:
				ReponerSaldo frame= new ReponerSaldo(usuario);
				frame.setVisible(true);
				this.dispose();
				break;
				
			case ED_DNI:
				usuario.setDni(txtdni.getText());
				clsGestor.ModificarUsuario(usuario, dni_usuario);
				dni_usuario= txtdni.getText();
				lbldni.setText("DNI: "+ dni_usuario );
				txtdni.setText("nuevo DNI");
				break;
			
			case ED_NOMBRE:
				usuario.setNombre(txtnombre.getText());
				clsGestor.ModificarUsuario(usuario, dni_usuario);
				lblnombre.setText("Nombre: "+usuario.getNombre() );
				txtnombre.setText("nuevo nombre");
				break; 
				
			case ED_APE:
				usuario.setApellido(txtape.getText());
				clsGestor.ModificarUsuario(usuario, dni_usuario);
				lblape.setText("Apellido: "+ usuario.getApellido() );
				txtape.setText("nuevo apellido");
				break;
				
			case ED_EDAD:
				//comprobar que sea un int y sacar error si no es el caso
				usuario.setEdad(Integer.parseInt(txtedad.getText()));
				
	
				clsGestor.ModificarUsuario(usuario, dni_usuario);
				lbledad.setText("Edad: "+ usuario.getEdad() );
				txtedad.setText("nueva edad");
			
				break;
				
			case ED_PASS:
				//si cambia luego no me deja ingresar con la nueva contrase�a
				usuario.setPassword(txtpass.getText());
				clsGestor.ModificarUsuario(usuario, dni_usuario);
				lblpass.setText("Contrase�a: "+usuario.getPassword());
				txtpass.setText("nueva contrase�a");
				break;
			
				
				
				
			
		
	}
	
	
	
	

	}
	
	//metodo para que el usuario pueda cambiar sus datos
	
	//metodo para que el usuario recargue dinero
	
	//metodo para que cuando no queden mas existencias de un producto el usuario no pueda consumir m�s : que el boton no funcione o poner una etiqueta de agotado.
	/**
	 * 
	 * Metodo de compra en el que segun lo que compre se reducira el saldo del usuario y la cantidad de stock de dicho producto
	 * 
	 * @param consumicion
	 */
	public void compra (String consumicion)
    {
		boolean es_bebida= false;
        float precio =0; float precio2=0;
        clsBebida bebidaconsumida = new clsBebida();
        LinkedList<clsBebida>listaBebidas= new LinkedList<clsBebida>();
        listaBebidas=clsGestor.BebidasGuardadas();
                 
        clsAlimento alimentoConsumido = new clsAlimento();
        LinkedList<clsAlimento>listaAlimentos= new LinkedList<clsAlimento>();
        listaAlimentos=clsGestor.AlimentosGuardados();
                
        for (clsAlimento aux: listaAlimentos)
        {
        	if(aux.getId().equals(consumicion)){ alimentoConsumido = aux; es_bebida=false;} 
                                 
        }
        for (clsBebida aux: listaBebidas)
        {
            if(aux.getId().equals(consumicion)){ bebidaconsumida = aux;es_bebida =true;}
            clsGestor.crearAdquisicion(aux.getId(),usuario.getDni());
        }
        if (es_bebida == false)
        {
           clsGestor.crearAdquisicion(alimentoConsumido.getId(),usuario.getDni());
           precio = alimentoConsumido.getPrecioP();
           if (usuario.getDinero()<precio )
           {
               JOptionPane.showMessageDialog(null, "No tiene suficiente saldo","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE);
           }
           else
           {
        	   if (alimentoConsumido.getNum()>0 )
        	   {
        		   	usuario.setDinero((float) (usuario.getDinero()- alimentoConsumido.getPrecioP()));
        		   	clsGestor.gastadinero(usuario.getDni(), consumicion);
                                                                                                    
        		   	dinero.setText("Saldo: "+ String.format(java.util.Locale.US,"%.2f", usuario.getDinero())+ " �");
        		   	clsGestor.consumoAlimento(consumicion);
           
        		   	crearTablaCompra(alimentoConsumido.getId(),alimentoConsumido.getNombreP());
               }
               else if(alimentoConsumido.getNum()==0 )
               {
                               JOptionPane.showMessageDialog(null, "No quedan m�s " +alimentoConsumido.getNombreP(), "ESTE PRODUCTO SE HA AGOTADO",JOptionPane.ERROR_MESSAGE);
               }
                                    
             }
                     
                     
         }
        else
        {
        	  precio2=bebidaconsumida.getPrecioP();
              
              if ( usuario.getDinero()<precio2)
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
                                           clsGestor.gastadinero(usuario.getDni(), consumicion);
                                          
                                                                                   
                                           dinero.setText("Saldo: "+ String.format(java.util.Locale.US,"%.2f", usuario.getDinero())+ " �");
                                           clsGestor.consumobebida(consumicion);
                                           
                                           crearTablaCompra(bebidaconsumida.getId(),bebidaconsumida.getNombreP());
                             }
                             else if( bebidaconsumida.getNum()==0)
                             {
                                           JOptionPane.showMessageDialog(null, "No quedan m�s " +bebidaconsumida.getNombreP(),
                                 "ESTE PRODUCTO SE HA AGOTADO",
                                 JOptionPane.ERROR_MESSAGE);
                             }
             
             
              }
        	
        }

                	  
          
                 
                  
                

	

	}
	public void crearTablaCompra (String id_producto, String nombre_producto)
	{
		clsAdquisicion compra = new clsAdquisicion(id_producto,usuario.getDni(),nombre_producto, usuario.getNombre());
		
		Connection nueva_conexion =ConexionSql.initBD("src\\BD\\Adquisiciones.db" );
		Statement st =ConexionSql.usarCrearTablasBD(nueva_conexion);
		ConexionSql.adquisicionInsert(st, compra);
		ConexionSql.cerrarBD(nueva_conexion, st);
		try {
			   //Y para terminar cerramos la conexi�n
			
			   nueva_conexion.close();
			
			  }

			  catch (SQLException e) {

			   //Esto se ejecuta si hay alg�n problema al realizar la conexi�n.

			   e.printStackTrace();
			  }
		
		
	}
	}