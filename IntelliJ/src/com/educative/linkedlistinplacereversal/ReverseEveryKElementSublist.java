package com.educative.linkedlistinplacereversal;

public class ReverseEveryKElementSublist {
    public static ListNode reverseKElementSubList(ListNode head, int k){

        if(k<=1 || head == null)
            return head;

        ListNode current = head, previous = null;
        while(true){
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;

            ListNode next = null;
            //Reverse the current node to point to previous as next and next as current
            for(int i=0; current!=null && i<k; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            //will only be null if previous was null, meaning the list is only node in length
            if(lastNodeOfPreviousPart!=null){
                lastNodeOfPreviousPart.next = previous;
            } else{
                //previous is the last node of the sublist
                //this means last node of sublist after reversal is head
                //this only happens when we are reversing the first sublist
                //starting at the head.
                head = previous;
            }

            //This node is now at bottom because it was top before reversal
            //we make it's next the current element
            lastNodeOfSubList.next = current;

            if(current == null)//we have reached end of the list
                break;
            previous = lastNodeOfSubList;
        }
        return head;
    }
}
