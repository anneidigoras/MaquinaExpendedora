package LP;

import java.awt.Color;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.io.IOException;

import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import COMUN.clsConstantes;
import LN.clsAdministrador;

import LN.clsBebida;

import LN.clsGestor;

import LN.clsMensaje;


public class PantallaAdmin extends JFrame   implements ActionListener,ItemListener
{

	private JMenuBar MenuPrincipal;
	private JMenu DatosUsuarios, DatosProductos;
	private JMenuItem ListadoUsuarios,ListadoProductos;
	private JButton vueltaInicio, correo, guardar,ajustes;
    private JPanel contentPane;
        
    
    static int num_cocacola =0;
    static int num_bifrutas=0;
    static int num_nestea=0;
    static int num_agua=0;
    
    private JLabel lblCoca, lblNestea, lblBifrutas, lblAgua;
    private JTextArea areaCoca, areaNestea, areaBifrutas, areaAgua;
    private static JSlider slidCoca, slidNestea, slidBifrutas, slidAgua;
    private static JLabel lblSlidCoca, lblSlidNestea,lblSlidBifrutas, lblSlidAgua;
	
    //static LinkedList<clsBebida> listaestatica;
    
     
	static final String SALIR = "Cerrar Sesion";
	static final String AJUSTES = "Ajustes";
	static final String CORREO= "Correo";
	static final String GUARDAR= "Guardar";
	static final String LISTA= "Listado Usuarios";
	static final String TABPROD= "Listado Productos";
	private final static String SALTO = "\n";
	private boolean ver=false;
	
	
	
