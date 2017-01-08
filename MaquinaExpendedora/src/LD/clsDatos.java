package LD;
/**
 * 
 * @author 
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

import COMUN.clsConstantes;



public class clsDatos
{

	
	private final String fic_usuarios= "src\\Ficheros\\Usuarios.dat";
	private final String fic_admin= "src\\Ficheros\\Admin.dat";
	private final String fic_bebidas= "src\\Ficheros\\Bebidas.dat";
	private final String fic_alimentos= "src\\Ficheros\\Alimentos.dat";
	private final String fic_adquisicion= "src\\Ficheros\\Adiquisicion.dat";

	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	AppendableObjectOutputStream aos;
	
	private String setFichero(COMUN.clsConstantes.enFicheros fichero)
	{
		
		switch (fichero)
		{
		case USUARIOS:
	
		 return fic_usuarios;
		 
		case ADMINISTRADOR:
			return fic_admin;
			
		case BEBIDAS: 
			return fic_bebidas;
			
		case ALIMENTOS:
			return fic_alimentos;
			
		case RELACIONUSUARIO_BEBIDA:
			return fic_adquisicion;
			
		case RELACIONUSUARIO_ALIMENTO:
			return fic_adquisicion;
		
		
	
	
		}
		return "";
	}
	
	 public void ComenzarSave(COMUN.clsConstantes.enFicheros ficheros)
		{
		 String ruta= setFichero(ficheros);
			File file = new File (ruta);
			
			if (file.exists())
			    {
				FileOutputStream salida;
				
				try {
					salida = new FileOutputStream(file, true);
					aos=new AppendableObjectOutputStream(salida);

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    }
				else 
				{
					FileOutputStream salida;
					try {
						salida = new FileOutputStream(file);
						oos= new ObjectOutputStream (salida);
					} catch (FileNotFoundException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 catch (IOException e) 
					 {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			    }
	    /**
	     * Este método guarda en el fichero abierto anteriormente el objeto serializable que se le pasa por parametro.
	     * @param objeto de tipo serializable
	     */
		public void Save (Serializable s)
		{
			if (oos== null)	
			{
				try 
				{
					aos.writeObject(s);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
			{
				try {
					oos.writeObject(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
		/**
		 * Este método cierra el archivo que se ha abierto para su escritura
		 */
		public void TerminarSave()
		{
			if (oos==null)
			{
				try {
					aos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		/**
		 * Este método sirve para saber si existe algun objeto en la direccion de memoria pasada por parametro.
		 * @param Fichero: La dirección del fichero.
		 * @return existe: es un boolean. Devuelve falso en caso de que no exista ningun objeto en la ruta. Y viceversa.
		 */
		public boolean comprobarexiste(COMUN.clsConstantes.enFicheros ficheros)
		{
			boolean existe=false;
			String ruta= setFichero(ficheros);
			File file = new File (ruta);
			if (file.exists())
			{
				
				existe=true;		
			}
			return existe;
		}
		
		public void tamañoFichero(COMUN.clsConstantes.enFicheros ficheros)
		{
			String ruta= setFichero(ficheros);
			File file = new File (ruta);
			if (file.exists())
			{
				file.length();		
			}
		}
		/**
		 * Abre el archivo a modo de lectura.
		 * @param Ficheros: Ruta del fichero que se va a leer más adelante.
		 * @throws IOException
		 */
		public void ComenzarRead(COMUN.clsConstantes.enFicheros ficheros) throws IOException
		{
			String ruta= setFichero(ficheros);
			File file = new File (ruta);
			if (file.exists())
			{
			    try
			    {
				     FileInputStream entrada = new FileInputStream (file);
				     ois= new ObjectInputStream (entrada);
			    } 
			    catch (IOException e)
			    {
			    	e.printStackTrace();
			    }
			}
			
		}
		/**
		 * Para leer los objetos que se encuentran en la ruta de ficheros abierta mediante el método anterior.
		 * @return listaobj: ArrayList que contiene todos los objetos del fichero que se ha abierto anteriormente.
		 */
		public ArrayList<Serializable> Read() 
		{
			ArrayList<Serializable> listaobj =new ArrayList<Serializable>();
			Serializable s;
			
			  try {
				while ((s = (Serializable) ois.readObject())!=null)
				  {
					  listaobj.add(s);
				  }
			} catch (ClassNotFoundException e) 
			{
			} catch (IOException e) 
			{
			}catch (NullPointerException e) {}
		
			return listaobj;
			
		}	
		/**
		 * Método para cerrar el fichero que se ha abierto a modo de lectura.
		 */
		public void TerminarRead()
		{
			if(ois!=null)
			{
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e)
			{
				e.printStackTrace();
			}
			}
			
		}	
		
		/**
		 * Método que elimina todos los objetos que se encuentran en una ruta determinada.
		 * @param fichero: ruta del fichero cuyos datos se van a eliminar
		 */
	    public void ResetFile (COMUN.clsConstantes.enFicheros ficheros )
		{
			String ruta= setFichero(ficheros);
			File file = new File (ruta);
			file.delete();
		}

	

}
