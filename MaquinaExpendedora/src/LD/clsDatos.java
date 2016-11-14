package LD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import COMUN.clsConstantes.enFicheros;
import LN.clsUsuario;

public class clsDatos implements itfDatos
{
	
	private final String fic_usuarios="usuarios.dat";
	private final String fic_admin="admin.dat";
	private final String fic_bebidas="bebidas.dat";
	private final String fic_relaciónalumasig="relaciónalumasig.dat";
	private final String fic_relaciónprofasig="relaciónprofasig.dat";
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	AppendableObjectOutputStream aos;
	
	
	private String Elegir(enFicheros fichero)
	{
		
		String aux = null;
		
		switch(fichero)
		{
		case USUARIOS:
			 return fic_usuarios;
		case ADMINISTRADOR:
			 return fic_admin;
		case BEBIDAS:
			return fic_bebidas;
//		case RELACIONALUM_ASIG:
//			return fic_relaciónalumasig;
//		case RELACIONPROF_ASIG:
//			return fic_relaciónprofasig;
		default:
			System.out.println("No existe este fichero");
		}
		return aux;
		
	}
	
	public void ComenzarSave(enFicheros fichero) 
	{
		String ruta=Elegir(fichero);
		File Faux= new File(ruta);
		
		if(Faux.exists())
		{
			try {
				aos=new AppendableObjectOutputStream(new FileOutputStream(Faux,true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
			try {
				//Faux.createNewFile();
				oos=new ObjectOutputStream(new FileOutputStream(Faux));
				} catch (IOException e) 
					{
				// TODO Auto-generated catch block
				e.printStackTrace();
					}
		}
		
	}

	public void TerminarSave() 
	{
		try 
			{
		if(oos!=null)
			oos.close();
		else if(aos!=null)
			aos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void Save(Serializable objA) 
	{
			try 
			{
				if(oos!=null)
					oos.writeObject(objA);
				else
				{
					if(aos!=null)
						aos.writeObject(objA);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
			
	public void ComenzarRead(enFicheros fichero) throws IOException 
	{
		String ruta=Elegir(fichero);
		File Faux=new File(ruta);
		
		if(Faux.exists())
		{
			ois=new ObjectInputStream(new FileInputStream(Faux));
		}
	}

	public void TerminarRead() 
	{
		
			try {
				if(ois!=null)ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public Serializable Leer() 
	{
		Serializable o=null;
		
		try {
			o=(Serializable)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	public void ResetFile(enFicheros fichero)
	{
	
		String ruta=Elegir(fichero);
		File Faux= new File(ruta);
		Faux.delete();
	}

	@Override
	public LinkedList<Serializable> Read()
	{

		LinkedList<Serializable>lista=new LinkedList<Serializable>();
		Serializable aux;
			try {
			
			while((aux=(Serializable)ois.readObject())!=null)
			{
				lista.add((Serializable)aux);
			}
			} catch (IOException e) {
				
			}
			catch(Exception e){
				//System.out.println(e.getMessage());
				//e.printStackTrace();
			}
	
		return lista;
	
	}

	
	

	
	
	
}