	public PantallaAdmin(String title)
	{
		
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
	
    	
				
    	getContentPane().setBackground(new Color(204, 204, 255));
    	
		MenuPrincipal = new JMenuBar();
		MenuPrincipal.setBackground(new Color(51, 102, 153));
		this.setJMenuBar(MenuPrincipal);
		
		DatosUsuarios = new JMenu("Datos Usuarios");
		DatosUsuarios.setForeground(Color.WHITE);
		MenuPrincipal.add(DatosUsuarios);
		DatosProductos = new JMenu("Datos Productos");
		DatosProductos.setForeground(Color.WHITE);
		MenuPrincipal.add(DatosProductos);
		
	    ListadoUsuarios = new JMenuItem("Listado Usuarios");
		ListadoUsuarios.setActionCommand(LISTA);
		ListadoUsuarios.addActionListener((ActionListener)this);
		DatosUsuarios.add(ListadoUsuarios);
		
		ListadoProductos = new JMenuItem("Listado Productos");
		ListadoUsuarios.setActionCommand(TABPROD);
		ListadoUsuarios.addActionListener((ActionListener)this);
	
	    DatosProductos.add(ListadoProductos);

	
		     vueltaInicio = new JButton("Cerrar Sesion");;
             vueltaInicio.setActionCommand(SALIR);
             vueltaInicio.addActionListener((ActionListener) this);
             
             
             ajustes = new JButton();
             ImageIcon icono0 = new ImageIcon(getClass().getResource("/img/ajustes.jpg"));
			 Image imagen0 = icono0.getImage();
			 ImageIcon iconoEsc0 = new ImageIcon (imagen0.getScaledInstance(22,22,Image.SCALE_SMOOTH));
			 ajustes.setIcon(iconoEsc0);
			 ajustes.setBorder(null);
        	    
        	 ajustes.setActionCommand(AJUSTES);
        	 ajustes.addActionListener((ActionListener) this);
             
             
             MenuPrincipal.add(Box.createHorizontalGlue());
             MenuPrincipal.add(ajustes);
             MenuPrincipal.add(vueltaInicio);
        
           
      	    contentPane = new JPanel();
    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    		setContentPane(contentPane);
    		contentPane.setLayout(null);
        	    
      	   
    		correo = new JButton ();
       		correo.setBounds(0, 14, 100, 60);
       		Image img3= null;
       		
       		try {
       			img3 = ImageIO.read(getClass().getResource("/img/correo.jpg"));
       		} catch (IOException e) {
       			e.printStackTrace();
       		}
       	    correo.setIcon(new ImageIcon(img3));
       	    correo.setActionCommand(CORREO);
       	    correo.addActionListener((ActionListener)this);
      	   
      		JPanel panel1 = new JPanel();
      		panel1.setBounds(10, 50, 300, 128);
      		panel1.setLayout(null);
      		panel1.add(correo);
 
    		contentPane.add(panel1);
    		    		
    		
    		
    		
    		LinkedList<clsBebida>lista;
    		lista= clsGestor.BebidasGuardadas();
    		
    	//COCACOLA
    		lblCoca= new JLabel ("CocaCola");
    		lblCoca.setBounds(0, 0, 100, 100);
    		 ImageIcon icono1 = new ImageIcon(getClass().getResource("/img/cocacola.jpg"));
			 Image imagen1 = icono1.getImage();
			 ImageIcon iconoEsc1 = new ImageIcon (imagen1.getScaledInstance(100,100,Image.SCALE_SMOOTH));
			 lblCoca.setIcon(iconoEsc1);
			 
			 areaCoca = new JTextArea();
			 areaCoca.setBounds(105, 0, 200, 100);
			 areaCoca.setEditable(false);
			 clsBebida beb = new clsBebida();
			 for ( clsBebida aux: lista)
			 {
				 if(aux.getId().equals(clsConstantes.ID_COCACOLA))
					 beb=aux;
			 }
			 areaCoca.append("Coca Cola"+ SALTO +"N� de bebidas disponibles: "+ beb.getNum());
			 
			 
			 slidCoca = new JSlider (0,50);
			 slidCoca.setBounds(400, 15, 150, 50);
			 slidCoca.setMinorTickSpacing(0);
			 slidCoca.addChangeListener(new MiAccion(clsConstantes.ID_COCACOLA));
			 
			 
			 lblSlidCoca= new JLabel();
			 lblSlidCoca.setBounds(580, 0, 15, 50);
			 
			 
    	//NESTEA
    		lblNestea= new JLabel ("Nestea");
    		lblNestea.setBounds(0,110,100,100);
    		 ImageIcon icono2 = new ImageIcon(getClass().getResource("/img/nest.jpg"));
			 Image imagen2 = icono2.getImage();
			 ImageIcon iconoEsc2 = new ImageIcon (imagen2.getScaledInstance(100,100,Image.SCALE_SMOOTH));
    		 lblNestea.setIcon(iconoEsc2);
    		
    		 areaNestea = new JTextArea();
    		 areaNestea.setBounds(105, 110, 200, 100);
    		 areaNestea.setEditable(false);
			 clsBebida beb2 = new clsBebida();
			 for ( clsBebida aux: lista){if(aux.getId().equals(clsConstantes.ID_NESTEA))beb2=aux;}
			 areaNestea.append("Nestea"+ SALTO +"N� de bebidas disponibles: "+ beb2.getNum());	
			 
			 slidNestea = new JSlider (0,50);
			 slidNestea.setBounds(400, 125, 150, 50);
			 slidNestea.setMinorTickSpacing(0);
			 slidNestea.addChangeListener(new MiAccion(clsConstantes.ID_NESTEA));

			 
			 lblSlidNestea= new JLabel();
			 lblSlidNestea.setBounds(580, 120, 15, 50);
			 
			 
    	//BIFRUTAS 
    		lblBifrutas= new JLabel ("Bifrutas");
    		lblBifrutas.setBounds(0,230,100,100);
    		 ImageIcon icono3 = new ImageIcon(getClass().getResource("/img/bif.png"));
			 Image imagen3 = icono3.getImage();
			 ImageIcon iconoEsc3 = new ImageIcon (imagen3.getScaledInstance(100,100,Image.SCALE_SMOOTH));
    		 lblBifrutas.setIcon(iconoEsc3);
    		 
    		 areaBifrutas = new JTextArea();
    		 areaBifrutas.setBounds(105, 230, 200, 100);
    		 areaBifrutas.setEditable(false);
			 clsBebida beb3 = new clsBebida();
			 for ( clsBebida aux: lista){if(aux.getId().equals(clsConstantes.ID_BIFRUTAS))beb3=aux;}
			 areaBifrutas.append("Bifrutas"+ SALTO +"N� de bebidas disponibles: "+ beb3.getNum());	
			 
			 slidBifrutas = new JSlider (0,50);
			 slidBifrutas.setBounds(400, 245, 150, 50);
			 slidBifrutas.setPaintTicks(true);
			 slidBifrutas.setMajorTickSpacing(25);
			 slidBifrutas.setMinorTickSpacing(5);
			 slidBifrutas.setPaintLabels(true);
			 slidBifrutas.addChangeListener(new MiAccion(clsConstantes.ID_BIFRUTAS));
			 //slidBifrutas.setValue(0);
			 
			 lblSlidBifrutas= new JLabel();
			 lblSlidBifrutas.setBounds(580, 240, 15, 50);
			
    		
		//AGUA
			 lblAgua= new JLabel ("Agua");
			 lblAgua.setBounds(0,330,100,100);
	    		 ImageIcon icono4 = new ImageIcon(getClass().getResource("/img/agua.jpg"));
				 Image imagen4 = icono4.getImage();
				 ImageIcon iconoEsc4 = new ImageIcon (imagen4.getScaledInstance(100,100,Image.SCALE_SMOOTH));
				 lblAgua.setIcon(iconoEsc4);
	    		 
				 areaAgua = new JTextArea();
				 areaAgua.setBounds(105, 330, 200, 100);
	    		 areaAgua.setEditable(false);
				 clsBebida beb4 = new clsBebida();
				 for ( clsBebida aux: lista){if(aux.getId().equals(clsConstantes.ID_AGUA))beb4=aux;}
				 areaAgua.append("Agua"+ SALTO +"N� de bebidas disponibles: "+ beb4.getNum());	
				 
				 slidAgua = new JSlider (0);
				 slidAgua.setBounds(400, 365, 150, 50);
				 slidAgua.setPaintTicks(true);
				 slidAgua.setMajorTickSpacing(25);
				 slidAgua.setMinorTickSpacing(5);
				 slidAgua.setPaintLabels(true);
				 slidAgua.addChangeListener(new MiAccion(clsConstantes.ID_AGUA));
				 //slidAgua.setValue(0);
				 
				 lblSlidAgua= new JLabel();
				 lblSlidAgua.setBounds(580, 360, 15, 50);
			
			
				 
			 
    		JPanel panel2 = new JPanel();
    		panel2.setBounds(350,50, 600, 500);
    		panel2.setLayout(null);
    		panel2.add(lblCoca);panel2.add(lblBifrutas);panel2.add(lblNestea);  panel2.add(lblAgua); 		
    		panel2.add(areaNestea);panel2.add(areaBifrutas);panel2.add(areaCoca); panel2.add(areaAgua);
    		panel2.add(slidCoca); panel2.add(slidNestea); panel2.add(slidBifrutas); panel2.add(slidAgua);
    		panel2.add(lblSlidCoca);panel2.add(lblSlidNestea);panel2.add(lblSlidBifrutas);panel2.add(lblSlidAgua);
    		
    		
    		contentPane.add(panel2);
    		
    		 guardar = new JButton("Guardar Cambios");
			 guardar.setBounds(900, 550, 150, 40);
			 guardar.setActionCommand(GUARDAR);
			 guardar.addActionListener((ActionListener)this);
    		contentPane.add(guardar);
    		
    		actualizarSliders();
		
	}
	protected static  void actualizarSliders()
	{
		LinkedList <clsBebida> lista = clsGestor.BebidasGuardadas();
		
		for (clsBebida aux: lista)
		{
			switch(aux.getId())
			{
			case clsConstantes.ID_COCACOLA:
				slidCoca.setMaximum(50-aux.getNum());
				slidCoca.setMajorTickSpacing(50-aux.getNum());
				slidCoca.setPaintTicks(true);
				slidCoca.setPaintLabels(true);
				slidCoca.setValue(0);
				break;
			case clsConstantes.ID_NESTEA:
				slidNestea.setMaximum(50-aux.getNum());
				slidNestea.setMajorTickSpacing(50-aux.getNum());
				slidNestea.setPaintTicks(true);
				slidNestea.setPaintLabels(true);
				slidNestea.setValue(0);
				break;
			}
		}
		
		
	}
	public static class MiAccion implements ChangeListener
	{
		String id;
	
