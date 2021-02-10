package dijkstra;

import java.util.ArrayList;

public interface VertexInterface { //interface de l'ensemble des sommets
	/** Get the label of a vertex : A,D,E,W**/
    public String getLabel();
    
    /** Give us the name of an object by his position: dim * posY + posX **/
    public int getName();

    /** Test if the vertex is a wall **/
    public boolean isWall();

    /** Send the vertex successors **/
    public ArrayList<VertexInterface> getSuccessors();
	
	
}
