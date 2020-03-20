package com.epi.greedy.invariants;

import java.util.List;

/**
 * brute force - O(n2)
 */
public class MaximumWaterTrappedByAPairOfVerticalLines {
    public static int maximumWaterBruteForce(List<Integer> heights){
        int numberOfPillars = heights.size();
        int max = 0;
        for(int i=0; i<numberOfPillars; i++){
            for(int j=i+1;j<numberOfPillars; j++){
                Math.max((j-i)*Math.min(heights.get(i), heights.get(j)), max);
            }
        }
        return max;
    }

    // -------------------------------------------------------------------------------------------------
    public static int maximumWaterDivideAndConquer(List<Integer> heights){
        int numberOfPillers = heights.size();
        int mid = heights.size()/2;
        return Math.max(maxWater(heights, 0, mid), maxWater(heights, mid+1, heights.size()-1));
    }

    private static int maxWater(List<Integer> heights, int i, int j) {
        if(j==i){
            return 0;
        } else if (j-i==1){
            return Math.min(heights.get(j), heights.get(i));
        }
        int mid = (i+j)/2;
        return Math.max(maxWater(heights, i, mid), maxWater(heights, mid+1, j));
    }
    // -------------------------------------------------------------------------------------------------

    public static int maximumWaterOptimized(List<Integer> heights){
        int i = 0, j=heights.size()-1, maxWater = 0;
        while(i<j){
            int width = j - i;
            maxWater = Math.max(maxWater, (j-i) * Math.min(heights.get(i), heights.get(j)));
            if(heights.get(j)>heights.get(i)){
                i++;
            } else if (heights.get(i) > heights.get(j)){
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxWater;
    }
}
