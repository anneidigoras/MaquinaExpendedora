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


	

	
	

		
