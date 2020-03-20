package com.educative.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SubArraysWithProductLessThanATarget {
    /**
     * Given an array with positive numbers and a target number
     * Find all "contiguous" subarrays whose product is LESS than target number
     */
    public static List<List<Integer>> returnSubArrays(int[] arr, int target){
        List<List<Integer>> subArrays = new ArrayList<>();
        int product = 1, left = 0;
        for(int right=0; right<arr.length; right++){
            product *= arr[right];
            while(product >= target && left < arr.length){
                product /= arr[left++];
            }
            List<Integer> subArray = new ArrayList<>();
            //we start from the right to the left, so that we don't add left element twice
            //starting from right means, we'll add the right most element as the single element
            //and then list of numbers once we reverse step towards the left most element
            for(int i=right; i>=left; i--){
                subArray.add(arr[i]);
                subArrays.add(new ArrayList<>(subArray)); //This operation is O(N)
            }
        }
        return subArrays;
    }

}
