package com.educative.mergeintervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Job{
    int start;
    int end;
    int cpuLoad;
    public Job(int start, int end, int cpuLoad){
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}

public class MaximumCPULoad {
    public static int maxCPULoad(List<Job> jobs){
        if(jobs == null || jobs.size() ==  0){
            return 0;
        }

        int maxCPULoad = 0;
        int currentCPULoad = 0;
        Collections.sort(jobs, (a,b)->(Integer.compare(a.start, b.start)));
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a,b)->(Integer.compare(a.end, b.end)));
        for(Job job : jobs){
            while(!minHeap.isEmpty() && job.start > minHeap.peek().end)
                currentCPULoad -= minHeap.poll().cpuLoad;
            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;
            Math.max(currentCPULoad, maxCPULoad);
        }
        return maxCPULoad;
    }
}