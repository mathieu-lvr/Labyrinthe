package maze;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/** Representation of a boxes, composing the smallest path**/
public class PBox extends MBox {
	public static  Icon imagePath;
	
	public PBox(int y, int x, Maze m) {
		super(y, x, m);
		try {
		imagePath = new ImageIcon("picture/PathBoxTexture.jpg");
		}
		catch (Exception e) {
	    	System.out.println("The images of the boxes couldn't be loaded");
	    }
	}
	
	public boolean isWall() {
		return false;
	}

	public String getLabel() {
		return "P";
	}
	
	public Icon getImagePath() {
		return imagePath;
	}

}