package LN;

public class clsUsuario
{

	private String nombre; 
	private String apellido;
	private int edad;
	private String genero;
	private float dinero;
	private String dni;
	
	
	public clsUsuario(String nombre2, String apellido1, String dNI2, int edad2, float dinero2)
	{
		nombre="";
		edad=0;
		genero="";
		dinero=COMUN.clsConstantes.DINERO_INICIAL;
		apellido="";
		dni="";
		
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

	public  String toString()
	{
		String cadena;
		
		cadena= "Al usuario: "+ this.getNombre()+"  "+ this.getApellido()+" le queda el sigiente saldo: " + this.getDinero();
		
		
		return cadena;
		
		
	}
	
	
}
