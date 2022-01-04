package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020OpenSocialDistancing1 {
    public static void cowvid() throws Exception{
        Scanner input = new Scanner(new File("socdist1.in"));

        int numStalls = input.nextInt();
        String stalls = input.next();

        int[] stallPositions = new int[stalls.length()];
        for(int i = 0; i < stalls.length(); i++){
            stallPositions[i] = Integer.valueOf(stalls.charAt(i)) - 48;
        }

        boolean allZeroes = true;
        for(int i = 0; i < stallPositions.length; i++){
            if(stallPositions[i] == 1){
                allZeroes = false;
                break;
            }
        }

        int numZeroes = 0;

        int maxDistance = 0;
        int tempDist = 0;
        if(stallPositions[0] == 0)
            tempDist = -1;

        int maxIndex = 0;

        for(int i = 0; i < stallPositions.length; i++){
            if(i == stallPositions.length - 1 && tempDist > 0){
                if(tempDist+1 > maxDistance) {
                    maxDistance = tempDist + 1;
                    maxIndex = i - (tempDist+1);
                }
                break;
            }
            if(stallPositions[i] == 0) {
                tempDist++;
                numZeroes++;
            }
            else {
                if(tempDist+1 > maxDistance) {
                    maxDistance = tempDist + 1;
                    maxIndex = i - (tempDist+1);
                }
                tempDist = 0;
            }
        }

        int secondMaxDist = 0;
        int tempDist2 = 0;
        if(stallPositions[0] == 0)
            tempDist2 = -1;

        for(int i = 0; i < stallPositions.length; i++){
            if(i == maxIndex){
                if(!(i+tempDist+1 >= stallPositions.length - 1)){
                    i += tempDist + 1;
                    if(i == stallPositions.length - 1 && tempDist2 > 0){
                        if(tempDist+1 > secondMaxDist) {
                            secondMaxDist = tempDist2 + 1;
                        }
                        break;
                    }
                    if(stallPositions[i] == 0)
                        tempDist2++;
                    else {
                        if(tempDist2+1 > secondMaxDist)
                            secondMaxDist = tempDist2 + 1;
                        tempDist2 = 0;
                    }
                }
                else{
                    break;
                }
            }
            else{
                if(i == stallPositions.length - 1 && tempDist2 > 0){
                    if(tempDist+1 > secondMaxDist) {
                        secondMaxDist = tempDist2 + 1;
                    }
                    break;
                }
                if(stallPositions[i] == 0)
                    tempDist2++;
                else {
                    if(tempDist2+1 > secondMaxDist)
                        secondMaxDist = tempDist2 + 1;
                    tempDist2 = 0;
                }
            }

        }

        if(secondMaxDist == 0 && numZeroes != maxDistance - 1){
            secondMaxDist = maxDistance;
        }

        int d = 0;

        if(maxDistance/3 < secondMaxDist/2){
            d = secondMaxDist/2;
        }
        else{
            d = maxDistance/3;
        }

        if(allZeroes){
            d = stallPositions.length - 1;
        }
        PrintWriter out = new PrintWriter(new FileWriter("socdist1.out"));
        out.println(d);
        out.close();
        input.close();

    }
}
