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
	
	private JButton btCoca, btNestea, btBifrutas, btKitKat, btOreo, btAnular;
	private JLabel lblCoca, lblNestea, lblBifrutas, lblKitKat, lblOreo;
	private JPanel contentPane;
	private JTextArea txtPantalla;
	static final String COCA= "CocaCola";
	static final String NESTEA= "Nestea";
	static final String BIF= "Bifrutas";
	static final String AN= "Anular";
	
	
	public InterfazSeleccionProductos()
	{
		
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//setResizable(false);
		setBounds(800, 800, 600, 390);
	
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblCoca= new JLabel ("CocaCola");
		lblCoca.setBounds(15, 75, 67, 40);
		lblNestea= new JLabel ("Nestea");
		lblNestea.setBounds(130,75,67,40);
		
		lblBifrutas= new JLabel ("Bifrutas");
		lblBifrutas.setBounds(245,75,67,40);
		
		lblKitKat= new JLabel ("KitKat");
		lblKitKat.setBounds(15,150,67,40);
		lblOreo= new JLabel ("Oreo");
		lblOreo.setBounds(15,200,67,40);
		
		
		btNestea = new JButton ();
		btNestea.setBounds(130, 14, 100, 60);
		Image img2= null;
		try {
			img2 = ImageIO.read(getClass().getResource("/img/nest.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    btNestea.setIcon(new ImageIcon(img2));
	    btNestea.setActionCommand(NESTEA);
	    btNestea.addActionListener((ActionListener)this);
	    
	    
	    btBifrutas = new JButton ();
		btBifrutas.setBounds(245, 14, 100, 60);
		Image img3= null;
		try {
			img3 = ImageIO.read(getClass().getResource("/img/bif.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    btBifrutas.setIcon(new ImageIcon(img3));
	    btBifrutas.setActionCommand(BIF);
	    btBifrutas.addActionListener((ActionListener)this);
		
		btCoca = new JButton ();
		btCoca.setBounds(10, 14, 100, 60);
		Image img = null;
		try {
			img = ImageIO.read(getClass().getResource("/img/cocacola.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    btCoca.setIcon(new ImageIcon(img));
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
	    
	    btAnular = new JButton();
	    btAnular.setBounds(10,250,90,50);
	    btAnular.setActionCommand(AN);
	    btAnular.addActionListener((ActionListener)this);
	    btAnular.setText("Anular");
		
	    JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(470, 35, 100, 50);
		contentPane.add(scrollPane_1);
		
		txtPantalla = new JTextArea();
		scrollPane_1.setViewportView(txtPantalla);
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 50, 300, 500);
		panel.setLayout(null);
		panel.add(lblCoca); panel.add(btCoca); panel.add(lblNestea);panel.add(btNestea);panel.add(lblBifrutas);panel.add(btBifrutas); 
		panel.add(lblKitKat);panel.add(lblOreo); panel.add(btOreo); panel.add(btAnular);
		contentPane.add(panel);
		

	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
          String comando = e.getActionCommand();
		
		switch(comando)
		{
			case (COCA):
				this.txtPantalla.append("CocaCola"+" 1,30 €");
				break;
			case (NESTEA):
				this.txtPantalla.append("Nestea"+" 1,20 €");
				break;
			case (BIF):
				this.txtPantalla.append("Bifrutas"+" 1,20 €");
				break;
			case (AN):
				
				this.txtPantalla.setText("");
			break;
				
				
			
		
	}
	

	
	
	

}}