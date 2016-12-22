package LN;

public class clsAdministrador 
{
	public static boolean existe= false;
	private String contraseña;
	private String nombre;
	public static String Correo;
	

	clsAdministrador()
	{
		contraseña="";
		nombre="";
	}

	public String getCorreo() {
		return Correo;
	}
	
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		clsAdministrador other = (clsAdministrador) obj;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
	

}