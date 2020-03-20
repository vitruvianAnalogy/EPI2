package com.epi.hashtables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestSubarrayCoveringAllValues {
    /**
     * Write a program that takes an "array of strings" and a "set of strings",
     * and return the indices of "starting and ending index" of a "shortest subarray"
     * of the given array that "covers" the set.
     */

    private static class SubArray{
        int start;
        int end;
        public SubArray(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int returnSize(){
            return end - start + 1;
        }
    }

    public static SubArray usingBruteForce(List<String> array, Set<String> set){
        SubArray min = new SubArray(0, array.size()-1);
        //find all the subarrays and then check which is the shortest
        for(int i=0; i<array.size()-1; i++){
            for(int j=i; j<array.size(); j++){
                if(doesSubArrayHasSet(array,i,j,set)){
                    if(min.returnSize()>(j-i+1)){
                        min = new SubArray(i,j);
                    }
                }
            }
        }
        return min;
    }

    private static boolean doesSubArrayHasSet(List<String> array, int i, int j, Set<String> set) {
        Set<String> newSet = new HashSet<>();
        newSet.addAll(set);
        if(array.containsAll(set))
            return true;
        return false;
    }
}
