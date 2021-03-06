
package LN;

/**
 * @author Anne y Mayi
 * 
 * clase en la que se gestionan los metodos para guardado y lectura de los ficheros
 * 
 */
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

import COMUN.clsConstantes;

import COMUN.clsConstantes.enFicheros;

import COMUN.clsUsuarioExistente;
import LD.*;
import LP.InterfazSeleccionProductos;



public class clsGestor 
{
	public static clsAdministrador admin = new clsAdministrador();
	public File file;          // Fichero
	public String nombre;     
	public String dni;    


	public clsGestor(File file2) 
	{
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * lectura del fichero del administrador
 */
	public static void cargaradmin()
	{
		
		
		clsDatos objD = new clsDatos();
		if (objD.comprobarexiste(enFicheros.ADMINISTRADOR)==true)
		{
			LinkedList<clsAdministrador> lista=new LinkedList<clsAdministrador>();
			
			try {
				objD.ComenzarRead(enFicheros.ADMINISTRADOR);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				for(Serializable aux:objD.Read())
				{
					lista.add((clsAdministrador)aux);
				}
			
			objD.TerminarRead();
			admin= lista.getFirst();
		}
		else
			{
			admin= new clsAdministrador();
			crearAdmin(); 
			}
	
	}
	/**
	 * 
	 * guardado del administrador en el fichero
	 */
	public static void crearAdmin()
	{	     
	               clsDatos objD = new clsDatos();
	               objD.ResetFile(enFicheros.ADMINISTRADOR);
	               objD.ComenzarSave(enFicheros.ADMINISTRADOR);
	               objD.Save((Serializable)admin);
	               objD.TerminarSave();
	}
	/**
	 * Este metodo se ejecuta una sola vez al principio del programa para crear las bebidas y los alimentos disponibles 
	 * Y guardarlas en la base de datos.
	 * Llama al metodo BebidasGuardadas(), si las bebidas ya estan en la base de datos solo las recoje en una LinkedList (Persistencia de datos)
	 * Si la base de datos de bebidas esta vac�a, inserta las bebidas disponobles. (1� ejecucion del programa) y el mismo procedimiento con los alimentos
	 */
	public static void creaproductos ()
	{
		LinkedList<clsBebida> listaB; 
		
		listaB=new LinkedList<clsBebida>();
		listaB = BebidasGuardadas ();
		if (listaB.isEmpty())
		{
		listaB.add(new clsBebida ("CocaCola", clsConstantes.PRECIO_COCACOLA, clsConstantes.ID_COCACOLA, 350, "lata",clsConstantes.NUM_INICIAL_PRODUCTOS));
		listaB.add(new clsBebida ("Nestea", clsConstantes.PRECIO_NESTEA, clsConstantes.ID_NESTEA, 350, "lata", clsConstantes.NUM_INICIAL_PRODUCTOS));

		listaB.add(new clsBebida ("Bifrutas", clsConstantes.PRECIO_BIFRUTAS, clsConstantes.ID_BIFRUTAS, 250, "lata", clsConstantes.NUM_INICIAL_PRODUCTOS));
		listaB.add(new clsBebida ("Agua", clsConstantes.PRECIO_AGUA, clsConstantes.ID_AGUA, 500, "botella", clsConstantes.NUM_INICIAL_PRODUCTOS));
		
		
		guardarBebidas (listaB);
		
		}
		
		LinkedList<clsAlimento> listaA; 
		
		
		listaA=new LinkedList<clsAlimento>();
		listaA = AlimentosGuardados ();
		if (listaA.isEmpty())
		{
			
			listaA.add(new clsAlimento ("Snickers", clsConstantes.PRECIO_SNICKERS, clsConstantes.ID_SNICKERS, 125, clsConstantes.NUM_INICIAL_PRODUCTOS));
			listaA.add(new clsAlimento("KitKat",clsConstantes.PRECIO_KITKAT,clsConstantes.ID_KITKAT,125,clsConstantes.NUM_INICIAL_PRODUCTOS));
			listaA.add(new clsAlimento("Oreo",clsConstantes.PRECIO_OREO,clsConstantes.ID_OREO,150,clsConstantes.NUM_INICIAL_PRODUCTOS));

			guardarAlimentos(listaA);
		}
	
	}
	
/**
 * 
 * guardado de alimentos en ficheros
 * @param listaAlim: pasamos como parametro la linkedlist de tipo clsAlimento
 */
	public static void guardarAlimentos (LinkedList <clsAlimento> listaAlim)
	{
		clsDatos objD=new clsDatos();
		
		objD.ResetFile(enFicheros.ALIMENTOS);
		
		objD.ComenzarSave(enFicheros.ALIMENTOS);
		
		for(clsAlimento aux: listaAlim )
		{
			objD.Save((Serializable) aux);
		}
		
		objD.TerminarSave();
		
	}
	/**
	 * lectura del fichero de alimentos
	 * @return lista de alimentos
	 */
	
	public static LinkedList <clsAlimento> AlimentosGuardados() 
	{
		
		LinkedList<clsAlimento> lista=new LinkedList<clsAlimento>();
		clsDatos objD = new clsDatos();
		
		try {
			objD.ComenzarRead(enFicheros.ALIMENTOS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			for(Serializable aux:objD.Read())
			{
				lista.add((clsAlimento)aux);
			}
		
		objD.TerminarRead();
		
		return lista;
	}
	/**
	 * giardado de las bebidas en el fichero
	 * @param listabebidas
	 */
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
	/**
	 * 
	 * lectura de la lista de bebidas guardadas en el fichero
	 * @return lista de bebidas
	 */
	
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
	/**
	 * 
	 * metodo utilizado para que al comprar las bebidas se reduzca su stock
	 * @param id: pasamos como parametro el id del producto
	 */
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
	/**
	 * 
	 * metodo utilizado para que al comprar los alimentos, el stock de estos se reduzca
	 * @param id
	 */
	
	public static void consumoAlimento (String id)
	{
		
		LinkedList <clsAlimento> listaA=new LinkedList<clsAlimento>();
		listaA = AlimentosGuardados ();
		for (clsAlimento  aux: listaA)
		{
			if(aux.getId().equals(id)){	aux.setNum(aux.getNum()-1);	break;}
		}
		guardarAlimentos (listaA);
		
		
	}
	/**
	 * 
	 * metodo utilizado para el registro de los usuarios
	 * @param nombre
	 * @param apellido1
	 * @param DNI
	 * @param edad
	 * @param pass
	 * @throws clsUsuarioExistente
	 */
	
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
/**
 * metodo utilizado para que una vez el usuario este registrado, podamos ingresar a la interfaz de compras
 * @param nombre
 * @param pass
 * @return existe: boolean que se pone a true en caso de que la contrase�a y el dni esten guardados
 */
    public static boolean IngresoCliente(String nombre, String pass)
		{
			boolean existe = false;
			ArrayList<clsUsuario>listaClientes= new ArrayList<clsUsuario>();
			listaClientes=leerUsuario();
			for (clsUsuario aux: listaClientes)
			{
				if (aux.getPassword().equals(pass) & aux.getDni().equals(nombre))
				{
					existe=true;
					break;
				}
			}
			return existe;
			
		}
    /**
     * 
     * lectura de usuarios guardados en fichero
     * @return lista de usuarios
     */

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

/**
 * 
 * guardados de los usuarios en ficheros
 * @param lista de usuarios que queremos guardar
 */
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
    /**
     * 
     * Metodo que nos permite modific
     * @param usuario
     * @param dni_anterior
     */
    public static void ModificarUsuario(clsUsuario usuario, String dni_anterior)
    {
    	ArrayList<clsUsuario> lista_anterior = leerUsuario();
    	for (clsUsuario aux: lista_anterior)
    	{
    		
    		if(aux.getDni().equals(dni_anterior))
    		{
    			lista_anterior.remove(aux);
    			break;
    		}
    	}
    	lista_anterior.add(usuario);
    	LinkedList <clsUsuario> lista_actual = new LinkedList <clsUsuario>();
    	for (clsUsuario aux: lista_anterior)
    	{
    		lista_actual.add(aux);
    	}
    	CrearListaUsuario(lista_actual);
    	
    }
    /**
     * 
     * Metodo usado para relacionar a los productos con los usuarios 
     * @param id_producto
     * @param dni_user
     */
    public static void crearAdquisicion(String id_producto, String dni_user)
{
	ArrayList<clsAdquisicion> adquisicion= new ArrayList<clsAdquisicion>();
	HashSet<clsAdquisicion> setadquisicion= new HashSet<clsAdquisicion>();
	clsDatos objDatos= new clsDatos();
	clsAdquisicion objadquisicion= new clsAdquisicion();
	
	adquisicion=leerAdquisicion();
	setadquisicion.addAll(adquisicion);
	
	objadquisicion.setId_producto(id_producto);objadquisicion.setDni_usuario(dni_user);
	

	

		objDatos.ComenzarSave(enFicheros.RELACIONUSUARIO_BEBIDA);
		objDatos.ComenzarSave(enFicheros.RELACIONUSUARIO_ALIMENTO);
		objDatos.Save((Serializable) objadquisicion);
		objDatos.TerminarSave();
		
		
	

}
public static ArrayList<clsAdquisicion> leerAdquisicion()
{
	ArrayList<Serializable>serializable= new ArrayList<Serializable>();
	ArrayList<clsAdquisicion> adquisicion= new ArrayList<clsAdquisicion>();
	clsDatos objDatos= new clsDatos();
	
	try
    {
		objDatos.ComenzarRead(enFicheros.RELACIONUSUARIO_BEBIDA);
		objDatos.ComenzarRead(enFicheros.RELACIONUSUARIO_ALIMENTO);
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

public static ArrayList<clsAdquisicion> leerAdquisicionBD()
{
	Connection nueva_conexion =ConexionSql.initBD("src\\BD\\Adquisiciones.db" );
	Statement st =ConexionSql.usarCrearTablasBD(nueva_conexion);
	
	ArrayList<clsAdquisicion> lista = ConexionSql.adquisicionSelect(st,null);
	ConexionSql.cerrarBD(nueva_conexion, st);
//	try {
//		   //Y para terminar cerramos la conexi�n
//		
//		   nueva_conexion.close();
//		
//		  }
//
//		  catch (SQLException e) {
//
//		   //Esto se ejecuta si hay alg�n problema al realizar la conexi�n.
//
//		   e.printStackTrace();
//		  }
	
	return lista;

}






/**
 * 
 * Metodo al que llamamos cuando se comprar algun producto, y el saldo del usuario se reduce
 * @param dni : dni del usuario
 * @param id: id del producto
 */

public static void gastadinero(String dni, String id)
{
	float precio =0;
	clsUsuario cliente = new clsUsuario () ;
	ArrayList<clsUsuario>listaClientes= new ArrayList<clsUsuario>();
	LinkedList<clsUsuario>LinkedUsuario= new LinkedList<clsUsuario>();
	listaClientes=leerUsuario();
	
	LinkedList<clsBebida>listaBebidas= new LinkedList<clsBebida>();
	listaBebidas=BebidasGuardadas();
	LinkedList<clsAlimento>listaAlimentos= new LinkedList<clsAlimento>();
	
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
	
	for (clsAlimento aux: listaAlimentos)
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