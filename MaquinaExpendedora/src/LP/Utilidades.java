package LP;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
Esta clase permite hacer uso de los dispositivos de entrada de forma muy sencilla.
Posee distintos métodos públicos y estáticos (por lo tanto no se necesita un
objeto como tal para acceder a ellos) para la lectura de los tipos de datos básicos
en Java. Además, todos los métodos tienen un control de errores mediante petición
sucesiva de introducción de dato hasta que estos sean correctos.
*/
public class Utilidades
{
  /**
  Permite introducir por teclado en la consola un número entero (32 bits = -2147483648 <-> 2147483648)
  realizando las comprobaciones pertienentes.
  @return Devuelve el número entero que se haya introducido por teclado.
  */
	public static int leerEntero()
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Integer entero = null;
		boolean error = true;
		do
		{
			try
			{
				String cadena = br.readLine();
				entero = new Integer(cadena);
				error = false;
			}
      catch(NumberFormatException nfe)
      {
				System.out.println("No tecleó un número entero-Repetir");
      }
			catch (Exception e)
			{
				System.out.println("Error de entrada-Repetir ");
			}
		}
		while(error);
		return entero.intValue();
	}

  /**
  Permite introducir por teclado en la consola un número real realizando
  las comprobaciones pertienentes.
  @return Devuelve el número real que se haya introducido por teclado.
  */
	public static double leerReal()
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Double real = null;
		boolean error = true;
		do
		{
			try
			{
				String cadena = br.readLine();
				real = new Double(cadena);
				error = false;
			}
      catch(NumberFormatException nfe)
      {
				System.out.println("No tecleó un número real-Repetir ");
      }
			catch (Exception e)
			{
				System.out.println("Error de entrada-Repetir ");
			}
		}
		while(error);
		return real.doubleValue();
	}

  /**
  Permite introducir por teclado en la consola un caracter (8 bits = -128 <-> 127)
  realizando las comprobaciones pertienentes.
  @return Devuelve el caracter que se haya introducido por teclado.
  */
	public static char leerCaracter()
	{
		char caracter = 0;
		boolean error = true;
		do
		{
			try
			{
				caracter = (char)System.in.read();
				System.in.skip(System.in.available());
        error = false;
			}
			catch (Exception e)
			{
				System.out.println("Error de entrada-Repetir ");
			}
		}
		while(error);
		return caracter;
	}

  /**
  Permite introducir por teclado en la consola una cadena de caracteres (String)
  realizando las comprobaciones pertienentes.
  @return Devuelve la cadena de caracteres que se haya introducido por teclado.
  */
	public static String leerCadena()
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String cadena = null;
		boolean error = true;
		do
		{
			try
			{
				cadena = br.readLine();
				error = false;
			}
			catch (Exception e)
			{
				System.out.println("Error de entrada-Repetir ");
			}
		}
		while(error);
		return cadena;
	}
	
	public static Date LeerFecha()
	{
		Date Fecha = new Date();
		DateFormat formato;
		formato = new SimpleDateFormat ("dd/MM/yyyy");
		formato.setLenient(false);
		String Referencia;
		boolean error;
		do
		{
			error = true;
			Referencia = leerCadena();
			try 
			{
				Fecha=formato.parse(Referencia);
			} 
			catch (ParseException e) 
			{
				System.out.println("Error en el parseo; vuelva a introducir la fecha por favor.");
				error = false;
			}
		}
		while (error == false);
		formato.format(Fecha);
		return Fecha;
	}
}

