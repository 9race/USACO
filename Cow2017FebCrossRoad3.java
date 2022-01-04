package com.company;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2017FebCrossRoad3 {
    public static void crossRoad3() throws Exception{
        Scanner input = new Scanner(new File("cowqueue.in"));

        int numCows = input.nextInt();
        ArrayList<Integer> arrivalTimes = new ArrayList<Integer>();
        ArrayList<Integer> questioningTimes = new ArrayList<Integer>();

        for(int i = 0; i < numCows; i++){
            arrivalTimes.add(input.nextInt());
            questioningTimes.add(input.nextInt());
        }

        int nextArrival = 0;
        while(arrivalTimes.size() > 0){
            int minIndex = findFirstArrival(arrivalTimes);
            if(arrivalTimes.get(minIndex) < nextArrival)
                nextArrival += questioningTimes.get(minIndex);
            else nextArrival = arrivalTimes.get(minIndex) + questioningTimes.get(minIndex);
            arrivalTimes.remove(minIndex);
            questioningTimes.remove(minIndex);
        }

        PrintWriter out = new PrintWriter(new FileWriter("cowqueue.out"));
        out.println(nextArrival);
        out.close();
        input.close();

        //create arrayList of arrivalTimes
        //create arrayList of questioningTimes
        //int minNextArrival
        //while arrivalTimes.size() > 0
            //int minIndex = findFirstArrival
            //if(arrivalTimes[minIndex] < minNextArrival)
                //minNextArrival += questioningTimes[minIndex];
        //else //minNextArrival = arrivalTimes[minIndex] + questioningTimes[minIndex];
            //remove val at minIndex in both arrayLists

    }

    public static int findFirstArrival(ArrayList<Integer> arrayList){
        int minVal = arrayList.get(0);
        int minIndex = 0;
        for(int i = 1; i < arrayList.size(); i++){
            if(arrayList.get(i) < minVal){
                minVal = arrayList.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
}

//Test Cases:
    //all back to back
    //none back to back, overlapping
    //big gap in between