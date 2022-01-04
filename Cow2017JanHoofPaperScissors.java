package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2017JanHoofPaperScissors {
    public static void hoofPaperScissors() throws Exception{
        Scanner input = new Scanner(new File("hps.in"));

        int numRounds = input.nextInt();

        int[] hps = {1,2,3};
        int[] origHps = {1,2,3};
        int[] numWins = new int[3];
        int[] rounds = new int[numRounds * 2];

        for(int i = 0; i < rounds.length; i++){
            rounds[i] = input.nextInt();
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < rounds.length - 1; j = j+2 ){
                int index1 = findIndex(rounds[j], hps);
                int index2 = findIndex(rounds[j+1],hps);
                if((index1 == 0 && index2 == 2) || (index1 == 2 && index2 == 1) || (index1 == 1 && index2 == 0)){
                    numWins[i]++;
                }
//                else if((index1 == 2 && index2 == 0) || (index1 == 1 && index2 == 2) || (index1 == 0 && index2 == 1)){
//                    numWins[i]--;
//                }
            }
            if(i == 0){
                hps[0] = origHps[1];
                hps[1] = origHps[0];
            }
            if(i == 1){
                hps = new int[]{1, 2, 3};
                hps[0] = origHps[2];
                hps[2] = origHps[0];
            }
            if(i == 2){
                hps = origHps;
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

        //create arr of 1,2,3
            //assume 1 loses to 2, 2 loses to 3, and 3 loses to 1
        //int[] numWins
        //put all of the rounds into an arr
        //loop 3 times
            //loop thru arr rounds
                //if(findIndex(rounds[j], hps) < findIndex(rounds[j+1], hps)
                    //increment numWins
            //int temp = hps[0];
            //int temp2 = hps[1];
            //hps[0] = hps[2];
            //hps[1] = temp;
            //hps[2] = temp2;
        //loop thru numWins
            //findMax

        //findIndex
            //loop thru arr
                //if(arr[i] == val)
                    //return i;
    }

    public static int findIndex(int val, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(val == arr[i])
                return i;
        }
        return -1;
    }
}

//Test Cases;
    //tie the entire time
    //two have max wins
    //one cow wins all round
    //lose, win, tie, tie, tie
