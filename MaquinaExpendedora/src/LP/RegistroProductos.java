package LP;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import LN.clsUsuario;
/**
 * 
 * 
 * @author Anne y Mayi
 *
 */
public class RegistroProductos extends JFrame implements ActionListener
{
		

	//private JPasswordField password1, password2;
    private JButton btAceptar, btCancelar;
	private JPanel contentPane;


	

	clsGestor objGestor;
	
	public RegistroProductos()
	{
		
		setTitle("Registro Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(400, 100, 600, 600);
		
		contentPane = new JPanel();
  		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  		setContentPane(contentPane);
  		contentPane.setLayout(null);
	
	
	    
		btAceptar= new JButton("Aceptar");
		btAceptar.setBounds(60, 20, 200, 50);
		contentPane.add(btAceptar);
		
		
		
		btAceptar.addActionListener(this);
		btAceptar.setActionCommand("Aceptar");
		
		btCancelar= new JButton("Cancelar");
		btCancelar.setBounds(230, 20, 200, 50);
		contentPane.add(btCancelar);
		
		btCancelar.addActionListener(this);
		btCancelar.setActionCommand("Cancelar");
		
	
		

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
			
			JOptionPane.showMessageDialog(btAceptar, "Registro realizado con éxito");
			anyadir();
			this.dispose();
		
			
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
	 clsGestor.creabebidas();		
	
	
	}
	public void anyadir()
	{
//
//		Connection conn=ConexionSql.dbConnector("Base datos Productos");
//		ConexionSql base=new ConexionSql();
//		
//		String nombre=txtNombre.getText();	
//	    int edad=Integer.parseInt(this.txtEdad.getText());
//		String ape=txtApe.getText();
//		String dni=txtDni.getText();
//		
//		
//		base.anyadirUsuario(nombre,ape,dni,edad);
//		
//		txtNombre.setText("");
//		txtApe.setText("");
//		txtDni.setText("");
//		txtEdad.setText("");
//		
	}
		
	

}