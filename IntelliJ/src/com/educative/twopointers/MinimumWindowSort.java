package com.educative.twopointers;

public class MinimumWindowSort {
    /**
     * Time complexity = O(N)
     * @param arr
     * @return
     */
    public static int sort(int[] arr){
        int low = 0, high = arr.length -1;

        while(low < high && arr[low]<=arr[low+1]){
            low++;
        }
        if(low==high)//means the array is sorted
            return 0;

        while(high>0 && arr[high]>=arr[high-1]){
            high--;
        }
        int max = Integer.MIN_VALUE, min= Integer.MAX_VALUE;
        for(int k=low; k<=high; k++){
            max = Math.max(max, arr[k]);
            min = Math.min(min, arr[k]);
        }

        while(low>0 && arr[low-1]> min)
            low--;
        while(high<arr.length-1 && arr[high+1]<max)
            high++;

        return high - low + 1;
    }
}
