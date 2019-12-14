public class ComputeTheNumberOfWaysToTraverseA2DArray{
	int count = 0;
	int x;
	int y;

	//Time complexity - O(2^x + 2^y)
	public int recursivelyChartAllPathsBruteForce(int[][] array){
		x = array.length;
		y = array[0].length;

		if(x==0 && y==0){
			return 1;
		}

		if(x==1 || y==1){
			return 1;
		}

		return recurse(1, 0) + recurse(0, 1);
	}

	private int recurse(int x, int y){
		if(x==this.x || y== this.y)
			return 0;
		if(x==this.x-1 && y==this.y-1 && x<this.x && y<this.y){
			return 1;
		} else {
			return recurse(x+1,y) + recurse(x,y+1);
		}
	}

	public static void main(String[] args){
		ComputeTheNumberOfWaysToTraverseA2DArray obj = new ComputeTheNumberOfWaysToTraverseA2DArray();
		int[][] array = new int[4][4];
		System.out.println(obj.recursivelyChartAllPathsBruteForce(array));
	}

	/////////////////////////////////////////////////////////////////

	public static int dpWayOfComputingPaths(int x, int y){
		int [][] memory = new int[x][y];
		//m and n are the size of array, 
		//i.e. m-1 and n-1 are last index of the array
		computeNumberOfWays(m-1,n-1, memory);
	}

	private int computeNumberOfWays(int indexX, int indexY, int[][]path){
		if(indexX==0 || indexY==0){
			//we have reached the top row
			//we have reached the first col
			//if you are at one of these areas
			//then that means there are not going to be 
			//any more paths, because you can
			//only go backwards or upwards
			return 1;
		}
		//if we haven't counted the paths for this index
		if(path[indexX][indexY] == 0){
			//compute path
			int waysTop = (x==0)? 0 : computeNumberOfWays(indexX-1, indexY, path);
			int waysLeft = (y==0)? 0 : computeNumberOfWays(indexX, indexY-1, path);
			path[indexX][indexY] = waysTop + waysLeft;
		}
		return path[x][y]; //at this index what was the number of paths computed  
	}
}

//The difference between the brute force and path[x][y] is that in dp we are storing
//the number of paths instead of brute force where we are counting our visits if 
//a new path is forged.