package com.educative.bfs;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        this.val = x;
    }
}
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

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
            result.add(list);
        }

        return result;
    }
}
