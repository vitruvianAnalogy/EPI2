package com.epi.greedy;

import java.util.Collections;
import java.util.List;

/**
 * 1,2,3,5
 * 0 = 1
 * 0+1 = 2
 * 0+1+2 = 3
 * 0+1+2+3 = 5
 */
public class ScheduleToMinimizeWaitingTime {
    public static int minimumWaitingTime(List<Integer> serviceTimes){
        int minWaitTime = 0;
        int minWaitTimeBruteForce = 0;
        Collections.sort(serviceTimes);
        for(int i=0; i<serviceTimes.size(); i++){
            //In above example 1 is added three times. 1 is the shortest service time.
            //Three times because it has three more "servicetimes" after it.
            int numberOfTimesEachWaitingTimeWillBeCounted = serviceTimes.size() - (i+1);
            minWaitTime+=serviceTimes.get(i) +numberOfTimesEachWaitingTimeWillBeCounted;
//            minWaitTime = minWaitTime+ minWaitTime + serviceTimes.get(i-1);
//            minWaitTime += minWaitTimeForIth(serviceTimes, i);
            /**
             * Brute force way would be to count all the queries before the query that is being counted.
             */
            minWaitTimeBruteForce+= minWaitTimeForIth(serviceTimes, i);
        }
        return minWaitTime;
    }

    /**
     * Brute force = Calculate
     * @param waitingTimes
     * @param i
     * @return
     */
    private static int minWaitTimeForIth(List<Integer> waitingTimes, int i) {
        int sum = 0;
        if(i==0){
            return 0;
        } else {
            for(int j = i-1; j>=0; j--){
                sum += waitingTimes.get(j);
            }
        }
        return sum;
    }

}
