package LN;

public class clsUsuario
{

	private String nombre; 
	private int edad;
	private String genero;
	private float dinero;
	
	public clsUsuario()
	{
		nombre="";
		edad=0;
		genero="";
		dinero=0;
		
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
	
	public  String toString()
	{
		String cadena;
		
		cadena= "Al usuario: "+ this.getNombre()+ "le queda el sigiente saldo: " + this.getDinero();
		
		
		return cadena;
		
		
	}
	
	
}
