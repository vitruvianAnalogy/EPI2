package com.educative.twopointers;

public class TripletsWithSmallerSum {
    public static int searchTriplets(int[] arr, int targetSum){
        int count = 0;

        for(int i=0; i<arr.length-2;i++){
            int left = i+1;
            int right = arr.length - 1;

            int targetDiff = Integer.MAX_VALUE;
            while(left<right){
                targetDiff = targetSum - arr[i] - arr[left] -arr[right];
                if( targetDiff > 0){
                    count++;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
