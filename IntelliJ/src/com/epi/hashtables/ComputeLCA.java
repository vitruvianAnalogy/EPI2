package com.epi.hashtables;

import java.util.HashSet;
import java.util.Set;

class TreeNode<Integer>{
    int data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
}
//Lowest common ancestor
public class ComputeLCA {

    /**
     * Time complexity is O(D0 + D1) - where D0 is the distance from node0 to the common root
     * while D1 is the distance from node1 to the common root.
     * @param node0
     * @param node1
     * @return
     */
    public static TreeNode<Integer> computeLCA(TreeNode<Integer> node0, TreeNode<Integer> node1){
        Set<TreeNode> set = new HashSet<>();
        while(node0 !=null || node1 != null){
            //check node0 isn't the parent and then add it to the list
            if(node0 != null){
                //a duplicate node in the set would mean node0 is the parent
                if(!set.add(node0)){
                    return node0;
                }
                node0 = node0.parent;
            }

            //Once node0 is checked, check node1 isn't the parent.
            if(node1 != null){
                if(!set.add(node1)){ //a duplicate node in the set would mean node1 is the parent
                    return node1;
                }
                node1 = node1.parent;
            }
        }
        throw new IllegalArgumentException("not in the same tree");
    }
}
