package dijkstra;
import java.util.ArrayList;

/**interface of the graph**/
public interface GraphInterface { //interface of the graph
	/** Send every vertexes of the graph**/
	public ArrayList<VertexInterface> getAllVertex();
	
	/** Send vertexes successors of a vertex **/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface S);
	
	/** Send the size of a graph**/
	public int getSize();
	
	/** sending the valuation between two vertexes**/
	public int getValuation(VertexInterface x, VertexInterface y);
	
}
