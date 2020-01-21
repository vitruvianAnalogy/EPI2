package com.educative.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    /**
     * Time complexity :
     * 1. Sorting - will take O(N * log N)
     * 2. The searchPairs will take O(N)
     * 3. The two loops in returnQuadruplet will take O(N^2).
     * In total : O(N * log N) + O(N^3)
     *
     * Space complexity :
     * 1. O(N) for sorting
     * @param arr
     * @param target
     * @return
     */
    public static List<List<Integer>> returnQuadruplet(int[] arr, int target){
        List<List<Integer>> quadruplets = new ArrayList<>();
        if(arr.length<=3)
            return quadruplets;
        Arrays.sort(arr);

        for(int i=0; i<arr.length-3;i++){
            //skip the same element as the previous
            //i>0 is checked such that i-1 doesn't go out of bounds
            if(i>0 && arr[i]==arr[i-1])
                continue;
            for(int j=i+1; j<arr.length-2;j++){
                //skip the same element as the previous
                //same logic as the outer loop if condition
                if(j>i+1 && arr[j]==arr[j-1])
                    continue;
                searchPairs(arr, target, i,j, quadruplets);
            }
        }
        return quadruplets;
    }

    //i is the first element of the quadruplet, j is the second element of the quadruplet
    private static void searchPairs(int[] arr, int target, int first, int second, List<List<Integer>> quadruplets) {
        int third = second+1;
        int fourth = arr.length-1; //4th element could be the last element of the array

        while(third < fourth){
            int sum = arr[first] + arr[second] + arr[third] + arr[fourth];
            if(sum==target){
                quadruplets.add(Arrays.asList(first,second,third,fourth));
                third++;//because next element will be bigger or equal
                fourth--;//because prev element will be smaller or equal
                while(third<fourth && arr[third]==arr[third-1])
                    third++;
                while(third<fourth && arr[fourth]==arr[fourth])
                    fourth--;
            }else if(sum<target){
                third++;
            } else {
                fourth--;
            }
        }
    }
}
