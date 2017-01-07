package LD;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


import LN.clsUsuario;




public class ConexionSql 
{
	private static Exception lastError = null;  // Información de último error SQL ocurrido
	static Connection conn = null;
	private static Logger logger = null;
	static Statement st;
	

	
	public static Connection dbConnector (String nombreBD)
	{
		try
		{ 
			Class.forName("org.sqlite.JDBC");
            File fichero = new File("MaquinaExpendedora(DataBase).s3db");
          //  Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\testdb.db");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fichero.getAbsolutePath());
			Statement st = conn.createStatement();      // (1) Solo para foreign keys
			st.setQueryTimeout(30);
		   
			log( Level.INFO, "Conectada base de datos " + nombreBD, null );
	

			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}
		catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public void anyadirUsuario(String nombre, String ape, String dni, int edad)
	{	
		
		
			try {
				
							
				String sentencia="insert into usuario values('"+nombre+"', '"+ape+"', '"+dni+"','"+edad+"')";
				st.executeUpdate(sentencia);
				
				String sentencia2="insert into registro values('"+nombre+" , '"+ape+"')";
				st.executeUpdate(sentencia2);
				
				String sentencia3="insert into compras values('"+dni+" )";
				st.executeUpdate(sentencia3);
				
				
				JOptionPane.showMessageDialog(null, "¡Usuario añadido correctamente!");	
			
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}	
		
	
	}
	public void anyadirProductos(String nombre,float precio, String id,int num)
	{
		try {
			
			
			String sentencia="insert into producto values('"+nombre+"', '"+precio+"', '"+id+"', '"+num+"')";
			st.executeUpdate(sentencia);
			
			String sentencia2="insert into compras values('"+id+"')";
			st.executeUpdate(sentencia2);
			
			
			
			JOptionPane.showMessageDialog(null, "¡Producto añadido correctamente!");	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void eliminarUsuario(JTable table, int fila, int columna,int columna2)
	{
		String usuario=table.getValueAt(fila, columna).toString();
		columna=0;
		columna2=6;
		try {
			
			String eliminado=usuario;
			
			String sentencia="delete from usuario where num_u='"+table.getValueAt(fila,columna)+"'";
			st.executeUpdate(sentencia);			
			
			String sentencia2="delete from compras where num_j= '"+eliminado+"'";
			st.executeUpdate(sentencia2);
			
			
			

			
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarUsuario(JTextField txtNombre,JTextField txtApe, JTextField txtDni, JTextField txtSaldo,JTextField txtPassword, JTextField txtCompras, JTable table, int fila, int columna)
	{
		
		columna=0;
		try {
			
			ResultSet rs = st.executeQuery("select * from jugador where num_="+table.getValueAt(fila, 0));
       	 while(rs.next() == true) {
       		 
       		 
       		 txtNombre.setText(rs.getString("nombre_u"));
       		 txtApe.setText( rs.getString("ape_j"));
       		 txtDni.setText(rs.getString("dni_u"));
       		 txtSaldo.setText(rs.getString("saldo_u"));

       		 txtCompras.setText (rs.getString("compras_u"));
       		 txtPassword.setText(rs.getString("password_u"));
       		 
       		
       		 
       		 
       	 } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	
	public DefaultListModel cargarUsuario(DefaultListModel modeloLista2)
	{
		
		
	     
	      try {
	    	
	    	ResultSet rs = st.executeQuery("select * from usuario");
			while(rs.next())
			  { 
				  // Leer el resultset
				 
				  modeloLista2.addElement(rs.getString("nombre_u") + " " + rs.getString("ape_u") + " " + rs.getString("edad_u"));
				  
				  
				      

			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modeloLista2;
	}
	
	
	
	
	


	public static String DirectorioActual()
	{
	    String directorio = System.getProperty("java.class.path");
	    File dir = new File(directorio);
	    String directorioPadre = dir.getParent();
	    return directorioPadre;
	}
	
	private static String secu( String string ) {
		// Implementación (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementación (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúüÁÉÍÓÚÚ.,:;-_(){}[]-+*=<>'\"¿?¡!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}
	

	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( ConexionSql.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
	

    
	
}
