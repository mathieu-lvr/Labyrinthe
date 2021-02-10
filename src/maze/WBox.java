package maze;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/** Representing a Wall box **/
public class WBox extends MBox{
	public static Icon imageWall;
	

	public WBox(int y, int x, Maze m) {
		super(y, x, m);
		try {
		imageWall = new ImageIcon("picture/WallTextureBox.png");
		}
		catch (Exception e) {
	    	System.out.println("The images of the boxes couldn't be loaded");
	    }
		}

	public boolean isWall() {
		return true;
	}

	public String getLabel() {
		return "W";
	}
	
	public Icon getImageWall() {
		return imageWall;
	}

}
