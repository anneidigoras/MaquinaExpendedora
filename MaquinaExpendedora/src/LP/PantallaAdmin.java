package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PantallaAdmin extends JFrame   implements ActionListener,ItemListener
{

	private JMenuBar MenuPrincipal;
	private JMenu DatosUsuarios;
	private JMenuItem ListadoUsuarios;
	private JMenuItem EditarListaUsuarios;
	private JMenu Productos;
	private JMenuItem Bebidas;
	private JMenuItem Alimentos;
	private JButton vueltaInicio;

	 static final String SALIR = "Cerrar Sesion";
	
	
	
	public PantallaAdmin(String title)
	{
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
		JOptionPane.showMessageDialog(this, "Welcome Administrador");
		MenuPrincipal = new JMenuBar();
		MenuPrincipal.setBackground(new Color(51, 102, 153));
		this.setJMenuBar(MenuPrincipal);
		
		DatosUsuarios = new JMenu("Datos Usuarios");
		DatosUsuarios.setForeground(Color.WHITE);
		MenuPrincipal.add(DatosUsuarios);
		
		ListadoUsuarios = new JMenuItem("ListadoUsuarios");
		//C_Ingresar.setForeground(new Color(0, 255, 0));
		//ListadoUsuarios.setActionCommand(SOY_CLIENTE);
		//ListadoUsuarios.addActionListener(this);
		DatosUsuarios.add(ListadoUsuarios);
		
		EditarListaUsuarios = new JMenuItem("Editable");
		//C_Registrarse.setForeground(new Color(200, 255, 0));
		//EditarListaUsuarios.setActionCommand(CREAR_CLIENTE);
		//EditarListaUsuarios.addActionListener(this);
		DatosUsuarios.add(EditarListaUsuarios);
    	
		Productos = new JMenu("ADMINISTRADOR");
		Productos.setForeground(Color.WHITE);
		MenuPrincipal.add(Productos);
		
	      Bebidas = new JMenuItem("Ingresar");
		//A_Ingresar.setForeground(new Color(0, 128, 0));
//		Bebidas.setActionCommand(SOY_ADMIN);
//		Bebidas.addActionListener(this);
		Productos.add(Bebidas);
	
		
		vueltaInicio = new JButton("Cerrar Sesion");;
        vueltaInicio.setActionCommand(SALIR);
        vueltaInicio.addActionListener((ActionListener) this);
        MenuPrincipal.add(vueltaInicio);
 
	
		
		
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
//			 ImageIcon icono = new ImageIcon(getClass().getResource("/img/maquina.jpg"));
//			 Image imagen = icono.getImage();
//			 ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(200,200,Image.SCALE_SMOOTH));
			 salir= JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar la sesion?","Confirmar ", JOptionPane.OK_CANCEL_OPTION);
			 if(salir==0)
				 this.dispose();
			   VentanaPrincipal frame = new VentanaPrincipal("");
			   frame.setVisible(true);
		
		     break;
		}
		
		
	}
}
