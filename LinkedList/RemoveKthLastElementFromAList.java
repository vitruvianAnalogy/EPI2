public class RemoveKthLastElementFromAList{
	public static ListNode<Integer> remove(ListNode<Integer> head, int k){
		ListNode<Integer> dummy = new ListNode<>(0,head);
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;

		while(k-->0){
			fast = fast.next;
		}

		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
		slow = slow.next.next;
		return dummy.next;
	}
}


1   3	slow
2	2	slow
3	1	slow
4	0	fast slow
5	fast
6	fast
7	fast