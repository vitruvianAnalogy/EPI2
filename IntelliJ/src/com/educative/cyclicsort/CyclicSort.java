package com.educative.cyclicsort;

/**
 * Given - an array of n objects
 * Each object - assigned a unique number
 */
public class CyclicSort {
    public static void sort(int[] nums){
        int i = 0;
        while(i<nums.length){
            int j = nums[i] - 1; //if i = 4 and it has the correct number i.e. nums[4] = 5,
            //then j = 5 -1, i.e. j = 4
            //so if nums[i]-1 end up becoming j which is equal to i
            if(nums[i]!=nums[j]){ //we can also use i!=j
                swap(nums, i, j);
            } else
                i++;
        }
    }

    private static void swap(int[] nums, int i, int num) {
        int temp = nums[i];
        nums[i] = nums[num];
        nums[num] = temp;
    }
}
