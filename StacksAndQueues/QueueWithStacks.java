//We will need two stacks

public class QueueWithStacks{
	private Deque<Integer> enqueue = new ArrayDeque<Integer>();
	private Deque<Integer> dequeue = new ArrayDeque<Integer>();

	public void enqueue(Integer x){
		enqueue.addFirst(x); //Add like stack. First element will be at the bottom of stack
	}

	public Integer dequeue(){
		if(dequeue.isEmpty()){
			//Transfer all the elements from enqueue stack to dequeue stack
			while(!enqueue.isEmpty()){
				dequeue.addFirst(enqueue.removeFirst());
			}
		}
		//if dequeue is not empty then it means all the elements
		//from enqueue has been moved here. 

		if(!dequeue.isEmpty()){
			return dequeue.removeFirst(); // Why aren't we putting the elements back
			// into the first stack after dequeue
			//Because, if another enqueue it'll simply happen in the first stack
			//If we need to dequeue NOW, we just need to dequeue from the second
			//stack because it is in the order we need dequeue to happen
			//Basically stack one holds all the enqueue, and stack two holds all
			//the dequeue. Once dequeue becomes empty because everything has been
			//dequeued, we move all the enqueued elements into the dequeue stack
			//hence repeating the process.
		}
		//if you reach this
		System.out.println("Queue is empty");
	}
}