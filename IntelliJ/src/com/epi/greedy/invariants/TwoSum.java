package com.epi.greedy.invariants;

import java.util.List;

public class TwoSum {
    /**
     * array is sorted, otherwise the two sum won't be solved like this
     * @param array
     * @param sum
     * @return
     */
    public static boolean hasTwoSum(List<Integer> array, int sum){
        int i = 0, j = array.size() - 1;
        while(i <= j){
            if(array.get(i) + array.get(j) == sum){
                return true;
            } else if (array.get(i) + array.get(j) < sum){
                ++i; //we are incrementing i because i is smaler than j
                //we know this because array is sorted
            } else {
                --j; // if i+j is greater than sum, then we can look for a smaller element
                //hence, we'll go to an earlier element because array is sorted
            }
        }
        return false;
    }
}
