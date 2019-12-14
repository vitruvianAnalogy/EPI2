package com.epi.greedy.invariants;

import java.util.List;

public class Gasup {
    //Mileage
    private final static int MPG = 20;

    private static class CityAndRemainingGas{
        int city;
        int remainingGas;
        public CityAndRemainingGas(int city, int remainingGas){
            this.city = city;
            this.remainingGas = remainingGas;
        }
    }

    /**
     * We need to start at each city and do a run.
     * If we finish the loop without running out of gas, we have an ample city
     * @param gallons - list of gallons each city provides
     * @param distances - list of distances from the current city to the next
     * @return
     */
    public static final int findAmpleBruteForce(List<Integer> gallons, List<Integer> distances){
        //Assuming that each city's gallons are included, even if they are zero
        if (gallons.size()!=distances.size()){
            return -1;
        }
        for(int i=0; i<gallons.size(); i++){
            CityAndRemainingGas startCity = new CityAndRemainingGas(i, gallons.get(i));
            for(int j=1; j<gallons.size();j++){
                startCity.remainingGas = distances.get(j-1);
                //TODO
            }
        }
        return -1; //TODO
    }

    public static final int findAmpleCity(List<Integer> gallons, List<Integer> distances){
        int remainingGallons = 0;
        //vehicle didn't had any gas to begin with
        CityAndRemainingGas min = new CityAndRemainingGas(0, 0); //start
        final int numCities = gallons.size();

        for(int i=1; i< numCities; i++){
            //gallons had - gallons used
            int gallonsHad = gallons.get(i-1);
            int gallonsUsed = distances.get(i-1)/MPG;
            remainingGallons += (gallonsHad - gallonsUsed);

            /**
             * If gallons left is less than zero (to get from last city to this city)
             * (Remember min.remaining gas is initialized to zero)
             * OR
             * If gallons left after travelling from the previous city to the current city
             * is less than what they were "remaining" from the visit prior to that
             * then we used more than
             * (what we got in the previous city + what we had when we got to the previous city)
             * meaning previous city cannot be used as start
             * remainingGallons - remainingGas < remainingGas - remainingGas
             * left < 0
             * there prev city couldn't have been the ample city since we need to start at 0
             */
            if(remainingGallons < min.remainingGas){
                min = new CityAndRemainingGas(i, remainingGallons);
            }
        }
        return min.city;
    }

}
