package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020FebTriangle {
    public static void triangle() throws Exception{
        Scanner input = new Scanner(new File("triangles.in"));
        int numCoordinates = input.nextInt();
        int[][] coordinates = new int[numCoordinates][2];

        int maxArea = 0;

        for(int i = 0; i < numCoordinates; i++){
            for(int j = 0; j < 2; j++){
                coordinates[i][j] = input.nextInt();
            }
        }

        for(int i = 2; i < numCoordinates; i++){
            for(int j = 0; j < numCoordinates; j++){
                for(int m = 0; m < numCoordinates; m++){
                    int[] one = coordinates[i];
                    int[] two = coordinates[j];
                    int[] three = coordinates[m];
                    if(valid(one, two, three) ||valid(one, three, two) ||
                            valid(two, one, three) || valid(two, three, one) ||
                            valid(three, two, one) || valid(three, one, two))
                    {
                        int area = findArea(one, two, three);
                        if(area > maxArea){
                            maxArea = area;
                        }
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("triangles.out"));
        out.print(maxArea);
        out.close();
        input.close();
//loop thru 3
        //check if valid
            //calc area



    }

    public static boolean valid(int[] one, int[] two, int[] three){
        if(one[0] == two[0] && (one[1] == three[1] || two[1] == three[1]))
            return true;
        return false;
    }

    public static int findArea(int[] one, int[] two, int[] three){
        if(one[0] == two[0]){
            if(one[1] == three[1]){
                return (Math.abs(two[1] - one[1])*Math.abs(three[0]-one[0]));
            }
            else if(two[1] == three[1]){
                return (Math.abs(two[1] - one[1])*Math.abs(three[0]-two[0]));
            }
        }
        else if(three[0] == two[0]){
            if(one[1] == three[1]){
                return (Math.abs(two[1] - three[1])*Math.abs(three[0]-one[0]));
            }
            else if(one[1] == two[1]){
                return (Math.abs(two[0] - one[0])*Math.abs(three[1]-two[1]));
            }
        }
        else if(one[0] == three[0]){
            if(one[1] == two[1]){
                return (Math.abs(two[0] - one[0])*Math.abs(three[1]-one[1]));
            }
            else if(three[1] == two[1]){
                return (Math.abs(three[1] - one[1])*Math.abs(three[0]-two[0]));
            }
        }
        return -1;
    }
}

//loop thru i
//loop thru i+1
//check if same x
//calc maxY diff
//check if same y
//calc maxX diff
//find area
//find area
