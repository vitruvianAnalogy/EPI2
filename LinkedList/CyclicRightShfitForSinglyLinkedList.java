public class CyclicRightShiftForSinglyLinkedList{
	public ListNode<Integer> cyclicRightShift(ListNode<Integer> head, int k){
		//If list is empty
		if (head == null)
			return head;

		int len = 0;
		ListNode<Integer> dummy = head;
		while (dummy!=null){
			len++;
			dummy = dummy.next;
		}

		//If k > n that means we'll end up rotating the array full circle.
		k = k % len;

		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;

		while(k-->0){
			fast = fast.next;
		}
		while(fast.next!=null){
			slow = slow.next;
			fast = fast.next;
		}

		ListNode<Integer> temp = slow.next;
		slow.next = null;
		fast.next = head;
		head = temp;
	}
}