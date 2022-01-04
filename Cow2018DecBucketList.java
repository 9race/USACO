//**DIFFICULT**//
package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2018DecBucketList {
    public static void bucketList() throws Exception{
        Scanner input = new Scanner(new File("blist.in"));

        int numCows = input.nextInt();
        int[][] cows = new int[numCows][3];

        for(int i = 0; i < numCows; i++){
            cows[i][0] = input.nextInt();
            cows[i][1] = input.nextInt();
            cows[i][2] = input.nextInt();
        }

        int[] bucketsTime = new int[1000];

        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < numCows; j++){
                if(i+1 >= cows[j][0] && i+1 <= cows[j][1]){
                    bucketsTime[i] += cows[j][2];
                }
            }
        }

        int numBuckets = Integer.MIN_VALUE;
        for(int i = 0; i < 1000; i++){
            if(bucketsTime[i] > numBuckets)
                numBuckets = bucketsTime[i];
        }

        PrintWriter out = new PrintWriter(new FileWriter("blist.out"));
        out.println(numBuckets);
        out.close();
        input.close();

        //create int[1000]
        //loop thru 1000
            //loop thru each cow
                //if i+1 is between any time stamps
                    //add to arr[i]

        //int numBuckets
        //loop thru
            //findMax
    }
}
//Test Cases:
    //all overlap
    //nvr overlap
    //back to back

//create int[][] arr of timeStamps
//int numBuckets
//loop thru arr
//loop thru i+1
//if(overlap)
//add both to numBuckets
//else
//add larger one to numBuckets