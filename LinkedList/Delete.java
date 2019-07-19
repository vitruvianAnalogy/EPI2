public class Delete{

	public void deleteTheNodeAfter(ListNode<T> node){
		if(node.next!=null) //Assuming node could be a tail
			node.next = node.next.next;
	}

	public void deleteTheNodeAfter(ListNode<T> node){
		node.next = node.next.next; //Assuming node is not a tail
	}
}