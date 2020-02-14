package com.educative.cyclicsort;

/**
 * Range - 1 to n numbers, total numbers = n+1
 * Indexes - 0 to n-1
 * One duplicate present
 */
public class FindDuplicateNumber {
    public static int duplicate(int[] nums){
        int size = nums.length;

        int j = 0;
        while(j<nums.length){
            if(j+1!=nums[j]){
                if(nums[j] != nums[nums[j]-1]) // if the number being swapped with is not the same
                    swap(nums,j,nums[j]-1);
                else //we have found our duplicate
                    return nums[j];
            }else{
                j++;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
