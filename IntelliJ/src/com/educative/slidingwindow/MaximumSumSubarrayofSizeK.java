package com.educative.slidingwindow;

public class MaximumSumSubarrayofSizeK {
    /**
     * Used the sliding approach where i calculated the 'subarrays of size k'
     * and this time also calculated whether the current sum is bigger than
     * the previous bigger sum i calculated.
     * Time complexity - O(arrayLength)
     * @param array
     * @param k
     * @return
     */
    public static int maximumSumOfAnySubArrayOfSizeK(int[] array, int k){
        int arrayLength = array.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arrayLength; i++){
            sum = sum + array[i];
            if(i >= k-1){//if k = 3, and we are at k-1 i.e. 2
                max = Math.max(sum, max);
                sum = sum - array[i-(k-1)]; //we'll keep subtracting every element we leave behind
            }
        }
        return max;
    }
}
