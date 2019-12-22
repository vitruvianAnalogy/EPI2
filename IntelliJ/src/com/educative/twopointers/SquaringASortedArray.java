package com.educative.twopointers;

/**
 * Given : A sorted Array with both negative and positive numbers
 * Output : A sorted array of squares of numbers. (since it has negative numbers, smaller numbers can
 * lead to bigger squares than the positive numbers)
 */
public class SquaringASortedArray {
    public static int[] returnSquareArrayByFindingThePositiveIndex(int[] arr){
        int[] squares = new int[arr.length];
        int squaresIndex = 0;
        int positiveIndex = 0;
        int negativeIndex = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=0){
                positiveIndex = i;
                negativeIndex = i-1;
                break;
            }
        }
        while(positiveIndex<arr.length && negativeIndex>=0){
            int a = arr[positiveIndex]*arr[positiveIndex];
            int b = arr[negativeIndex]*arr[negativeIndex];
            if(a<=b){
                squares[squaresIndex] = a;
                positiveIndex++;
            } else if(a>b){
                squares[squaresIndex] = b;
                negativeIndex--;
            }
            squaresIndex++;
        }
        while(negativeIndex>=0){
            squares[squaresIndex++] = arr[negativeIndex]*arr[negativeIndex];
            negativeIndex--;
        }
        while(positiveIndex<arr.length){
            squares[squaresIndex++] = arr[positiveIndex]*arr[positiveIndex];
            positiveIndex++;
        }
        return squares;
    }

    public static int[] returnSquareArrayByUsingPointersFromFirstAndLastIndexAndThenWorkingTheirWayBackwards(int[] arr){
        int[] squares = new int[arr.length];
        //insert code
        return squares;
    }
}
