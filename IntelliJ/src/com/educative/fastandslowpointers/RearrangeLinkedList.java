package com.educative.fastandslowpointers;

/**
 * No extra space should be used
 * Linked List should be modified in-place
 */
public class RearrangeLinkedList {
    public static void rearrange(ListNode head){
        if(head == null || head.next == null)
            return;
        //Find middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half of the list

        ListNode reverseHead = reverse(slow);
        ListNode tempHead = head;

        //iterate through first and second half of the list
        slow.next = null;
        ListNode tempReverseHead = reverseHead;

        while(head!=null && reverseHead!=null){
            ListNode next = head.next;
            head.next = reverseHead;
            head = next;

            next = reverseHead.next;
            reverseHead.next = head;
            reverseHead = next;
        }
        if(head!=null){
            head.next = null;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev; //prev holds the last element, hence first of the reversed list, because "head" is now null
    }
}
