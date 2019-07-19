public class TestForCyclicity{
	public static boolean hasCycle(ListNode<Integer> head){
		if(head == null || head.next == null || head.next.next == null)
			return false;

		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head.next.next;

	//If the current or the next or the next.next element is not null, otherwise
		//null pointer exception

		// Use AND instead of OR because OR shortcut checks second
		//condition if first is false
		while(fast!=null && fast.next!=null && fast.next.next != null){
			if(slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	public static ListNode cycleStart(ListNode<Integer> head){
		//Not necessary. it get's checked in the while loop later
		//if (head == null || head.next == null || head.next.next == null)
		//	return null;

		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;

		//we can use just fast!=null check but
		//since we are looking ahead, the other if conditions
		//are to ignore 
		while(fast!=null && fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next;
			if(slow == fast){
				slow = head;
				while(slow!=fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}