package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020FebSwappitySwap {
    public static void swap() throws Exception {

        Scanner input = new Scanner(new File("swap.in"));
        int numCows = input.nextInt();
        int numReverses = input.nextInt();
        int[] a = new int[2];
        int[] b = new int[2];

        for (int i = 0; i < 2; i++) {
            a[i] = input.nextInt();
        }

        for (int i = 0; i < 2; i++) {
            b[i] = input.nextInt();
        }

        int[] cows = new int[numCows];
        int[] orig = new int[numCows];
        for (int i = 0; i < numCows; i++) {
            orig[i] = i + 1;
        }

        cows = reverse(a[0] - 1, a[1] - 1, orig);
        int numCycles = 1;
        int j = 1;
        while (!same(orig, cows)) {
            if (j % 2 == 0) {
                cows = reverse(a[0] - 1, a[1] - 1, cows);
            } else {
                cows = reverse(b[0] - 1, b[1] - 1, cows);
            }
            j++;
            numCycles++;
        }

        int min = numReverses % numCycles;

        for (int i = 0; i < min; i++) {
            for (int k = 0; k < 2; k++) {
                if (k == 0) {
                    orig = reverse(a[0] - 1, a[1] - 1, orig);
                } else {
                    orig = reverse(b[0] - 1, b[1] - 1, orig);
                }
            }
        }

            PrintWriter out = new PrintWriter(new FileWriter("swap.out"));
            for(int i = 0; i < numCows; i++){
                out.println(orig[i]);
            }
            out.close();
            input.close();
            //loop thru n times
            //reverse

            //reverse (startingIndex, endingIndex, int[] arr)
            //loop backwards
            //store values in new arr
            //replace arr
    }
    public static int[] reverse(int startingIndex, int endingIndex, int[] cows){
        int[] arr = new int[cows.length];
        for(int i = 0; i < cows.length; i++){
            arr[i] = cows[i];
        }
        int start = startingIndex;
        for(int i = endingIndex; i >= startingIndex; i--){
            arr[start] = cows[i];
            start++;
        }
        return arr;
    }

    public static boolean same(int[] one, int[] two){
        for(int i = 0; i < one.length; i++){
            if(one[i] != two[i])
                return false;
        }
        return true;
    }

}




//    int numCows = input.nextInt();
//    int numReverses = input.nextInt();
//    int[] a = new int[2];
//    int[] b = new int[2];
//
//        for(int i = 0; i < 2; i++){
//        a[i] = input.nextInt();
//        }
//
//        for(int i = 0; i < 2; i++){
//        b[i] = input.nextInt();
//        }
//
//        int[] cows = new int[numCows];
//        for(int i = 0; i < numCows; i++){
//        cows[i] = i+1;
//        }
//
//        for(int i = 0; i < numReverses; i++){
//        for(int j = 0; j < 2; j++){
//        if(j == 0){
//        cows = reverse(a[0] - 1, a[1] - 1, cows);
//        }
//        else{
//        cows = reverse(b[0] - 1, b[1] - 1, cows);
//        }
//        }
//
//
//        }