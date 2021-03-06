package LP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import COMUN.clsConstantes;
import LN.clsAdministrador;
import LN.clsGestor;
import LN.clsMensaje;
/**
 * 
 * Clase de registro del administrador, con una clave y usuario predeterminados
 * @author Anne y Mayi
 *
 */
public class RegistroAdmin extends JFrame implements ActionListener
{
	private static boolean ingreso = false;
	private JTextField txtUsuario;
    private JButton btingresar,btcancelar;
    private JLabel lblUsuario ;
	private JPanel contentPane;
	private JPasswordField password;
	
	private JLabel lblcorreo;
	private JButton correo;
	static final String CORREO= "Correo";
	 
	
	/**
	 * 
	 * Constructor de la clase 
	 */
	public RegistroAdmin()
	{
		if (ingreso==false)
			{JOptionPane.showMessageDialog(this, "Welcome Administrador, Tu nombre de usuario es: "+clsGestor.admin.getNombre()+" y tu contraseña: "+clsGestor.admin.getContraseña());}
			

		
		setTitle("Inicio de sesión");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(300, 100, 600, 390);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// En caso de que sea la primera vez que ingresa el administrador, le damos la opcion de recibir por correo 
		// los datos de usuario y contraseña
		if(clsAdministrador.existe==false)
		{
				JPanel panel0 = new JPanel();
				panel0.setBounds(10, 10, 500, 128);
				contentPane.add(panel0);
				panel0.setLayout(null);
				
				correo = new JButton ();
		  		correo.setBounds(10, 25, 100, 60);
		  		Image img3= null;
		  		try {
		  			img3 = ImageIO.read(getClass().getResource("/img/correo.jpg"));
		  		} catch (IOException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
		  	    correo.setIcon(new ImageIcon(img3));
		  	    correo.setActionCommand(CORREO);
		  	    correo.addActionListener((ActionListener)this);
		  	    panel0.add(correo);
		  	    
		  	    lblcorreo = new JLabel("Clique aqui para recibir un correo con los datos para ingresar");
		  	    lblcorreo.setBounds(120,45,400,15);
		  	    panel0.add(lblcorreo);
		}
  	    
  	    JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 145, 300, 128);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(112, 11, 178, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		

		lblUsuario = new JLabel("Nombre");
		lblUsuario.setBounds(10, 14, 46, 14);
		panel.add(lblUsuario);
//		
		password= new JPasswordField(10);
		password.setEchoChar('*');
		password.setBounds(112, 42, 178, 20);
		panel.add(password);
		password.setColumns(10);

		
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setBounds(10, 45, 92, 14);
		lblContra.setLabelFor(password);
		panel.add(lblContra);
		
	
		
		JPanel panel2 = new JPanel();
		//panel2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel2.setBounds(10, 302, 560, 49);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		btingresar = new JButton("Ingresar");
		btingresar.setBounds(10, 11, 110, 23);
		panel2.add(btingresar);
		
		btingresar.addActionListener(this);
		btingresar.setActionCommand("Ingresar");
		
		btcancelar = new JButton("Cancelar");
		btcancelar.setBounds(150, 11, 110, 23);
		panel2.add(btcancelar);
		
		btcancelar.addActionListener(this);
		btcancelar.setActionCommand("Cancelar");
		
	 }
		
		
	/**
	 * 
	 * Verificacion de que la contrasenya es la correcta
	 * @param input: contraseña 
	 * @param nombre: nombre de usuario
	 * @return nos devuelve un boolean 
	 */
	  public boolean isPasswordCorrect(char[] input, String nombre) 
	 {
	        boolean isCorrect = true;
	       String nombre2= clsGestor.admin.getNombre();
	        char[] correctPassword = clsGestor.admin.getContraseña().toCharArray();

	        if (input.length != correctPassword.length && nombre.length()!= nombre2.length())
	        {
	            isCorrect = false;
	        } else 
	        {
	            isCorrect = Arrays.equals (input, correctPassword) && nombre.equals(nombre2);
	        }

	        //Zero out the password.
	        Arrays.fill(correctPassword,'0');

	        return isCorrect;
	    }


/**
 * Metodo en que al darle al boton de aceptar llamaremos al metodo de verificacion de la contraseña
 * En caso de pasarle los parametros correctos nos dejara pasar a la pantalla principal del administrador
 * En caso de habernos confundido podremos volver a intentarlo
 */
	
	 private void pulsadoIngreso()
		{
			if (btingresar.getText().equals("Ingresar"))
			{
				 char[] input = password.getPassword();
				 String nombre= txtUsuario.getText();
		            if (isPasswordCorrect(input, nombre)) 
		            {
		                JOptionPane.showMessageDialog(this, "Contraseña correcta");
		                this.dispose();
		                ingreso= true;
		                
		               // TablasUsuarios frame= new TablasUsuarios();
		                //frame.setVisible(true);
		                PantallaAdmin frame= new PantallaAdmin("Pantalla Admin");
		                frame.setVisible(true);
		                
		            } 
		            
		            
		            else 
		            {
		             JOptionPane.showMessageDialog(this,"Contraseña erronea. Intentelo de nuevo.");
		            }

		            //Zero out the possible password, for security.
		            Arrays.fill(input, '0');

		            password.selectAll();
		            resetFocus();
			}
			
				
					
		}
	  
	  protected void resetFocus() 
	  {
	        password.requestFocusInWindow();
	    }


/**
 * 
 * MEtodo que nos permite realizar las funciones indicadas
 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		String comando = e.getActionCommand();
		
		switch(comando)
		{
			case "Ingresar":
				  this.pulsadoIngreso();
				break;
			
			case "Cancelar":
				this.dispose();
				VentanaPrincipal frame = new VentanaPrincipal("");
				frame.setVisible(true);
				break;
			case CORREO:
				clsAdministrador.Correo = JOptionPane.showInputDialog("Introduzca su correo electrónico (con la forma ...@example.com)");
				clsMensaje.correo_identificacion();
				clsAdministrador.existe = true;
				
				
				break;
			
	  }
}
	  
	   
	    
	    

}