public class ReverseASingleSubList{
	public static ListNode<Integer> reverseSubList(ListNode<Integer> head, int start, int end){
		ListNode<Integer> dummyNode = new ListNode<>(0,head);
		ListNode<Integer> dummyNode2 = dummyNode;
		ListNode<Integer> prev;
		ListNode<Integer> curr;
		ListNode<Integer> temp;
		int count = 1;
		while(count < start){
			dummyNode2 = dummyNode2.next;
			count++;
		}

		prev = dummyNode2;
		curr = dummyNode2.next;
		while(count<end){
			temp = curr.next;
			curr.next = prev;
			curr = temp;
			count++;
		}
		head.next = curr;
		return dummyNode.next;
	}

}
