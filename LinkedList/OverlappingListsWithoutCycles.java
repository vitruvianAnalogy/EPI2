//These lists have no cycles
public class OverlappingListsWithoutCycle{
	public static ListNode<Integer> firstCommonNode(ListNode<Integer> l1, ListNode<Integer> l2){
		ListNode<Integer> smaller = l1;
		ListNode<Integer> larger = l2;
		int smallerLen = largerLen = 0;
		while(l1!=null){
			l1 = l1.next;
			smallerLen++;
		}
		while(l2!=null){
			l2 = l2.next;
			largerLen++;
		}
		int diff = Math.abs(smallerLen - largerLen);

		if (lenL1>lenL2){
			ListNode<Integer> temp = smaller;
			smaller = larger;
			larger = temp;

			int tempLen = smallerLen;
			smallerLen = largerLen;
			largerLen = tempLen;
		}

		while(diff>0){
			larger = larger.next;
			diff--;
		}

		//1st approach

		while(smaller!=null && larger!= null){
			if(smaller == larger)
				return smaller;
			smaller = smaller.next;
			larger = larger.next;
		}

		return null;

		//2nd approach

		// while(smaller!=null && larger!= null && smaller!=null){
		// 	smaller = smaller.next;
		// 	larger = larger.next;
		// }

		// return smaller;

	}
}