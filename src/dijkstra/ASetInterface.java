package dijkstra;
/**interface cantrolling the set of vertices**/
public interface ASetInterface { 
	/**Add the pivot value **/
	public void add(VertexInterface y);
	
	/** search if y is a value of the set A (0:yes , 1:no)**/
	public boolean contains(VertexInterface y);
}
