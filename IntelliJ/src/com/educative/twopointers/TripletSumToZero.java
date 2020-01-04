package com.educative.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    /**
     * Space complexity - Ignoring the triplets arraylist, we use O(N) for sorting
     * Time complexity - 1. searchPair takes O(N) and it is called for each element hence O(N^2)
     * 2. Sorting takes O(N * log N)
     * 3. In total - time complexity = O(N * log N) + O(N^2) which is equivalent to O(N^2)
     * @param arr - unsorted array
     * @return - array of arrays
     */
    public static List<List<Integer>> searchTriplets(int[] arr){
        Arrays.sort(arr); //sort the array to get the numbers in order
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0; i<arr.length-2; i++){
            if(i>0 && arr[i]==arr[i-1]){ //skip the same element
                continue;
            }
            searchPair(arr, arr[i], i+1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while(left<right){
            int currentSum = arr[left]+arr[right];
            if(currentSum == targetSum){
                triplets.add(Arrays.asList(arr[left], arr[right], targetSum));
                left++;
                right--;//because the next triplet would have a bigger arr[left] since we are moving to the right

                while(left<right && arr[left]==arr[left-1]){
                    left++;
                }
                while(left<right && arr[right]==arr[right+1]){
                    right--;
                }
            } else if(currentSum<targetSum){
                left++;
            } else {
                right--;
            }
        }
    }
}
