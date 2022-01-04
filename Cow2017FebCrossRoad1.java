package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2017FebCrossRoad1 {
    public static void cowsCrossRoad1() throws Exception{
        Scanner input = new Scanner(new File("crossroad.in"));

        int[] cowPositions = new int[10];

        for(int i = 0; i < 10; i++){
            cowPositions[i] = -1;
        }

        int numLines = input.nextInt();
        int numCrossings = 0;
        for(int i = 0; i < numLines; i++){
            int cowId = input.nextInt();
            int position = input.nextInt();
            for(int j = 0; j < 10; j++){
                if(j+1 == cowId){
                    if(cowPositions[j] != -1 && position != cowPositions[j]){
                        numCrossings++;
                    }
                    cowPositions[j] = position;
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("crossroad.out"));
        out.println(numCrossings);
        out.close();
        input.close();


        //create int[10] cows
        //loop thru and set every val to -1
        //numCrossings
        //loop thru arr
            //if index = nextInt - 1
                //if val == -1
                    //set val to nextInt
                //else
                    //set val to nextInt
                    //increment numCrossings
    }
}

//Test Cases:
    //no one changes position
    //just putting new cow positions
    //one cow keeps changing
    //one cow, never changes position