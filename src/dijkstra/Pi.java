package dijkstra;

import java.util.Hashtable;
/** represent the valuation for every vertices**/
public final class Pi implements PiInterface{
	
	private Hashtable<VertexInterface, Integer> hTable;
	
	public Pi()
	{
		hTable = new Hashtable<VertexInterface, Integer>();
	}
	/** Put a new value Pi(y)**/
	public void setValue(VertexInterface vertex, int value) 
	{
		hTable.put(vertex, new Integer(value));
	}
	/** Send back Pi(y) value**/
	public int getValue(VertexInterface vertex) 
	{
		return hTable.get(vertex).intValue();
	}	

}