		String nose;

		public MiAccion(String id) 
		{
			this.id= id;
		}
		
		@Override
		public void stateChanged(ChangeEvent arg0) 
		{
			switch (id)
			{
			
			case clsConstantes.ID_COCACOLA:
				num_cocacola = slidCoca.getValue(); /*toma el valor que tiene el slider y lo guarda como entero */
				nose = Integer.toString(num_cocacola); /*En nose guarda nuestro entero evaluo como un string */
				lblSlidCoca.setText(nose); /*actualiza nuestro label al valor en el que se encuentra nuestro JSlider */
				
				//actualizarlistabebidas(id, nose);
				break;
				
			case clsConstantes.ID_NESTEA: 
				num_nestea = slidNestea.getValue(); /*toma el valor que tiene el slider y lo guarda como entero */
				nose = Integer.toString(num_nestea); /*En nose guarda nuestro entero evaluo como un string */
				lblSlidNestea.setText(nose); /*actualiza nuestro label al valor en el que se encuentra nuestro JSlider */
				
				//actualizarlistabebidas(id, nose);
				break;
				
			case clsConstantes.ID_BIFRUTAS:
				num_bifrutas = slidBifrutas.getValue(); /*toma el valor que tiene el slider y lo guarda como entero */
				nose = Integer.toString(num_bifrutas); /*En nose guarda nuestro entero evaluo como un string */
				lblSlidBifrutas.setText(nose); /*actualiza nuestro label al valor en el que se encuentra nuestro JSlider */
				
				//actualizarlistabebidas(id, nose);
				break;
				
			case clsConstantes.ID_AGUA:
				num_agua = slidAgua.getValue(); /*toma el valor que tiene el slider y lo guarda como entero */
				nose = Integer.toString(num_agua); /*En nose guarda nuestro entero evaluo como un string */
				lblSlidAgua.setText(nose); /*actualiza nuestro label al valor en el que se encuentra nuestro JSlider */
				//actualizarlistabebidas(id, nose);
				break;
		
			}	
			
		}
		
	}
	

