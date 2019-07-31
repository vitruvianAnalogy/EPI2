// An edge between vertices A and B represent A blocked on B
// A cycle in the graph will mean a "deadlock"
public class DeadlockDetection{
	//THe input will be a directed graph

	//When we are processing a vertex, 
	//we can give it a color that means being processed
	//If we come across another vertex that has the same color
	//that means that vertex is also being processed. 
	//Since our previous vertex processing hasn't finished means,
	//this new vertex is one of the older vertices that is still
	//in process, hence a cycle.

	private static class GraphVertex{
		public static enum Color{WHITE;GRAY;BLACK}

		public Color color;
		public List<GraphVertex> edges;
	}

	public static boolean isDeadlocked(List<GraphVertex> vertices){
		//We go through each vertex
		//If a vertex is not white, then it means it hasn't been processed
		//the next thing we check is if it has a cycle
		//if it has a cycle and it is white, then it means
		//it is deadlocked
		for(GraphVertex vertex : vertices){
			if(vertex.color == GraphVertex.Color.WHITE && hasCycle(vertex)){
				return true;
			}
		}

		//If none of the vertices are part of a deadlock then none of
		//the process is deadlocked
		return false;
	}

	private static boolean hasCycle(GraphVertex vertex){
		//If the vertex is already under check, hence cycle is present
		//hence deadlock
		if(vertex.color == GraphVertex.Color.GRAY){
			return true;
		}

		//otherwise mark as being processed, update the color
		//and go down all the edges to see if it has a cycle
		vertex.color = GraphVertex.Color.GRAY;
		for(GraphVertex next : vertex.edges){
			if(next.color != GraphVertex.Color.BLACK && hasCycle(next)){
				return true;
			}
		}

		//We have reached here means that no cycle was encountered 
		//and we have finished processing the vertex, hence the
		//change in vertex color to black
		vertex.color = GraphVertex.Color.BLACK;
		//and return false for having a cycle.
		return false;
	}

}