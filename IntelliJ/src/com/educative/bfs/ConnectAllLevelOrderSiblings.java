package com.educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {
    public static TreeNode2 solution (TreeNode2 head){

        if(head == null || (head.left == null && head.right==null)){
            return head;
        }

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(head);

        TreeNode2 prev = head;

        while(queue.peek()!=null){
            int size = queue.size();

            while(size>0){
                TreeNode2 top = queue.poll();
                prev.next = top;
                if(top.left != null)
                    queue.offer(top.left);
                if(top.right != null)
                    queue.offer(top.right);
                size--;
                prev = top;
            }
        }
        prev.next = null;
        return head;
    }
}
