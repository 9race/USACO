package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2018DecMixMilk {
    public static void mixMilk() throws Exception {
        Scanner input = new Scanner(new File("mixmilk.in"));

        int[] bucketSize = new int[3];
        int[] milkStatus = new int[3];


        for(int j = 0; j < 3; j++){
            bucketSize[j] = input.nextInt();
            milkStatus[j] = input.nextInt();
        }

        int currBucket = 0;
        int nextBucket = 1;
        for(int i = 0; i < 100; i++){
            if(i%3 == 0){
                currBucket = 0;
                nextBucket = 1;
            }
            else if(i%3 == 1){
                currBucket = 1;
                nextBucket = 2;
            }
            else{
                currBucket = 2;
                nextBucket = 0;
            }
            if(milkStatus[currBucket] + milkStatus[nextBucket] > bucketSize[nextBucket]) {
                milkStatus[currBucket] -= bucketSize[nextBucket] - milkStatus[nextBucket];
                milkStatus[nextBucket] = bucketSize[nextBucket];
            }

            else {
                milkStatus[nextBucket] += milkStatus[currBucket];
                milkStatus[currBucket] = 0;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("mixmilk.out"));
        for(int i = 0; i < 3; i++){
            out.println(milkStatus[i]);
        }
        out.close();
        input.close();

        //int[] bucketSize
        //int[] milk
        //loop 100 times
            //int currBucket;
            //int nextBucket;
            //if(i%3 == 0)
                //currBucket = 0;
                //nextBucket = 1;
            //else if %3 == 1
                //curr = 1
                //next = 2
            //else
                //curr = 2
                //next = 0
            //if(milk[curr] + milk[next] > bucketSize[next])
                //milk[curr] -= bucketSize[next] - milk[next];
            //else
                //milk[next] += milk[curr]
                //milk[curr] = 0

    }
}

//Test Cases:
    //