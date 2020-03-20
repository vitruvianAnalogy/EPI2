package com.educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Range of numbers = 1 to n
 * One number got duplicated and other got missing
 */
public class CorruptPair {
    public static int[] corruptPair(int[] nums){
        int[] pair = new int[2];
        int i = 0;
        while(i<nums.length){
            int j = nums[i]-1;
            if(nums[i]!=nums[j]){
                swap(nums,i,j);
            } else{
                i++;
            }
        }

        int c = 0;
        for(i = 0; i<nums.length; i++){
            if(nums[i]!=i+1){
                pair[0] = nums[i];
                pair[1] = i+1;
            }
        }

        return pair;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
