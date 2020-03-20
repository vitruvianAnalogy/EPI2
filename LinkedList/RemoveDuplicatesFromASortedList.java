public class RemoveDuplicatesFromASortedList{
	public static ListNode<Integer> removeDuplicates(ListNode<Integer> head){
		ListNode<Integer> dummy = new ListNode(0, head);
		while(head!=null){
			if(head.next!=null && head.data==head.next.data){
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
}