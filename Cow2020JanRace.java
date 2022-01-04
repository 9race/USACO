package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020JanRace {
    public static void race() throws Exception {
        Scanner input = new Scanner(new File("race.in"));
        int distance = input.nextInt();
        int numSpeeds = input.nextInt();
        int[] speeds = new int[numSpeeds];
        int[] times = new int[numSpeeds];

        for(int i = 0; i < numSpeeds; i++){
            speeds[i] = input.nextInt();
        }

        for(int i = 0; i < numSpeeds; i++){
            int currDist = distance;
            int currSpeed = 1;
            int threshold = speeds[i];
            while(currDist > 0){
                if(needDecrease(currDist,currSpeed,threshold)){
                    currDist -= currSpeed;
                    currSpeed--;
                    times[i]++;
                }

                else if(canIncrement(currDist,currSpeed,threshold)) {
                    currDist -= currSpeed;
                    currSpeed++;
                    times[i]++;
                }
                else{
                    currDist -= currSpeed;
                    times[i]++;
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("race.out"));
        for(int i = 0; i < times.length; i++) {
            out.println(times[i]);
        }
        out.close();
        input.close();
    }

    public static boolean needDecrease(int currDist, int currSpeed, int threshold){
//        int val = currSpeed*(currSpeed+1)/2 - (threshold-2)*(threshold-1)/2;
        currDist -= currSpeed;
        int test = currSpeed*(currSpeed+1)/2 - (threshold)*(threshold-1)/2;
        if (test > currDist)
            return true;
//        if(val == currDist)
//            return true;
        return false;
    }

    public static boolean canIncrement(int currDist, int currSpeed, int threshold){
        if(currDist <= currSpeed+1 && currSpeed+1 > threshold)
            return false;
        int val = (currSpeed+2)*(currSpeed+1)/2 - (threshold-2)*(threshold-1)/2;
        if(val <= currDist)
            return true;
        return false;
    }

    //int[] times
    //int dist

    //loop thru speeds
        //

    //needDecrease(int currDist, int currSpeed, int threshold)
        //currDist(currDist+1)/2 - (threshold-2)(threshold-1)/2
        //if equal to dist
            //return true
        //return false

    //canIncrement
        //if currDist <= currSpeed+1
            //return false;
        ////currDist(currDist+1)/2 - (threshold-2)(threshold-1)/2
            //if equal to dist
                //
}





//method find speeds
//new arrList
//int maxSpeed
//int distance = 0
//int currentSpeed = 0
//while distance < maxDistance
//if(distance + increment) > maxDistance && increment <= maxSpeed
//distance += increment
//else if(distance + currentSpeed) > maxDistance