package com.educative.dfs;

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence){
        if(root == null)
            return sequence.length == 0;

        return isSequence(root, sequence, 0);

    }

    private static boolean isSequence(TreeNode root, int[] sequence, int index) {
        if(root == null)
            return false;

        if(sequence.length<=index || root.val != sequence[index])
            return false;
        if(root.left == null && root.right == null && sequence.length == index+1)
            return true;
        return isSequence(root.left, sequence, index+1) || isSequence(root.right, sequence, index+1);

    }
}
