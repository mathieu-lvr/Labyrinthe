package maze;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/** represent an empty box **/
public class EBox extends MBox{
	public static  Icon imageEmpty;
	
	public EBox(int y, int x, Maze m) {
		super(y, x, m);
		try {
		imageEmpty = new ImageIcon("data/pictures/EmptyBoxTexture.jpg");
		}
		catch (Exception e) {
	    	System.out.println("The images of the boxes couldn't be loaded");
	    }
	}
	
	public boolean isWall() {
		return false;
	}

	public String getLabel() {
		return "E";
	}
	
	public Icon getImageEmpty() {
		return imageEmpty;
	}
}
