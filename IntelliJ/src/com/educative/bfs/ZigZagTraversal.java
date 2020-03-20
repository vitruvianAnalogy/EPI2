package com.educative.bfs;

import java.util.*;

public class ZigZagTraversal {
    public static List<List<Integer>> zigzagbfs(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(node);
        int c = 0;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                if(c%2==0){
                    TreeNode top = queue.pollFirst();
                    list.add(top.val);
                    queue.offer(top.left);
                    queue.offer(top.right);
                } else {
                    TreeNode top = queue.pollLast();
                    list.add(top.val);
                    queue.offer(top.left);
                    queue.offer(top.right);
                }
                c++;
            }
            result.add(list);
        }

        return result;
    }
}
