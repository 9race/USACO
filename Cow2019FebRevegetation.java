package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Cow2019FebRevegetation {
    public static void revegetate() throws Exception{
        Scanner input = new Scanner(new File("revegetate.in"));

        //arr of pastures
        //arr[][] of pairs
        //set all pastures equal to 1
        //loop thru pairs
            //if paired
                //increment

        int numPastures = input.nextInt();
        int numCows = input.nextInt();
        int[] pastures = new int[numPastures];
        for(int i = 0; i < numPastures; i++){
            pastures[i] = 1;
        }

        int[][] cows = new int[numCows][2];
        for(int i = 0; i < cows.length; i++){
            int pasture = input.nextInt();
            int nextPasture = input.nextInt();
            if(pasture < nextPasture) {
                cows[i][0] = pasture;
                cows[i][1] = nextPasture;
            }
            else {
                cows[i][0] = nextPasture;
                cows[i][1] = pasture;
            }
//            for(int j = 0; j < 2; j++){
//                cows[i][j] = input.nextInt();
//            }
        }

//        cows = sortRowWise(cows);
//        Arrays.sort(cows, (a, b) -> Double.compare(a[1], b[1]));
        Arrays.sort(cows, (a, b) -> Double.compare(a[0], b[0]));

        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0])
                    return 1;
                else if(o2[0] > o1[0])
                    return -1;
                else if (o1[0] == o2[0])
                    return Integer.compare(o1[1],o2[1]);
                else return 0;
            }
        });

        while (!isValid(cows, pastures)) {
            updatePastures(cows, pastures);
        }

        PrintWriter out = new PrintWriter(new FileWriter("revegetate.out"));
        for(int i = 0; i < numPastures; i++){
            out.print(pastures[i]);
        }
        out.close();
        input.close();
    }

    public static boolean isValid(int[][] cows, int[] pastures){
        for(int i = 0; i < cows.length; i++){
                if(pastures[cows[i][1]-1] == pastures[cows[i][0]-1])
                    return false;
        }
        return true;
    }

    public static void updatePastures(int[][] cows, int[] pastures){
        for(int i = 0; i < cows.length; i++){
            int first = pastures[cows[i][1]-1];
            int second = pastures[cows[i][0]-1];
            if(first == second)
                pastures[cows[i][1]-1]++;
        }
    }

//    public static int[][] sortRowWise(int m[][])
//    {
//        // loop for rows of matrix
//        for (int i = 0; i < m.length; i++) {
//
//            // loop for column of matrix
//            for (int j = 0; j < m[i].length; j++) {
//
//                // loop for comparison and swapping
//                for (int k = 0; k < m[i].length - j - 1; k++) {
//                    if (m[i][k] > m[i][k + 1]) {
//
//                        // swapping of elements
//                        int t = m[i][k];
//                        m[i][k] = m[i][k + 1];
//                        m[i][k + 1] = t;
//                    }
//                }
//            }
//        }
//        return m;
//    }
}

//test case:
//

//while(check if it works)
    //loop thru

