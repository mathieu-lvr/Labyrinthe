package maze;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/** Represent a departure box**/
public class DBox extends MBox {
	public static  Icon imageDeparture;
	
	public DBox(int y, int x, Maze m) {
		super(y, x, m);
		try {
		imageDeparture = new ImageIcon("picture/DepartureBoxTexture.png");
		}
		catch (Exception e) {
	    	System.out.println("The images of the boxes couldn't be loaded");
	    }
	}
	
	public boolean isWall() {
		return false;
	}

	public String getLabel() {
		return "D";
	}
	
	public Icon getImageDeparture() {
		return imageDeparture;
	}
}

	
