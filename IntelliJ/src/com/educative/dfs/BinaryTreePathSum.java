package com.educative.dfs;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val){
        this.val = val;
    }
}

public class BinaryTreePathSum {
    public static boolean hasPath(TreeNode root, int sum){
        boolean hasPath = false;

        if(root.val + sum(root.left)==sum || root.val + sum(root.right)==sum)
            return true;

        return hasPath;
    }

    private static int sum(TreeNode root) {
        return root.val + sum(root.left);
    }
}
