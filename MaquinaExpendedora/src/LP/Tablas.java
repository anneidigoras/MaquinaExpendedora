package LP;

/**
 * @author Anne Idigoras & Mayi Echeveste
 * 
 *  Clase que extiende de JInternalFrame e implementa un actionListener
 *  Su funcion es la de crear una tabla con los Productos que se han dado de alta, ordenandolos alfabeticamente por nombre, 
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
import LN.clsBebida;
import LN.clsGestor;



public class Tablas extends JFrame implements ActionListener
{
   private JRadioButton rdbUser, rdbBebidas;
   private static boolean visibilidad;
   static LinkedList<clsBebida> Productos;	
   private static JTable jtProductos;		
   private JScrollPane jspProductos;
   private JLabel 	jlProductos;
	
   static ArrayList<clsUsuario> Usuarios;	
   private static JTable jtUsuarios;		
   private JScrollPane jspUsuarios;
   private JLabel 	jlUsuarios;
   private JPanel	contentPane, panelUsuario, panelBebida;
   clsGestor objGestor= new clsGestor(null);	
   private DefaultTableModel modelo;
	ConexionSql con = null;
	
	static final String USUARIO= "Tabla Usuarios";
	static final String BEBIDAS ="Tabla Bebidas";
	
	

	public Tablas()
	{
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listarDatosBebidas();
		listarDatos();
		CreateShowGUI();

	
	}
	


	
	private void listarDatosBebidas()
	{
		Productos=clsGestor.BebidasGuardadas();
	}
	
	private void crearTablaProductos()
	{
		
		jtProductos=null;		
		
        TablaProductosModel tam=new TablaProductosModel(Productos);
	
		jtProductos = new JTable(tam);
		jtProductos.setPreferredScrollableViewportSize(new Dimension(500, 200));
		jtProductos.setFillsViewportHeight(true);
		jtProductos.setEnabled(true);
		jtProductos.setRowSelectionAllowed(true);
		tam.fireTableDataChanged();
		ordenacionBebidas();
				
	}
		
	
	public void actualizarTablaBebidas()
	{
		Productos= clsGestor.BebidasGuardadas();
		
		TablaProductosModel tam=(TablaProductosModel)jtProductos.getModel();
		tam.setData(Productos);
		tam.fireTableDataChanged();
	}
	
	class TablaProductosModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		
		private String[] columnNames = {"Nombre","Id","Cantidad","Precio"};
        Object[][] data;
        
        public TablaProductosModel(LinkedList<clsBebida> productos)
        {
        	
        	super();
        	
    		int filas = productos.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsProducto aux : productos)
    		{
    		   
    			Object[]a={
    					new String(aux.getNombreP()), new String(aux.getId()), new Integer(aux.getNum()),new Integer((int) aux.getPrecioP())
    					
    				
    					   };
    			data[cont]=a;
    			cont++;
    		}
    		
        	
        }
        
        public void setData(LinkedList<clsBebida> productos) 
        {
        	int filas = productos.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsProducto aux : productos)
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
	


	@Override
	
	public void actionPerformed(ActionEvent e)
	{
		
		switch(e.getActionCommand())
		{
		 
		case USUARIO:
			
			visibilidad=false;
	        mostrarPanel();
					break;
		case BEBIDAS:
			visibilidad=true;
	        mostrarPanel();
					break;
		
	
			
		}
		
		
	}
	protected void mostrarPanel()
	{
		if (visibilidad==false)
		{
			
			panelUsuario.setVisible(true);
			panelBebida.setVisible(false);
			System.out.println("Estoy en usuarios");
		}
		if (visibilidad==true)
		{
			
			panelUsuario.setVisible(false);
			panelBebida.setVisible(true);
			System.out.println("Estoy en alimentos");
			
		}
	}
	
	
    private void ordenacionBebidas()
    {
    	TableRowSorter<TablaProductosModel>sorter= new TableRowSorter(jtProductos.getModel());
    	jtProductos.setRowSorter(sorter);
    	ArrayList<RowSorter.SortKey> sortKey=new ArrayList<>();
    	
    	int colSort=0;
    	int colSort2=1;
    	sortKey.add(new RowSorter.SortKey(colSort, SortOrder.ASCENDING));
    	sortKey.add(new RowSorter.SortKey(colSort2, SortOrder.ASCENDING));
    	
    	sorter.setSortKeys(sortKey);
    	sorter.sort();
   }
    
    private void listarDatos()
	{
		Usuarios=clsGestor.leerUsuario();
	}
	
	private void crearTablaUsuarios()
	{
		
		jtUsuarios=null;		
		
        TablaUsuariosModel tam=new TablaUsuariosModel(Usuarios);
	
		jtUsuarios = new JTable(tam);
		jtUsuarios.setPreferredScrollableViewportSize(new Dimension(500, 200));
		jtUsuarios.setFillsViewportHeight(true);
		jtUsuarios.setEnabled(true);
		jtUsuarios.setRowSelectionAllowed(true);
		tam.fireTableDataChanged();
		ordenacion();
				
	}
		
	
	public void actualizartabla()
	{
		Usuarios= clsGestor.leerUsuario();
		
		TablaUsuariosModel tam=(TablaUsuariosModel)jtUsuarios.getModel();
		tam.setData(Usuarios);
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
	   }
	

	 private void CreateShowGUI()
		{
			crearTablaUsuarios();	
			crearTablaProductos();
			visibilidad=false;
		
			contentPane= new JPanel();
			panelUsuario= new JPanel();
			panelBebida= new JPanel();
			
			this.setResizable(true);
			
			
			contentPane.setLayout(new BorderLayout());
			setContentPane(contentPane);
		
			panelUsuario.setLayout(new BorderLayout());
			panelBebida.setLayout(new BorderLayout());
			
			
			
	        jspProductos=new JScrollPane(jtProductos);
		    jlProductos=new JLabel("Listado de Bebidas");
			panelBebida.add(jlProductos,BorderLayout.NORTH);
			panelBebida.add(jspProductos,BorderLayout.CENTER);
			
			jspUsuarios=new JScrollPane(jtUsuarios);
		    jlUsuarios=new JLabel("Listado de Usuarios");
			panelUsuario.add(jlUsuarios,BorderLayout.NORTH);
			panelUsuario.add(jspUsuarios,BorderLayout.CENTER);
			
			rdbUser = new JRadioButton("Tabla Usuarios");
			rdbUser.setBounds(138, 300, 100, 30);
			rdbUser.setSelected(true);
			contentPane.add(rdbUser);
				
			rdbBebidas = new JRadioButton("Tabla Bebidas");
			rdbBebidas.setBounds(240, 300, 109, 30);
			contentPane.add(rdbBebidas);
			
			rdbBebidas.setActionCommand(BEBIDAS);
			rdbUser.setActionCommand(USUARIO);
				
				//Group the radio buttons.
			ButtonGroup group = new ButtonGroup();
			group.add(rdbBebidas);
			    group.add(rdbUser);
			    
		   rdbBebidas.addActionListener((ActionListener)this);
	       rdbUser.addActionListener((ActionListener)this);
	       
	       if(visibilidad==false){contentPane.add(panelUsuario);}
	       if(visibilidad==true){contentPane.add(panelBebida);}
	       
		 					
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(1000,400);
			this.setVisible(true);
			
		
			
			
		}
    
	
	
}