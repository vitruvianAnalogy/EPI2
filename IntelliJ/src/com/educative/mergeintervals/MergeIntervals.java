package com.educative.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals){
        if(intervals.size()<2)
            return intervals;
        List<Interval> mergedIntervals = new ArrayList<>();
        Collections.sort(intervals, (a,b) ->Integer.compare(a.start,b.start));

        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()){
            interval = intervalIterator.next();
            if(interval.start <= end){//overlapping
                end = Math.max(interval.end, end); //increase the end, hence increasing the interval
            } else {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start,end)); //final interval
        return mergedIntervals;
    }
}
