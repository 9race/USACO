package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2018DecBackForth {
    static ArrayList<Integer> allPossibilities = new ArrayList<>();
    public static void backAndForth() throws Exception {
        Scanner input = new Scanner(new File("backforth.in"));

        ArrayList<Integer> firstBarnBuckets = new ArrayList<>();
        ArrayList<Integer> secondBarnBuckets = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            firstBarnBuckets.add(input.nextInt());
        }

        for(int i = 0; i < 10; i++){
            secondBarnBuckets.add(input.nextInt());
        }

        for(int i = 0; i < firstBarnBuckets.size(); i++){
            ArrayList<Integer> clone2 = (ArrayList<Integer>)secondBarnBuckets.clone();
            ArrayList<Integer> clone1 = (ArrayList<Integer>)firstBarnBuckets.clone();
            clone2.add(firstBarnBuckets.get(i));
            clone1.remove(i);
            wednesday(clone1, clone2);
        }

        PrintWriter out = new PrintWriter(new FileWriter("backforth.out"));
        out.println(allPossibilities.size());
        out.close();
        input.close();
    }

    public static void wednesday(ArrayList<Integer> firstBarn, ArrayList<Integer> secondBarn){
        for(int i = 0; i < secondBarn.size(); i++){
            ArrayList<Integer> clone2 = (ArrayList<Integer>)secondBarn.clone();
            ArrayList<Integer> clone1 = (ArrayList<Integer>)firstBarn.clone();
            clone1.add(secondBarn.get(i));
            clone2.remove(i);
            thursday(clone1, clone2);
        }
    }

    public static void thursday(ArrayList<Integer> firstBarn, ArrayList<Integer> secondBarn){
        for(int i = 0; i < firstBarn.size(); i++){
            ArrayList<Integer> clone2 = (ArrayList<Integer>)secondBarn.clone();
            ArrayList<Integer> clone1 = (ArrayList<Integer>)firstBarn.clone();
            clone2.add(firstBarn.get(i));
            clone1.remove(i);
            friday(clone1, clone2);
        }
    }

    public static void friday(ArrayList<Integer> firstBarn, ArrayList<Integer> secondBarn){
        for(int i = 0; i < secondBarn.size(); i++){
            ArrayList<Integer> clone2 = (ArrayList<Integer>)secondBarn.clone();
            ArrayList<Integer> clone1 = (ArrayList<Integer>)firstBarn.clone();
            clone1.add(secondBarn.get(i));
            clone2.remove(i);
            int sum = 0;
            for(int j = 0; j < clone1.size(); j++){
                sum += clone1.get(j);
            }
            if(!allPossibilities.contains(sum))
                allPossibilities.add(sum);
        }
    }
}


//int firstBarn
//int secondBarn
//ArrayList firstBarnBuckets
//ArrauList secondBarnBuckets
//ArrayList readings

//boolean first = true;
//loop 4
//ArrayList reading = 1000
//if(first)
//loop thru firstBarnBuckets
//new ArrayList temp
//temp.add(reading -= firstBarnBuckets.get())
//
//else
//loop thru secondBarnBuckets


//tuesday
//readings.remove()
//loop thru readings
//loop thru firstBarnBuckets
//.add(1000 - firstBarnBuckets)

//wednesday
//loop thru readings
//secondBarnBuckets.add(firstBarnBuckets.get(i))
//loop thru secondBarnBuckets
//temp
//temp.add(readings - secondBarnBuckets)
//remove(firstBarnBuckets)


//for loop 10 (tues)
//secondBarnBuckets.add(tues)
//firstBarnBuckets.remove(tues)
//for loop 10 (weds)
//secondBarnBuckets.remove(weds)
//firstBarnBuckets.add(weds)
//for loop 10 (thurs)
//secondBarnBuckets.add(thurs)
//firstBarnBuckets.remove(thurs)
//for loop 10 (fri)
//secondBarnBuckets.remove(fri)
//firstBarnBuckets.add(fri)
//add number to readings
