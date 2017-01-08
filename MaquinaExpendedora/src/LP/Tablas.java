package LP;

/**
 * @author Anne Idigoras & Mayi Echeveste
 * 
 *  Clase que extiende de JInternalFrame e implementa un actionListener
 *  Su funcion es la de crear una tabla con los Bebidas que se han dado de alta, ordenandolos alfabeticamente por nombre, 
 *  y en la que poder eliminar al Producto seleccionado, por su id
 * 
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import COMUN.clsConstantes;
import LD.ConexionSql;
import LN.clsProducto;
import LN.clsUsuario;
import LN.clsAdquisicion;
import LN.clsAlimento;
import LN.clsBebida;
import LN.clsGestor;
import LN.clsMensaje;



public class Tablas extends JFrame implements ActionListener
{

   private JButton salir, correoUsuarios, correoBebidas, correoAlimentos, correoCompras;
   private static JTable jtBebidas,jtAlimentos,jtUsuarios, jtCompras;		
   private JScrollPane jspBebidas,jspAlimentos,jspUsuarios,jspCompras;
   private JLabel 	jlBebidas,jlAlimentos,jlUsuarios,jlCompras;
	
   static ArrayList<clsUsuario> Usuarios;	
   static LinkedList<clsAlimento>Alimentos;
   static ArrayList<clsAdquisicion> Compras;
   static LinkedList<clsBebida> Bebidas;	
   
   private JPanel	contentPane, tablaPanel;
   clsGestor objGestor= new clsGestor(null);	
   private DefaultTableModel modelo;
	ConexionSql con = null;
	
	static final String SALIR= "Salir";
	static final String CORREOU= "Correo Usuarios";
	static final String CORREOB= "Correo Bebidas";
	static final String CORREOA= "Correo Alimentos";
	static final String CORREOC= "Correo Compras";
	

	
	

	public Tablas()
	{
	
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		listarDatos();
		
		CreateShowGUI();

	
	}
	

	private void listarDatos()
	{
		Bebidas=clsGestor.BebidasGuardadas();
		Usuarios=clsGestor.leerUsuario();
		Alimentos= clsGestor.AlimentosGuardados();
		Compras= clsGestor.leerAdquisicion();
	}		
	
	public void actualizarTablaCompras()
	{
		Compras= clsGestor.leerAdquisicion();
		
		TablaComprasModel tam=(TablaComprasModel)jtCompras.getModel();
		tam.setData(Compras);
		tam.fireTableDataChanged();
	}
	
	class TablaComprasModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		
		private String[] columnNames = {"Dni","Id Producto"};
        Object[][] data;
        
        public TablaComprasModel(ArrayList<clsAdquisicion> compras)
        {
        	
        	super();
        	
    		int filas = compras.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsAdquisicion aux : compras)
    		{
    		   
    			Object[]a={
    					new String(aux.getDni_usuario()), new String (aux.getId_producto())
    					
    				
    					   };
    			data[cont]=a;
    			cont++;
    		}
    		
        	
        }
        
        public void setData(ArrayList<clsAdquisicion> compras) 
        {
        	int filas = compras.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsAdquisicion aux : compras)
    		{
    		   
    		Object[]a={
    				
    				new String(aux.getDni_usuario()), new String (aux.getId_producto())
 					
 					   };
    				
    			data[cont]=a;
    			cont++;
    		}
        }
        
       public int getColumnCount() 
        {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) 
        {
        	
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) 
        {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        @SuppressWarnings("unchecked")
		public Class getColumnClass(int c) 
        {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
           
                return false;
           
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) 
        {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }

    }
	public void actualizarTablaBebidas()
	{
		Bebidas= clsGestor.BebidasGuardadas();
		
		TablaBebidasModel tam=(TablaBebidasModel)jtBebidas.getModel();
		tam.setData(Bebidas);
		tam.fireTableDataChanged();
	}
	
	class TablaBebidasModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		
		private String[] columnNames = {"Nombre","Id","Cantidad","Precio"};
        Object[][] data;
        
        public TablaBebidasModel(LinkedList<clsBebida> Bebidas)
        {
        	
        	super();
        	
    		int filas = Bebidas.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsProducto aux : Bebidas)
    		{
    		   
    			Object[]a={
    					new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Float( aux.getPrecioP())
    					
    				
    					   };
    			data[cont]=a;
    			cont++;
    		}
    		
        	
        }
        
        public void setData(LinkedList<clsBebida> Bebidas) 
        {
        	int filas = Bebidas.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsProducto aux : Bebidas)
    		{
    		   
    		Object[]a={
    				new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Float( aux.getPrecioP())
    					
 					
 					   };
    				
    			data[cont]=a;
    			cont++;
    		}
        }
        
       public int getColumnCount() 
        {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) 
        {
        	
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) 
        {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        @SuppressWarnings("unchecked")
		public Class getColumnClass(int c) 
        {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
           
                return false;
           
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) 
        {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }

    }
	class TablaAlimentosModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		
		private String[] columnNames = {"Nombre","Id","Cantidad","Precio"};
        Object[][] data;
        
        public TablaAlimentosModel(LinkedList<clsAlimento> Alimentos)
        {
        	
        	super();
        	
    		int filas = Alimentos.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsProducto aux : Alimentos)
    		{
    		   
    			Object[]a={
    					new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Float( aux.getPrecioP())
    					
    				
    					   };
    			data[cont]=a;
    			cont++;
    		}
    		
        	
        }
        
        public void setData(LinkedList<clsAlimento> Alimentos) 
        {
        	int filas = Alimentos.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsProducto aux : Alimentos)
    		{
    		   
    		Object[]a={
    				new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Float( aux.getPrecioP())
    					
 					
 					   };
    				
    			data[cont]=a;
    			cont++;
    		}
        }
        
       public int getColumnCount() 
        {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) 
        {
        	
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) 
        {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        @SuppressWarnings("unchecked")
		public Class getColumnClass(int c) 
        {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
           
                return false;
           
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) 
        {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }

    }
	

	private void crearTablas()
	{
		
		jtUsuarios=null;		
		
        TablaUsuariosModel tam=new TablaUsuariosModel(Usuarios);
	
		jtUsuarios = new JTable(tam);
		jtUsuarios.setPreferredScrollableViewportSize(new Dimension(clsConstantes.ancho_pantalla/2 -50, clsConstantes.alto_pantalla/8));
		jtUsuarios.setFillsViewportHeight(true);
		jtUsuarios.setEnabled(true);
		jtUsuarios.setRowSelectionAllowed(true);
		tam.fireTableDataChanged();

		jtBebidas=null;		
		
        TablaBebidasModel tam2=new TablaBebidasModel(Bebidas);
	
		jtBebidas = new JTable(tam2);
		jtBebidas.setPreferredScrollableViewportSize(new Dimension(clsConstantes.ancho_pantalla/2 -50, clsConstantes.alto_pantalla/8));
		jtBebidas.setFillsViewportHeight(true);
		jtBebidas.setEnabled(true);
		jtBebidas.setRowSelectionAllowed(true);
		tam2.fireTableDataChanged();

		jtAlimentos=null;		
		
        TablaAlimentosModel tam3=new TablaAlimentosModel(Alimentos);
	
		jtAlimentos = new JTable(tam3);
		jtAlimentos.setPreferredScrollableViewportSize(new Dimension(clsConstantes.ancho_pantalla/2 -50, clsConstantes.alto_pantalla/8));
		jtAlimentos.setFillsViewportHeight(true);
		jtAlimentos.setEnabled(true);
		jtAlimentos.setRowSelectionAllowed(true);
		tam3.fireTableDataChanged();
		
        jtCompras=null;		
		
        TablaComprasModel tam4=new TablaComprasModel(Compras);
	
		jtCompras = new JTable(tam4);
		jtCompras.setPreferredScrollableViewportSize(new Dimension(clsConstantes.ancho_pantalla/2 -50, clsConstantes.alto_pantalla/8));
		jtCompras.setFillsViewportHeight(true);
		jtCompras.setEnabled(true);
		jtCompras.setRowSelectionAllowed(true);
		tam4.fireTableDataChanged();
		ordenacion();
				
	}
		
	
	public void actualizartablaUsuarios()
	{
		Usuarios= clsGestor.leerUsuario();
		
		TablaUsuariosModel tam=(TablaUsuariosModel)jtUsuarios.getModel();
		tam.setData(Usuarios);
		tam.fireTableDataChanged();
	}
	
	public void actualizartablaAlimentos()
	{
		Alimentos= clsGestor.AlimentosGuardados();
		
		TablaAlimentosModel tam=(TablaAlimentosModel)jtAlimentos.getModel();
		tam.setData(Alimentos);
		tam.fireTableDataChanged();
	}
	
	class TablaUsuariosModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		
		private String[] columnNames = {"Nombre","Primer Apellido","DNI","Edad"};
        Object[][] data;
        
        public TablaUsuariosModel(ArrayList<clsUsuario> Usuario)
        {
        	
        	super();
        	
    		int filas = Usuario.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsUsuario aux : Usuario)
    		{
    		   
    			Object[]a={
    					new String(aux.getNombre()), new String(aux.getApellido()), new String(aux.getDni()),new Integer(aux.getEdad())
    					
    				
    					   };
    			data[cont]=a;
    			cont++;
    		}
    		
        	
        }
        
        public void setData(ArrayList<clsUsuario> Usuario) 
        {
        	int filas = Usuario.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsUsuario aux : Usuario)
    		{
    		   
    		Object[]a={
    					new String(aux.getNombre()), new String(aux.getApellido()), new String(aux.getDni()),new Integer(aux.getEdad())
    					
 					
 					   };
    				
    			data[cont]=a;
    			cont++;
    		}
        }
        
       public int getColumnCount() 
        {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) 
        {
        	
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) 
        {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        @SuppressWarnings("unchecked")
		public Class getColumnClass(int c) 
        {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
           
                return false;
           
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) 
        {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }

    }
	 private void ordenacion()
	    {
	    	TableRowSorter<TablaUsuariosModel>sorter= new TableRowSorter(jtUsuarios.getModel());
	    	jtUsuarios.setRowSorter(sorter);
	    	ArrayList<RowSorter.SortKey> sortKey=new ArrayList<>();
	    	
	    	int colSort=0;
	    	int colSort2=1;
	    	sortKey.add(new RowSorter.SortKey(colSort, SortOrder.ASCENDING));
	    	sortKey.add(new RowSorter.SortKey(colSort2, SortOrder.ASCENDING));
	    	
	    	sorter.setSortKeys(sortKey);
	    	sorter.sort();
	    	
	    	TableRowSorter<TablaBebidasModel>sorter2= new TableRowSorter(jtBebidas.getModel());
	    	jtBebidas.setRowSorter(sorter2);
	    	ArrayList<RowSorter.SortKey> sortKey2=new ArrayList<>();
	    	
	    	int colSort3=0;
	    	int colSort4=1;
	    	sortKey2.add(new RowSorter.SortKey(colSort3, SortOrder.ASCENDING));
	    	sortKey2.add(new RowSorter.SortKey(colSort4, SortOrder.ASCENDING));
	    	
	    	sorter2.setSortKeys(sortKey2);
	    	sorter2.sort();
	    	
	    	TableRowSorter<TablaAlimentosModel>sorter3= new TableRowSorter(jtAlimentos.getModel());
	    	jtAlimentos.setRowSorter(sorter3);
	    	ArrayList<RowSorter.SortKey> sortKey3=new ArrayList<>();
	    	
	    	int colSort5=0;
	    	int colSort6=1;
	    	sortKey3.add(new RowSorter.SortKey(colSort5, SortOrder.ASCENDING));
	    	sortKey3.add(new RowSorter.SortKey(colSort6, SortOrder.ASCENDING));
	    	
	    	sorter3.setSortKeys(sortKey3);
	    	sorter3.sort();
	    	
	    	TableRowSorter<TablaComprasModel>sorter4= new TableRowSorter(jtCompras.getModel());
	    	jtCompras.setRowSorter(sorter4);
	    	ArrayList<RowSorter.SortKey> sortKey4=new ArrayList<>();
	    	
	    	int colSort7=0;
	    	int colSort8=1;
	    	sortKey4.add(new RowSorter.SortKey(colSort7, SortOrder.ASCENDING));
	    	sortKey4.add(new RowSorter.SortKey(colSort8, SortOrder.ASCENDING));
	    	
	    	sorter4.setSortKeys(sortKey4);
	    	sorter4.sort();
	   }
	
	 
	 

	 private void CreateShowGUI()
		{
			crearTablas();	
		
			this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		
			//new BorderLayout());
			contentPane= new JPanel();
			contentPane.setBounds(0,0,clsConstantes.ancho_pantalla,clsConstantes.alto_pantalla);
			contentPane.setLayout(null);
			//this.setResizable(true);
			
		  
			salir= new JButton();
			salir.setBounds(contentPane.getWidth()-120,10,100,30);
			salir.setText("Volver");
			salir.setActionCommand(SALIR);
			salir.addActionListener((ActionListener) this);
			contentPane.add(salir);
			

		
			
			tablaPanel= new JPanel();//new GridLayout());
		    tablaPanel.setBounds(0,0,contentPane.getWidth(),contentPane.getHeight());
		    tablaPanel.setLayout(null);
			//tablaPanel.setLayout(new BorderLayout());			
		    
		    jlUsuarios=new JLabel("Listado de Usuarios");
		    jlUsuarios.setBounds(tablaPanel.getWidth()/3, 0,200,20);
		    tablaPanel.add(jlUsuarios);//),BorderLayout.NORTH);
		    
			JPanel panelU= new JPanel();
			panelU.setBounds(clsConstantes.ancho_pantalla/20,30,clsConstantes.ancho_pantalla/2, clsConstantes.alto_pantalla/6);
			jspUsuarios=new JScrollPane(jtUsuarios);
			panelU.add(jspUsuarios);//BorderLayout.NORTH);
			
			jlBebidas=new JLabel("Listado de Bebidas");
			jlBebidas.setBounds(tablaPanel.getWidth()/3,clsConstantes.alto_pantalla/4,200,20);
			tablaPanel.add(jlBebidas); //labelPanel.add(jlAlimentos);
			
			JPanel panelB= new JPanel();
			jspBebidas=new JScrollPane(jtBebidas);
			panelB.setBounds(clsConstantes.ancho_pantalla/20,clsConstantes.alto_pantalla/4 +30,clsConstantes.ancho_pantalla/2, clsConstantes.alto_pantalla/6);
			panelB.add(jspBebidas);//,BorderLayout.CENTER); 
			
			jlAlimentos=new JLabel("Listado de Alimentos");
			jlAlimentos.setBounds(tablaPanel.getWidth()/3, clsConstantes.alto_pantalla/4 *2, 200, 20);
			tablaPanel.add(jlAlimentos);//),BorderLayout.NORTH);
			
			JPanel panelA= new JPanel();
			panelA.setBounds(clsConstantes.ancho_pantalla/20, (clsConstantes.alto_pantalla/2)+30,clsConstantes.ancho_pantalla/2, clsConstantes.alto_pantalla/6);
	        jspAlimentos= new JScrollPane(jtAlimentos);
			panelA.add(jspAlimentos);//,BorderLayout.PAGE_END);
			
			jlCompras=new JLabel("Listado de Compras");
			jlCompras.setBounds(tablaPanel.getWidth()/3, (clsConstantes.alto_pantalla/4)*3, 200, 20);
			tablaPanel.add(jlCompras);//),BorderLayout.NORTH);
			
			JPanel panelC= new JPanel();
			panelC.setBounds(clsConstantes.ancho_pantalla/20,(clsConstantes.alto_pantalla/4)*3 +30,clsConstantes.ancho_pantalla/2, clsConstantes.alto_pantalla/6);
			jspCompras= new JScrollPane(jtCompras);
			panelC.add(jspCompras);
			
			
			tablaPanel.add(panelU);
			tablaPanel.add(panelB);
			tablaPanel.add(panelA);
			tablaPanel.add(panelC);
			
			contentPane.add(tablaPanel);//,BorderLayout.CENTER);
			
       		
       		ImageIcon correo = new ImageIcon(getClass().getResource("/img/correo.jpg"));
    		Image imagencorreo = correo.getImage();
    		ImageIcon correoEsc = new ImageIcon (imagencorreo.getScaledInstance(120,100,Image.SCALE_SMOOTH));
       		
			correoUsuarios = new JButton ();
	       	correoUsuarios.setBounds(clsConstantes.ancho_pantalla*2/3, 40, 120, 100);
	       	correoUsuarios.setIcon(correoEsc);
	        correoUsuarios.setActionCommand(CORREOU);
	       	correoUsuarios.addActionListener((ActionListener)this);
	       	
	       	correoBebidas = new JButton ();
	       	correoBebidas.setBounds(clsConstantes.ancho_pantalla*2/3, clsConstantes.alto_pantalla/4 +40, 120, 100);
	        correoBebidas.setIcon(correoEsc);
	        correoBebidas.setActionCommand(CORREOB);
	       	correoBebidas.addActionListener((ActionListener)this);
	       	
	       	correoAlimentos = new JButton ();
	       	correoAlimentos.setBounds(clsConstantes.ancho_pantalla*2/3, (clsConstantes.alto_pantalla/2) +40, 120, 100);
	        correoAlimentos.setIcon(correoEsc);
	        correoAlimentos.setActionCommand(CORREOA);
	       	correoAlimentos.addActionListener((ActionListener)this);
	       	
	       	
	       	correoCompras = new JButton ();
	       	correoCompras.setBounds(clsConstantes.ancho_pantalla*2/3, (clsConstantes.alto_pantalla/4)*3 +40, 120, 100);
	        correoCompras.setIcon(correoEsc);
	        correoCompras.setActionCommand(CORREOC);
	       	correoCompras.addActionListener((ActionListener)this);
	       	
	       	
	       	tablaPanel.add(correoAlimentos);tablaPanel.add(correoBebidas);tablaPanel.add(correoUsuarios); tablaPanel.add(correoCompras);
	  
			//this.setSize(1000,400);
			//this.setVisible(true);
			this.setContentPane(contentPane);
			
		
			
			
		}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando=e.getActionCommand();
	
		switch(comando)
		{
		
		case CORREOU:
			clsMensaje.correoU();
			break;
			
		case CORREOA:
			clsMensaje.correoA();
			break;
			
		case CORREOB:
			clsMensaje.correoB();
			break;
		case SALIR:
			this.dispose();
			break;
		
		case CORREOC:
			clsMensaje.correoC();
			
			break;}
		
		
	}
    
	
	
}