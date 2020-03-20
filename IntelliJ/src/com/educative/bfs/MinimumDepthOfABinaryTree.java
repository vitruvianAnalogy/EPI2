package com.educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfABinaryTree {
    public static int findDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left==null)
                    return depth;
                else
                    queue.add(node.left);
                if(node.right==null)
                    return depth;
                else
                    queue.add(node.right);
            }
        }
        return -1;
    }
}
