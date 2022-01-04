package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Cow2016OpenFieldReduction {
    public static void reduceField() throws Exception{
        Scanner input = new Scanner((new File("reduce.in")));

        int numCows = input.nextInt();
        int[] xValues = new int[numCows];
        int[] yValues = new int[numCows];

        for(int i = 0; i < numCows; i++){
            xValues[i] = input.nextInt();
            yValues[i] = input.nextInt();
        }

        int[] extremeVals = findExtremes(xValues, yValues);
        int minArea = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++){
            int area = 0;
                area = findArea(extremeVals[i], xValues, yValues);
            if(area < minArea)
                minArea = area;
        }

        PrintWriter out = new PrintWriter(new FileWriter("reduce.out"));
        out.println(minArea);
        out.close();
        input.close();

    }

    public static int findArea(int index, int[] arrX, int[] arrY){
        int newXArr[] = new int[arrX.length - 1];
        int newYArr[] = new int[arrY.length - 1];
            int xSpot = 0;
            for (int i = 0; i < arrX.length; i++) {
                if (i != index) {
                    newXArr[xSpot] = arrX[i];
                    xSpot++;
                }
            }
            int ySpot = 0;
            for (int i = 0; i < arrY.length; i++) {
                if (i != index) {
                    newYArr[ySpot] = arrY[i];
                    ySpot++;
                }
            }
            int[] extremes = findExtremes(newXArr, newYArr);
            return ((newXArr[extremes[0]] - newXArr[extremes[1]]) * (newYArr[extremes[2]] - newYArr[extremes[3]]));
    }

    public static int[] findExtremes(int[] arr1, int[] arr2){
        int maxXVal = arr1[0];
        int minXVal = arr1[0];
        int minXIndex = 0;
        int maxXIndex = 0;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] > maxXVal) {
                maxXVal = arr1[i];
                maxXIndex = i;
            }
            else if(arr1[i] < minXVal) {
                minXVal = arr1[i];
                minXIndex = i;
            }
        }
        int maxYVal = arr2[0];
        int minYVal = arr2[0];
        int minYIndex = 0;
        int maxYIndex = 0;
        for(int i = 0; i < arr2.length; i++){
            if(arr2[i] > maxYVal) {
                maxYVal = arr2[i];
                maxYIndex = i;
            }
            else if(arr2[i] < minYVal) {
                minYVal = arr2[i];
                minYIndex = i;
            }
        }
        int[] extremes = {maxXIndex, minXIndex, maxYIndex, minYIndex};
        return extremes;
    }

    //put all xValues into arr
    //put all yValues into arr
    //call find extremes
    //loop thru extreme arr
    //call findArea
    //if area < minArea
    //minArea = area



    //findArea (index, arr)
    //create new arr without the val
    //call findExtremes
    //find area


    //findExtremes
    //loop thru xVal
    //if less than min
    //set index to minIndex
    //if greater than max
    //set index to maxIndex
    //loop thru xVal
    //if less than min
    //set index to minIndex
    //if greater than max
    //set index to maxIndex
    //put max and min indices into arr
    //return arr
}
