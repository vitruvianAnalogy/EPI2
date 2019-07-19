public class ListPivoting{
	public ListNode<Integer> pivot(ListNode<Integer> head, int k){
		ListNode<Integer> greater = new ListNode<>(0, null);
		ListNode<Integer> equal = new ListNode<>(0, null);
		ListNode<Integer> less = new ListNode<>(0, null);
		ListNode<Integer> greaterTemp = greater;
		ListNode<Integer> equalTemp = equal;
		ListNode<Integer> lessTemp = less;

		while(head!=null){
			ListNode<Integer> temp = null;
			if(head.data < k){
				less.next = head;
			} else if (head.data > k){
				greater.next = head;
			}
			else if(head.data==k) {
				equal.next = head;
			}
			temp = head.next;
			head.next = null;
			head = temp;
		}
		less.next = equalTemp.next;
		equal.next = greaterTemp.next;
		greater.next = null;
		return lessTemp.next;
	}
}