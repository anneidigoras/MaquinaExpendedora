package LN;

public class clsBebida extends clsProducto
{

/**
	 * 
	 */
	private static final long serialVersionUID = 127134869965129608L;
	private int miliL;
    public int getMiliL() {
		return miliL;
	}

    clsBebida (String nombre, float precio, String id, int ml)
    {
    	super(nombre, precio);
    	
    	this.id_B=id;
    	miliL = ml;
    }
	
    public void setMiliL(int miliL) {
		this.miliL = miliL;
	}

	private String id_B;
	
	clsBebida()
	{
		super();
		
	}
	

	public String getId_B() {
		return id_B;
	}

	public void setId_B(String id_B) {
		this.id_B = id_B;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
