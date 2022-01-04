package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2019DecGymnastics {
    public static void cowGymnastics() throws Exception{
        Scanner input = new Scanner(new File("gymnastics.in"));

        //create an arr[] for the first one
        //store the paiirs in an arr
        //add the pairs to an int[][]
        //numValid
        //loop thru the num practice sessions
            //create a new arr for the next ones
                //see if it is valid
                    //numValid++

        int numSessions = input.nextInt();
        int numCows = input.nextInt();

        int[] firstPractice = new int[numCows];

        for(int i = 0; i < numCows; i++){
            firstPractice[i] = input.nextInt();
        }

        int[][] pairs = new int[numCows * (numCows - 1)/2][2];

        boolean[] valid = new boolean[numCows * (numCows - 1)/2];
        for(int i = 0; i < valid.length; i++){
            valid[i] = true;
        }

        int spot = 0;
        for (int i = 0; i < numCows; i++){
            for(int j = i + 1; j < numCows; j++){
                pairs[spot][0] = firstPractice[i];
                pairs[spot][1] = firstPractice[j];
                spot++;
            }
        }


        for(int i = 0; i < numSessions - 1; i++){
            int[] session = new int[numCows];

            for(int j = 0; j < numCows; j++){
                session[j] = input.nextInt();
            }

            for(int x = 0; x < pairs.length; x++){
                if(findIndex(session, pairs[x][0]) > (findIndex(session, pairs[x][1])))
                    valid[x] = false;
            }
        }

        int numValid = 0;

        for(int i = 0; i < valid.length; i++){
            if(valid[i])
                numValid++;
        }

        PrintWriter out = new PrintWriter(new FileWriter("gymnastics.out"));
        out.println(numValid);
        out.close();
        input.close();
    }

    public static int findIndex(int[] arr, int val){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
}
