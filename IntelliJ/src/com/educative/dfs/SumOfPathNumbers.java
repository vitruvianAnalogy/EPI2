package com.educative.dfs;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        return calculateSumOfAllPaths(root, 0);

    }

    private static int calculateSumOfAllPaths(TreeNode currentNode, int pathSum) {
        if(currentNode == null)
            return 0;

        pathSum = 10 * pathSum + currentNode.val;

        if(currentNode.left==null && currentNode.right == null)
            return pathSum;
        return calculateSumOfAllPaths(currentNode.left, pathSum) + calculateSumOfAllPaths(currentNode.right, pathSum);
    }
}

