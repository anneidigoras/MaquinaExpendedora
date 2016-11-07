package LN;

import java.io.Serializable;

public class clsProducto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombreP;
	private float precioP;
	
	
	public clsProducto()
	{
		
	}
	public clsProducto(String nombre, float precio)
	{
		nombreP=nombre;
		precioP=precio;
		
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public float getPrecioP() {
		return precioP;
	}

	public void setPrecioP(float precioP) {
		this.precioP = precioP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
