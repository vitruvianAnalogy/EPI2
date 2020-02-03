package com.educative.mergeintervals;

import java.util.*;

class EmployeeInterval{
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex){
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}
public class EmployeeFreeTime {
    public static List<Interval> getFreeIntervals(List<List<Interval>> listsOfIntervals){
        List<Interval> result = new ArrayList<>();

        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a,b)->(Integer.compare(a.interval.start, b.interval.start)));

        //insert first interval of each employee
        for(int i=0; i<listsOfIntervals.size(); i++){
            minHeap.offer(new EmployeeInterval(listsOfIntervals.get(i).get(0),i,0));
        }

        Interval prev = minHeap.peek().interval;
        while(!minHeap.isEmpty()){
            EmployeeInterval queueTop = minHeap.poll();
            if(prev.end < queueTop.interval.start){
                result.add(new Interval(prev.end, queueTop.interval.start));
                prev = queueTop.interval;
            } else {
                if(prev.end < queueTop.interval.end){
                    prev = queueTop.interval;
                }
            }

            List<Interval> employeeSchedule = listsOfIntervals.get(queueTop.employeeIndex);
            if(employeeSchedule.size() > queueTop.intervalIndex+1){
                minHeap.offer(new EmployeeInterval(
                        employeeSchedule.get(queueTop.intervalIndex+1),
                        queueTop.employeeIndex,
                        queueTop.intervalIndex+1
                ));
            }
        }
        return result;
    }
}
