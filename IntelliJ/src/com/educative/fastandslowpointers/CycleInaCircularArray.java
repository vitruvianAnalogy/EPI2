package com.educative.fastandslowpointers;

public class CycleInaCircularArray {
    public static boolean cycleExistsForArray(int[] arr){
        for(int i=0; i<arr.length;i++){
            boolean isForward = (arr[i]>=0); //whether we are moving forward or backward

            int slow = i, fast = i;
            do{
                slow = findNextIndex(arr, isForward, slow);
                fast = findNextIndex(arr, isForward, fast);
                if(fast!=-1)
                    fast = findNextIndex(arr, isForward, fast);
            } while(slow!=-1 && fast!=-1 && slow!=fast);

            if(slow != -1 && slow == fast)
                return true;
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction =(arr[currentIndex]>=0);
        if(isForward!=direction)//if direction changed then we can't find a cycle
            return -1;

        int nextIndex = (currentIndex + arr[currentIndex])%arr.length;

        //nextindex will only be negative if the direction has always been running backwards
        if(nextIndex < 0) //if we go beyond the start of the array
            nextIndex += arr.length; //then we are backtracking from the end of the array

        //If we end up on the same index, after one step, then it means the cycle was only one element long
        //hence returning -1
        if(nextIndex == currentIndex) // one element cycle
            nextIndex = -1;

        return nextIndex;
    }
}
