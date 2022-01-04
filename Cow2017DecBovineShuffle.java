package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2017DecBovineShuffle {
    public static void bovineShuffle() throws Exception{
        Scanner input = new Scanner(new File("shuffle.in"));

        int numCows = input.nextInt();

        int[] shuffleFormula = new int[numCows];
        for(int i = 0; i < numCows; i++){
            shuffleFormula[i] = input.nextInt();
        }

        int[] ids = new int[numCows];
        for(int i = 0; i < numCows; i++){
            ids[i] = input.nextInt();
        }

        int[] tempIds = new int[numCows];
        for(int i = 0; i < numCows; i++){
            tempIds[i] = i;
        }
        int[] shuffledTemp = shuffle(tempIds, shuffleFormula);

        int[] origArr = new int[numCows];
        for(int i = 0; i < numCows; i++){
            int index = findIndex(tempIds[i], shuffledTemp);
            origArr[i] = ids[index];
        }

        PrintWriter out = new PrintWriter(new FileWriter("shuffle.out"));
        for(int i = 0; i < numCows; i++){
            out.println(origArr[i]);
        }
        out.close();
        input.close();


        //create new array with letters (1.2.3.4,....)
        //define new arr2, set equal to original
        //loop thru the array 3 times
            //create new arr
            //shuffle the letters in the arr3
            //set new arr3 = arr2
        //create new arr
        //loop thru orig arr
            //call findIndex on arr2
                //set newestArr at that val to the id in the origArr



        //findIndex
            //loop thru arr
                //if val == requestdedVal
                    //return i
    }
    public static int[] shuffle(int[] orig, int[] shuffleOrder){
        int[] shuffledArr = orig;
        for(int i = 0; i < 3; i++){
            int[] tempArr = new int[orig.length];
            for(int j = 0; j < orig.length; j++){
                tempArr[shuffleOrder[j] - 1] = shuffledArr[j];
            }
            shuffledArr = tempArr;
        }
        return shuffledArr;
    }

    public static int findIndex(int val, int[]arr){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
}
