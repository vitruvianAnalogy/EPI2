public class ComputeTheBinomialCoefficient{
	//why do we use static for all these tests
	//because we usually test these methods from the
	//public static void main method
	//And that method is static.

	//    ( n )
	//		k
	public static int binomialCoefficient(int n, int k){
		int[][] memory = new int[n+1][k+1]; //we usually create an array of size n,k
		//because we map out each choice which means n,k is the largest choice space.

		//the memoization array is made to keep track of the combination of choices
		//in an array m,n, ..for every 1....m, we have a 1...n

		return computeCoefficient(n,k,memory);
	}

	private static int computeCoefficient(int n, int k, int[][]mem){
		if(n==0 || k==n){
			return 1;
		}
		if(mem[n][k] == 0){
			/**
			without k, we'll compute a k-sized subset in (n-1) sized set
			**/
			int withoutk = computeCoefficient(n-1, k, mem);
			/**
			with k, we'll compute a (k-1)-sized subset in (n-1) sized set
			**/
			int withK = computeCoefficient(n-1, k-1, mem);
			mem[n][k] = withoutK + withK;
		}
		return mem[n][k];
	}
}