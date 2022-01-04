package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Cow2016OpenDiamonds {
    public static void diamonds() throws Exception{
        Scanner input = new Scanner(new File("diamond.in"));

        int numDiamonds = input.nextInt();
        int maxDifference = input.nextInt();
        int[] diamonds = new int[numDiamonds];

        for(int i = 0; i < numDiamonds; i++){
            diamonds[i] = input.nextInt();
        }
        Arrays.sort(diamonds);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < diamonds.length; i++){
            int tempMax = maxDiamonds(i, diamonds, maxDifference);
            if(tempMax > max)
                max = tempMax;
        }

        PrintWriter out = new PrintWriter(new FileWriter("diamond.out"));
        out.println(max);
        out.close();
        input.close();
    }

    public static int maxDiamonds(int startingIndex, int[] diamonds, int k){
        int[] newArr = new int[diamonds.length - startingIndex];
        for(int i = 0; i < diamonds.length - startingIndex; i++){
            newArr[i] = diamonds[i+startingIndex];
        }

        int numDiamonds = 1;
        for(int j = 1; j < diamonds.length - startingIndex; j++){
            if(newArr[j] - newArr[0] <= k)
                numDiamonds++;
        }
        return numDiamonds;
    }
}
