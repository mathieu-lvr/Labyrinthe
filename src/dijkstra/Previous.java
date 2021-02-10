package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/** Allow us to know every precedessor for each vertices**/
public final class Previous implements PreviousInterface {
	private Hashtable<VertexInterface, VertexInterface> hTable; 
	private VertexInterface racine = null;

	public Previous(VertexInterface racine)
	{
		hTable = new Hashtable<VertexInterface, VertexInterface>();
		this.racine = racine;
	}
	/** Define a new predecessor y**/
	public void setPrevious(VertexInterface vertex, VertexInterface previous) 
	{
		hTable.put(vertex, previous);
	}
	
	/** Send back the name of the predecessor of a vertex**/
	public VertexInterface getPrevious(VertexInterface vertex) 
	{
		return hTable.get(vertex);
	}
	/**Send back the shortest path to get to the vertex**/
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) 
	{
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();
		VertexInterface v = vertex;
		path.add(vertex);
		
		while (v != null && v != racine) {
			v = getPrevious(v);
			if (v != null) {
				path.add(v);
			}
		}

		return path;
	}
}
	
