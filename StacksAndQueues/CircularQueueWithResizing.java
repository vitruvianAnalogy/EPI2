public static class Queue{
	private int head = 0, tail = 0, numQueueElements = 0;
	private static final int SCALE_FACTOR = 2;
	private Integer[] entries; // Notice this is an array,  not arrayList

	public Queue(int capacity){
		entries = new Integer[capacity];
	}

	public void enqueue(Integer n){
		///Increase the size of the array when array is full
		if(numQueueElements == entries.length){ //array is full
			Collections.rotate(Arrays.asList(entries), -head); // we are rotating
			//by head, in case the easier cells of the array are empty.
			head = 0;
			tail = numQueueElements;
			entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR); // increase
			//the size of the arrays.
		}

		entries[tail] = n;
		tail = (tail + 1) % entries.length; //if tail was 10, then now tail is (10+1)%(20),
		//because entries.length is 20 since it got doubled, so that modulus
		//will only return 11%20 i.e. 11
		++numQueueElements;
	}

	public Integer dequeue(){
		if(numQueueElements != 0){
			--numQueueElements;
			Integer ret = entries[head];
			head = (head+1)%entries.length; //We are just moving the head forward, whenever an element is dequeued
			//If head is 1, then head becomes 2 on dequeue...
			//WHat do we do for all the empty spaces....
			//Well, we are ROTATING, that pushes the empty spaces back.
			return ret;
		}
		System.out.println("Queue is empty");
	}

	public int size(){
		return numQueueElements;
	}
}