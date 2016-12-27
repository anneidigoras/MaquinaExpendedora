package LP;

/**
 * @author Anne Idigoras
 * 
 *  Clase que extiende de JInternalFrame e implementa un actionListener
 *  Su funcion es la de crear una tabla con los Usuarios que se han dado de alta, ordenandolos alfabeticamente por nombre, 
 *  y en la que poder eliminar al Usuario seleccionado, por su id
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

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import LD.ConexionSql;
import LN.clsUsuario;
import LN.clsGestor;


public class TablasUsuarios extends JInternalFrame implements ActionListener
{

    static ArrayList<clsUsuario> Usuarios;	
	private static JTable jtUsuarios;		
	private JScrollPane jspUsuarios;
    private JButton aceptar,cancelar;
	private JLabel 	jlUsuarios;
	private JPanel 	panel;
	clsGestor objGestor= new clsGestor(null);	
	private DefaultTableModel modelo;
	ConexionSql con = null;
	
	

	public TablasUsuarios()
	{
		
		super("DATOS DE UsuarioS");
		listarDatos();
		CreateShowGUI();
		
	
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
	
	private void CreateShowGUI()
	{
		crearTablaUsuarios();	
		
	
		panel= new JPanel();
		
		this.setResizable(true);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		
		panel.setLayout(new BorderLayout());
		
		jspUsuarios=new JScrollPane(jtUsuarios);
	
		
		jlUsuarios=new JLabel("Listado de Usuarios");
		
		
		panel.add(jlUsuarios,BorderLayout.NORTH);
		panel.add(jspUsuarios,BorderLayout.CENTER);
					
		
		aceptar= new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setActionCommand("Aceptar");
		
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setActionCommand("Cancelar");
		
				
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,400);
		this.setVisible(true);
		
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
			//Aceptar(e);
			this.dispose();
			
		break;
		
		case "Cancelar":
			
			System.out.println("Ha pulsado cancelar");
			aceptar.setBackground(Color.magenta);
			this.dispose();
			
			
		break;	
			
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