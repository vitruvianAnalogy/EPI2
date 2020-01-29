package com.educative.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    public static Interval[] intersectionSet(Interval[] intervals1, Interval[] intervals2){
        List<Interval> mergedIntervals = new ArrayList<>();
        int len1 = intervals1.length;
        int len2 = intervals2.length;

        int i = 0;
        int j = 0;
        while(i<len1 && j<len2){
            if((intervals1[i].start <= intervals2[j].end && intervals1[i].end >= intervals2[j].end)||
                    (intervals1[j].start <=intervals1[i].end && intervals2[j].end >= intervals1[i].end )){
                int start  = Math.max(intervals1[i].start, intervals2[i].start);
                int end = Math.min(intervals1[i].end, intervals2[i].end);
                mergedIntervals.add(new Interval(start,end));
            }

            //move away from the interval that is finishing first, since it is in the intersection
            if(intervals1[i].end < intervals2[j].end){
                i++;
            } else {
                j++;
            }
        }

        return mergedIntervals.toArray(new Interval[mergedIntervals.size()]);
    }
}
