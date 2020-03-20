package com.epi.dynamicprogramming;

public class CountTheNumberOfMovesToClimbStairs {
    public static int numberOfWaysYouCanGetToYourDestination(int n, int maximumStep){
        /**
        Since we are counting the "number of moves" there are only n states
        i.e. the number of ways to get to your destination if you are at the 1ST step
             the number of ways to get to your destination if you are at the 2ND step
             the number of ways to get to your destination if you are at the 3RD step
        So the number of states should be equal to number of stairs i.e. 'n'

         We'll also want to use index 1 for stair 1, but arrays go from 0 to n-1 rather than 1 to n
         therefore we'll create an array of size (n+1) instead of (n)
         */
        int[] stairsStep = new int[n+1];

        return countWays(stairsStep, n, maximumStep);

    }

    private static int countWays(int[] stairsStep, int whichStair, int maximumStep) {
        if(whichStair<=1){
            return 1;
        }
        if(stairsStep[whichStair] == 0){
            for(int step=1; step<=maximumStep && whichStair-step > 0; step++){
                stairsStep[whichStair] += countWays(stairsStep, whichStair-step, maximumStep);
            }
        }
        return stairsStep[whichStair];
    }
}
