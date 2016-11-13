package LN;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;



import COMUN.clsConstantes.enFicheros;
import LD.*;


public class clsGestor 
{


	
	public static void nuevoUsuario(String nombre, String apellido1, String DNI, int edad, float dinero)//throws clsUsuarioExistente
	{
		clsUsuario objA = new clsUsuario(nombre,apellido1,DNI,edad,dinero);
		
		if(ListaA().size()!=0)
		{
		HashSet<clsUsuario> miset=new HashSet<clsUsuario>();
		miset.addAll(ListaA());
//		if(miset.add(objA)==false)
//		{
//			throw new clsUsuarioExistente();
//		}
//		}
		
		clsDatos objD=new clsDatos();
		objD.ComenzarSave(enFicheros.USUARIOS);
		objD.Save(objA);
		objD.TerminarSave();
		}
		
	}

//public static void nuevoprofesor(String nombre, String apellido1, String apellido2,String DNI,String Departamento,String ID) throws clsProfesorExistente 
//
//{
//	clsProfesor objP=new clsProfesor(nombre,apellido1,apellido2,DNI,Departamento,ID);
//	
//	if(ListaP().size()!=0)
//	{
//	HashSet<clsProfesor> miset=new HashSet<clsProfesor>();
//	miset.addAll(ListaP());
//	if(miset.add(objP)==false)
//	{
//		throw new clsProfesorExistente();
//	}
//	}
//	clsDatos objD=new clsDatos();
//	objD.ComenzarSave(enFicheros.PROFESORES);
//	objD.Save(objP);
//	objD.TerminarSave();
//}
//
//public static void nuevaasignatura(String nombre,String Desc,int Creditos,String id) throws clsAsignaturaExistente
//{
//	clsAsignatura objAsig=new clsAsignatura(nombre,Desc,Creditos,id);
//	
//	if(ListaAsig().size()!=0)
//	{
//	HashSet<clsAsignatura> miset=new HashSet<clsAsignatura>();
//	miset.addAll(ListaAsig());
//	if(miset.add(objAsig)==false)
//	{
//		throw new clsAsignaturaExistente();
//	}
//	}
//	
//	clsDatos objD=new clsDatos();
//	objD.ComenzarSave(enFicheros.ASIGNATURAS);
//	objD.Save(objAsig);
//	objD.TerminarSave();
//}
//
//public static void nuevaimpartir(String DNI,String ID) throws clsImparteExistente
//{
//	clsImparte objI=new clsImparte(DNI,ID);
//	
//	if(ListaI().size()!=0)
//	{
//	HashSet<clsImparte> miset=new HashSet<clsImparte>();
//	miset.addAll(ListaI());
//	if(miset.add(objI)==false)
//	{
//		throw new clsImparteExistente();
//	}
//	}
//	
//	clsDatos objD=new clsDatos();
//	objD.ComenzarSave(enFicheros.RELACIONPROF_ASIG);
//	objD.Save(objI);
//	objD.TerminarSave();
//}
//
//public static void nuevamatricula(String DNI,String ID) throws clsMatriculaExistente
//{
//	clsMatrícula objM=new clsMatrícula(DNI,ID);
//	
//	if(ListaM().size()!=0)
//	{
//	HashSet<clsMatrícula> miset=new HashSet<clsMatrícula>();
//	miset.addAll(ListaM());
//	if(miset.add(objM)==false)
//	{
//		throw new clsMatriculaExistente();
//	}
//	}
//	
//	clsDatos objD=new clsDatos();
//	objD.ComenzarSave(enFicheros.RELACIONALUM_ASIG);
//	objD.Save(objM);
//	objD.TerminarSave();
//}

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

//public static LinkedList<clsProfesor> ListaP()
//
//{
//	
//	LinkedList<clsProfesor> lista=new LinkedList<clsProfesor>();
//	clsDatos objD = new clsDatos();
//	
//	try {
//		objD.ComenzarRead(enFicheros.PROFESORES);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//		for(Serializable aux:objD.Read())
//		{
//			lista.add((clsProfesor)aux);
//		}
//	
//	objD.TerminarRead();
//	
//	return lista;
//}
//
//public static LinkedList<clsAsignatura> ListaAsig()
//{
//	LinkedList<clsAsignatura> lista=new LinkedList<clsAsignatura>();
//	clsDatos objD = new clsDatos();
//	
//	try {
//		objD.ComenzarRead(enFicheros.ASIGNATURAS);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//		for(Serializable aux:objD.Read())
//		{
//			lista.add((clsAsignatura)aux);
//		}
//	
//	objD.TerminarRead();
//	
//	return lista;
//}
//
//public static LinkedList<clsImparte> ListaI()
//{
//	LinkedList<clsImparte> lista=new LinkedList<clsImparte>();
//	clsDatos objD = new clsDatos();
//	
//	try {
//		objD.ComenzarRead(enFicheros.RELACIONPROF_ASIG);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//		for(Serializable aux:objD.Read())
//		{
//			lista.add((clsImparte)aux);
//		}
//	
//	objD.TerminarRead();
//	
//	return lista;
//}
//
//public static LinkedList<clsMatrícula> ListaM()
//{
//	LinkedList<clsMatrícula> lista=new LinkedList<clsMatrícula>();
//	clsDatos objD = new clsDatos();
//	
//	try {
//		objD.ComenzarRead(enFicheros.RELACIONALUM_ASIG);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//		for(Serializable aux:objD.Read())
//		{
//			lista.add((clsMatrícula)aux);
//		}
//	
//	objD.TerminarRead();
//	
//	return lista;
//}
//
//public static clsProfesor buscarIDP(String ID)
//{
//	
//	LinkedList<clsProfesor> lista=ListaP();
//	
//	if(lista.size()!=0)
//	{
//	for(clsProfesor aux: lista)
//	{
//		if(aux.getID_P().equals(ID))
//		{
//			return aux;
//		}
//	}
//	}
//		return null;
//}
//
//public static clsAsignatura buscarIDAsig(String ID)
//{
//	LinkedList<clsAsignatura> lista=ListaAsig();
//	
//	if(lista.size()!=0)
//	{
//	for(clsAsignatura aux: lista)
//	{
//		if(aux.getId_asignatura().equals(ID))
//		{
//			return aux;
//		}
//	}
//	}
//		return null;
//}
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

//public static clsPersona buscarDNI(String DNI)
//{
//	if(ListaA().size()!=0)
//	{
//		for(clsUsuario aux: ListaA())
//	{
//		if(aux.getDNI().equals(DNI))
//		{
//			return aux;
//		}
//	}
//	}
//	
//	if(ListaP().size()!=0)
//	{
//	for(clsProfesor aux: ListaP())
//	{
//		if(aux.getDNI().equals(DNI))
//		{
//			return aux;
//		}
//	}
//	}
//		return null;
//}

public static void CrearlistaA(LinkedList<clsUsuario> lista)
{
	clsDatos objD=new clsDatos();
	
	objD.ResetFile(enFicheros.USUARIOS);
	
	objD.ComenzarSave(enFicheros.USUARIOS);
	
	for(clsUsuario aux: lista )
	{
		objD.Save(aux);
	}
	
	objD.TerminarSave();
	
}

//public static void CrearlistaP(LinkedList<clsProfesor> lista)
//
//{
//	clsDatos objD=new clsDatos();
//	
//	objD.ResetFile(enFicheros.PROFESORES);
//	
//	objD.ComenzarSave(enFicheros.PROFESORES);
//	
//	for(clsProfesor aux: lista )
//	{
//		objD.Save(aux);
//	}
//	
//	objD.TerminarSave();
//	
//}
//
//public static void CrearlistaAsig(LinkedList<clsAsignatura>lista)
//{
//	clsDatos objD=new clsDatos();
//	
//	objD.ResetFile(enFicheros.ASIGNATURAS);
//	
//	objD.ComenzarSave(enFicheros.ASIGNATURAS);
//	
//	for(clsAsignatura aux: lista )
//	{
//		objD.Save(aux);
//	}
//	
//	objD.TerminarSave();
//	
//}
//
//public static void CrearlistaI(LinkedList<clsImparte>lista)
//{
//	clsDatos objD=new clsDatos();
//	
//	objD.ResetFile(enFicheros.RELACIONPROF_ASIG);
//	
//	objD.ComenzarSave(enFicheros.RELACIONPROF_ASIG);
//	
//	for(clsImparte aux: lista )
//	{
//		objD.Save(aux);
//	}
//	
//	objD.TerminarSave();
//	
//}
//
//public static void CrearlistaM(LinkedList<clsMatrícula>lista)
//{
//	clsDatos objD=new clsDatos();
//	
//	objD.ResetFile(enFicheros.RELACIONALUM_ASIG);
//	
//	objD.ComenzarSave(enFicheros.RELACIONALUM_ASIG);
//	
//	for(clsMatrícula aux: lista )
//	{
//		objD.Save(aux);
//	}
//	
//	objD.TerminarSave();
//	
//}

public static void Eliminar()
{
	System.out.println("Has seleccionado reiniciar ficheros");
	clsDatos objD=new clsDatos();
	
	objD.ResetFile(enFicheros.USUARIOS);
//	objD.ResetFile(enFicheros.ASIGNATURAS);
//	objD.ResetFile(enFicheros.PROFESORES);
//	objD.ResetFile(enFicheros.RELACIONALUM_ASIG);
//	objD.ResetFile(enFicheros.RELACIONPROF_ASIG);
}


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

//public static void EliminarP(String  id)
//{
//	
//	LinkedList<clsProfesor>lista = ListaP();
//	LinkedList<clsProfesor>lista1 =new LinkedList<clsProfesor>(); 		
//	for(clsProfesor aux:lista)
//	{
//		if(!aux.getID_P().equals(id))
//			lista1.add(aux);
//	}
//	CrearlistaP(lista1);
//}

}


	

	
	

		
