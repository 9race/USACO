package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class
Cow2020CopyFebSwappitySwap {
    public static void swap() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("swap.in"));

        StringTokenizer stringTokenizer1 = new StringTokenizer(input.readLine());
        int numCows = Integer.parseInt(stringTokenizer1.nextToken());
        int repeatTimes = Integer.parseInt(stringTokenizer1.nextToken());

        StringTokenizer stringTokenizer2 = new StringTokenizer(input.readLine());
        int[] firstReverse = new int[2];
        firstReverse[0] = Integer.parseInt(stringTokenizer2.nextToken());
        firstReverse[1] = Integer.parseInt(stringTokenizer2.nextToken());

        StringTokenizer stringTokenizer3 = new StringTokenizer(input.readLine());
        int[] secondReverse = new int[2];
        secondReverse[0] = Integer.parseInt(stringTokenizer3.nextToken());
        secondReverse[1] = Integer.parseInt(stringTokenizer3.nextToken());

        int[] cowPositions = new int[numCows];
        for (int i = 0; i < numCows; i++){
            cowPositions[i] = i+1;
        }

        int[] currentPositions = new int[numCows];
        for(int i = 0; i < numCows; i++){
            currentPositions[i] = cowPositions[i];
        }

        int numTimes = 0;

        while(true){
            currentPositions = reverseOnce(currentPositions, firstReverse, secondReverse);
            numTimes++;

            if(numTimes == repeatTimes){
                cowPositions = currentPositions;
                break;
            }
            if(Arrays.equals(currentPositions, cowPositions)){
                int minTimes = repeatTimes % numTimes;
                cowPositions = reverse(cowPositions, firstReverse, secondReverse, minTimes);
                break;
            }
        }


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        for(int i = 0; i < cowPositions.length; i++){
            out.println(cowPositions[i]);
        }
        out.close();
        input.close();
    }

    public static int[] reverseOnce(int[] cowPositions, int[] firstReverse, int[] secondReverse){
//        for(int i = firstReverse[0] - 1; i < (firstReverse[0] + firstReverse[1])/2; i++){
//            int val = cowPositions[i];
//            cowPositions[i] = cowPositions[firstReverse[1] - i];
//            cowPositions[firstReverse[1] - i] = val;
//        }
//        for(int i = secondReverse[0] - 1; i < (secondReverse[0] + secondReverse[1])/2; i++){
//            int val = cowPositions[i];
//            cowPositions[i] = cowPositions[secondReverse[1] - i];
//            cowPositions[secondReverse[1] - i] = val;
//        }
//        return cowPositions;

        int[] reversedPositions = new int[cowPositions.length];
        for(int i = 0; i < firstReverse[0] - 1; i++){
            reversedPositions[i] = cowPositions[i];
        }
        int spot = firstReverse[1]-1;
        for(int i = firstReverse[0] - 1; i < firstReverse[1]; i++){
            reversedPositions[i] = cowPositions[spot];
            spot--;
        }
        for(int i = firstReverse[1]; i < cowPositions.length; i++){
            reversedPositions[i] = cowPositions[i];
        }

        int[] secondReversePositions = new int[cowPositions.length];
        for(int i = 0; i < secondReverse[0] - 1; i++){
            secondReversePositions[i] = reversedPositions[i];
        }
        int spot2 = secondReverse[1]-1;
        for(int i = secondReverse[0] - 1; i < secondReverse[1]; i++){
            secondReversePositions[i] = reversedPositions[spot2];
            spot2--;
        }
        for(int i = secondReverse[1]; i < reversedPositions.length; i++){
            secondReversePositions[i] = reversedPositions[i];
        }

        return secondReversePositions;
    }


    public static int[] reverse(int[] cowPositions, int[] firstReverse, int[] secondReverse, int numTimes){
        for(int i = 0; i < numTimes; i++){
            cowPositions = reverseOnce(cowPositions, firstReverse, secondReverse);
        }
        return cowPositions;
    }
}

// cowPositions = reverse(cowPositions, firstReverse, secondReverse, repeatTimes);