	protected static LinkedList<clsBebida> actualizarlistabebidas()
	{
		LinkedList <clsBebida> lista = clsGestor.BebidasGuardadas();
		for(clsBebida aux: lista)
		{
			switch (aux.getId())
			{
			case clsConstantes.ID_COCACOLA:
				aux.setNum(aux.getNum()+ num_cocacola);
				
			case clsConstantes.ID_NESTEA:
				aux.setNum(aux.getNum()+ num_nestea);
				
			case clsConstantes.ID_BIFRUTAS:
				aux.setNum(aux.getNum()+ num_bifrutas);
				
			case clsConstantes.ID_AGUA:
				aux.setNum(aux.getNum()+ num_agua);
			
			
			}
			
		}
		return lista;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
		case SALIR:
			 int salir;

			 salir= JOptionPane.showConfirmDialog(null, "�Seguro que quiere cerrar la sesion?","Confirmar ", JOptionPane.OK_CANCEL_OPTION);
			 if(salir==0)
				 {this.dispose();
			   VentanaPrincipal frame = new VentanaPrincipal("");
			   frame.setVisible(true);}
		
		     break;
		case CORREO:
			if(clsAdministrador.Correo.isEmpty())
			clsAdministrador.Correo = JOptionPane.showInputDialog("Introduzca su correo electr�nico (con la forma ...@example.com)");
			clsMensaje.correo();
			break;

		case LISTA:
			getContentPane().removeAll();
			tablasUsers();
			
			break;
		case TABPROD:
			getContentPane().removeAll();
			tablasProductos();
			
			break;
			
		case GUARDAR:
			guardar();
			break;
		
		case AJUSTES:
			ajustes();
			
		
		}
		
		
	}
	protected void guardar ()
	{
		LinkedList <clsBebida> lista = actualizarlistabebidas();
		clsGestor.guardarBebidas(lista);
		actualizarSliders();
		
	}
	protected void ajustes()
	{

		 String[] opciones = {
		            "Cambiar nombre y contrase�a",
		            "Registro Productos",
		        };
		 String opcion = (String)JOptionPane.showInputDialog(null, "Ajustes: ", "AJUSTES", JOptionPane.DEFAULT_OPTION, new ImageIcon(getClass().getResource("/img/ajustes.jpg")),opciones, opciones[0]);
		 if(opcion.equals("Cambiar nombre y contrase�a"))
		 {
			 System.out.println("lo que sea");
		 }
		 
		 else if (opcion.equals("Registro Productos"))
		 {
			RegistroProductos registro= new RegistroProductos();
			registro.setVisible(true);
			 
		 }
		 else System.out.println("no pasa na");
	}
	protected void tablasUsers()
    {
    	
    	TablasUsuarios tabla= new TablasUsuarios();
    	tabla.setVisible(true);
    	toFront();
    	contentPane.add(tabla);
    	
    	try 
    	{
			tabla.setSelected(true);
		}
    	catch (PropertyVetoException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	protected void tablasProductos()
	{
		
		TablasProductos tabla2= new TablasProductos();
		tabla2.setVisible(true);
		toFront();
    	contentPane.add(tabla2);
    	
    	try 
    	{
			tabla2.setSelected(true);
		}
    	catch (PropertyVetoException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}