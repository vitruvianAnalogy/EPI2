package com.educative.linkedlistinplacereversal;

public class ReverseAlternatingKElementSubList {
    public static ListNode reverseAlternatingSubList(ListNode head, int k){
        if(k<=1 || head == null)
            return head;

        ListNode previous = null, current = head;

        while(true){
            ListNode lastNodeOfPrevious = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next = null;

            for(int i=0; current==null || i<k; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if(lastNodeOfPrevious != null){
                lastNodeOfPrevious.next = previous;
            } else {
                head = previous;
            }

            lastNodeOfSubList.next = current;

            for(int i=0; current==null || i<k; i++){
                previous = current;
                current = current.next;
            }

            if(current == null){
                break;
            }
        }
        return head;
    }
}
