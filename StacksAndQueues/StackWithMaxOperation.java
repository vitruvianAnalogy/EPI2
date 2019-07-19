public class StackWithMaxOperation{
	private Deque<Integer> elements = new ArrayDeque<>();
	private Deque<MaxWithCount> cachedMaxWithCount = new ArrayDeque<>();

	private boolean empty(){
		return elements.isEmpty();
	}
	public Integer max(){
		if(empty()){
			//throw exception
		}
		//if not empty
		return cachedMaxWithCount.peekFirst().max(); //peek the top element. top is max
	}

	//take out the top element
	public Integer pop(){
		if(empty()){
			//throw exception, nothing to pop
		}
		//if not empty
		Integer top = elements.removeFirst(); //remove the top element, ofcourse, but what about max
		//we check if top matches the max, if not then there is probably a bigger max
		//after top, i.e. top was never max, hence never saved
		if(cachedMaxWithCount.peekFirst().max.equals(top)){
			cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count -1;
		}
		if(cachedMaxWithCount.peekFirst().count.equals(0)){
			cachedMaxWithCount.removeFirst();//if count is zero then remove the element
		}

		return top;
	}

	public void push(Integer x){
		//add x to the top of the elements
		elements.addFirst(x);

		//lets add max if possible
		if(!cachedMaxWithCount.isEmpty()){
			if(Integer.compare(x, cachedMaxWithCount.peekFirst().max) == 0){
				//if new element is equal to the max
				cachedMaxWithCount.peekFirst().count = 
					cachedMaxWithCount.peekFirst().count + 1;
			} else if (Integer.compare(x, cachedMaxWithCount.peekFirst().max)>1){
				//if new element is bigger than the max, then update the max and the count
				cachedMaxWithCount.addFirst(new MaxWithCount(x,1));
			}
			//if new element is less than max, then we don't need to add it
			//because it is never bigger than max
		} else {
			cachedMaxWithCount.addFirst(new MaxWithCount(x,1));
		}
	}
}

//What is the maximum number and how many times it occur
private static class MaxWithCount{
	public Integer max;
	public Integer count;

	public MaxWithCount(Integer max, Integer count){
		this.max = max;
		this.count = count;
	}
}