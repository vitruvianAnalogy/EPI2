package com.educative.fastandslowpointers;

/**
 * Time complexity - O(N)
 */
public class FindLengthOfCycle {
    public static int returnLengthOfCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        while(fast!=null && head!=slow){
            head = head.next;
            length++;
        }

        return length;
    }
}
