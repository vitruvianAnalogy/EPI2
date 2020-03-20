package com.educative.linkedlistinplacereversal;

public class ReverseSubList {
    public static ListNode reverseSubList(ListNode head, int p, int q){
        if(p==q)
            return head;

        ListNode current = head, previous = null;
        //Iterate until we reach the pth element
        for(int i=1; current!=null && i<p; i++){
            previous = current;
            current = current.next;
        }

        ListNode theNodeBeforePthNode = previous;
        ListNode pthNodeWhichBecomesPrevOfSublistWhenSublistIsReversed = current;
        ListNode next = null;

        //p=3, q=6 i.e. 3,4,5,6 i.e. 6-3+1 = 4
        for(int i=1; current!=null && i<=q-p+1; i++){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if(theNodeBeforePthNode != null){
            theNodeBeforePthNode.next = previous;
        } else{
            //theNodeBeforePthNode will only be null if p == 1, i.e. p is the first node of the list,
            //therefore when we flip the last node of the sublist, that last node becomes head
            head = previous;
        }
        pthNodeWhichBecomesPrevOfSublistWhenSublistIsReversed.next = current;

        return head;
    }
}
