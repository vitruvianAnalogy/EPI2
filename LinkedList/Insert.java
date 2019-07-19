public class Insert{
	public void insertAfter1(ListNode<T> node, ListNode<T> newNode){
		Node temp = node.next;
		node.next = newNode;
		newNode.next = temp;
	}

	/**
	*insertAfter2 is same as insertAfter1. The only difference is that
	* we don't use a temp variable to store the next of node
	* The next of node has to go to the next of newNode either way.
	* Temp variable is only used when there is a swap
	* This might look like a swap but newNode.next is empty, so there is space for assignment
	* It is kind of like a temp variable.
	*/
	public void insertAfter2(ListNode<T> node, ListNode<T> newNode){
		newNode.next = node.next;
		node.next = newNode;
	}
}