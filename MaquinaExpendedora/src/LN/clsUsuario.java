package LN;

import java.io.Serializable;
import java.util.Comparator;
/**
 * Clase usuario, con sus atributos. Implemente comparable, serilizable y comparator
 * Usamos el hashcode y el equals en el dni, para que el dni sea unico y no se pueda repetir
 *
 */
public class clsUsuario implements Comparable<clsUsuario> ,Serializable,Comparator
{

	private String nombre; 
	private String apellido;
	private int edad;
	private String genero;
	private float dinero;
	private String dni;
	private String password;
	
	

	public clsUsuario(String nombre2, String apellido1, String dNI2, int edad2, String pass)
	{
		nombre="";
		edad=0;
		genero="";
		dinero=COMUN.clsConstantes.DINERO_INICIAL;
		apellido="";
		dni="";
		password = pass;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public  String toString()
	{
		String cadena;
		
		cadena= "Al usuario: "+ this.getNombre()+"  "+ this.getApellido()+" le queda el sigiente saldo: " + this.getDinero();
		
		
		return cadena;
		
		
	}

	@Override
	public int compare(Object o1, Object o2) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(clsUsuario obj) 
	{
		
		return this.getNombre().compareTo(obj.getNombre());
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsUsuario other = (clsUsuario) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
}
