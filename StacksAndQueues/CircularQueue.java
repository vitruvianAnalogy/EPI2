public class CircularQueue{
	int start = 0;
	int end = -1;
	int[] array;

	public CircularQueue(int capacity){
		array = new int[capacity];
	}	
	
	public void enqueue(int data){
		if(end+1 == array.length){
			System.out.println("Queue has reached its capacity");
			return;
		}
		end++;
		array[end] = data;
	}

	public void dequeue(){
		if(end == -1){
			System.out.println("Queue is empty");
			return;
		}
		if(end == 0){
			array[end] = 0;
			end--;
			return;
		}

		int temp = start;
		while(temp < end){
			array[temp] = array[temp+1];
			temp++;
		}
		end--;
	}

	public int getNumberOfElements(){
		if(end == -1)
			return 0;
		return end - start + 1;
	}
}

class TestCircularQueue{
	public static void main(String[] args){
		CircularQueue queue = new CircularQueue(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.getNumberOfElements());
	}
}