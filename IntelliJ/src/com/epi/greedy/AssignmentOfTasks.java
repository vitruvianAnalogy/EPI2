package com.epi.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Tasks are independent, so no order of completion of tasks
 * Each worker can be assigned exactly only two tasks
 * For tasks of duration 5,2,1,6,4,4
 * the optimum assignment would be to assign (5,2), (1,6) and (4,4)
 * This way the maximum time to finish the task would be 8
 * which is the fastest it takes to complete the task
 */
public class AssignmentOfTasks {
    
    static class Assignment{
        int a;
        int b;
        public Assignment(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args){
        List<Integer> tasks= Arrays.asList(5,2,1,6,4,4);
        List<Integer> tasks2 = Arrays.asList(5,2,1,6,4,4,9);
        List<Integer> tasks3 = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,100,200,300);

        AssignmentOfTasks assigning = new AssignmentOfTasks();
        List<Assignment> assignment = assigning.assignTasks(tasks);
    }

    private static List<Assignment> assignTasks(List<Integer> tasks) {
        ArrayList<Assignment> assignment = new ArrayList<>();
        Collections.sort(tasks);
        int length = tasks.size();
        if(length%2==1){
            assignment.add(new Assignment(tasks.get(tasks.size()-1),-1));
            tasks.remove(tasks.size()-1);
        }
        for(int i=0; i<=tasks.size()/2; i++){
            assignment.add(new Assignment(tasks.get(i), tasks.get(tasks.size()-1-i)));
        }
        return assignment;
    }
}
