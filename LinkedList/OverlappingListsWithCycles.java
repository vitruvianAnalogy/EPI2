public class OverlappingListsWithCycles{
	public static ListNode<Integer> overlapping(ListNode<Integer> l1, ListNode<Integer> l2){
		ListNode<Integer> root1 = TestForCyclicity.cycleStart(l1);
		ListNode<Integer> root2 = TestForCyclicity.cycleStart(l2);

		// If there are no cycles, then just return the overlapping lists
		if(root1 == null && root2 == null){
			return OverlappingListsWithoutCycles.firstCommonNode(l1,l2);
		}
		//One has cycle, another one doesn't
		if((root1 == null && root2!=null)|| (root2==null && root1!=null)){
			return null; //That means the two lists are not overlapping
			//If one list has cycle but another doesn't they can't be overlapping
		}

		//If both have cycles.
		if(root1.data != root2.data){
			return null; //If cycles are disjoint, each have their own cycle.
		}

		// If both have cycles and they are overlapping

		//1. Check if lists are overlapping before the cycles.
		//Calculcate the nodes traverse to reach the start of cycle
		int len1 = distance(l1, root1);
		int len2 = distance(l2, root2);
		int count = Math.abs(len1 - len2);

		//if l2 is closer to first overlapping node,
		//then we'll bring advance l1 so that it is
		//just as close from first overlapping node, as
		//close is l2
		if(len1> len2){
			advanceByK(l1, count);
		} else {
			advanceByK(l2,count);
		}

		//advance both lists unless 
		//we both lists coincide
		//or l1 reaches root1 
		//or l2 reaches root2
		while(l1!=l2 && l1!=root1 && l2!=root2){
			l1 = l1.next;
			l2 = l2.next;
		}

		//if both have reached l1 then return l1
		if(l1==l2)
			return l1;
		else
			return root1;//else any node on the cycle - not sure about this case
		
	}
}