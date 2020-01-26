package com.educative.fastandslowpointers;

public class MiddleOfLinkedList {
    public static ListNode find(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            slow = slow.next;
            if(fast.next!=null)
                fast = fast.next.next;
        }
        return slow;
    }
}