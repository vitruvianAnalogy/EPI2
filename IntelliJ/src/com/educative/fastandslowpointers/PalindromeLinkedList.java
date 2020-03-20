package com.educative.fastandslowpointers;

public class PalindromeLinkedList {
    /**
     * Contraints
     * 1. O(N) time complexity
     * 2. No change in the list
     * 3. Constant space only
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode copyHeadSecondHalf = headSecondHalf;

        while(head!=null && headSecondHalf!=null){
            if(head.value != headSecondHalf.value){
                break; // we can return false, but we need to bring the list back to its original state
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf);

        if(head==null || headSecondHalf==null){ // i.e. the loop above finished
            return true;
        }

        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head!=null){ //1->2->3
            ListNode next = head.next; //store 2 in next
            head.next = prev; //i.e. first node's next becomes null //1->null
            prev = head; // prev = 1
            head = next; // head = 2
        }
        return prev; // last node
    }
}
