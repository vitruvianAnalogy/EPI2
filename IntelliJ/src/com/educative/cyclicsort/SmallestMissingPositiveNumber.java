package com.educative.cyclicsort;

public class SmallestMissingPositiveNumber {
    public static int smallestMissingNumber(int[] nums){
        int i = 0;
        while(i < nums.length){

            //if nums[i] doesn't have the correct number
            //then nums[i] -1 won't be equal to i
            //we store nums[i]-1 in j and then check if nums[i]==nums[j]
            //if nums[i] = nums[j] then it means both i and j are the same index
            //because we don't have duplicate numbers
            // or we have duplicate numbers but they are in indexes i and j
            //Since in this problem we know we don't have duplicate numbers
            //we can do what we should be doing
            int j = nums[i] - 1;
            //if number is positive
            if(nums[i] > 0){
                swap(nums,i,j);
            } else if (nums[i] <= nums.length){ //is within the range
                swap(nums,i,j);
            } else if (nums[i] != nums[j]){ // and the usual check that the number is not equal to what it should be
                swap(nums,i,j);
            } else { //if these conditions are not met we'll just ignore that cell
                i++;
            }
        }

        for(i = 0; i<nums.length; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        //If we are here, then that means that the array has all numbers from 1 to n
        //that means the smallest number that is not in the array is n + 1
        //
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
