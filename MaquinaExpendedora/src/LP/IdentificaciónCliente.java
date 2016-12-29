package LP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import LN.clsGestor;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 
 * 
 * @author Mayi
 *
 */
public class IdentificaciónCliente extends JInternalFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	

	
	JButton BAceptar;
	JButton BCancelar;
	
	JTextField textDni;
	JPasswordField textContra;
	
	JLabel Info;
	JLabel lblDni;
	JLabel lblContra;
	
	
	private final String ACEPTAR= "Aceptar";
	private final String CANCELAR= "Cancelar";
	
	
	
	/**
	 * constructor con el diseño de la ventana
	 */
	public IdentificaciónCliente()
	{
		getContentPane().setBackground(new Color(136, 201, 89));
//		setBounds(300, 200 ,500,500);
		getContentPane().setLayout(null);
		
	    Info= new JLabel ("Introduzca sus datos:");
	    Info.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
	    Info.setForeground(Color.white);
		Info.setBounds(500,50,400,50);
		Info.setLocation(150,5);
		getContentPane().add(Info);
		
	    lblDni = new JLabel("DNI:");
	    lblDni.setBounds(150, 100, 100, 15);
		getContentPane().add(lblDni);
		
		textDni = new JTextField();
		textDni.setBounds(280, 100, 91, 20);
		getContentPane().add(textDni);
		
		lblContra = new JLabel("Contraseña:");
		lblContra.setBounds(150,180, 90, 18);
		getContentPane().add(lblContra);
		
		textContra = new JPasswordField();
		textContra.setBounds(280, 180, 91, 20);
		getContentPane().add(textContra);
		
		
		
		BAceptar = new JButton(ACEPTAR);
		BAceptar.setBounds(25, 300, 200, 50);
		BAceptar.addActionListener(this);
		BAceptar.setActionCommand(ACEPTAR);
		getContentPane().add(BAceptar);
		
		BCancelar = new JButton (CANCELAR);
		BCancelar.setBounds(250, 300, 200, 50);
		BCancelar.addActionListener(this);
		BCancelar.setActionCommand(CANCELAR);
		getContentPane().add(BCancelar);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

/**
 * Metodo que recoge el evento que salta.
 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String comando= arg0.getActionCommand();
		
		switch(comando)
		{
		case ACEPTAR:
			Ingresar();
			break;
		case CANCELAR:
			this.dispose();
			break;
		
	}
	
	}
	private void Ingresar()
	{
		boolean existe= false;
		String nombre;
		char [] Arraypass=null;
		String password = null;
		
		nombre= this.textDni.getText();
		Arraypass = this.textContra.getPassword();
		
		for (int i=0; i<Arraypass.length; i++)			password = password + Arraypass [i];
	
		
		if (nombre.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Introduzca su nombre ");
		}
		else
		{	
			existe= clsGestor.IngresoCliente(nombre, password);
			if (existe== true)
			{
			this.dispose();
			InterfazSeleccionProductos frame= new InterfazSeleccionProductos(nombre);
			frame.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El cliente introducido no está registrado o los datos introducidos son incorrectos");
			}
		}
		

		
			
				
	}
	
}
