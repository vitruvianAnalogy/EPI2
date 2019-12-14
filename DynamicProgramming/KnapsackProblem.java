public class KnapsackProblem{
	private static class Item{
		public Integer weight;
		public Integer value;

		public Item(Integer weight, Integer value){
			this.weight = weight;
			this.value = value;
		}
	}

	public static int optimumValueToCapacity(List<Item> items, int capacity){
		/**
		1. Find the memoization array size - We need to find all possible combinations of weight to item
		//Since we make decisions whether to choose a clock or not
		//and the other constraint is the capacity
		//our memoization table or our choices table will show
		//these two combinations
		//hence each item with total capacity
		**/
		int[][] memory = new int[items.size()][capacity+1];
		//initialize the array with -1 to know what choice hasn't
		//been used yet
		for(int[] v : V){ //iterate through each single dimension of array
			Arrays.fill(v, -1); //Fill the single dimensional array with -1
		}

		return optimumValueToItemAndCapacity(items, items.size() -1, capacity, V);
	}

	private static int optimumValueToItemAndCapacity(List<Item> items,
		int k,
		int availableCapacity,
		int[][] V){

		if(k<0){
			return 0; //beyond the limits of the memory
		}

		//if we haven't encountered this choice
		if(V[k][availableCapacity] == -1){
			//items don't change, k-1 -> one less item to choose from
			//availableCapacity still full because didn't choose this item
			//memory table
			int withoutCurrentItem = optimumValueToItemAndCapacity(items, k-1, availableCapacity, V);

			int weightOfCurrentItem = items.get(k).weight;
			boolean notEnoughSpace = (availableCapacity < weightOfCurrentItem)
			int withCurrentItem;
			if(notEnoughSpace){
				withCurrentItem = 0;
			} else {
				withCurrentItem = weightOfCurrentItem 
					+ optimumValueToItemAndCapacity(items, k-1, availableCapacity - weightOfCurrentItem, V);
			}
			V[k][availableCapacity] = Math.max(withCurrentItem, withoutCurrentItem);
		}
		return V[k][availableCapacity];

	}
}