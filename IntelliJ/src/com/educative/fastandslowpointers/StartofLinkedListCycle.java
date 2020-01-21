package com.educative.fastandslowpointers;

/**
 * Time complexity - O(N) is the time complexity because
 * FindLengthOfCycle.returnLengthOfCycle is O(N)
 * and iterate to find the start is O(N)
 * O(N) + O(N) is O(N)
 */
public class StartofLinkedListCycle {
    //what is the start of the cycle.
    public static ListNode startOfCycle(ListNode head){
        int len = FindLengthOfCycle.returnLengthOfCycle(head);
        ListNode slow = head;
        ListNode fast = head;
        while(len-->0){
            fast = fast.next;
        }
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
