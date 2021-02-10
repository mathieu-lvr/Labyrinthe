package maze;

import java.util.ArrayList;
import dijkstra.VertexInterface;

/** Abstract class representing a Box **/
public abstract class MBox implements VertexInterface {

	private int x ;
	private int y ;
	private Maze m;
	
	/* To create a box object */
	public MBox(int y,int x,Maze m) {
		this.y = y;
		this.x = x;
		this.m = m;
	}
	
	/*Send back an ArrayList containing every successors */
	public ArrayList<VertexInterface> getSuccessors(){
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		
		if(y>0 && !m.getVertexBox(y-1, x).isWall() ) { //Top successor
			successors.add(m.getVertexBox(y-1, x));
		}
		if(y<m.getNbLines()-1 && !m.getVertexBox(y+1, x).isWall() ) { //Below successor
			successors.add(m.getVertexBox(y+1, x));
		}
		if(x>0 && !m.getVertexBox(y,x-1).isWall() ) { //Left successor
			successors.add(m.getVertexBox(y, x-1));
		}
		if(x<m.getNbColumns()-1 && !m.getVertexBox(y, x+1).isWall() ) { //Right successor

			successors.add(m.getVertexBox(y, x+1));
		}
		
		return successors;

	}
	
	/*Send back the height position of the box*/
	public int getName() {
		return y * m.getNbLines() + x;
	}
	
	/*Send back the height position of the box*/
	public int getY() {
		return y;
	}
	
	/*Set the height position of the box*/
	public void setY(int heigh) {
		this.y = heigh;
	}

	/*Send back the width position of the box*/
	public int getX() {
		return x;
	}

	/*Set the width position of the box*/
	public void setX(int length) {
		this.x = length;
	}
	
	public abstract String getLabel() ;
}