package com.epi.greedy.invariants;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SkylineProblem {
    public static int largestRectangle(List<Integer> heights) {
        //Why deque?
        Deque<Integer> pillarIndices = new LinkedList<>();
        int maxRectangleArea = 0;
        //O(n) where n is the number of buildings
        for(int buildingNumber = 0; buildingNumber <=heights.size(); buildingNumber++){
            // If we haven't already added a building in the list
            // and building number is valid, i.e. not greater than total buildings
            // and height of this building is equal to height of 'earlier' building
            // in the pillarIndices list - earlier because we are incrementally using the loop
            if(!pillarIndices.isEmpty() && buildingNumber < heights.size()
            && heights.get(buildingNumber).equals(heights.get(pillarIndices.peekFirst()))){
                pillarIndices.removeFirst();
                pillarIndices.addFirst(buildingNumber);
            }

            while(!pillarIndices.isEmpty()
            && isNewPillarOrReachEnd(heights, buildingNumber, pillarIndices.peekFirst())){
                int height = heights.get(pillarIndices.removeFirst());
                int width = pillarIndices.isEmpty() ? buildingNumber : buildingNumber - pillarIndices.peekFirst() -1;
                maxRectangleArea = Math.max(height * width, maxRectangleArea);
            }
            pillarIndices.addFirst(buildingNumber);
        }
        return maxRectangleArea;
    }

    private static boolean isNewPillarOrReachEnd(List<Integer> heights, int currentBuildingNumber, int previousBuildingNumber) {
        //If current building is valid
        //then check if the height of the current building is less than previous building or not
        return currentBuildingNumber < heights.size()
                ? heights.get(currentBuildingNumber) < heights.get(previousBuildingNumber)
                : true;
    }

    /*
    Time complexity - O(n2)
     */
    public static int largestRectangleUsingON2BruteForce(List<Integer> heights){
        int size = heights.size();
        int maxRectangle = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                maxRectangle = Math.max(maxRectangle, Math.min(heights.get(i), heights.get(j)) * (j - i + 1));
            }
        }
        return maxRectangle;
    }
}
