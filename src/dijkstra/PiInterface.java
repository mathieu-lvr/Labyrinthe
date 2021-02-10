package dijkstra;

/**interface de le fonction pi**/
public interface PiInterface { 
	/** Send back Pi(y) value**/
	public int getValue(VertexInterface y);
	
	/** Put a new value Pi(y)**/
	public void setValue(VertexInterface y, int n);
}
