package com.educative.linkedlistinplacereversal;

public class RotateALinkedList {
    public static ListNode rotate(ListNode head, int k){
        if(k<=0){// no rotations
            return head;
        }
        ListNode lastNode = head;
        //find length of the list
        int length = 0;
        while(lastNode!=null){
            lastNode = lastNode.next;
            length++;
        }

        lastNode.next = head; //attach last node to the first node
        int rotateBy = k%length;
        int skipBy = length-rotateBy;

        ListNode lastNodeOfRotatedList = head;
        for(int i=1; i< skipBy; i++){
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }

        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }
}
