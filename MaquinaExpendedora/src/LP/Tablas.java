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
   
   private JPanel	contentPane, labelPanel, tablaPanel;
   clsGestor objGestor= new clsGestor(null);	
   private DefaultTableModel modelo;
	ConexionSql con = null;
	
	static final String SALIR= "Salir";
	static final String CORREOU= "Correo Usuarios";
	static final String CORREOB= "Correo Bebidas";
	static final String CORREOA= "Correo Alimentos";

	
	

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
	
//	public void actualizarTablaCompras()
//	{
//		Compras= clsGestor.leerAdquisicion();
//		
//		TablaComprasModel tam=(TablaComprasModel)jtCompras.getModel();
//		tam.setData(Compras);
//		tam.fireTableDataChanged();
//	}
	
//	class TablaComprasModel extends AbstractTableModel
//    {
//		private static final long serialVersionUID = 1L;
//		
//		
//		private String[] columnNames = {"Id producto","Dni"};
//        Object[][] data;
//        
//        public TablaComprasModel(ArrayList<clsAdquisicion> compras)
//        {
//        	
//        	super();
//        	
//    		int filas = compras.size();
//    		int cont;
//    		data=new Object[filas][];
//    		cont=0;
//    		
//    		
//    		//Nos recorremos el map para cargar la variable data[][]
//    		for (clsAdquisicion aux : compras)
//    		{
//    		   
//    			Object[]a={
//    					new String(aux.getDni_usuario()), new String (aux.getId_producto())
//    					
//    				
//    					   };
//    			data[cont]=a;
//    			cont++;
//    		}
//    		
//        	
//        }
//        
//        public void setData(ArrayList<clsAdquisicion> compras) 
//        {
//        	int filas = compras.size();
//    		int cont;
//    		data=new Object[filas][];
//    		cont=0;
//    		
//    		
//    		
//    		for (clsAdquisicion aux : compras)
//    		{
//    		   
//    		Object[]a={
//    				
//    				new String(aux.getDni_usuario()), new String (aux.getId_producto())
// 					
// 					   };
//    				
//    			data[cont]=a;
//    			cont++;
//    		}
//        }
//        
//       public int getColumnCount() 
//        {
//            return columnNames.length;
//        }
//
//        public int getRowCount() {
//            return data.length;
//        }
//
//        public String getColumnName(int col) 
//        {
//        	
//            return columnNames[col];
//        }
//
//        public Object getValueAt(int row, int col) 
//        {
//            return data[row][col];
//        }
//
//        /*
//         * JTable uses this method to determine the default renderer/
//         * editor for each cell.  If we didn't implement this method,
//         * then the last column would contain text ("true"/"false"),
//         * rather than a check box.
//         */
//        @SuppressWarnings("unchecked")
//		public Class getColumnClass(int c) 
//        {
//            return getValueAt(0, c).getClass();
//        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * editable.
//         */
//        public boolean isCellEditable(int row, int col) {
//           
//                return false;
//           
//        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * data can change.
//         */
//        public void setValueAt(Object value, int row, int col) 
//        {
//            
//            data[row][col] = value;
//            fireTableCellUpdated(row, col);
//
//        }
//
//    }
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
    					new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Integer((int) aux.getPrecioP())
    					
    				
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
    				new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Integer((int) aux.getPrecioP())
    					
 					
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
    					new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Integer((int) aux.getPrecioP())
    					
    				
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
    				new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Integer((int) aux.getPrecioP())
    					
 					
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
		jtUsuarios.setPreferredScrollableViewportSize(new Dimension(500, 200));
		jtUsuarios.setFillsViewportHeight(true);
		jtUsuarios.setEnabled(true);
		jtUsuarios.setRowSelectionAllowed(true);
		tam.fireTableDataChanged();

		jtBebidas=null;		
		
        TablaBebidasModel tam2=new TablaBebidasModel(Bebidas);
	
		jtBebidas = new JTable(tam2);
		jtBebidas.setPreferredScrollableViewportSize(new Dimension(500, 200));
		jtBebidas.setFillsViewportHeight(true);
		jtBebidas.setEnabled(true);
		jtBebidas.setRowSelectionAllowed(true);
		tam2.fireTableDataChanged();

		jtAlimentos=null;		
		
        TablaAlimentosModel tam3=new TablaAlimentosModel(Alimentos);
	
		jtAlimentos = new JTable(tam3);
		jtAlimentos.setPreferredScrollableViewportSize(new Dimension(500, 200));
		jtAlimentos.setFillsViewportHeight(true);
		jtAlimentos.setEnabled(true);
		jtAlimentos.setRowSelectionAllowed(true);
		tam3.fireTableDataChanged();
		
        jtCompras=null;		
		
//        TablaComprasModel tam4=new TablaComprasModel(Compras);
//	
//		jtCompras = new JTable(tam4);
//		jtCompras.setPreferredScrollableViewportSize(new Dimension(500, 200));
//		jtCompras.setFillsViewportHeight(true);
//		jtCompras.setEnabled(true);
//		jtCompras.setRowSelectionAllowed(true);
//		tam4.fireTableDataChanged();
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
	    	
