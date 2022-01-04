package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2016DecSquare {
    public static void squarePasture()throws Exception{
        Scanner coordinates = new Scanner(new File("square.in"));
        int[] xValues = new int[4];
        int[] yValues = new int[4];

        int spot = 0;
        for(int i = 0; i < 8; i++){
            if(i % 2 == 0){
                xValues[spot] = coordinates.nextInt();
            }
            else{
                yValues[spot] = coordinates.nextInt();
                spot++;
            }
        }

        int minX = xValues[0];
        int maxX = xValues[0];
        int minY = yValues[0];
        int maxY = yValues[0];

        for(int i = 1; i < 4; i++){
            if(xValues[i] < minX)
                minX = xValues[i];
            if(xValues[i] > maxX)
                maxX = xValues[i];
            if(yValues[i] < minY)
                minY = yValues[i];
            if(yValues[i] > maxY)
                maxY = yValues[i];
        }

        int largestDifference = 0;
        int xDifference = maxX - minX;
        int yDifference = maxY - minY;

        if(xDifference > yDifference)
            largestDifference = xDifference;
        else largestDifference = yDifference;

        PrintWriter out = new PrintWriter(new FileWriter("square.out"));
        out.println(largestDifference * largestDifference);
        out.close();
        coordinates.close();
    }
}