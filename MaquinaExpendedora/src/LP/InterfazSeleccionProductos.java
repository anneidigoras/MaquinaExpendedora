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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * 
 * Clase en la que pondremos la interfaz con la que interactuara el usuario para escoger el producto que quiera
 * @author Anne
 *
 */
public class InterfazSeleccionProductos extends JFrame implements ActionListener
{
	
	private JButton btCoca, btNestea, btBifrutas;
	private JLabel lblCoca, lblNestea, lblBifrutas;
	private JPanel contentPane;
	
	public InterfazSeleccionProductos()
	{
		
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		setTitle("Registro");
		
		setResizable(false);
		setBounds(800, 200, 600, 390);
	
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblCoca= new JLabel ("CocaCola");
		lblCoca.setBounds(15, 75, 67, 40);
		lblNestea= new JLabel ("Nestea");
		lblNestea.setBounds(130,75,67,40);
		
		lblBifrutas= new JLabel ("Bifrutas");
		lblBifrutas.setBounds(245,75,67,40);
		
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
		
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 300, 128);
		panel.setLayout(null);
		panel.add(lblCoca); panel.add(btCoca); panel.add(lblNestea);panel.add(btNestea);panel.add(lblBifrutas);panel.add(btBifrutas);
		contentPane.add(panel);
		

		this.setVisible(true);	
		this.setPreferredSize(new Dimension(500,450));
		this.setResizable(true);
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
