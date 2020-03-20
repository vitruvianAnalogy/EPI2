package com.educative.twopointers;

/**
 * Given: a sorted array of numbers
 * Task: Remove all duplicates
 * Constraint: No extra space allowed - hence no hashmap
 * Output : Remove duplicates
 * Return : Length of new array
 */
public class RemoveDuplicates {
    public static int returnNewLengthWithoutRemovingDuplicates(int[] arr){
        int slow = 0;
        int fast = slow+1;
        int len = arr.length;
        int total = 0;

        //When the fast pointer reaches the last index
        while(fast< len-1){
            while(arr[slow]==arr[fast]){
                fast++;
                arr[fast] =-1;
            }
            total++;
            slow=fast;
            fast++;
        }
        if(fast==len-1 && arr[slow]!=arr[fast]){
            total++;
        }
        return total;
    }

    /**
     * It might look like that this algo isn't removing duplicates in place
     * but it really is
     * @param arr
     * @return
     */
    public static int returnNewLengthWhileRemovingElementsInPlace(int[] arr){
        int nextNonDuplicateElement = 1; //this is the pointer that keeps track of the in-place array
        for(int i=1; i<arr.length; i++){ //i is the pointer that keeps track of the iteration
            if(arr[nextNonDuplicateElement-1]!=arr[i]){
                arr[nextNonDuplicateElement]=arr[i];
                nextNonDuplicateElement++;
            }
            //ELSE i increments, until it reaches an index such that it isn't a duplicate
            //at which, we do this 'arr[nextNonDuplicateElement]=arr[i]', we basically move it
            //to the next index available.
        }
        return nextNonDuplicateElement;
    }
}
