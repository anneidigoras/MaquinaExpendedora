package LN;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

import COMUN.clsAdquisicionRepetido;
import COMUN.clsConstantes;

import COMUN.clsConstantes.enFicheros;

import COMUN.clsUsuarioExistente;
import LD.*;



public class clsGestor 
{

	public File file;          // Fichero
	public String nombre;     
	public String dni;    


	public clsGestor(File file2) 
	{
		// TODO Auto-generated constructor stub
	}
	/**
	 * Este metodo se ejecuta una sola vez al principio del programa para crear las bebidas disponibles 
	 * Y guardarlas en la base de datos.
	 * Llama al metodo BebidasGuardadas(), si las bebidas ya estan en la base de datos solo las recoje en una LinkedList (Persistencia de datos)
	 * Si la base de datos de bebidas esta vacía, inserta las bebidas disponobles. (1º ejecucion del programa)
	 */
	public static void creabebidas ()
	{
		LinkedList<clsBebida> listaB; 
		
		listaB=new LinkedList<clsBebida>();
		listaB = BebidasGuardadas ();
		if (listaB.isEmpty())
		{
		listaB.add(new clsBebida ("CocaCola", (float) 1.2, clsConstantes.ID_COCACOLA, 350, "lata",clsConstantes.NUM_INICIAL_BEBIDAS));
		listaB.add(new clsBebida ("Nestea", (float) 1.2, clsConstantes.ID_NESTEA, 350, "lata", clsConstantes.NUM_INICIAL_BEBIDAS));
//		listaB.add(new clsBebida ("Fanta Naranja", (float) 1.2, "FN", 250, "botella", clsConstantes.NUM_INICIAL_BEBIDAS));
//		listaB.add( new clsBebida ("Sprite", (float) 1.2, "S", 250, "botella", clsConstantes.NUM_INICIAL_BEBIDAS));
//		listaB.add(new clsBebida ("RedBull", (float) 1.5, "RB", 335, "lata", clsConstantes.NUM_INICIAL_BEBIDAS));
//		listaB.add(new clsBebida ("Aquarius", (float) 1.2, "AQ", 330, "lata", clsConstantes.NUM_INICIAL_BEBIDAS));
		listaB.add(new clsBebida ("Bifrutas", (float) 1.0, clsConstantes.ID_BIFRUTAS, 250, "lata", clsConstantes.NUM_INICIAL_BEBIDAS));
		listaB.add(new clsBebida ("Agua", (float) 1.5, clsConstantes.ID_AGUA, 500, "botella", clsConstantes.NUM_INICIAL_BEBIDAS));
		
		guardarBebidas (listaB);
		
		}
	}
	
	public static void guardarBebidas (LinkedList <clsBebida> listabebidas)
	{
		clsDatos objD=new clsDatos();
		
		objD.ResetFile(enFicheros.BEBIDAS);
		
		objD.ComenzarSave(enFicheros.BEBIDAS);
		
		for(clsBebida aux: listabebidas )
		{
			objD.Save((Serializable) aux);
		}
		
		objD.TerminarSave();
		
	}
	
