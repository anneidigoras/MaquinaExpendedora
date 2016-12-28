package LN;

import java.io.Serializable;

public class clsProducto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String nombreP;
	private float precioP;
	private int num; //numero de producto de cada tipo que quedan en la maquina
	//protected clsUsuario usuario;
	
	
	public clsProducto()
	{
		
	}
	public clsProducto(String id,String nombre, float precio, int num)
	{
		this.id = id;
		nombreP=nombre;
		precioP=precio;
		this.num= num;
		
		
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
