package com.epi.greedy;

public class SimpleGreedyChangeMaking {
    public static int changeMaking(int cents){
        final int[] COINS = {100, 50, 25, 10, 5, 1};
        int numCoins = 0;
        for(int i = 0; i< COINS.length; i++){
            numCoins += cents/COINS[i]; //add the numerator
            cents %= COINS[i]; //denominator becomes the left over cent
        }
        return numCoins;
    }
}
