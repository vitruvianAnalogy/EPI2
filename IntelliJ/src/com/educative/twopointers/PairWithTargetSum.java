package com.educative.twopointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairWithTargetSum {
    public static int[] searchUsingTwoPointers(int[] sortedArray, int targetSum){
        int[] result = new int[2];
        int startIndex = 0;
        int endIndex = sortedArray.length - 1;

        while(startIndex < endIndex){
            if(sortedArray[startIndex]+sortedArray[endIndex] < targetSum){
                startIndex++;
            }else if(sortedArray[startIndex]+sortedArray[endIndex] > targetSum){
                endIndex--;
            } else {
                result[0] = startIndex;
                result[1] = endIndex;
            }
        }
        return result;
    }

    public static int[] searchUsingHashMap(int[] array, int targetSum){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<array.length; i++){
            int element = array[i];
            int t = map.getOrDefault(targetSum-element,-1);
            if(t != -1){
                return new int[] {t, i};
            } else {
                map.put(element,i);
            }
        }
        return new int[] {-1,-1};
    }
}
