package com.educative.mergeintervals;

import java.util.*;

import static java.lang.Integer.compare;

class Meeting{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

/**
 * Time complexity
 * O(N*logN) for Collections.sort
 * Minheap operations like poll and offer take O(log N) time and they
 * happen inside an iteration that takes O(N) time, hence making that (N * log N) as well
 *
 * O(N) is the space complexity because
 * in worst case the minHeap will have all the meetings
 * since all the meetings will be overlapping
 *
 *
 * MinHeap's function is that it keeps the smallest end time possessing meeting at top
 * meaning the meeting that will finish first is at the top
 * hence that is our best chance to find a room
 */
public class MinimumMeetingRooms {
    public static int minimumNumberOfRooms(List<Meeting> meetings){
        //If no meetings
        if(meetings == null || meetings.size() == 0)
            return 0;

        Collections.sort(meetings, (a,b)->(Integer.compare(a.start, b.start)));

        int minRooms = 0;

        //Create a minHeap that is of size of the meetings
        //and since it is the mean heap we need compare to
        //use end times of the meetings
        //Remember PriorityQueue in java is minheap by default
        //to use priority queue as max heap, you should reverse the compareto method
        PriorityQueue<Meeting> minHeap =
                new PriorityQueue<>(meetings.size(), (a,b)-> (Integer.compare(a.end,b.end)));

        //Iterate through each meeting
        for(Meeting meeting : meetings){
            //Remove all meetings that have ended
            //We'll iterate through all meetings in the minheap
            //minheap will store the meeting with lowest end time in the heap
            //if the lowest end time is more than start time
            //then that means no meetings have ended
            //but if current meeting's start time is more than head meetings's
            //end time then that means that meeting has ended
            while(!minHeap.isEmpty() && meeting.start>=minHeap.peek().end){
                minHeap.poll();
            }
            //now that we have removed all meetings that have ended, we'll have to use
            //a new room
            minHeap.offer(meeting);

            //all active meetings are in minHeap, so the size of the minHeap will tell us
            //how many meeting rooms we need
            minRooms = Math.max(minRooms, minHeap.size());
            //On last iteration, we'll have checked all meetings for the sizes
            //and hence the minRooms in the end will be the correct answer
        }

        return minRooms;
    }

    private static class MergingClass {
        public static List<Interval> merge(List<Interval> intervals) {
            List<Interval> mergedIntervals = new ArrayList<>();
            if(intervals == null || intervals.size() == 0)
                return intervals;
            Iterator<Interval> it = intervals.iterator();
            Interval prev = it.next();
            int start = prev.start;
            int end = prev.end;

            while(it.hasNext()){
                Interval curr = it.next();
                //interval ends before start of next
                if(curr.start>=end){
                    mergedIntervals.add(new Interval(start, end));
                    start = curr.start;
                    end = curr.end;
                    continue;
                }
                //next interval starts before end
                if(end>curr.start){
                    end = Math.max(end, curr.end);
                    //no adding into mergedIntervals, because it could merge with the next interval as well
                }
                //next interval is inside the prev
                if(end>curr.end){
                    end = Math.max(end, curr.end);
                }
            }
            mergedIntervals.add(new Interval(start,end));
            return mergedIntervals;
        }
    }
}
