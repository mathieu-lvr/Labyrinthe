package ui;

import java.awt.*;
import javax.swing.*;

/** Window where we display the maze **/
public final class MazePanel extends JPanel {
	private final MazeApp mazeApp;
	private int dimY;
	private int dimX;

	
	/**Table of button corresponding of the maze boxes**/
	private BoxPanel[][] boxes;
	
	public MazePanel(MazeApp mazeApp){
		super();
		setPreferredSize(new Dimension(512,512));	
		dimY = mazeApp.getModel().getDimY();
		dimX = mazeApp.getModel().getDimX();
		this.mazeApp = mazeApp;
		gridLayoutInit();
		initBoxPanels();
		drawMaze();
	}
	
	public void initBoxPanels(){
		BoxPanel[][] b = new BoxPanel[dimY][dimX];
		for(int line=0;line<dimY;line++) {
			for(int column=0;column<dimX;column++) {
				b[line][column] = new BoxPanel(mazeApp,column,line);
			}
		}
		boxes = b;
	}
	
	public void gridLayoutInit() {
		setLayout(new GridLayout(dimY,dimX));
	}
	
	public void drawMaze() {
		for(int line=0;line<dimY;line++) {
			for(int column=0;column<dimX;column++) {
				add(boxes[line][column]);
				boxes[line][column].repaint();
			}
		}
	}

	public BoxPanel[][] getBoxes() {
		return boxes;
	}
	
}
