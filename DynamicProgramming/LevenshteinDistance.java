public class LevenshteinDistance{
	public static int levenshtein(String a, String b){
		//Memoization - We need a 2D array - Do we always need 2D array? Read up on this
		int [][] distance = new int[a.length][b.length];

		for(int[] row : distance){
			Arrays.fill(row,-1); // Fill each array with -1 //Default value
		}		

		return computeDistanceBetween(a, a.length-1, b, b.length-1, distance); //the cache needs to be passed
	}

	public static int computeDistanceBetween(String a, int lastIndexOfA, String b, int lastIndexOfB, int[][] distance){
		if(lastIndexOfA) // we are going from the end of the string to the first. -  - why? not sure
		{
			return lastIndexOfB + 1; //if we have deleted all of A's alphabets, then that means now we'll need to replace all of B's remaining alphabets
		}
		if(lastIndexOfB){
			return lastIndexOfA + 1; //same as above for B
		}
		if(distance[lastIndexOfA][lastIndexOfB] == -1){ //that we haven't compared these two indexes in A and B respectively, otherwise -1 would have been replaced
			if(a.charAt(lastIndexOfA) == b.charAt(lastIndexOfB)){ // if both alphabets are same then we dont need to do any "edits"
				distance[lastIndexOfA][lastIndexOfB] = computeDistanceBetween(a,lastIndexOfA-1, b, lastIndexOfB-1, distance);
			}
			else {
				int substitute = computeDistanceBetween(a,lastIndexOfA-1, b, lastIndexOfB-1, distance);

				int insert = computeDistanceBetween(a,lastIndexOfA, b, lastIndexOfB-1, distance); //a's length doesn't decrease because we add

				int delete = computeDistanceBetween(a,lastIndexOfA-1, b, lastIndexOfB, distance); //both don't get decrement, because after
				//deletion we wanna check the next alphabet with B's current alphabet

				distance = 1 + Math.min(substitute, Math.min(insert, delete)); //choose which choice led to minimum edit
			}
		}
		return distance[lastIndexOfA][lastIndexOfB];
	}
}

/*Time complexity = number of states * cost.
Since cost of each step is 1 in our problem, time complexity is a.b where a and b are length of the strings A and B

Space complextiy = we will store each state, meaning number of states = a.b

i.e. time complexity = ab
space complexity = ab
*/