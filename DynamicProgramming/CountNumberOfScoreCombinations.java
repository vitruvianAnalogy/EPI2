public class CountNumberOfScoreCombinations{
	public int count(int final, List<Integer> scores){
		int[][] numberOfCombinations = new int[scores.size()][final+1];
		for(int i =0 ; scores.size(); i++){
			numberOfCombinations[i][0] = 1;
			for (int j=1; j<=finalscore; j++ ){
				int withoutThis = i-1>=0 ? numberOfCombinations[i-1][j];
				int withThis = (j>=scores.get(i)) ? numberOfCombinations[i][j-scores.get(i)] : 0;
				numberOfCombinations = withThis + withoutThis;
			}
		}
		return numberOfCombinations[scores.size() - 1][final];
	}	
}