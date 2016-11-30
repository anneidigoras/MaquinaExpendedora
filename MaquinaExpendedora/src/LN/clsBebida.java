package LN;

public class clsBebida extends clsProducto
{

/**
	 * 
	 */
	private static final long serialVersionUID = 127134869965129608L;
	private int miliL;
	private String caracteristica;
	private int num; //numero de bebidas de cada tipo que quedan en la maquina


	clsBebida (String nombre, float precio, String id, int ml, String carac, clsUsuario usuario)
    {
    	super(nombre, precio, usuario);
    	
    	this.id_B=id;
    	miliL = ml;
    	this.caracteristica= carac;
    	num = COMUN.clsConstantes.NUM_INICIAL_BEBIDAS;
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
