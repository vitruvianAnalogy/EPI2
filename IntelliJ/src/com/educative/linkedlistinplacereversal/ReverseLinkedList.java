package com.educative.linkedlistinplacereversal;

class ListNode{
    int value = 0;
    ListNode next;

    public ListNode(int value){
        this.value = value;
    }
}
public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        //After the iteration is finished temp becomes null
        //while the prev to temp becomes the head
        return prev;
    }
}
