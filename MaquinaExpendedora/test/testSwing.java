



import javax.swing.JFrame;

import junit.framework.TestCase;

public class testSwing extends TestCase 
{
 
	private JFrame testFrame;
	
	  protected void tearDown(  ) throws Exception 
	  {
	        if (this.testFrame != null) {
	            this.testFrame.dispose(  );
	            this.testFrame = null;
	        }
	    }
	  
	  public JFrame getTestFrame(  ) {
	        if (this.testFrame == null) {
	            this.testFrame = new JFrame("Test");
	        }
	        return this.testFrame;
	    }


    }
