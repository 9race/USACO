package com.company;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Cow2016FebBarn {
    public static void circularBarn() throws Exception{
        Scanner input = new Scanner(new File("cbarn.in"));

        int numRooms = input.nextInt();
        int[] numCows = new int[numRooms];
        for(int i = 0; i < numRooms; i++){
            numCows[i] = input.nextInt();
        }
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < numRooms; i++){
            int distance = findDistance(i, numCows);
            if(distance < minDistance)
                minDistance = distance;
        }

        PrintWriter out = new PrintWriter(new FileWriter("cbarn.out"));
        out.println(minDistance);
        out.close();
        input.close();

    }

    public static int findDistance(int startingIndex, int[] arr){
        int[] newArr = new int[arr.length];
        int newIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(newIndex + startingIndex >= arr.length)
                newIndex = 0 - startingIndex;
            newArr[i] = arr[newIndex + startingIndex];
            newIndex++;
        }
        int distance = 0;
        for(int i = 0; i < arr.length; i++){
            distance += newArr[i]*i;
        }
        return distance;
    }

    //main method
    //put all values int arr
    //int minDistances
    //loop thru arr
    //call findDistance
    //if findDistance < min
    //min = findDistance

    //method findDistance (startingIndex, arr)
    //puts values into new array with value at startingIndex at index 0
    //int distance
    //loop thru newArr
    //distance += newArr[i]*i
    //return distance
}
