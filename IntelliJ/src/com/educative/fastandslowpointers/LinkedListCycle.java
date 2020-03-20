package com.educative.fastandslowpointers;

class ListNode{
    int value = 0;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }
}
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

}
