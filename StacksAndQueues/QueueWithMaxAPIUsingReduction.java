//Uses Stack With Max operation
public class QueueWithMaxAPIUsingReduction{
	private StackWithMaxOperation.Stack enqueue = new StackWithMax.Stack();
	private StackWithMaxOperation.Stack dequeue = new StackWithMax.Stack();

	public void enqueue(Integer x){
		enqueue.push(x);
	}

	public Integer dequeue(){
		if(dequeue.empty()){
			while(!enqueue.empty()){
				dequeue.push(enqueue.pop());
			}
		}
		if(!dequeue.isEmpty()){
			return dequeue.pop();
		}
		//if here, then queue is empty
	}

	public Integer max(){
		if(!enqueue.isEmpty()){
			return dequeue.empty() ? enqueue.max() : Math.max(enqueue.max(), dequeue.max());
		}
		if(!dequeue.empty()){
			return dequeue.max();
		}
		//empty queue
	}
}