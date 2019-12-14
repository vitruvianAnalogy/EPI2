public class FibonacciUsingDP{
	private static Map<Integer, Integer> map = new HashMap<>();
	public static int findNthFibonacci(int n){
		if(n<=1){
			return n;
		} else if(!cache.contains(n)){
			cache.put(n, findNthFibonacci(n-2)+findNthFibonacci(n-1));
		}
		return cache.get(n);
	}
	/**
	* Bottom up uses only two extra space
	**/
	public static int bottomUp(int n){
		if(n<=1){
			return n;
		}
		int fMinus1 = 1;
		int fMinus2 = 0;
		for(int i=2; i<=n; ++i){
			int f = fMinus1 + fMinus2;
			fMinus2 = fMinus1;
			fMinus1 = f;
		}
		return fMinus1;
	}
}
