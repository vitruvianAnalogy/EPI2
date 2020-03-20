package com.educative.slidingwindow;

/**
 * Given an array, find 'length' of the 'smallest' subarray,
 * whose sum is greater than or equal to S.
 *
 * Find the smallest subarray (meaning size wise) but greater than a sum
 * Find length
 * Return 0 otherwise
 */

public class SmallestSubArrayWithAGivenSum {

    /**
     * There are two sliding windows inside this solution, like a nested sliding window
     * Time complexity - O (N)
     *
     * It might look like there is a nested loop in it, but each element can only be
     * processed at most 2 times, since inner loop will only check the elements once
     * The sliding window moves forward, the inner loop won't come for the elements again
     * O(N + N) still is O(N)
     */
    public static int getLengthOfSmallestSubArrayWithSumGreaterThanK(int[] array, int k){
        int arrayLength = array.length;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        for(int i=0; i<arrayLength; i++){
            sum = sum + array[i];
            // We iterate until the sum becomes less than k, because if
            // we don't, it is possible that the sum is already bigger than k
            // ALSO, we want to check other subarrays inside the bigger subarray
            // that might fulfill the condition that we are looking for.
            while(sum>=k){
                minLength = Math.min(minLength, (i-startIndex+1));
                sum = sum - array[startIndex];
                startIndex++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
