package dijkstra;

import java.util.ArrayList;
	/**Interface of the predecessor of the vertices**/
public interface PreviousInterface { 
	/** Define a new predecessor y**/
	public void setPrevious(VertexInterface y, VertexInterface pere);
	
	/** Send back the name of a predecessor**/
	public VertexInterface getPrevious(VertexInterface vertex);
	
	/**Send back the shortest path to get to the vertex**/
	public ArrayList <VertexInterface> getShortestPathTo(VertexInterface vertex);
}
