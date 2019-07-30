//Black and white digitized image of a maze.
//Black and white matrix

//Find a path from entrance to exit.
//Knowing full well that BFS and DFS both work well with identifying paths.

//We are given entry, and exit points.
//Reminds me of match result problem
//But instead of list of matches (adjacency list), we get adjacency matrix
public class SearchAMaze{
	public static enum Color { WHITE; BLACK}
	static class Coordinate{
		public int x, y;

		public Coordinate(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o){
			if(this == o)
				return true;

			if(o == null || getClass() != o.getClass()){
				return false;
			}

			Coordinate that = (Coordinate)o;
			if( x!=that.x || y!=that.y){
				return false;
			}
			return true;
		}

		@Override
		public int hashCode(){
			return Objects.has(x,y); // generates a hashcode of a sequence of input values
		}
	}

	//Maze is made as a list of list of color, not the coordinates.
	//Coordinates come after
	public static List<Coordinate> searchMaze(List<List<Color>> maze, 
											Coordinate source, Coordinate exit){
		List<Coordinate> path = new ArrayList<>();
		//Pass the path array into the method
		if(!searchMazeHelperDFS(maze,source, exit, path)){
			return Collections.EMPTY_LIST;
		}
		return path;
	}

	private static boolean searchMazeHelperDFS(List<List<Color>> maze, Coordinate current,
		Coordinate exit, List<Coordinate> path){
		//if not within limits or white, then false
		if(!isFeasible(current, maze)){
			return false;
		}
		path.add(current); // add to path
		//Once current is added into the path, we will change its color to BLACK
		//this means that we can't visit this vertex again.
		//Instead of using a separate hashmap to store visited nodes, 
		//we'll just use the color value 
		//Maze's x coordinate will have a y coordinate set and its color will be 
		//BLACK
		maze.get(current.x).set(current.y, Color.BLACK);
		if(current.equals(exit)){
			return true;
		}

		//move in all directions
		final int[][] SHIFT = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int[] s : SHIFT){
			if(searchMazeHelperDFS(maze,new Coordinate(current.x+s[0], current.y + s[1]), exit, path)){
				return true;
			}
		}
		//Cannot find a path, remove entry added in path.add(current)
		path.remove(path.size()-1);
		return false;
	}

	//If coordinates is within limits and is WHITE
	private static boolean isFeasible(Coordinate current, List<List<Color>> maze){
		return current.x > 0 && current.x < maze.size() && current.y >= 0
		&& current.y < maze.get(current.x).size()
		&& maze.get(current.x).get(current.y) == Color.WHITE;
	}
}