	public static LinkedList <clsBebida> BebidasGuardadas() 
	{
		
		LinkedList<clsBebida> lista=new LinkedList<clsBebida>();
		clsDatos objD = new clsDatos();
		
		try {
			objD.ComenzarRead(enFicheros.BEBIDAS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			for(Serializable aux:objD.Read())
			{
				lista.add((clsBebida)aux);
			}
		
		objD.TerminarRead();
		
		return lista;
	}
	
	public static void consumobebida (String id)
	{
		
		LinkedList <clsBebida> listaB=new LinkedList<clsBebida>();
		listaB = BebidasGuardadas ();
		for (clsBebida  aux: listaB)
		{
			if(aux.getId().equals(id)){	aux.setNum(aux.getNum()-1);	break;}
		}
		guardarBebidas (listaB);
		
		
	}
	
	
	public  void nuevoUsuario(String nombre, String apellido1, String DNI, int edad,  String pass)throws clsUsuarioExistente
	{
		HashSet<clsUsuario>setUsuario= new HashSet<clsUsuario>();
		ArrayList<clsUsuario>listaUsuario= new ArrayList<clsUsuario>();
		
		listaUsuario=leerUsuario();
		setUsuario.addAll(listaUsuario);
		
		clsUsuario objUsuario= new clsUsuario(nombre, apellido1, DNI, edad, pass);
		clsDatos objDatos= new clsDatos();
		
		//objUsuario.setNombre(nombre); objUsuario.setApellido(apellido1);objUsuario.setApe2(ape2); objUsuario.setId_Usuario(id);objUsuario.setNum_asig(asignaturas);
		
		boolean cont= setUsuario.add(objUsuario);
		
		if(cont==false)
		{
			try 
			{
				throw new clsUsuarioExistente();
			} 
			catch (clsUsuarioExistente e) 
			{
			
				System.out.println(e.getMessage());
			}
		}
		else
		{
		
		objDatos.ComenzarSave(enFicheros.USUARIOS);
        objDatos.Save(objUsuario);
        objDatos.TerminarSave();
        }
		}

    public static boolean IngresoCliente(String nombre, String pass)
		{
			boolean existe = false;
			ArrayList<clsUsuario>listaClientes= new ArrayList<clsUsuario>();
			listaClientes=leerUsuario();
			for (clsUsuario aux: listaClientes)
			{
				if (aux.getPassword().equals(pass)|| aux.getNombre().equals(nombre))
				{
					existe=true;
					break;
				}
			}
			
			return existe;
			
		}

    public static ArrayList<clsUsuario> leerUsuario()
		{
			ArrayList<clsUsuario> listaUsuario= new ArrayList<clsUsuario>();
			clsDatos objDatos= new clsDatos();
			ArrayList<Serializable> serializable= new ArrayList<Serializable>();
			
		    try 
		    {
				objDatos.ComenzarRead(enFicheros.USUARIOS);
			} 
		    catch (IOException e)
		    {
				
				e.printStackTrace();
			}
		    
				serializable=objDatos.Read();
		    for(Serializable aux: serializable)
		    {
		    	listaUsuario.add((clsUsuario)aux);
		    }
		    Collections.sort(listaUsuario);
		    
		    objDatos.TerminarRead();
			
		    return listaUsuario;
		}


    public static void CrearListaUsuario(LinkedList<clsUsuario> lista)
{
	clsDatos objD=new clsDatos();
	
	objD.ResetFile(enFicheros.USUARIOS);
	
	objD.ComenzarSave(enFicheros.USUARIOS);
	
	for(clsUsuario aux: lista )
	{
		objD.Save((Serializable) aux);
	}
	
	objD.TerminarSave();
	
}

public static void crearAdquisicion(String id_producto, String dni_user)
{
	ArrayList<clsAdquisicion> adquisicion= new ArrayList<clsAdquisicion>();
	HashSet<clsAdquisicion> setadquisicion= new HashSet<clsAdquisicion>();
	clsDatos objDatos= new clsDatos();
	clsAdquisicion objadquisicion= new clsAdquisicion();
	
	adquisicion=leeradquisicion();
	setadquisicion.addAll(adquisicion);
	
	objadquisicion.setId_producto(id_producto);objadquisicion.setDni_usuario(dni_user);
	
	boolean cont= setadquisicion.add(objadquisicion);
	
	if(cont==false)
	{
		
		try {
			throw new clsAdquisicionRepetido();
		} catch (clsAdquisicionRepetido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else
	{
		objDatos.ComenzarSave(enFicheros.RELACIONUSUARIO_PRODUCTO);
		objDatos.Save((Serializable) objadquisicion);
		objDatos.TerminarSave();
		
		
	}

}
public static ArrayList<clsAdquisicion> leeradquisicion()
{
	ArrayList<Serializable>serializable= new ArrayList<Serializable>();
	ArrayList<clsAdquisicion> adquisicion= new ArrayList<clsAdquisicion>();
	clsDatos objDatos= new clsDatos();
	
	try
    {
		objDatos.ComenzarRead(enFicheros.RELACIONUSUARIO_PRODUCTO);
	}
	catch (IOException e)
	{
		
		e.printStackTrace();
	}
	serializable= objDatos.Read();
	
	for(Serializable aux: serializable)
	{
		adquisicion.add((clsAdquisicion)aux);
		
	}
	
	objDatos.TerminarRead();
	return adquisicion;
	
}
public static void Eliminar()
{
	System.out.println("Has seleccionado reiniciar ficheros");
	clsDatos objD=new clsDatos();
	
	objD.ResetFile(enFicheros.USUARIOS);
}



public static void EliminarA(String  dni)
{
	
	ArrayList<clsUsuario>lista = leerUsuario();
	LinkedList<clsUsuario>lista1 =new LinkedList<clsUsuario>(); 		
	for(clsUsuario aux:lista)
	{
		if(!aux.getDni().equals(dni))
			lista1.add(aux);
	}
	CrearListaUsuario(lista1);
}





public void crearAdmin(LinkedList<clsAdministrador>listaA)

{
	
clsDatos objD=new clsDatos();
	
	objD.ResetFile(enFicheros.ADMINISTRADOR);
	
	objD.ComenzarSave(enFicheros.ADMINISTRADOR);
	
	for(clsAdministrador aux: listaA )
	{
		objD.Save((Serializable) aux);
	}
	
	objD.TerminarSave();
	
}

public void asignarBebida()

{
	


}

public boolean anyadirFilaATabla( Statement st ) {
	// Adicional uno
	if (chequearYaEnTabla(st)) {  // Si está ya en la tabla
		return modificarFilaEnTabla(st);
	}
	// Inserción normal
	try {
		String sentSQL = "insert into fichero_multimedia values(" +
				"'" + file.getAbsolutePath() + "', " +
				"'" + dni+ "', " +
				"'" + nombre + "')";
		System.out.println( sentSQL );  // (Quitar) para ver lo que se hace-CONSEJO: hacer siempre un syso del string para ver como se ve
		int val = st.executeUpdate( sentSQL );
		if (val!=1) return false;  // Se tiene que añadir 1 - error si no
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}
public boolean chequearYaEnTabla( Statement st ) {
	try {
		String sentSQL = "select * from fichero_multimedia " +
				"where (fichero = '" + file.getAbsolutePath() + "')"; //con getAbs.. no pueden existir dos arhivos con el mismo nombre
		System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
		ResultSet rs = st.executeQuery( sentSQL ); // con resultset gestionamos los archivos vlc
		if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
			rs.close();
			return true; //si existe un valor return true, si no false
		}
		return false;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}

public boolean modificarFilaEnTabla( Statement st ) {
	try {
		String sentSQL = "update fichero_multimedia set " +
				"nombre = '" + nombre + "', " +
				"dni = '" + dni + "', " +
				
				"where (fichero = '" + file.getAbsolutePath() + "')";
		System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
		int val = st.executeUpdate( sentSQL ); 
		if (val!=1) return false;  // Se tiene que modificar 1, error si no
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}

public void cargarDeTabla( Statement st ) {
	try {
		String sentSQL = "select * from fichero_multimedia " +
				"where (fichero = '" + this.file.getAbsolutePath() + "')";
		System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
		ResultSet rs = st.executeQuery( sentSQL );
		if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
		
			this.nombre = rs.getString( "nombre" );
			this.dni = rs.getString( "dni" );
			
			rs.close();
		}
		// else No hay ninguno en la tabla
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static clsGestor cargarDeTabla( Statement st, String nombreFichero ) {
	try {
		String sentSQL = "select * from fichero_multimedia " +
				"where (fichero = '" + nombreFichero + "')";
		System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
		ResultSet rs = st.executeQuery( sentSQL );
		if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
			clsGestor fm = new clsGestor( new File(nombreFichero) );
			
			fm.nombre = rs.getString( "nombre" );
			fm.dni = rs.getString( "dni" );
			
			rs.close();
			return fm;
		}
		// else No hay ninguno en la tabla
		return null;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;  // Error
	}
}

public static ArrayList<clsGestor> cargarVariosDeTabla( Statement st, String exprWhere ) {
	try {
		ArrayList<clsGestor> lista = new ArrayList<>();
		String sentSQL = "select * from fichero_multimedia" +
				((exprWhere==null||exprWhere.equals(""))?"":(" where " + exprWhere));
		System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
		ResultSet rs = st.executeQuery( sentSQL );
		while (rs.next()) { 
			clsGestor fm = new clsGestor( new File(rs.getString( "fichero_multimedia" )) );
			
			fm.nombre = rs.getString( "nombre" );
			fm.dni = rs.getString( "dni" );
			
			rs.close();
			lista.add( fm );
		}
		return lista;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;  // Error
	}
}


public static void gastadinero(String dni, String id)
{
	float precio =0;
	clsUsuario cliente = new clsUsuario () ;
	ArrayList<clsUsuario>listaClientes= new ArrayList<clsUsuario>();
	LinkedList<clsUsuario>LinkedUsuario= new LinkedList<clsUsuario>();
	listaClientes=leerUsuario();
	
	LinkedList<clsBebida>listaBebidas= new LinkedList<clsBebida>();
	listaBebidas=BebidasGuardadas();
	for (clsBebida aux: listaBebidas)
	{
		if(aux.getId().equals(id)) precio = aux.getPrecioP();
	}
	for (clsUsuario aux: listaClientes)
	{
		if (aux.getDni().equals(dni))
		{
			cliente= aux;
			listaClientes.remove(aux);
			break;
		}
	}
	cliente.setDinero(cliente.getDinero()-precio);
	listaClientes.add(cliente);
	
	LinkedUsuario.addAll(listaClientes);
	CrearListaUsuario(LinkedUsuario);
	
	
	
	

}


}