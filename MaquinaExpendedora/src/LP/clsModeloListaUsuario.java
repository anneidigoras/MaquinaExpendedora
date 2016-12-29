package LP;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;

import LN.clsUsuario;





public class clsModeloListaUsuario extends DefaultListModel<clsUsuario>
{
	protected ArrayList<clsUsuario>Usuario;
	

	  public clsModeloListaUsuario (ArrayList<clsUsuario> Usuario)
	  {
	    this.Usuario=Usuario;
	  }
	  
	  public clsUsuario getElement(int index)
	  {
		return Usuario.get(index);
		  
	  }
	  public int getSize() 
	  {
		return Usuario.size();
		  
		  
	  }

      public void añadirElemento(clsUsuario elemento)
      {
    	  Usuario.add(elemento);
    	  this.fireContentsChanged(this, Usuario.size(), Usuario.size());
    	  
      }
      
}
