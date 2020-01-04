package com.educative.twopointers;

import java.util.Arrays;

/**
 * I think this will work the same way as TripletSumCloseToZero
 * The problem is assuming that there is only one triplet that is closest
 * So we don't have to return all the triplets
 * Instead we have to return the sum of the triplet, that is closest to the
 */
public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) //  we've found a triplet with an exact sum
                    return targetSum - targetDiff; // return sum of all the numbers

                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; // save the closest and the biggest difference

                if (targetDiff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }
        }
        return targetSum - smallestDifference;
    }
}
