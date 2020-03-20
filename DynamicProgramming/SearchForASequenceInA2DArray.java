public class SearchForASequenceInA2DArray{
	
/**
	Suffix string doesn't exist in x,y in the grid
	**/

	/** The attempt object represents that for an attempt starting at x and y,
	a suffix of length "size of suffix" in all directions didn't match
	**/
	class Attempt{
		int x;
		int y;
		int sizeOfSuffix;
	}

	public static boolean isSequenceInGrid(List<Integer> sequence, List<List<Integer>> grid){
		Set<Attempt> previousAttempts = new HashSet<>();
		for(int i=0; i<grid.size(); i++){
			for(int j=0; grid.get(i).size(); i++){
				if(patternExits(grid, i, j, pattern, 0, previousAttempts)){
					return true;
				}
			}
		}
	}

	private static boolean patternExists(List<List<Integer>> grid, 
										int x, 
										int y, 
										List<Integer> pattern, 
										int offset, 
										Set<Attempt> previousAttempts){

		if(pattern.size() == offset){
			//nothing left to compare
			//offset probably stands for the length of the suffix
			return true;
		}
		//Check if x || y lies outside the grid, because then it means it doesn't match
		if(x<0 || y<0 || x>=grid.size() || y>=grid.get(x).size() || previousAttempts.contains(new Attempt(x,y,offset))){ //using previousAttemps here makes this a memoization use hence DP
			return false;
		}

		if(grid.get(x).get(y).equals(pattern.get(offset)) 
			|| patternExists(grid, x-1,y, pattern, offset+1, previousAttempts)
			|| patternExists(grid, x+1,y, pattern, offset+1, previousAttempts)
			|| patternExists(grid, x,y-1, pattern, offset+1, previousAttempts)
			|| patternExists(grid, x,y+1, pattern, offset+1, previousAttempts)){
			return true;
		}
		previousAttempts.add(new Attempt(x,y, offset)); //if no match happened
		return false;
	}
}

//Time complexity is n * m * |size of 1d pattern|