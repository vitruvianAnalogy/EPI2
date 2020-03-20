package com.educative.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static List<TreeNode> traverse (TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.add(root);
        while(queue.peek()!=null){
            int size = queue.size();
            while(size>0){
                TreeNode top = queue.poll();

                //we can also do a check here instead of inserting them in
                //reverse order. We can check if the element is the last
                //element of the level, i.e. index == levelSize - 1;

                //OR

                //Insert them in reverse order such that right one stays on start of the queue
                if(top.right!=null){
                    queue.offer(top.right);
                }
                if(top.left!=null){
                    queue.offer(top.left);
                }
                size--;
            }
            if(queue.peek()!=null)
                result.add(queue.peek());
        }

        return result;
    }
}
