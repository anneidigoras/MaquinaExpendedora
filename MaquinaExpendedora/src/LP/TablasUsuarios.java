package LP;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.TableRowSorter;

import LN.clsUsuario;
import LN.clsGestor;
import LN.clsUsuario;




public class TablasUsuarios extends JFrame
{
	//private static UserTable datos;
    static ArrayList<clsUsuario> Usuarios;	
	static JTable jtUsuarios;		
	private JScrollPane jspUsuarios;
    private JLabel 	jlUsuarios;
	private JPanel 	contentPane;
	clsGestor objGestor= new clsGestor();	
	
	
	private static DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
	static {
		
		rendererCentrado.setHorizontalAlignment( JLabel.CENTER );
	}
	
	public TablasUsuarios()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
		setTitle("Datos Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(800, 200, 600, 390);
		
		contentPane= new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listarDatos();
		crearTablaUsuarios();	

		
		
	
		contentPane= new JPanel();
	    jspUsuarios=new JScrollPane(jtUsuarios);
	    jlUsuarios=new JLabel("Listado de Usuarios");
		
		
		contentPane.add(jlUsuarios,BorderLayout.NORTH);
		contentPane.add(jspUsuarios,BorderLayout.CENTER);
					
		

		this.setVisible(true);	
		this.setPreferredSize(new Dimension(500,450));
		this.setResizable(true);
		
		
	}
	


	private void listarDatos()
	{
		Usuarios=clsGestor.leerUsuario();
	}
	
	private void crearTablaUsuarios()
	{
		
		jtUsuarios=null;		
		
        TablaUsuariosModel tum=new TablaUsuariosModel(Usuarios);
        jtUsuarios = new JTable(tum);
		jtUsuarios.setPreferredScrollableViewportSize(new Dimension(500, 200));
		jtUsuarios.setFillsViewportHeight(true);
		jtUsuarios.setEnabled(true);
		jtUsuarios.setRowSelectionAllowed(true);
		tum.fireTableDataChanged();
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
		
		
		private String[] columnNames = {"Nombre","Apellido","DNI","Edad"};
		
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
    					new String(aux.getNombre()), new String(aux.getApellido()), new String(aux.getDni()),
    					new Integer(aux.getEdad())
    					
 					
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

        public String getColumnName(int col) {
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

	
  
}

	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


