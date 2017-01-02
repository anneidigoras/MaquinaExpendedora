package LP;

import java.util.ArrayList;


import javax.swing.DefaultListModel;

import LN.clsProducto;





public class clsModeloListaProducto extends DefaultListModel<clsProducto>
{
	protected ArrayList<clsProducto>Producto;
	

	  public clsModeloListaProducto (ArrayList<clsProducto> Producto)
	  {
	    this.Producto=Producto;
	  }
	  
	  public clsProducto getElement(int index)
	  {
		return Producto.get(index);
		  
	  }
	  public int getSize() 
	  {
		return Producto.size();
		  
		  
	  }

      public void a�adirElemento(clsProducto elemento)
      {
    	  Producto.add(elemento);
    	  this.fireContentsChanged(this, Producto.size(), Producto.size());
    	  
      }
      
}