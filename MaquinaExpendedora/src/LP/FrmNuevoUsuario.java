package LP;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//import LN.clsAlumnoExistente;
import LN.clsGestor;


public class FrmNuevoUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lblnombre;
	JTextField  txtnombre;
	
	JLabel lblapellido1;
	JTextField  txtapellido1;
	
	JLabel lblapellido2;
	JTextField  txtapellido2;
	
	JLabel lblDNI;
	JTextField  txtDNI;
	
	JLabel lblfecha;
	
	JButton buttonFecha;
	private final String FECHA="FECHA";
	
	JLabel lblID;
	JTextField  txtID;
	
	JButton buttonA;
	private final String COMMAND_BUTTONA="COMMAND_BUTTONA";
	
	JButton buttonC;
	private final String COMMAND_BUTTONC="COMMAND_BUTTONC";
	
	JPanel jpContent;

	
	
	public FrmNuevoUsuario(String title)
	{
		
		
		super(title);
		
		
		lblnombre=new JLabel("Nombre");
		lblnombre.setToolTipText("Introduce el nombre del usuario");
		txtnombre= new JTextField();
		
		lblapellido1=new JLabel("Primer apellido");
		txtapellido1= new JTextField();
		
		
		lblDNI=new JLabel("DNI");
		txtDNI= new JTextField();
		
		
		buttonA=new JButton("Aceptar");
		buttonA.addActionListener(this);
		buttonA.setActionCommand(COMMAND_BUTTONA);
		
		buttonC=new JButton("Cancelar");
		buttonC.addActionListener(this);
		buttonC.setActionCommand(COMMAND_BUTTONC);
		
		jpContent=new JPanel();
		this.setResizable(true);
		this.setClosable(true);
		this.setIconifiable(true);
	
		this.setContentPane(jpContent);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		


	public void createandshowGUI()
	{
		addComponentsToPane(this.getContentPane());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addComponentsToPane(Container pane)
	{
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		
		this.getContentPane().add(lblnombre);
		this.getContentPane().add(txtnombre);
		
		this.getContentPane().add(lblapellido1);
		this.getContentPane().add(txtapellido1);

	
		
		this.getContentPane().add(lblDNI);
		this.getContentPane().add(txtDNI);
		
		this.getContentPane().add(lblfecha);
		this.getContentPane().add(buttonFecha);
		
		this.getContentPane().add(lblID);
		this.getContentPane().add(txtID);
		
		this.getContentPane().add(buttonA);
		this.getContentPane().add(buttonC);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String comando=arg0.getActionCommand();
		
		switch(comando)
		{
//		
//			}	
		case COMMAND_BUTTONC:
		{
			
			this.dispose();
			break;
		}
		
			
		}	
	}
	private void setIconifiable(boolean b) {
		// TODO Auto-generated method stub
		
	}


	private void setClosable(boolean b) {
		// TODO Auto-generated method stub
		
	}




}