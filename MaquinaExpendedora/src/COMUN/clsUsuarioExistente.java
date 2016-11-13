package COMUN;

public class clsUsuarioExistente extends Exception
{ private final String mensaje = "Ya hay un dni idéntico introducido";

@Override
    public String getMessage()
    {
	return mensaje;
    }

}
