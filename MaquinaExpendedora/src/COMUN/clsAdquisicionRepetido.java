package COMUN;

public class clsAdquisicionRepetido extends Exception{
	private final String mensaje = "Ya hay una adquision identica realizada";

	@Override
	    public String getMessage()
	    {
		return mensaje;
	    }

}
