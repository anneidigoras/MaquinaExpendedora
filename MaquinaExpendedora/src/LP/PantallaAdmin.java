package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LN.clsGestor;

import LN.clsMensaje;
import LN.clsUsuario;

public class PantallaAdmin extends JFrame   implements ActionListener,ItemListener
{

	private JMenuBar MenuPrincipal;
	private JMenu DatosUsuarios;
	private JMenuItem ListadoUsuarios;
	private JMenuItem EditarListaUsuarios;
	private JMenu Admin;
	private JMenuItem Ingresar;
	private JMenuItem Correo;
	private JButton vueltaInicio, correo;
    private JPanel contentPane;
    private JDesktopPane desktop;
    
   
	 static final String SALIR = "Cerrar Sesion";
	 static final String CORREO= "Correo";
	 static final String LISTA= "Listado Usuarios";
	

	
	
	public PantallaAdmin(String title)
	{
		
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		JOptionPane.showMessageDialog(this, "Welcome Administrador");
		
		desktop= new JDesktopPane();
    	desktop.setPreferredSize(new Dimension (700, 500));
    	setContentPane(desktop);
		

		
		ImageIcon icono = new ImageIcon(getClass().getResource("/img/wall.jpg"));
		Image imagen = icono.getImage();
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(1000,1000,Image.SCALE_SMOOTH));
        JLabel imagenlbl = new JLabel (iconoEscalado);
        this.getContentPane().setPreferredSize(this.getSize());
        getContentPane().add(imagenlbl);
		getContentPane().setBackground(new Color(204, 204, 255));
		MenuPrincipal = new JMenuBar();
		MenuPrincipal.setBackground(new Color(51, 102, 153));
		this.setJMenuBar(MenuPrincipal);
		
		DatosUsuarios = new JMenu("Datos Usuarios");
		DatosUsuarios.setForeground(Color.WHITE);
		MenuPrincipal.add(DatosUsuarios);
		
		    ListadoUsuarios = new JMenuItem("Listado Usuarios");
		    ListadoUsuarios.setActionCommand(LISTA);
		    ListadoUsuarios.addActionListener((ActionListener)this);
	
		    DatosUsuarios.add(ListadoUsuarios);
		
		    EditarListaUsuarios = new JMenuItem("Editable");
	
	      	DatosUsuarios.add(EditarListaUsuarios);
    	
		     Admin = new JMenu("ADMINISTRADOR");
		     Admin.setForeground(Color.WHITE);
		     MenuPrincipal.add(Admin);
		
	         Ingresar = new JMenuItem("Ingresar");
		     Admin.add(Ingresar);
		  
		     Correo = new JMenuItem("Correo");
		
		     Admin.add(Correo);
	
		
		     vueltaInicio = new JButton("Cerrar Sesion");;
             vueltaInicio.setActionCommand(SALIR);
             vueltaInicio.addActionListener((ActionListener) this);
             MenuPrincipal.add(vueltaInicio);
        

        
            correo = new JButton ();
      		correo.setBounds(0, 14, 100, 60);
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
      	   
      		JPanel panel = new JPanel();
    		panel.setBounds(10, 50, 300, 128);
    		panel.setLayout(null);
    		panel.add(correo);
    		
    		getContentPane().add(panel);
 
	
		
		
	}



	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
		case SALIR:
			 int salir;

			 salir= JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la sesion?","Confirmar ", JOptionPane.OK_CANCEL_OPTION);
			 if(salir==0)
				 this.dispose();
			   VentanaPrincipal frame = new VentanaPrincipal("");
			   frame.setVisible(true);
		
		     break;
		case CORREO:
			clsMensaje.correo();
			
			
			break;

		case LISTA:
			
			tablasUsers();
			break;
			
		
		}
		
		
	}
	
	protected void tablasUsers()
    {
    	
    	TablasUsuarios eliminar= new TablasUsuarios();
    	eliminar.setVisible(true);
    	desktop.add(eliminar);
    	
    	try 
    	{
			eliminar.setSelected(true);
		}
    	catch (PropertyVetoException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
