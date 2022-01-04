package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Cow2017JanLast {
    public static void notLast() throws Exception {

        Scanner input = new Scanner(new File("notlast.in"));

        int numLines = input.nextInt();
        String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        int[] numMilk = new int[7];

        for(int i = 0; i < numLines; i++){
            String name = input.next();
            numMilk[findIndex(name, names)] += input.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 7; i++){
            if(numMilk[i] < min) {
                min = numMilk[i];
            }
        }

        int secondLeastMilk = Integer.MAX_VALUE;
        int secondLeastIndex = -1;
        ArrayList<Integer> secondLeastCowIndices = new ArrayList<Integer>();
        for(int i = 0; i < 7; i++){
            if(numMilk[i] < secondLeastMilk && numMilk[i] > min){
                secondLeastMilk = numMilk[i];
                ArrayList<Integer> temp  = new ArrayList<Integer>();
                temp.add(i);
                secondLeastCowIndices = temp;
                secondLeastIndex = i;

            }
            else if(numMilk[i] == secondLeastMilk && numMilk[i] > min){
                secondLeastCowIndices.add(i);
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("notLast.out"));
        if(secondLeastIndex == -1 || secondLeastCowIndices.size() > 1)
            out.println("Tie");
        else out.println(names[(secondLeastIndex)]);
        out.close();
        input.close();
    }

    public static int findIndex(String val, String[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(val))
                return i;
        }
        return -1;
    }
}


//        for(int i = 0; i < numLines; i++){
//            if(numMilk.get(i) == min){
//                numMilk.remove(i);
//                names.remove(i);
//                i--;
//                numLines--;
//            }
//        }

//arr of names
//arr of milkAmount
//loop thru milkAmount
    //find min
//loop thru milkAmount
    //if reassign secondLeast
        //change arrList
        //reassign i
    //else if equal
        //add arrList

//Test Case
    //all the same, no secondleast
    //several are secondMin
