public class QueueWithMaxAPI<T extends Comparable<T>>{

	private Queue<T> entries = new ArrayDeque<>();

	private Deque<T> candidatesForMax = new ArrayDeque<>();

	public void enqueue(T data){
		entries.add(data);
		while(!candidatesForMax.isEmpty() && candidatesForMax.getLast().compareTo(data) < 0){
			candidatesForMax.removeLast();
		}
		candidatesForMax.addLast(data);
	}

	public T dequeue(){
		if(!entries.isEmpty()){
			T result = entries.remove();
			if(candidatesForMax.equals(result)){
				candidatesForMax.remove();
			}
			return result;
		}
		// else exception
	}

	public Integer max(){
		if(!candidatesForMax.isEmpty()) {
			return candidatesForMax.getFirst();
		}
		//else exception
	}
}