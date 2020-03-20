package com.educative.bfs;

import java.lang.reflect.Array;
import java.util.*;

public class TreeBoundary {
    public static List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<TreeNode> leftView = new ArrayList<>();
        List<TreeNode> rightView = new ArrayList<>();
        List<TreeNode> leaves = new ArrayList<>();

        while(queue.peek()!=null){
            int size = queue.size();
            TreeNode start = queue.poll();

            for(int i=0; i<size; i++){
                if(start.left==null && start.right==null)
                    continue;
                else if(i==0)
                    leftView.add(start);
                else if(i==size-1)
                    result.add(0,start);

                if(start.left!=null)
                    queue.offer(start.left);
                if(start.right!=null)
                    queue.offer(start.right);
            }
        }

        result = returnResult(leftView,rightView, root);

        return result;
    }

    private static List<TreeNode> returnResult(List<TreeNode> leftView, List<TreeNode> rightView, TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.addAll(leftView);
        list.addAll(findDFS(root));
        list.addAll(rightView);
        return list;
    }

    private static Collection<? extends TreeNode> findDFS(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode top = stack.pop();
            if(top.left==null && top.right==null)
                list.add(top);

            //Right is inserted before left because we want
            //left to be processed before right
            //and this is a LIFO
            if(top.right!=null)
                stack.push(top.right);
            if(top.left!=null)
                stack.push(top.left);
        }
        return list;
    }
}
