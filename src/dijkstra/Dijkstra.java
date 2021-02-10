package dijkstra;

import java.util.ArrayList;

public final class Dijkstra 
{	
	/** All us to reach the algorithm, and to configure it **/
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		return dijkstra(g, r, new ASet(),new Pi(), new Previous(r));
	}
	
	/** Dijkstra Algorithm **/
	private static PreviousInterface dijkstra(GraphInterface g,VertexInterface r,ASetInterface a,PiInterface pi,PreviousInterface previous)
	{
		a.add(r); //put the root in the a set
		ArrayList <VertexInterface> allVertex = g.getAllVertex();
		int n = allVertex.size(); //number of vertices in the graph
		
		for(VertexInterface y : allVertex) { //initializing the value of pi for every vertexes
				pi.setValue(y, Integer.MAX_VALUE);
		}
		
		pi.setValue(r, 0); //initializing pi(r)=0
		VertexInterface pivot = r;
		
		
		for(int i=1; i<n; i++) {//for every vertexes
			for(VertexInterface y : g.getSuccessors(pivot)) { //for every successor of the pivot
				if( pi.getValue(y) > pi.getValue(pivot) + g.getValuation(pivot, y)) { //we test his valuation
					pi.setValue(y, pi.getValue(pivot) + g.getValuation(pivot, y));
					previous.setPrevious(y, pivot);
				}
			}
			
			int minimum = Integer.MAX_VALUE;
			
			for(VertexInterface y : allVertex) { //searching for every vertexes, the one with the least valuation
				if(!a.contains(y)) {
					if( minimum > pi.getValue(y) ) {
						minimum = pi.getValue(y);
						pivot = y;
					}
				}
			}
			a.add(pivot); //when we find the vertex with the minimum valuation we add it to the set A
		}
		
		return previous;			
	}
}
