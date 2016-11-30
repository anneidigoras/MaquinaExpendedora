package LN;

public class clsAlimento  extends clsProducto
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3360300107312162781L;
	
	private String id_A;
	
	clsAlimento()
	{
		super();
		
	}
	
	clsAlimento(String nombre, float precio, String id, clsUsuario usuario)
	{
		super(nombre, precio, usuario);
		
		this.id_A=id;

		
	}

	public String getId_A() {
		return id_A;
	}

	public void setId_A(String id_A) {
		this.id_A = id_A;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
