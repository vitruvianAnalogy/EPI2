public class QueueWithMaxIntro{
	private Deque<Integer> data = new LinkedList<>();
	public void enqueue(Integer x){
		data.add(x); // or addlast since queue is first in first out
	}

	public Integer dequeue(){
		return data.removeFirst();
	}

	public Integer max(){
		if(!data.isEmpty()){
			return Collections.max(data); // this one probably takes O(n) since it is part of the library
		}
		// return exception if data is empty, there is no max
	}
}