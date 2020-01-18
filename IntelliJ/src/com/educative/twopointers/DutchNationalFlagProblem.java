package com.educative.twopointers;

public class DutchNationalFlagProblem {
    //only three entires are possible 0,1,2
    public void sortArrayInPlaceTreatingEachEntryAsObject(int[] arr){
        int left = 0, right = arr.length -1;
        for(int i=0; i<=right;){
            if(arr[i] == 0){
                swap(arr,i,left);
                //move to the next element,
                //because the current element was 0
                // and now you have whatever left was on the left side, probably a 1
                i++;
                left++; //left increments, because we have a 0 now before left.
            } else if(arr[i] == 1){
                i++; //we keep it where it is, and move to the next element
            } else {
                swap(arr,i,right); //move i to right
                //no incrementing i because we wanna see what we swapped with.
                right--;
            }
        }
    }

    private void swap(int[] arr, int i, int left) {
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
    }
}
