package LN;

import java.io.Serializable;

public class clsAdquisicion implements Serializable
{
	private String id_producto, dni_usuario, nombre_p, nombre_u;
	

	public String getNombre_p() {
		return nombre_p;
	}

	public void setNombre_p(String nombre_p) {
		this.nombre_p = nombre_p;
	}

	public String getNombre_u() {
		return nombre_u;
	}

	public void setNombre_u(String nombre_u) {
		this.nombre_u = nombre_u;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}
	
	public clsAdquisicion()
	{
		
		
	}
	public clsAdquisicion(String id_p, String id_u, String nmb_p, String nmb_u)
	{
		this.id_producto= id_p;
		this.dni_usuario = id_u;
		this.nombre_p= nmb_p;
		this.nombre_u= nmb_u;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni_usuario == null) ? 0 : dni_usuario.hashCode());
		result = prime * result + ((id_producto == null) ? 0 : id_producto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsAdquisicion other = (clsAdquisicion) obj;
		if (dni_usuario == null) {
			if (other.dni_usuario != null)
				return false;
		} else if (!dni_usuario.equals(other.dni_usuario))
			return false;
		if (id_producto == null) {
			if (other.id_producto != null)
				return false;
		} else if (!id_producto.equals(other.id_producto))
			return false;
		return true;
	}
	

}
