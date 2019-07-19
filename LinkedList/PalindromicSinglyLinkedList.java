public class PalindromicSinglyLinkedList{
	public boolean isPalindrome(ListNode<Integer> head) {
        if(head==null || head.next == null){
            return true;

        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        // If list is even, slow will reach the first element of second half
        //If list is odd in length, slow will reach the first element of second half
        //that is shared with the first half of the list (last element of the first half)
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        //Reverse the sublist starting from "slow"
        //Returns the sublist ending at slow and starting at tail
        ListNode<Integer> reverse = reverse(slow);
        
        //Reversed and head list are traversed and checked
        while(reverse!= null && head!=null){
            if(reverse.data != head.data)
                return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode<Integer> reverse(ListNode<Integer> curr){
        ListNode<Integer> prev = null; //want last element to be null, hence
        //we start by setting prev to null
        while(curr.next!=null){
            ListNode<Integer> temp = curr.next; //save the next elememnt in temp variable
            curr.next = prev; // connect current to its parent or preceding element
            prev = curr; // now current becomes preceding
            curr = temp; // and the next element that we saved in temp, becomes current
        }
        //Every node is connected to the one previous except the last one
        //hence the following
        curr.next = prev;
        
        return curr;
    }
}