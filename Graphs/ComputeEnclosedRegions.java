// W represents White cell
public class ComputeEnclosedRegions{
	private static class Coordinate{
		public Integer x;
		public Integer y;

		public Coordinate(Integer x, Integer y){
			this.x = x;
			this.y = y;
		}
	}

	public static void fillSurroundedRegions(List<List<Character>> board){
		for(int i =0; i<board.size(); i++){
			//Left Boundary
			if(board.get(i).get(0)=='W'){
				markRegionsThatAreAdjacentToBoundary(i,0, board);
			}
			//Right Boundary
			if(board.get(i).get(board.get(i).size()-1) == 'W'){
				markRegionsThatAreAdjacentToBoundary(i, board.get(i).size()-1, board);
			}
		}
		for(int j = 0; j<board.get(0).size(); j++){
			//Top Boundary
			if(board.get(0).get(j) == 'W'){
				markRegionsThatAreAdjacentToBoundary(0, j, board);
			}
			//Bottom Boundary
			if(board.get(board.get(0).size()-1).get(j) == 'W'){
				markRegionsThatAreAdjacentToBoundary(board.get(0).size()-1, j, board);
			}
		}
	}

	public static void markRegionsThatAreAdjacentToBoundary(int i, int j, List<List<Character>> board){
		Queue<Coordinate> queue = new LinkedList<>();
		int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

		queue.add(new Coordinate(i,j));
		while(!q.isEmpty()){
			Coordinate current = queue.poll();
			if(current.x>0 && current.y >0 
				&& current.x <= board.size()-1 
				&& current.y <= board.get(0).size()-1
				&& board.get(current.x).get(current.y) == 'W'){
				board.get(current.x).set(current.y, 'B');
				queue.add(new Coordinate(current.x + 1, current.y));
				queue.add(new Coordinate(current.x, current.y + 1));
				queue.add(new Coordinate(current.x - 1, current.y));
				queue.add(new Coordinate(current.x, current.y - 1));
			}
		}
	}
}