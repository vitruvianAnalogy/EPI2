package com.educative.cyclicsort;

public class FindTheMissingNumber {
    public static int findMissingNumber(int[] nums){
        int size = nums.length;
        //Do a cyclic sort
        //and then iterate to see what is not in its position
        int i=0;
        while(i<size){
            /**
             nums[i] < nums.length - is done because we have 0 to n in indexes 0 to n-1
             in cyclic sort we had only 1 to n in indexes 0 to n-1,
             therefore we had exact number of cells in arrays.
             In cyclic sort each number would have made to its position
             but in case of number 'n' we don't have an index for it, because we have numbers
             for 0 to n-1
             therefore we will only not move to the next number until we have the correct number
             */
            if(nums[i]<nums.length && i!=nums[i]){
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        for(int j=0; j<size; j++){
            if(j!=nums[j]){
                return j+1;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
