package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LN.clsGestor;

public class InternalUsuario extends JInternalFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	JTextField nombre,ape1,dni,edad, dinero;
	JPanel panel;
	JButton aceptar,cancelar;
	JLabel nom, ap1,dni_,edad_,dinero_;
	
	clsGestor objGestor= new clsGestor();
	
	
	
	
	public InternalUsuario()
	{
		
		setBounds(200,200,400,400);
		nom= new JLabel ("Nombre");
		nombre= new JTextField();
		
		ap1= new JLabel("Primer Apellido");
		ape1= new JTextField();
		
		dni_= new JLabel("DNI");
		dni= new JTextField();
		
		edad_= new JLabel("Edad");
		edad=new JTextField();
		
		dinero_= new JLabel("Dinero");
		dinero= new JTextField("");
		
		aceptar= new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setActionCommand("Aceptar");
		
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setActionCommand("Cancelar");
	
		panel = new JPanel();
		
	
		this.setResizable(true);
		this.setClosable(true);
		this.setIconifiable(true);
        
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.CYAN);
		panel.repaint();
		
		JPanel textPanel= new JPanel(new GridLayout(0,1,0,3));
		textPanel.add(nom);textPanel.add(nombre);textPanel.add(ap1);textPanel.add(ape1);textPanel.add(dni_); textPanel.add(dni);textPanel.add(edad_); textPanel.add(edad);
		textPanel.add(dinero_);textPanel.add(dinero);
		
		panel.add(textPanel, BorderLayout.PAGE_START);
		//panel.add(texto2, BorderLayout.CENTER);
	    JPanel basePanel= new JPanel(new GridLayout());
	    basePanel.add(aceptar); basePanel.add(cancelar);
	    
		panel.add(basePanel,BorderLayout.SOUTH);
		
		
		this.setContentPane(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		
		case "Aceptar":
			System.out.println("Ha pulsado aceptar");
			aceptar.setBackground(Color.blue);
			try {
				Aceptar(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			
		break;
		
		case "Cancelar":
			
			System.out.println("Ha pulsado cancelar");
			aceptar.setBackground(Color.magenta);
			this.dispose();
			
		break;	
			
		}
	
	}
	
	private void Aceptar(ActionEvent e) throws IOException
	{
	try
	{	
		String nombre=this.nombre.getText(); String ape1= this.ape1.getText(); String dni= this.dni.getText(); int edad= Integer.parseInt(this.edad.getText());
		float dinero= Integer.parseInt(this.dinero.getText());
		
		objGestor.nuevoUsuario(nombre, ape1, dni, edad, dinero);
	}
	catch(Exception a)
	{
		JOptionPane.showMessageDialog(null, "Campos Obligatorios", "Mensaje", JOptionPane.ERROR_MESSAGE);
	}
		
		
	}
	
}

	
	
	
	
	

	


