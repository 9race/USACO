package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cow2017DecMilkMeasurement {

    public static void milkMeasurement() throws Exception{

        Scanner input = new Scanner(new File("measurement.in"));

        int numChanges = input.nextInt();
        int[] cowMilkUpdates = {7,7,7};
        int[] days = new int[numChanges];
        String[] cowUpdates = new String[numChanges];
        int[] amountUpdated = new int[numChanges];

        for(int i = 0; i < numChanges; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0)
                    days[i] = input.nextInt();
                else if(j== 1)
                    cowUpdates[i] = input.next();
                else amountUpdated[i] = input.nextInt();
            }
        }

        int changeDisplay = 0;

        ArrayList<Integer> cowsDisplayed = new ArrayList<Integer>();
        cowsDisplayed.add(0);
        cowsDisplayed.add(1);
        cowsDisplayed.add(2);

        for(int day = 1; day <= 100; day++){
            for(int i = 0; i < numChanges; i++){
                if(days[i] == day){
                    if(cowUpdates[i].equals("Bessie")){
                        cowMilkUpdates[0] += amountUpdated[i];
                    }
                    else if(cowUpdates[i].equals("Elsie")){
                        cowMilkUpdates[1] += amountUpdated[i];
                    }
                    else if(cowUpdates[i].equals("Mildred")){
                        cowMilkUpdates[2] += amountUpdated[i];
                    }
                    if(!(findMaxCow(cowMilkUpdates).equals(cowsDisplayed))){
                        changeDisplay++;
                        cowsDisplayed = findMaxCow(cowMilkUpdates);
                    }
                }
            }



        }

        PrintWriter out = new PrintWriter(new FileWriter("measurement.out"));
        out.println(changeDisplay);
        out.close();
        input.close();

        //int numChanges
        //arr of size 3 containing milk for each cow
        //arr of days
        //arr of milk cows
        //arr of milkUpdates
        //int bessieMax
        //int elsieMax
        //int mildredMax
        //int changeDisplay
        //loop thru 1-100
            //loop thru days
                //if day[i] == day
                    //find the cow
                        //updated cowMilkUpdates
            //call findMaxCow
                //if bessie
                    //increment bessieMax
                    //increment changeDisplay


    }

    public static ArrayList<Integer> findMaxCow(int[] cowMilk){
        int maxMilk = cowMilk[0];
        ArrayList<Integer> maxIndices = new ArrayList<Integer>();
        for(int i = 0; i < cowMilk.length; i++){
            if(cowMilk[i] > maxMilk) {
                maxMilk = cowMilk[i];
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                maxIndices = temp;
            }
            else if(cowMilk[i] == maxMilk){
                maxIndices.add(i);
            }
        }
        return maxIndices;
    }
}


//        String max = updates[0][0];
//        String min = updates[0][0];
//        int minIndex = 0;
//        int maxIndex = 0;
//        for(int i = 1; i < numChanges; i++){
//            if(updates[i][0].compareTo(max) > 0){
//                max = updates[i][0];
//                maxIndex = i;
//            }
//            else if(updates[i][0].compareTo(min) < 0){
//                min = updates[i][0];
//                minIndex = i;
//            }
//        }
//
//        int middleIndex = -1;
//        for(int i = 0; i < 3; i++){
//            if(i != minIndex && i != maxIndex)
//                middleIndex = i;
//        }
//
//        sorted[0] = updates[minIndex];
//        sorted[1] = updates[minIndex];
//        sorted[2] = updates[minIndex];


//            if(indexOfMax == 0){
//                if(bessieMax == 0){
//                    bessieMax = 1;
//                    changeDisplay++;
//                    elsieMax = 0;
//                    mildredMax = 0;
//                }
//            }
//            else if(indexOfMax == 1){
//                if(elsieMax == 0){
//                    elsieMax = 1;
//                    changeDisplay++;
//                    bessieMax = 0;
//                    mildredMax = 0;
//                }
//            }
//            else if(indexOfMax == 2){
//                if(mildredMax == 0){
//                    mildredMax = 1;
//                    changeDisplay++;
//                    elsieMax = 0;
//                    bessieMax = 0;
//                }
//            }



//Test Cases:
    //all subtract
    //all add
    //no changes
    //one cow changes the entire time
    //two cows are max
