public class MergeTwoSortedLists{
	public static ListNode<Integer> MergeTwoSortedLists(ListNode<Integer> l1, ListNode<Integer> l2){
		ListNode<Integer> dummyNode = new ListNode<>(0, null);
		ListNode<Integer> dummyNode2 = dummyNode;
		while(l1!=null && l2!=null){
			if(l1.data <= l2.data){
				dummyNode.next = l1;
				l1 = l1.next;
			} else {
				dummyNode.next = l2;
				l2 = l2.next;
			}
		}
		if(l1 == null){
			dummyNode.next = l2;
		} else if (l2 == null){
			dummyNode.next = l1;
		}

		return dummyNode2.next;

	}
}