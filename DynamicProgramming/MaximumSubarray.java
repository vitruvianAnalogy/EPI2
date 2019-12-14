//This might not look like an example of DP but it is
//we are using three variables to store info - caching
//then we solving the same subproblem and fixing it.
//we are using the solutions stored in the cache
//and reusing them in the future.

public class MaximumSubarray{
	public static int findMaximumSubarray(List<Integer> list){
		int minSum = 0, sum = 0, maxSum = 0;
		for(int i =0; i<list.size(); ++i){
			sum += list.get(i); //we add everything, negative integers as well
			
			//we'll keep adding the sum unless the sum is decreasing
			//sum will only decrease if a digit is negative
			//Hence the idea to store minSum, otherwise
			//minSum will stay 0 and the subtraction will lead 
			//to nothing
			if(sum< minSum){
				minSum = sum;
			}
			if(sum - minSum > maxSum){
				maxSum = sum - minSum; // we'll remove the negative integers
			}
		}
		return maxSum; //what's left is max Sum - Sliding window algo
	}
}