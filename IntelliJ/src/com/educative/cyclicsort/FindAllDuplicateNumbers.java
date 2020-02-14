package com.educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    public static List<Integer> findNumbers(int[] nums){
        int i = 0;
        while(i<nums.length){
            //nums[0] to nums[n-1] covers range 1 to n
            int j = nums[i] - 1;
            //if things are not in their correct place we swap them
            if(nums[i] != nums[j]){ //if a[0] != a[nums[0]-1] i.e. nums[0]-1 !=0 i.e. nums[0]!=1
                swap(nums,i,j);
            } else {//else we move to the next index
                i++;
            }
        }

        List<Integer> duplicateNumbers = new ArrayList<>();
        for(i=0; i<nums.length; i++){
            if(nums[i]!=i+1){//if a[0]!=1
                duplicateNumbers.add(nums[i]);//we add the number found in the incorrect index
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
