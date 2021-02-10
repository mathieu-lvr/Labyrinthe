package dijkstra;

import java.util.HashSet;

/**Set of studied vertices **/
public final class ASet implements ASetInterface {
	private final HashSet<VertexInterface> aSet;
	
	
	public ASet() 
	{
		aSet = new HashSet<VertexInterface>();
	}
	/**Add the pivot value **/
	public void add(VertexInterface vertex)
	{
		aSet.add(vertex);
	}
	
	/** search if y is a value of the set A (0:yes , 1:no)**/
	public boolean contains(VertexInterface vertex)
	{
		return aSet.contains(vertex);
	}
}
