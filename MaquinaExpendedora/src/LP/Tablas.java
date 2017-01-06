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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
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
import LP.TablasUsuarios.TablaUsuariosModel;
import LN.clsAlimento;
import LN.clsBebida;
import LN.clsGestor;



public class Tablas extends JFrame 
{
   private JRadioButton rdbUser, rdbBebidas;
   private static boolean visibilidad;
   static LinkedList<clsBebida> Bebidas;	
   private static JTable jtBebidas,jtAlimentos,jtUsuarios;		
   private JScrollPane jspBebidas,jspAlimentos,jspUsuarios;
   private JLabel 	jlBebidas,jlAlimentos,jlUsuarios;
	
   static ArrayList<clsUsuario> Usuarios;	
   static LinkedList<clsAlimento>Alimentos;
  	
   private JPanel	contentPane, labelPanel, tablaPanel;
   clsGestor objGestor= new clsGestor(null);	
   private DefaultTableModel modelo;
	ConexionSql con = null;
	
	static final String USUARIO= "Tabla Usuarios";
	static final String BEBIDAS ="Tabla Bebidas";
	
	

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
	


	protected void mostrarPanel()
	{
//		if (visibilidad==false)
//		{
//			
//			panelUsuario.setVisible(true);
//			panelBebida.setVisible(false);
//			System.out.println("Estoy en usuarios");
//		}
//		if (visibilidad==true)
//		{
//			
//			panelUsuario.setVisible(false);
//			panelBebida.setVisible(true);
//			System.out.println("Estoy en alimentos");
//			
//		}
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
	    	
	    	sorter3.setSortKeys(sortKey2);
	    	sorter3.sort();
	   }
	

	 private void CreateShowGUI()
		{
			crearTablas();	
		
			//visibilidad=false;
		
			contentPane= new JPanel();
			labelPanel= new JPanel(new GridLayout());
			tablaPanel= new JPanel(new GridLayout());
			
			this.setResizable(true);
			
			
			contentPane.setLayout(new BorderLayout());
		
		
			labelPanel.setLayout(new BorderLayout());
			tablaPanel.setLayout(new BorderLayout());			
			
	        jspBebidas=new JScrollPane(jtBebidas); jspAlimentos= new JScrollPane(jtAlimentos);
		    jlBebidas=new JLabel("Listado de Bebidas");
			labelPanel.add(jlBebidas); //labelPanel.add(jlAlimentos);
			tablaPanel.add(jspBebidas,BorderLayout.CENTER); tablaPanel.add(jspAlimentos,BorderLayout.PAGE_END);
			
			jspUsuarios=new JScrollPane(jtUsuarios);
		    jlUsuarios=new JLabel("Listado de Usuarios");
			labelPanel.add(jlUsuarios,BorderLayout.NORTH);
			tablaPanel.add(jspUsuarios,BorderLayout.NORTH);
			
			contentPane.add(labelPanel,BorderLayout.NORTH);
			contentPane.add(tablaPanel,BorderLayout.CENTER);
			
			
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
//	     //  if(visibilidad==false){contentPane.add(panelUsuario);}
//	       if(visibilidad==false){contentPane.add(panelBebida);}
//	       
		 					
			
			
			
			this.setSize(1000,400);
			this.setVisible(true);
			this.setContentPane(contentPane);
			
		
			
			
		}
    
	
	
}