package LD;
/**
 * 
 * @author Anne Idigoras
 * clase datos de nuestra logica de datos, por la cual podremos leer y escribir del fichero
 * 
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import COMUN.clsConstantes.enFicheros;



public class clsDatos// implements itfDatos
{

	
	private final String fic_usuarios= "C:\\Users\\ALUMNO\\Desktop\\Usuarios.dat";
	private final String fic_admin= "C:\\Users\\ALUMNO\\Desktop\\Admin.dat";
	
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	AppendableObjectOutputStream aos;
	
	private String setFichero(enFicheros fichero)
	{
		
		switch (fichero)
		{
		case USUARIOS:
	
		 return fic_usuarios;
		
		
		case ADMINISTRADOR:
		
			return fic_admin;
	
		}
		return "";
	}
	
		
	public void ComenzarSave(enFicheros fichero)
	{
		
		String ruta=setFichero(fichero);
		File file = new File (ruta);
		
		if(file.exists())
		{
			
			try
			{
				aos= new AppendableObjectOutputStream (new FileOutputStream (file, true));// true para no sobreescribir
			}
			
			catch(IOException o)
			{
				o.printStackTrace();
			}
			
		}
		
		else
		{
			try
			{
				oos= new ObjectOutputStream (new FileOutputStream(file,true));
			}
			
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void Save(Serializable obj)
	{
		
		if(oos!=null)
			{
				try
				{
					oos.writeObject(obj);
				} 
				catch (IOException e)
				{
				
					e.printStackTrace();
				}
			}
			
			else if(aos!=null)
				{
					try 
					{
						aos.writeObject(obj);
						
					} 
					catch (IOException e) 
					{
					
						e.printStackTrace();
					}
				}
			}
		
	
	public void TerminarSave()
	
	{
		 {
	        	try
	        	{
	        		if(oos!=null)oos.close();
	        		else if(aos!=null)aos.close();
	        	}
	        	catch(IOException e)//aqui no hace falta ni mostrar el error
	        	{
	        		e.printStackTrace();
	        	}
	        	
	        }
		
		
	}
	
	public void ComenzarRead(enFicheros fichero) throws IOException
	{
		
		String ruta= setFichero(fichero);
		
		File file= new File(ruta);
		
		if(file.exists()==true)
		{
		try 
		 {
			ois= new ObjectInputStream(new FileInputStream (file));
		 } 
		catch (IOException e) 
		 {
			
			e.printStackTrace();
		 }
		}
		
	}	
	
	public ArrayList <Serializable>Read() 
	{
		ArrayList <Serializable> Lista = new ArrayList <Serializable>();
		Serializable o;
		try
		{
			while((o=(Serializable)ois.readObject())!=null)
			{	
				Lista.add(o);
			}
		}
		catch (NullPointerException e)
		{
		
		}
		catch (EOFException e)
		{
			//Excepción de fin de lectura.
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return Lista;	
		}

	public void TerminarRead()
	{
		
		if(ois!=null)
		{
			try 
			{
				ois.close();
			} 
			catch ( IOException e) 
			{
				
				e.printStackTrace();
			}
		}
		
	}

	public void ResetFile(enFicheros fichero)
	{
		String ruta= setFichero(fichero);
		File file= new File(ruta);
		file.delete();
		
	}




	

}


