public class ReverseLinkedListUsingStack{
	public static void printLinkedListInReverse(ListNode<Integer> head){
		//using linkedlist because the push and pop 
		//in a stack that uses linked list is O(1)
		Deque<Integer> nodes = new LinkedList<>(); 
		while(head!=null){
			nodes.addFirst(head.data); //at the top
		}

		while(!nodes.isEmpty()){
			System.out.println(nodes.poll());
		}
	}
}