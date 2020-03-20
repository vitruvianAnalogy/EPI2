package com.educative.slidingwindow;

public class SumOfContiguousSubArray {

    /**
     * Time complexity - O ( (arrayLength - k) * k )
     * @param array
     * @param k - number of elements in the subarray
     * @return
     */
    public static int[] getArrayOfSumOfSubArraysUsingBruteForce(int[] array, int k){
        // Total number of elements in the array
        int arrayLength = array.length;
        // Total number of elements in the array of sums
        int sizeOfArrayOfMean = arrayLength-k+1;
        int[] arrayOfMeans = new int[sizeOfArrayOfMean];
        for(int i=0; i<sizeOfArrayOfMean; i++){
            arrayOfMeans[i] = 0;
            for(int j=i; j<i+k; j++){
                arrayOfMeans[i] = arrayOfMeans[i] + array[j];
            }
            arrayOfMeans[i] = arrayOfMeans[i]/k;
        }
        return arrayOfMeans;
    }

    /**
     * Time complexity - O(arrayLength)
     * @param array
     * @param k - number of elements in the subarray
     * @return
     */
    public static int[] getArrayOfSumOfSubArrayUsingSlidingWindow(int[] array, int k){
        int arrayLength = array.length;
        int sizeOfArrayOfMeans = arrayLength - k + 1;
        int[] arrayOfMeans = new int[sizeOfArrayOfMeans];
        int sum = 0;
        // Optional : You can use another variable windowStart to keep track of the start of the window
        // and then keep on incrementing it. That way you won't have to calculate using 'i-(k-1)'
        for(int i=0; i< arrayLength; i++){
            sum = sum + array[i];
            if(i>=k-1){
                arrayOfMeans[i-(k-1)] = sum/k;
                sum = sum - array[i-(k-1)];
            }
        }
        return arrayOfMeans;
    }
}
