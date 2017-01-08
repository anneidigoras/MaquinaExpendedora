package LN;

public class clsBebida extends clsProducto
{

/**
	 * Clase que here
	 */
	private static final long serialVersionUID = 127134869965129608L;
	private int miliL;
	private String caracteristica;
	


	clsBebida (String nombre, float precio, String id, int ml,String carac ,int num)
    {
    	super(id, nombre, precio, num);
    	
    	
    	miliL = ml;
    	this.caracteristica= carac;
    	
    }
	
    
	public int getMiliL() {
    	return miliL;
    }
    public void setMiliL(int miliL) {
		this.miliL = miliL;
	}

    public String getCaracteristica() {
    	return caracteristica;
    }
    
    public void setCaracteristica(String caracteristica) {
    	this.caracteristica = caracteristica;
    }
	
	
	public clsBebida()
	{
		super();
		
	}
	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}