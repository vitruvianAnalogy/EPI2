package com.epi.greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        if(this.end<((Interval)o).end){
            return -1;
        } else if (this.end > ((Interval)o).end){
            return 1;
        } else {
            return 0;
        }
    }
}
public class IntervalCoveringProblem {

    public static List<Integer> minimumSizedSetOfNumbers(List<Interval> intervals){
        if(intervals.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        Collections.sort(intervals);
        List<Integer> visits = new ArrayList<>();
        Integer lastVisitTime = intervals.get(0).end;
        visits.add(lastVisitTime);

        for(Interval interval : intervals){
            /**
             * when we encounter an interval whose 'start' we haven't
             * covered in the last visit, then we use it's 'end'
             */
            if(interval.start > lastVisitTime){
                lastVisitTime = interval.end;
                visits.add(lastVisitTime);
            }
        }
    }
}
