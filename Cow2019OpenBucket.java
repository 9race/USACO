package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2019OpenBucket {
    public static void bucketBrigade() throws Exception{
        //arr[][] rows
        //calculate difference in x
        //calculate difference in y
        //if b and l are in same row
        //if the rock is in same row
        //else if b and l are in same col
        //if rock is in same col
        //see if the rock is in the same x or y as b

        String[] grid = new String[10];

        Scanner input = new Scanner(new File("buckets.in"));
        for(int i = 0; i < 10; i++){
            grid[i] = input.next();
        }

        int bX = -1;
        int bY = -1;
        int lY = -1;
        int lX = -1;
        int rX = -1;
        int rY = -1;

        for(int i = 0; i < 10; i ++){
            for(int j = 0; j < 10; j++){
                if(grid[i].charAt(j) == 'B'){
                    bX = j;
                    bY = i;
                }
                else if(grid[i].charAt(j) == 'R'){
                    rX = j;
                    rY = i;
                }
                else if(grid[i].charAt(j) == 'L'){
                    lX = j;
                    lY = i;
                }
            }
        }

        boolean inMiddle = false;

        if(bX == lX){
            if(rX == bX && ((rY >= bY && rY <= lY) || (rY <= bY && rY >= lY))){
                inMiddle = true;
            }
        }

        else if(bY == lY){
            if(rY == bY && ((rX >= bX && rX <= lX) || (rX <= bX && rX >= lX))){
                inMiddle = true;
            }
        }

        int totalMoves = 0;

        if(inMiddle){
            totalMoves = Math.abs(bX - lX) + Math.abs(bY - lY) + 2;
        }
        else totalMoves = Math.abs(bX - lX) + Math.abs(bY - lY) ;

        PrintWriter out = new PrintWriter(new FileWriter("buckets.out"));
        out.println(totalMoves-1);
        out.close();
        input.close();
    }
}
