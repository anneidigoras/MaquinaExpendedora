package LP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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




public class RegistroUsuario extends JFrame implements ActionListener
{
	

	
	private JTextField txtUsuario;
    private JButton btingresar;
	private JPanel contentPane;
	private JPasswordField password;
	
	
	public RegistroUsuario()
	{
		
		setTitle("Inicio de sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 600, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 145, 300, 128);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(112, 11, 178, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		

		JLabel lblUsuario = new JLabel("Nombre");
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
		
	 }
		
		
	
	 private static boolean isPasswordCorrect(char[] input) 
	 {
	        boolean isCorrect = true;
	        char[] correctPassword = { 'h', 'o', 'l', 'a' };

	        if (input.length != correctPassword.length) {
	            isCorrect = false;
	        } else {
	            isCorrect = Arrays.equals (input, correctPassword);
	        }

	        //Zero out the password.
	        Arrays.fill(correctPassword,'0');

	        return isCorrect;
	    }



	
	 private void pulsadoIngreso()
		{
			if (btingresar.getText().equals("Ingresar"))
			{
				 char[] input = password.getPassword();
		            if (isPasswordCorrect(input)) 
		            {
		                JOptionPane.showMessageDialog(this, "Bien! Ha introducido bien la contraseña.");
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
	  
	  protected void resetFocus() {
	        password.requestFocusInWindow();
	    }



	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		String comando = e.getActionCommand();
		
		switch(comando)
		{
			case ("Ingresar"):

				  this.pulsadoIngreso();
				break;
	  }
}
	  
	   
	    
	    

}
