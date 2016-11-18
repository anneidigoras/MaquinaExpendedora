package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import COMUN.clsUsuarioExistente;
import LN.clsGestor;
/**
 * 
 * 
 * @author Anne
 *
 */
public class RegistroUsuario extends JFrame implements ActionListener
{
		
	private JTextField txtNombre, txtApe, txtEdad, txtDni, txtDinero;
    private JButton btAceptar, btCancelar;
	private JPanel contentPane;
	private JLabel lblNombre, lblApe, lblEdad, lblDni, lblDinero;

	clsGestor objGestor;
	
	public RegistroUsuario()
	{
		
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 200, 600, 390);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.ORANGE);
		
		
		lblNombre= new JLabel ("Nombre");
		lblNombre.setBounds(10, 14, 46, 14);
		
	    txtNombre= new JTextField();
		txtNombre.setBounds(112, 11, 178, 20);

		lblApe= new JLabel("Primer Apellido");
		lblApe.setBounds(10, 35, 92, 14);
		txtApe= new JTextField();	
		txtApe.setBounds(112, 32, 178, 20);
		
		lblDni= new JLabel("DNI");	
		lblDni.setBounds(10, -5, 92, 140);
		txtDni= new JTextField();	
		txtDni.setBounds(112, 53, 86, 20);
		
		lblEdad= new JLabel("Edad");
		lblEdad.setBounds(10, 10, 92, 140);
		txtEdad=new JTextField();	
		txtEdad.setBounds(112, 74, 86, 20);
		
		lblDinero= new JLabel("Dinero");
		lblDinero.setBounds(10, 40, 92, 140);
		txtDinero= new JTextField("");
		txtDinero.setBounds(112, 95, 86, 20);
				
		
		JPanel panel = new JPanel(new GridLayout(0,1,0,3));
		panel.setBounds(10, 50, 300, 128);
		panel.setLayout(null);
		panel.add(txtNombre);panel.add(lblNombre);panel.add(txtApe);panel.add(lblApe);panel.add(txtDni); panel.add(lblDni);panel.add(txtEdad); panel.add(lblEdad);
		panel.add(txtDinero);panel.add(lblDinero);
		panel.setBackground(Color.PINK);
		
		contentPane.add(panel, BorderLayout.PAGE_START);
	
		JPanel basePanel= new JPanel();
		
		basePanel.setBounds(10, 200, 560, 49);
	    basePanel.setLayout(null);
	    basePanel.setBackground(Color.PINK);
	    
		btAceptar= new JButton("Aceptar");
		btAceptar.setBounds(10, 20, 110, 23);
		basePanel.add(btAceptar);
		
		
		
		btAceptar.addActionListener(this);
		btAceptar.setActionCommand("Aceptar");
		
		btCancelar= new JButton("Cancelar");
		btCancelar.setBounds(200, 20, 110, 23);
		basePanel.add(btCancelar);
		
		btCancelar.addActionListener(this);
		btCancelar.setActionCommand("Cancelar");
		contentPane.add(basePanel, BorderLayout.SOUTH);
	
		

		this.setVisible(true);	
		this.setPreferredSize(new Dimension(500,450));
		this.setResizable(true);
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		
		case "Aceptar":
			System.out.println("Ha pulsado aceptar");
			btAceptar.setBackground(Color.blue);
			Aceptar(e);
			this.dispose();
			InterfazSeleccionProductos frame= new InterfazSeleccionProductos();
			frame.setVisible(true);
			
		break;
		
		case "Cancelar":
			
			System.out.println("Ha pulsado cancelar");
			btCancelar.setBackground(Color.magenta);
			this.dispose();
			
		break;	
			
		}
	
	}
	

	private void Aceptar(ActionEvent e)
	{
		
		String nombre=this.txtNombre.getText(); String ape1= this.txtApe.getText(); String dni= this.txtDni.getText(); int edad= Integer.parseInt(this.txtEdad.getText());
		float dinero= Integer.parseInt(this.txtDinero.getText());
		
		objGestor= new clsGestor();
		
		try {
			objGestor.nuevoUsuario(nombre, ape1, dni, edad, dinero);
		} catch (clsUsuarioExistente e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	
	
	}
	

}
