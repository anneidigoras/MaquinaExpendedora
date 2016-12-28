package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

import LN.clsAdministrador;
import LN.clsMensaje;
/**
 * 
 * Clase en la que pondremos la interfaz con la que interactuara el usuario para escoger el producto que quiera
 * @author Anne
 *
 */
public class InterfazSeleccionProductos extends JFrame implements ActionListener
{
	
	private JButton btCoca, btNestea, btBifrutas, btKitKat, btOreo, btAnular, btComprar;
	private JLabel lblCoca, lblNestea, lblBifrutas, lblKitKat, lblOreo;
	private JPanel contentPane;
	private JTextArea txtPantalla;
	static final String COCA= "CocaCola";
	static final String NESTEA= "Nestea";
	static final String BIF= "Bifrutas";
	static final String OREO= "Oreo";
	static final String KIT= "KitKat";
	static final String AN= "Anular";
	static final String COMPRAR= "Comprar";
	
	
	public InterfazSeleccionProductos()
	{
		
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setBounds(800, 800, 600, 390);
	
		contentPane = new JPanel();

		
		contentPane.setLayout(null);
		
		
		lblCoca= new JLabel ("CocaCola");
		lblCoca.setBounds(15, 105, 67, 40);
		
		lblNestea= new JLabel ("Nestea");
		lblNestea.setBounds(155,105,67,40);
		
		lblBifrutas= new JLabel ("Bifrutas");
		lblBifrutas.setBounds(305,105,67,40);
		
		lblKitKat= new JLabel ("KitKat");
		lblKitKat.setBounds(130,200,67,40);
		lblOreo= new JLabel ("Oreo");
		lblOreo.setBounds(15,200,67,40);
		
		
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
		
		btCoca = new JButton ();
		btCoca.setBounds(10, 10, 90, 90);
		ImageIcon icono1 = new ImageIcon(getClass().getResource("/img/cocacola.jpg"));
		 Image imagen1 = icono1.getImage();
		 ImageIcon iconoEsc1 = new ImageIcon (imagen1.getScaledInstance(90,90,Image.SCALE_SMOOTH));
	    btCoca.setIcon(iconoEsc1);
	    btCoca.setActionCommand(COCA);
	    btCoca.addActionListener((ActionListener)this);
	    
	    btOreo = new JButton ();
		btOreo.setBounds(10, 150, 100, 60);
		Image img4 = null;
		try {
			img4 = ImageIO.read(getClass().getResource("/img/oreo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    btOreo.setIcon(new ImageIcon(img4));
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
	    
	    btAnular = new JButton();
	    btAnular.setBounds(10,250,90,50);
	    btAnular.setActionCommand(AN);
	    btAnular.addActionListener((ActionListener)this);
	    btAnular.setText("Anular");
	    
	    btComprar = new JButton();
	    btComprar.setBounds(350,290,90,50);
	    btComprar.setActionCommand(COMPRAR);
	    btComprar.addActionListener((ActionListener)this);
	    btComprar.setText(COMPRAR);
		
	    JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(600, 35, 100, 50);
		contentPane.add(scrollPane_1);
		
		txtPantalla = new JTextArea();
		scrollPane_1.setViewportView(txtPantalla);
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 50, 500, 350);
		panel.setLayout(null);
		panel.add(lblCoca); panel.add(btCoca); panel.add(lblNestea);panel.add(btNestea);panel.add(lblBifrutas);panel.add(btBifrutas); 
		panel.add(lblKitKat);panel.add(lblOreo); panel.add(btOreo); panel.add(btCoca);panel.add(btKitKat);
		panel.add(btComprar);//panel.add(btAnular);
		panel.setBackground(Color.red);
		contentPane.add(panel);
		
		
		setContentPane(contentPane);
	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.txtPantalla.setText(""); //Para que se vacie el textArea cada vez
          String comando = e.getActionCommand();
		
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
//			case (AN):
//				
//				this.txtPantalla.setText("");
//			break;
			
			case OREO:
				this.txtPantalla.append("Oreos"+" 1,20 €");
				break;
			
			case KIT:
				this.txtPantalla.append("KitKat"+" 1,20 €");
				break;
				
			case COMPRAR :
				//Como plus se podria hacer un hilo con una miniventana que diga: "Gracias pos su compra"
				break;
				
				
			
		
	}
	

	
	
	

}}