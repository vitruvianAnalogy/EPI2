package com.educative.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForASum {
    public static int countPaths(TreeNode root, int sum) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, sum, currentPath);
    }

    private static int countPathsRecursive(TreeNode root, int sum, List<Integer> currentPath) {
        if(root == null)
            return 0;

        currentPath.add(root.val); //Whenever we meet a new node we add it to a path
        int pathCount = 0, pathSum = 0;
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());

        //At current node, we iterate backward to figure out if there is a path that sums up to sum.
        //Since we are iterating from the current node, we get a unique path
        while(pathIterator.hasPrevious()){
            pathSum += pathIterator.previous();
            if(pathSum == sum)
                pathCount++;
        }

        pathCount += countPathsRecursive(root.left, sum, currentPath);
        pathCount += countPathsRecursive(root.right, sum, currentPath);

        currentPath.remove(currentPath.size()-1); //we remove the current node because we don't the current node to be considered when the algo goes to the "right side" of tree.

        return pathCount;
    }
}
