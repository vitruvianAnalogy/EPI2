public class AddTwoLinkedLists{
	public ListNode<Integer> add(ListNode<Integer> l1, ListNode<Integer> l2){
		ListNode<Integer> dummy = l1;
		int carry = 0;
		while(l1!=null && l2!=null){
			l1.data = l1.data + l2.data + carry;
			carry = l1.data%10;
			l1.data = l1.data/10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l2!=null){
			carry = l2.data + carry;
			l1 = new ListNode(carry/10);
			carry = carry%10;
			l2 = l2.next;
		}

		while(l1!=null && (carry+l1.data>9)){
			carry = l1.data+carry;
			l1.data = carry%10;
			carry = carry/10;
			l1 = l1.next;
		}

		return dummy;
	}
}