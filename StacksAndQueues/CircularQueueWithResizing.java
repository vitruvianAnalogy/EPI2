public static class Queue{
	private int head = 0, tail = 0, numQueueElements = 0;
	private static final int SCALE_FACTOR = 2;
	private Integer[] entries; // Notice this is an array,  not arrayList

	public Queue(int capacity){
		entries = new Integer[capacity];
	}

	public void enqueue(Integer n){
		if(numQueueElements == entries.length){ //array is full
			Collections.rotate(Arrays.asList(entries), -head);
			head = 0;
			tail = numQueueElements;
			entries = Arrays.copyOf(entries, numQueueElements + SCALE_FACTOR);
		}

		entries[tail] = n;
		tail = (tail + 1) % entries.length;
		++numQueueElements;
	}

	public Integer dequeue(){
		if(numQueueElements != 0){
			--numQueueElements;
			Integer ret = entries[head];
			head = (head+1)%entries.length;
			return ret;
		}
		System.out.println("Queue is empty");
	}

	public int size(){
		return numQueueElements;
	}
}