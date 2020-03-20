public class CloneAGraph{

	private static class GraphVertex{
		public Integer label;
		public List<GraphVertex> vertices;

		public GraphVertex(Integer label){
			this.label = label;
			vertices = new ArrayList<>();
		}
	}

	public static GraphVertex cloneGraph(GraphVertex g){
		if(g == null)
			return g;
		Map<GraphVertex, GraphVertex> map = new HashMap<>();
		Queue<GraphVertex> queue = new LinkedList<>();
		queue.add(g);
		map.put(g, new GraphVertex(g.label));
		while(!q.isEmpty()){
			GraphVertex current = q.remove();
			for(GraphVertex vertex : current.vertices){
				if(!map.contains(vertex)){
					map.put(vertex,new GraphVertex(vertex.label));
					q.add(vertex);
				}
				map.get(current).vertices.add(map.get(vertex)); //add vertices to the vertices list
			}
		}

		return map.get(g);
	}
}