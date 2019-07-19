public class Search{
	//What do i need to search - search for a key. We can't search for a node, because
	//if we search for a node, we are assuming we already have the node
	public ListNode<T> search1(ListNode<T> head, int key){
		while(head!=null){
			if(key == head.data){
				return head;
			}
			head = head.next;
		}
		return head; // head will become null if we don't find the node, because
		//head will reach the end.
	}

	//Another approach is to do the "if check" (in search1) with the "while" check
	//instead of in the next line (in search1)
	public ListNode<T> search(ListNode<T> head, int key){
		while(head!=null && key!=head.data){
			head = head.next;
		}
		return head; //if key == head, we'll have the desired node in head
		//if head == null then we'll return null
	}
}