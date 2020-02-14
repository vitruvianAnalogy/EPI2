package com.educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Range - 1 to n
 * Indexes - 0 to n-1
 * Duplicates are allowed
 */
public class FindAllMissingNumbers {
    public static List<Integer> missing(int[] nums){
        List<Integer> list = new ArrayList<>();
        CyclicSort.sort(nums);

        for(int i=0;i<nums.length; i++){
            if(nums[i]!=i+1){
                list.add(i+1);
            }
        }
        return list;
    }
}
