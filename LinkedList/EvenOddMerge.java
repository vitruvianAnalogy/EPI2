public class EvenOddMerge{
	public ListNode<Integer> merge(ListNode<Integer> head){
		ListNode<Integer> even = head;
		if(even == null || even.next == null)
			return even;
		ListNode<Integer> odd = even.next;
		ListNode<Integer> dummyOdd = odd;

		while(even!=null && even.next!=null){
			even.next = even.next.next;
		}

		while(odd!=null && odd.next!=null){
			odd.next = odd.next.next;
		}

		

	}
}