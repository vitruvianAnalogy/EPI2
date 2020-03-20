package com.educative.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static List<List<Integer>> reverseTraversal(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(queue.peek()!=null){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left!=null)
                    queue.offer(current.left);

                if(current.right!=null)
                    queue.offer(current.right);
            }
            result.add(0,list); //add the list to the start, so that the first list gets pushed to next level, everytime we collate a new list.
        }

        return result;
    }
}
