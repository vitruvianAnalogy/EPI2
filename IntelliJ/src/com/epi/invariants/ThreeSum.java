package com.epi.invariants;

import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class ThreeSum {
    /**
     * Time - O(n3)
     * Space - O(1)
     * @param array
     * @param sum
     * @return
     */
    public static boolean hasThreeSumBruteForce(List<Integer> array, int sum){
        int size = array.size();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                for(int k=0; k<size; k++){
                    if(array.get(i) + array.get(j) + array.get(k) == sum){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Time - O(n2)
     * Space - O(n)
     * @param array
     * @param sum
     * @return
     */
    public static boolean hasThreeSumOptimizationByUsingHashSet(List<Integer> array, int sum){
        HashSet<Integer> set = new HashSet<>();
        int size = array.size();
        for(int i=0; i<size; i++){
            set.add(array.get(i));
        }
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(set.contains(sum-array.get(i)-array.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * O(nlogn) for sorting, O(n2logn) for the loops
     * O(1) space
     * @param array
     * @param sum
     * @return
     */
    public static boolean hasThreeSumOptimizationByUsingSorting(List<Integer> array, int sum){
        int size = array.size();
        Collections.sort(array);

        for(int i =0 ; i<size; i++){
            for(int j=0; j<size; j++){
                int temp = sum - (array.get(i) + array.get(j));
                int start = 0;
                int end = size-1;
                int mid = end/2;
                for(int k=start; k<end;k++){
                    if(temp > array.get(k) && temp < array.get(mid) ){
                        end = mid;
                    } else if(temp > array.get(mid) && temp < array.get(end)){
                        start = mid;
                    } else if(temp == array.get(mid)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}






