//	    	TableRowSorter<TablaComprasModel>sorter4= new TableRowSorter(jtCompras.getModel());
//	    	jtCompras.setRowSorter(sorter4);
//	    	ArrayList<RowSorter.SortKey> sortKey4=new ArrayList<>();
//	    	
//	    	int colSort7=0;
//	    	int colSort8=1;
//	    	sortKey4.add(new RowSorter.SortKey(colSort7, SortOrder.ASCENDING));
//	    	sortKey4.add(new RowSorter.SortKey(colSort8, SortOrder.ASCENDING));
//	    	
//	    	sorter4.setSortKeys(sortKey4);
//	    	sorter4.sort();
	   }
	
	 
	 

	 private void CreateShowGUI()
		{
			crearTablas();	
		
			//visibilidad=false;
		
			contentPane= new JPanel();
			contentPane.setBounds(0,0,1000,1000);
			labelPanel= new JPanel();//new GridLayout());
			tablaPanel= new JPanel();//new GridLayout());
			JPanel panelU= new JPanel();
			panelU.setBounds(0, 0,200,200);
			JPanel panelB= new JPanel();
			panelB.setBounds(220, 0,200,200);
			JPanel panelA= new JPanel();
			panelB.setBounds(440, 0,200,200);
			JPanel panelC= new JPanel();
			panelC.setBounds(660, 0,200,200);
			this.setResizable(true);
		    
			
			
			contentPane.setLayout(null);//new BorderLayout());
		
		    labelPanel.setBounds(0,0,300,50);
			//labelPanel.setLayout(new BorderLayout());
		    tablaPanel.setBounds(0,100,1000,1000);
			//tablaPanel.setLayout(new BorderLayout());			
			
	        jspBebidas=new JScrollPane(jtBebidas); jspAlimentos= new JScrollPane(jtAlimentos);
		    jlBebidas=new JLabel("Listado de Bebidas");
			labelPanel.add(jlBebidas); //labelPanel.add(jlAlimentos);
			panelB.add(jspBebidas);//,BorderLayout.CENTER); 
			panelA.add(jspAlimentos);//,BorderLayout.PAGE_END);
			
			jspUsuarios=new JScrollPane(jtUsuarios);
		    jlUsuarios=new JLabel("Listado de Usuarios");
			labelPanel.add(jlUsuarios);//),BorderLayout.NORTH);
			panelU.add(jspUsuarios);//BorderLayout.NORTH);
			tablaPanel.add(panelU); tablaPanel.add(panelB);tablaPanel.add(panelA);
			
			contentPane.add(labelPanel);//,BorderLayout.NORTH);
			contentPane.add(tablaPanel);//,BorderLayout.CENTER);
			
			salir= new JButton();
			salir.setBounds(300,10,20,10);
			salir.setText("Volver");
			labelPanel.add(salir);
			salir.setActionCommand(SALIR);
			salir.addActionListener((ActionListener) this);
			
			correoUsuarios = new JButton ();
	       	correoUsuarios.setBounds(800, 20, 40, 30);
	       	Image img3= null;
	       		
	       		try {
	       			img3 = ImageIO.read(getClass().getResource("/img/correo.jpg"));
	       		} catch (IOException e) {
	       			e.printStackTrace();
	       		}
	       	correoUsuarios.setIcon(new ImageIcon(img3));
	        correoUsuarios.setActionCommand(CORREOU);
	       	correoUsuarios.addActionListener((ActionListener)this);
	       	
	       	correoBebidas = new JButton ();
	       	correoBebidas.setBounds(800, 70, 40, 30);
	        correoBebidas.setIcon(new ImageIcon(img3));
	        correoBebidas.setActionCommand(CORREOB);
	       	correoBebidas.addActionListener((ActionListener)this);
	       	
	       	correoAlimentos = new JButton ();
	       	correoAlimentos.setBounds(800, 130, 40, 30);
	        correoAlimentos.setIcon(new ImageIcon(img3));
	        correoAlimentos.setActionCommand(CORREOA);
	       	correoAlimentos.addActionListener((ActionListener)this);
	       	
	       	tablaPanel.add(correoAlimentos);tablaPanel.add(correoBebidas);tablaPanel.add(correoUsuarios);
	  
//			rdbUser = new JRadioButton("Tabla Usuarios");
//			rdbUser.setBounds(138, 300, 100, 30);
//			rdbUser.setSelected(true);
//			contentPane.add(rdbUser);
//				
//			rdbBebidas = new JRadioButton("Tabla Bebidas");
//			rdbBebidas.setBounds(240, 300, 109, 30);
//			contentPane.add(rdbBebidas);
//			
//			rdbBebidas.setActionCommand(BEBIDAS);
//			rdbUser.setActionCommand(USUARIO);
//				
//				//Group the radio buttons.
//			ButtonGroup group = new ButtonGroup();
//			group.add(rdbBebidas);
//			    group.add(rdbUser);
//			    
//		   rdbBebidas.addActionListener((ActionListener)this);
//	       rdbUser.addActionListener((ActionListener)this);
//	       
	       
		 					
			
			
			
			this.setSize(1000,400);
			this.setVisible(true);
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
			
			break;}
		
		
	}
    
	
	
}