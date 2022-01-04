package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Cow2017CopyJanHoofPaperScissors {
    public static void hoofPaperScissors() throws Exception {
        Scanner input = new Scanner(new File("hps.in"));

        int numRounds = input.nextInt();
        int[] hps = {1,2,3};
        int[] origHps = {1,2,3};
        int[] numWins = new int[3];
        int[] rounds = new int[numRounds * 2];

        for(int i = 0; i < rounds.length; i++){
            rounds[i] = input.nextInt();
        }


        for(int i = 0; i< 3; i++){
            if(i == 0){
                numWins[0] = numWins(rounds, hps);
            }
            else if(i == 1){
                hps[0] = origHps[1];
                hps[1] = origHps[0];
                numWins[1] = numWins(rounds, hps);
            }
            else{
                hps[0] = origHps[2];
                hps[2] = origHps[0];
                numWins[2] = numWins(rounds, hps);
            }
        }

        int maxWins = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++){
            if(numWins[i] > maxWins)
                maxWins = numWins[i];
        }

        PrintWriter out = new PrintWriter(new FileWriter("hps.out"));
        out.println(maxWins);
        out.close();
        input.close();
    }

    public static int numWins(int[] rounds, int[] hps){
        int numWins = 0;
        for(int i = 0; i < rounds.length; i = i+2){
            int first = findIndex(rounds[i], hps);
            int second = findIndex(rounds[i+1], hps);
            if((first == 0 && second == 2) || (first == 1 && second == 2) || (first == 1 && second == 0))
                numWins++;
        }
        return numWins;
    }

    public static int findIndex(int val, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(val == arr[i])
                return i;
        }
        return -1;
    }
}
