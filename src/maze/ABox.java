package maze;

import javax.swing.Icon;
import javax.swing.ImageIcon;



/** Representation of an arrival Box **/
public class ABox extends MBox {
	public static Icon imageArrival;
	
	public ABox(int y, int x, Maze m) {
		super(y, x, m);
		try {
		imageArrival = new ImageIcon("picture/ArrivalBoxTexture.PNG");//Load of the picture
		System.out.println("image loaded");
		}
		catch (Exception e) {
	    	System.out.println("The images of the boxes couldn't be loaded");
	    }
	}
	
	private void setImage() {
		// TODO Auto-generated method stub
		
	}

	public boolean isWall() {
		return false;
	}

	public String getLabel() {
		return "A";
	}
	
	public Icon getImageArrival() {
		return imageArrival;
	}
}
