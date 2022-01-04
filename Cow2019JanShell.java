package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2019JanShell {
    /*
    * put all the swaps into an arr
    * put all the guesses into an arr
    * boolean []
    * numRight []
    *loop 3 times
        * set the i one to true
            * loop thru swaps
                * swap the boolean values
                * check if value guessed has true boolean
                    * increment  numRight[i]
    *
    * */



    public static void shellGame() throws Exception {
        Scanner input = new Scanner(new File("shell.in"));

        int numSwaps = input.nextInt();
        boolean[] shells = new boolean[3];
        int[] guesses = new int[numSwaps];
        int[][] swaps = new int[numSwaps][2];

        for(int i = 0; i < numSwaps; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    swaps[i][0] = input.nextInt();
                }
                else if (j == 1){
                    swaps[i][1] = input.nextInt();
                }
                else{
                    guesses[i] = input.nextInt();
                }
            }
        }

        int[] numRight = new int[3];

        for(int i = 0; i < 3; i++){
            shells[i] = true;
            numRight[i] = calcNumRight(swaps, guesses, shells);
            //shells[i] = false;
            for(int j = 0; j < 3; j++){
                shells[j] = false;
            }
        }

        int maxRight = 0;
        for(int i = 0; i < 3; i++){
            if(numRight[i] > maxRight)
                maxRight = numRight[i];
        }

        PrintWriter out = new PrintWriter(new FileWriter("shell.out"));
        out.println(maxRight);
        out.close();
        input.close();
    }

    public static int calcNumRight(int[][] swaps, int[] guesses, boolean[] shells){
        int numRight = 0;
        for(int i = 0; i < guesses.length; i++){
            boolean val = shells[swaps[i][0]-1];
            shells[swaps[i][0]-1] = shells[swaps[i][1]-1];
            shells[swaps[i][1]-1] = val;
            if(shells[guesses[i]-1]){
                numRight++;
            }
        }
        return numRight;
    }
}

//bool arr shells
//int arr guesses
//int arr swaps
//int numswaps
//int arr numRight

//loop 3 times
    //set one of shells to true
    //numRight[i] = calcNumRight()


//calcNumRight
    //int numRight
    //loop thru numSwaps
        //swap them
        //if its true
          //numRight++



//    int numSwaps = input.nextInt();
//    boolean[] shells = new boolean[3];
//    ArrayList<Integer> swaps = new ArrayList<>();
//    ArrayList<Integer> guesses = new ArrayList<>();
//    int[] numRight = new int[3];
//
//        for(int i = 0; i < numSwaps; i++){
//        for(int j = 0; j < 3; j++){
//        if (j%3 != 2){
//        swaps.add(input.nextInt());
//        }
//        else{
//        guesses.add(input.nextInt());
//        }
//        }
//        }
//
//        for(int i = 0; i < 3; i++){
//        boolean[] newShells = shells;
//        newShells[i] = true;
//        int spot = 0;
//        for(int j = 0; j < numSwaps; j += 2){
//        boolean val = newShells[swaps.get(j)-1];
//        newShells[swaps.get(j)-1] = newShells[swaps.get(j+1)-1];
//        newShells[swaps.get(j+1)-1] = val;
//        if(newShells[guesses.get(spot)-1]){
//        numRight[i]++;
//        }
//        spot++;
//        }
//        }
//
//        int maxRight = 0;
//        for(int i = 0; i < 3; i++){
//        if(numRight[i] > maxRight)
//        maxRight = numRight[i];
//        }