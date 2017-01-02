package LP;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;
import LN.clsUsuario;

public class ReponerSaldo extends JFrame implements ActionListener
{
	private JTextArea txtIntro;
	private JLabel lblSaldo;
	private JPanel contentPane;
	private JButton btAceptar, btCancelar, bt5, bt10,bt15,bt20;
	static final String ACEPTAR= "Aceptar";
	static final String CANCELAR= "Cancelar";
	static final String CINCO= "5";
	static final String DIEZ= "10";
	static final String QUINCE= "15";
	static final String VEINTE= "20";
	
	public ReponerSaldo()
	{
		
		setTitle("Reponer Saldo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(400, 100, 600, 600);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.YELLOW);
		
		
		lblSaldo= new JLabel ("Cantidad que desea reponer");
		lblSaldo.setBounds(30, 70, 200, 20);
	    txtIntro= new JTextArea();
		txtIntro.setBounds(250, 50, 100, 50);
		
		btAceptar = new JButton ();
		btAceptar.setBounds(200, 400, 90, 70);
		btAceptar.setActionCommand(ACEPTAR);
	    btAceptar.addActionListener((ActionListener)this);
	    btAceptar.setText("Aceptar");
		
	    btCancelar = new JButton ();
		btCancelar.setBounds(340, 400, 90, 70);
		btCancelar.setActionCommand(CANCELAR);
	    btCancelar.setText("Cancelar");
		btCancelar.addActionListener((ActionListener)this);
	   
	    bt5 = new JButton ();
		bt5.setBounds(170, 160, 70, 80);
		bt5.setActionCommand(CINCO);
	    bt5.addActionListener((ActionListener)this);
	    bt5.setText("5");
	    
	    bt10 = new JButton ();
	 	bt10.setBounds(240, 160, 70, 80);
	 	bt10.setActionCommand(DIEZ);
	    bt10.addActionListener((ActionListener)this);
	    bt10.setText("10");
	    
	    bt15 = new JButton ();
	 	bt15.setBounds(170, 260, 70, 80);
	 	bt15.setActionCommand(QUINCE);
	    bt15.addActionListener((ActionListener)this);
	    bt15.setText("15");
	    
	    bt20 = new JButton ();
	 	bt20.setBounds(240, 260, 70, 80);
	 	bt20.setActionCommand(VEINTE);
	    bt20.addActionListener((ActionListener)this);
	    bt20.setText("20");
	    
	    
	    
		contentPane.add(txtIntro); contentPane.add(lblSaldo);contentPane.add(btAceptar);contentPane.add(btCancelar);
		contentPane.add(bt5);contentPane.add(bt10);
		contentPane.add(bt15);contentPane.add(bt20);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.txtIntro.setText(""); 
		
		switch(e.getActionCommand())
		{
		
		case ACEPTAR:
			System.out.println("Ha pulsado aceptar");
			btAceptar.setBackground(Color.blue);
			
			Aceptar();
			this.dispose();
		
			
		break;
		
		case CANCELAR:
			
			System.out.println("Ha pulsado cancelar");
			btCancelar.setBackground(Color.magenta);
			this.dispose();
			
		break;
		
		case CINCO:
			
			txtIntro.append("5 €");
			
			
		break;
		
		case DIEZ:
			txtIntro.append("10 €");
			
			
		break;
		
		case QUINCE:
			txtIntro.append("15 €");
			
			
		break;
		
		case VEINTE:
			txtIntro.append("20 €");
			
			
		break;
		
		
			
		
		
	}

  }
	
	public void Aceptar()
	{
		JOptionPane.showConfirmDialog(null, "¿Seguro que quiere reponer el saldo?","Confirmar ", JOptionPane.OK_CANCEL_OPTION);
	    clsUsuario usuario = new clsUsuario (); 
		if (txtIntro.equals(5))
		{
			
			usuario.setDinero(usuario.getDinero()+5);
		
			
		}
		if (txtIntro.equals(10))
		{
			
			usuario.setDinero(usuario.getDinero()+10);
		}
		if (txtIntro.equals(15))
		{
			
			usuario.setDinero(usuario.getDinero()+15);
		}
		if (txtIntro.equals(20))
		{
			
			usuario.setDinero(usuario.getDinero()+20);
		}
		
		
	}
}