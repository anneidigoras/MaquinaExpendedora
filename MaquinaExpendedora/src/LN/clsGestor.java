package LN;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;



import COMUN.clsConstantes.enFicheros;
import COMUN.clsUsuarioExistente;
import LD.*;


public class clsGestor 
{


	/**
	 * Este metodo se ejecuta una sola vez al principio del programa para crear las bebidas disponibles 
	 * Y guardarlas en la base de datos.
	 */
	public void creabebidas ()
	{
		clsBebida CC= new clsBebida ("CocaCola", (float) 1.2, "b1", 350, "lata" );
		clsBebida CCL= new clsBebida ("CocaColaLight", (float) 1.2, "b2", 350, "lata");
		clsBebida Fanta= new clsBebida ("Fanta Naranja", (float) 1.2, "b3", 250, "botella");
		clsBebida Sprite= new clsBebida ("Sprite", (float) 1.2, "b4", 250, "botella");
		clsBebida RB= new clsBebida ("RedBull", (float) 1.5, "b5", 335, "lata");
		clsBebida Aquarius= new clsBebida ("Aquarius", (float) 1.2, "b6", 330, "lata");
		clsBebida Bifrutas= new clsBebida ("Bifrutas", (float) 1.0, "b7", 250, "lata");
		clsBebida Agua= new clsBebida ("Agua", (float) 1.5, "b8", 500, "botella");
		
	}
	public  void nuevoUsuario(String nombre, String apellido1, String DNI, int edad, float dinero)throws clsUsuarioExistente
	{
		clsUsuario objA = new clsUsuario(nombre,apellido1,DNI,edad,dinero);
		
		if(ListaA().size()!=0)
		{
		HashSet<clsUsuario> miset=new HashSet<clsUsuario>();
		miset.addAll(ListaA());
		if(miset.add(objA)==false)
	{
			throw new clsUsuarioExistente();
		}
		}
		
		clsDatos objD=new clsDatos();
		objD.ComenzarSave(enFicheros.USUARIOS);
		objD.Save((Serializable) objA);
		objD.TerminarSave();
		}
		
	



public static LinkedList<clsUsuario> ListaA() 
{
	
	LinkedList<clsUsuario> lista=new LinkedList<clsUsuario>();
	clsDatos objD = new clsDatos();
	
	try {
		objD.ComenzarRead(enFicheros.USUARIOS);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		for(Serializable aux:objD.Read())
		{
			lista.add((clsUsuario)aux);
		}
	
	objD.TerminarRead();
	
	return lista;
}


public static clsUsuario buscarIDA(String dni)
{

	LinkedList<clsUsuario> lista=ListaA();
	
	if(lista.size()!=0)
	{
	for(clsUsuario aux: lista)
	{
		if(aux.getDni().equals(dni))
		{
			return aux;
		}
	}
	}
		return null;
}


public static void CrearlistaA(LinkedList<clsUsuario> lista)
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



public static void Eliminar()
{
	System.out.println("Has seleccionado reiniciar ficheros");
	clsDatos objD=new clsDatos();
	
	objD.ResetFile(enFicheros.USUARIOS);}



public static void EliminarA(String  dni)
{
	
	LinkedList<clsUsuario>lista = ListaA();
	LinkedList<clsUsuario>lista1 =new LinkedList<clsUsuario>(); 		
	for(clsUsuario aux:lista)
	{
		if(!aux.getDni().equals(dni))
			lista1.add(aux);
	}
	CrearlistaA(lista1);
}



}


	

	
	

		
