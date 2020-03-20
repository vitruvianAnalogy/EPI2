package com.educative.dfs;

import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {
    private static int diameter = 0;

    public static int diameter(TreeNode root){
        calculateHeight(root);
        return diameter;
    }

    private static int calculateHeight(TreeNode root) {
        if(root == null)
            return 0;
        //Calculate heights of both children paths
        int leftTreeHeight = calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);

        //Update the global variable to update the maximum height, because we might lose this information if we don't save it now
        diameter = Math.max(diameter, leftTreeHeight + rightTreeHeight + 1);

        //Choose which height you want this node to represent. ofcourse the longer one, which will be decided by doing the Math.max selection and adding 1 to it.
        //for instance if my left is 3 in len and my right is 7 in len, i know that my current's FULL POTENTIAL is to be as long as 7 + 1, not 3 + 1,
        //because 7 is larger
        return Math.max(leftTreeHeight+1, rightTreeHeight+1);
    }

}
