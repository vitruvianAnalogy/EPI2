package com.epi.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinimumWeightedPathInATriangle {

    public static int minimumPathTotal(List<List<Integer>> triangle){
        /**
         * Check if the triangle is empty
         */
        if(triangle.isEmpty())
            return 0;
        A

        /**
         * Extract the first array
         */
        List<Integer> prevRow = new ArrayList<>(triangle.get(0));

        /**
         * Iterate through the triangle from second row to last row
         */
        for(int i=1; i<triangle.size(); i++){
            /**
             * Store the second, third, fourth....nth row
             */
            List<Integer> currentRow = new ArrayList<>(triangle.get(i));
            //store the prev row's first element and current row's first element and add them
            //store their sum in the first element
            currentRow.set(0,currentRow.get(0)+prevRow.get(0)); //leftmost element
            for(int j=1; j<currentRow.size() -1 ; j++){ //iterate through first column of current row to the end
                //replace jth column with sum of current row's jth element  and the
                //minimum of previous row's adjacent elements
                //adjacent elements are usually in same column or in the column before
                currentRow.set(j, currentRow.get(j) + Math.min(prevRow.get(j-1), prevRow.get(j)));
            }
            //rightmost element
            currentRow.set(currentRow.size()-1, currentRow.get(currentRow.size()-1)+prevRow.get(prevRow.size()-1));
            prevRow = currentRow;
        }
        return Collections.min(prevRow);
    }
}
