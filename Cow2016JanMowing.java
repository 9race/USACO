package com.company;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


public class Cow2016JanMowing {
    public static void mow() throws Exception {
        int totalSteps = getTotalSteps();

        Scanner input = new Scanner(new File("mowing.in"));

        int numDirectionChanges = input.nextInt();
        int[][] coordinates = new int[totalSteps + 1][2];
        coordinates[0][0] = 0;
        coordinates[0][1] = 0;

        int spot = 1;
        for (int i = 0; i < numDirectionChanges; i++) {
            char direction = input.next().charAt(0);
            int partialSteps = input.nextInt();
            for (int j = 0; j < partialSteps; j++) {
                if (direction == 'N') {
                    coordinates[spot][0] = coordinates[spot - 1][0];
                    coordinates[spot][1] = coordinates[spot - 1][1] + 1;
                }
                if (direction == 'S') {
                    coordinates[spot][0] = coordinates[spot - 1][0];
                    coordinates[spot][1] = coordinates[spot - 1][1] - 1;
                }
                if (direction == 'E') {
                    coordinates[spot][0] = coordinates[spot - 1][0] + 1;
                    coordinates[spot][1] = coordinates[spot - 1][1];
                }
                if (direction == 'W') {
                    coordinates[spot][0] = coordinates[spot - 1][0] - 1;
                    coordinates[spot][1] = coordinates[spot - 1][1];
                }
                spot++;
            }
        }

        ArrayList<Integer> intersections = findIntersection(coordinates);
        int min = Integer.MAX_VALUE;
        if(intersections.size() == 0)
            min = -1;

        for(int i = 0; i < intersections.size() - 1; i = i + 2){
            if((intersections.get(i+1) - intersections.get(i)) < min)
                min = intersections.get(i+1) - intersections.get(i);
        }

        ArrayList<Integer> stuff = new ArrayList<Integer>();
        PrintWriter out = new PrintWriter(new FileWriter("mowing.out"));
        out.println(min);
        out.close();
        input.close();
    }

    public static int getTotalSteps() throws Exception {
        Scanner input = new Scanner(new File("mowing.in"));
        int numSteps = input.nextInt();
        int totalSteps = 0;
        for (int i = 0; i < numSteps; i++) {
            input.next();
            totalSteps += input.nextInt();
        }
        input.close();
        return totalSteps;
    }

    public static ArrayList<Integer> findIntersection(int[][] coordinates) throws Exception {
        Scanner input = new Scanner(new File("mowing.in"));
        ArrayList<Integer> intersect = new ArrayList<Integer>();

        for(int i = 0; i < coordinates.length; i++){
            for(int j = i+1; j < coordinates.length; j++){
                if(coordinates[i][0] == coordinates[j][0] && coordinates[i][1] == coordinates[j][1]) {
                    intersect.add(i);
                    intersect.add(j);
                }
            }
        }
        return intersect;
    }
}

//new ArrayList intersections
//loop thru coordinates
    //loop thru elements after current index
        //if(coordinates[i][0] == coordinates[j][0] && coordinates[i][1] == coordinates[j][1])
            //add both i and j to ArrayList
//return ArrayList





//    public static int[][] convert(int[] arr1, int[]arr2){
//        int length;
//        int[][] result;
//        if(arr1.length < arr2.length) {
//            length = arr1.length;
//            result = new int[arr2.length][2];
//        }
//        else{
//            length = arr2.length;
//            result = new int[arr1.length][2];
//        }
//        for(int i = 0; i < length; i++){
//            for(int j = 0; j < 2; j++){
//                if(j == 0)
//                    result[i][j] = arr1[i];
//                else result[i][j] = arr2[i];
//            }
//        }
//        if(length == arr1.length)
//            for(int i = 0; i < arr2.length - arr1.length; i++){
//                for(int j = 0; j < 2; j++) {
//                    if(j == 0)
//                        result[i + arr1.length][j] = arr1[arr1.length-1];
//                    else result[i + arr1.length][j] = arr2[i + arr1.length];
//                }
//            }
//        return result;
//    }
//
//}

// for(int i = 0; i < numDirectionChanges; i++){
//
//            char direction = input.next().charAt(0);
//            int numMoves = input.nextInt();
//
//            for(int j = 0; j < numMoves; j++) {
//                if(direction == 'N') {
//                    if(ySpot > 0)
//                        yValues[ySpot] = yValues[ySpot - 1] + 1;
//                    else yValues[ySpot]++;
//                    ySpot++;
//                }
//                else if(direction == 'S'){
//                    if(ySpot > 0)
//                        yValues[ySpot] = yValues[ySpot - 1] - 1;
//                    else yValues[ySpot]--;
//                    ySpot++;
//                }
//                else if(direction == 'W'){
//                    if(xSpot > 0)
//                        xValues[xSpot] = xValues[xSpot - 1] - 1;
//                    else xValues[xSpot]--;
//                    xSpot++;
//                }
//                else if(direction == 'E'){
//                    if(xSpot > 0)
//                        xValues[xSpot] = xValues[xSpot - 1] + 1;
//                    else xValues[xSpot]++;
//                    xSpot++;
//                }
//            }
//        }

//int[][] coordinates = new int[][];
//find total number of steps = 32
//directionChanges
//for(int i = 0; i < directionChanges; i++)
//
//for(int j = 0; j < partialSteps; j++)
//if(N)
//increment y, x stays same
//if(S)
//decrement y, x stays same
//if(E)
//increment x, y stays same
//if(W)
//decrement x, y stays same


//        ArrayList<Integer> intersections = findIntersection(coordinates);
//        int min = intersections.get(0);
//        for(int i = 0; i < intersections.size()-1; i = i+2){
//            if(intersections.get(i+1) - intersections.get(i) < min)
//                min = intersections.get(i+1) - intersections.get(i);
//        }


//    public static int findNorthSouth() throws Exception{
//        Scanner input = new Scanner(new File("mowing.in"));
//        int num = 0;
//        int numTimes = input.nextInt();
//        for(int i = 0; i < numTimes; i++){
//            char direction = input.next().charAt(0);
//            if(direction == 'N' || direction == 'S')
//                num += input.nextInt();
//            else input.nextInt();
//        }
//        return num;
//    }
//
//    public static int findEastWest() throws Exception{
//        Scanner input = new Scanner(new File("mowing.in"));
//        int num = 0;
//        int numTimes = input.nextInt();
//        for(int i = 0; i < numTimes; i++){
//            char direction = input.next().charAt(0);
//            if(direction == 'E' || direction == 'W')
//                num += input.nextInt();
//            else input.nextInt();
//        }
//        return num;
//    }

//
//        for(int i = 0; i < intersect.size() - 2; i = i+2){
//                if(northSouth[intersect.get(i)] != northSouth[intersect.get(i+1)]) {
//                intersect.remove(i);
//                intersect.remove(i + 1);
//            }
//        }