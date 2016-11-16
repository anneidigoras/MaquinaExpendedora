package LP;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IdentificaciónCliente extends JInternalFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	

	
	JButton BAceptar;
	JButton BCancelar;
	
	JTextField textNombre;
	JPasswordField textContra;
	
	JLabel lblNombre;
	JLabel lblContra;
	
	
	private final String ACEPTAR= "Aceptar";
	private final String CANCELAR= "Cancelar";
	
	
	
	/**
	 * constructor con el diseño de la ventana
	 */
	public IdentificaciónCliente()
	{
		getContentPane().setBackground(new Color(152, 251, 152));
		setBounds(300, 200 ,500,500);
		getContentPane().setLayout(null);
		JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/Fondo/fallout.jpg")));
	    fondo.setBounds(0,0,800,600);
	    this.getContentPane().add(fondo);
		//setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		
	    lblNombre = new JLabel("Nombre Cliente");
	    lblNombre.setBounds(100, 12, 100, 15);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(169, 47, 91, 20);
		getContentPane().add(textNombre);
		
		lblContra = new JLabel("Nombre:");
		lblContra.setBounds(82, 48, 52, 18);
		getContentPane().add(lblContra);
		
		textContra = new JPasswordField();
		textContra.setBounds(169, 47, 91, 20);
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
			this.dispose();
			break;
		case CANCELAR:
			this.dispose();
			break;
		
	}
	
	}
	private void Ingresar()
	{
		boolean cerrar = true;
		String nombre;
		char [] Arraypass;
		String password = null;
		
		nombre= this.textNombre.getText();
		Arraypass = this.textContra.getPassword();
		
		for (int i=0; i<Arraypass.length; i++)
		{
			password = password + Arraypass [i];
		}
		
		if (nombre.isEmpty()||password.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Tiene que seleccionar un socio y un juego para poder llevar a cabo esta operación");
		}
		else
		{
			
		}
		

		
			
				
	}
	private void SoyAdmin()
	{

//		 JOptionPane.showMessageDialog(null, "Tiene que seleccionar un socio y un juego para poder llevar a cabo esta operación",
		
			
				
	}
}
