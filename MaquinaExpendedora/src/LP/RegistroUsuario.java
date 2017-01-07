package LP;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import COMUN.clsUsuarioExistente;

import javax.swing.JButton;

import LD.ConexionSql;
import LN.clsGestor;

/**
 * 
 * 
 * @author Anne y Mayi
 *
 */
public class RegistroUsuario extends JFrame implements ActionListener
{
		
	private JTextField txtNombre, txtApe, txtEdad, txtDni;
	private JPasswordField password1, password2;
    private JButton btAceptar, btCancelar;
	private JPanel contentPane;
	private JLabel lblNombre, lblApe, lblEdad, lblDni, lblPass1, lblPass2;
	

	clsGestor objGestor;
	
	public RegistroUsuario()
	{
		
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(400, 100, 600, 600);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.ORANGE);
		
		
		lblNombre= new JLabel ("Nombre");
		lblNombre.setBounds(10, 20, 46, 14);
	    txtNombre= new JTextField();
		txtNombre.setBounds(112, 20, 178, 20);

		lblApe= new JLabel("Primer Apellido");
		lblApe.setBounds(10, 50, 92, 14);
		txtApe= new JTextField();	
		txtApe.setBounds(112, 50, 178, 20);
		
		lblDni= new JLabel("DNI");	
		lblDni.setBounds(10, 80, 92, 14);
		txtDni= new JTextField();	
		txtDni.setBounds(112, 80, 86, 20);
		
		lblEdad= new JLabel("Edad");
		lblEdad.setBounds(10, 110, 92, 14);
		txtEdad=new JTextField();	
		txtEdad.setBounds(112, 110, 86, 20);
		
		lblPass1= new JLabel("Contraseña");
		lblPass1.setBounds(10, 190, 120, 14);
		password1= new JPasswordField("");
		password1.setBounds(155, 190, 86, 20);
		
		lblPass2= new JLabel("Confirme contraseña");
		lblPass2.setBounds(10,220, 120, 14);
		password2= new JPasswordField("");
		password2.setBounds(155, 220, 86, 20);
				
		
		JPanel panel = new JPanel(new GridLayout(0,1,0,3));
		panel.setBounds(150, 20, 300, 280);
		panel.setLayout(null);
		panel.add(txtNombre);panel.add(lblNombre);panel.add(txtApe);panel.add(lblApe);panel.add(txtDni); panel.add(lblDni);
		panel.add(txtEdad); panel.add(lblEdad); 
		panel.add(lblPass1);panel.add(lblPass2); panel.add(password1); panel.add(password2);
		panel.setBackground(Color.PINK);
		
		contentPane.add(panel, BorderLayout.PAGE_START);
	
		JPanel basePanel= new JPanel();
		
		basePanel.setBounds(100, 350, 400, 49);
	    basePanel.setLayout(null);
	    basePanel.setBackground(Color.PINK);
	    
		btAceptar= new JButton("Aceptar");
		btAceptar.setBounds(60, 20, 110, 23);
		basePanel.add(btAceptar);
		
		
		
		btAceptar.addActionListener(this);
		btAceptar.setActionCommand("Aceptar");
		
		btCancelar= new JButton("Cancelar");
		btCancelar.setBounds(230, 20, 110, 23);
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
			//anyadir();
		
			
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
		char [] Arraypass1;char [] Arraypass2;
		String password1 =null; String password2 =null;
		
		String nombre=this.txtNombre.getText(); String ape1= this.txtApe.getText(); String dni= this.txtDni.getText(); int edad= Integer.parseInt(this.txtEdad.getText());
		Arraypass1 = this.password1.getPassword();Arraypass2 = this.password2.getPassword();
		
		for (int i=0; i<Arraypass1.length; i++)			password1 = password1 + Arraypass1 [i];
		for (int i=0; i<Arraypass2.length; i++)			password2 = password2 + Arraypass2 [i];
		
		
		
		objGestor= new clsGestor(null);
		if (password1.equals(password2))
		{
			try 
			{
			objGestor.nuevoUsuario(nombre, ape1, dni, edad,password1);
			this.dispose();
			InterfazSeleccionProductos frame= new InterfazSeleccionProductos(dni);
			frame.setVisible(true);
			
			} catch (clsUsuarioExistente e1) {	e1.printStackTrace(); }
		}
		else
		{
			JOptionPane.showMessageDialog(null, "La contraseña está mal introducida ");
		}
		
	
		
	
	
	}
	public void anyadir()
	{

		Connection conn=ConexionSql.dbConnector("Base datos Usuarios");
		ConexionSql base=new ConexionSql();
		
		String nombre=txtNombre.getText();	
	    int edad=Integer.parseInt(this.txtEdad.getText());
		String ape=txtApe.getText();
		String dni=txtDni.getText();
		
		
		base.anyadirUsuario(nombre,ape,dni,edad);
		
		txtNombre.setText("");
		txtApe.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		
	

	}}
