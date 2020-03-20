package com.educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode2{
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;

    int val;
    TreeNode2(int x){
        this.val = x;
    }
}

public class ConnectLevelOrderSiblings {
    public static void connectLevelOrderSiblings(TreeNode2 root){
        //BFS and while BFS ing, connect to level order successor
        //and if level order successor in next line then connect to null

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(root);
        TreeNode2 temp = null;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode2 top = queue.poll();
                if(top.left!=null)
                    queue.add(top.left);
                if(top.right!=null)
                    queue.add(top.right);
                top.next = queue.peek();
                temp = top;
            }
            temp.next = null;
        }

    }
}
