package LN;

public class clsAlimento  extends clsProducto
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3360300107312162781L;
	
	private int gramos;
	
	clsAlimento()
	{
		super();
		
	}
	
	clsAlimento(String nombre, float precio, String id, int gramos, int num)
	{
		super(id,nombre, precio,num);
		
		this.gramos = gramos;

		
	}

	
	public int getGramos() {
		return gramos;
	}

	public void setGramos(int gramos) {
		this.gramos = gramos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
