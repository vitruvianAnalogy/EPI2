public class DeleteNodeFromASinglyLinkedList{
	public static void delete(ListNode<Integer> node){
		//node.next can be null, this solution will only work
		//if node is not tail, i.e. there is a node.next
		node.data = node.next.data;
		node.next = node.next.next;
	}

	//When node can be tail, we need the 
	//previous node's next to be set to null.
	//Therefore, we also need head of the list
	//to iterate to the node.
	public static void delete(ListNode<Integer> node){
	}
}