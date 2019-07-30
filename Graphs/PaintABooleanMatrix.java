public class PaintABooleanMatrix{
	private static class Coordinate{
		public Integer x;
		public Integer y;

		public Coordinate(Integer x, Integer y){
			this.x = x;
			this.y = y;
		}
	}

	public static void flipColor(List<List<Boolean>> A, int x, int y){
		final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
		boolean color = A.get(x).get(y);//store the initial color

		Queue<Coordinate> queue = new LinkedList<>();
		A.get(x).set(y,!A.get(x).get(y)); //Flip the starting coordinate
		queue.add(new Coordinate(x,y)); //Add the initial coordinate

		//start using bfs by using the queue
		while(!queue.isEmpty()){
			Coordinate current = q.element(); //first element, not pop
			for(int [] dir : directions){
				Coordinate next = new Coordinate(current.x+dir[0],current.y+dir[1]);
				if(next.x>=0 && next.y>=0 && next.x<A.size() && next.y<A.get(next.x).size()
					&& A.get(next.x).get(next.y)==color){
					A.get(next.x).set(next.y,!color);
					queue.add(next);
				}
			}
			queue.remove(); // remove the element once processed
		}

	}
}
