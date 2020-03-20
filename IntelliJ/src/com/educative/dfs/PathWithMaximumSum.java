package com.educative.dfs;

/**
 * This is same as tree diameter except instead of len of the path
 * we have to keep track of the weight of the path
 */
public class PathWithMaximumSum {
    private static int weight = 0;
    public static int maxPath(TreeNode root){
        calculateWeight(root);
        return weight;
    }

    private static int calculateWeight(TreeNode root) {
        if(root == null)
            return 0;
        int leftWeight = Math.max(0,calculateWeight(root.left)); //such that both paths are negative we treat them as zero. The interviewer should be the one to decide how to handle this
        int rightWeight = Math.max(0,calculateWeight(root.right));

        weight = Math.max(weight, leftWeight+rightWeight+root.val);

        return Math.max(leftWeight+root.val, rightWeight+root.val);
    }
}
