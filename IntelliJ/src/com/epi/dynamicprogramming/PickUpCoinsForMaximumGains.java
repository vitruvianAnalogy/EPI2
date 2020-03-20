package com.epi.dynamicprogramming;

import java.util.List;

//Time complexity = O(n^2)
public class PickUpCoinsForMaximumGains {
    public static int pickUpCoins(List<Integer> coins){
        /**
         memoization needs a 2d array of size m,n where m==n==number of coins
         why 2D?
         Because we need to know the best outcome when we have a certain left and certain right end
         for instance in case of 5,25,10,1
         if left is 5 and right is 1
         if left is 25 and right is 1
         or if left is 5 and right is 10
         */
        return computeMaximumRevenueForRange(coins, 0, coins.size()-1,
                new int[coins.size()][coins.size()]);
    }

    private static int computeMaximumRevenueForRange(List<Integer> coins, int left, int right, int[][] maximumRevenueForRange) {
        if(left > right){
            //no coins left
            return 0;
        }
        if(maximumRevenueForRange[left][right]==0){
            int maximumRevenueLeft = coins.get(left) + Math.min(computeMaximumRevenueForRange(coins, left +1, right -1, maximumRevenueForRange),
                    computeMaximumRevenueForRange(coins, left + 2, right, maximumRevenueForRange));
            int maximumRevenueRight = coins.get(right) + Math.min(computeMaximumRevenueForRange(coins, left + 1, right -1, maximumRevenueForRange),
                    computeMaximumRevenueForRange(coins, left , right - 2, maximumRevenueForRange));
            maximumRevenueForRange[left][right] = Math.max(maximumRevenueLeft , maximumRevenueRight);
        }
        return maximumRevenueForRange[left][right];
    }
}
