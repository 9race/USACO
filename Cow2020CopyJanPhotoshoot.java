package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

//COMPLETED
public class Cow2020CopyJanPhotoshoot {
    public static void photoshoot() throws Exception {
        Scanner input = new Scanner(new File("photo.in"));

        int numCows = input.nextInt();
        int[] bessieList = new int[numCows - 1];

        for(int i = 0; i < numCows - 1; i++){
            bessieList[i] = input.nextInt();
        }

        int[] permutation = new int[numCows];
        for(int i = 1; i < bessieList[0]; i++){
            int[] orig = calcPermutation(bessieList, i);
            if(isValid(orig, numCows)){
                permutation = orig;
                break;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("photo.out"));
        for(int i = 0; i < permutation.length; i++){
            out.print(permutation[i]);
            out.print(" ");
        }
        out.close();
        input.close();
    }

    public static int[] calcPermutation(int[] bessieList, int start){
        int[] orig = new int[bessieList.length + 1];
        orig[0] = start;
        int currentStart = start;

        for(int i = 1; i < orig.length; i++){
            orig[i] = bessieList[i-1] - currentStart;
            currentStart = orig[i];
        }
        return orig;
    }

    public static boolean isValid(int[] orig, int numCows){
        for(int i = 1; i <= numCows; i++){
            int finalI = i;
            boolean x = Arrays.stream(orig).anyMatch(n -> n == finalI);
            if(!x) return false;
        }
        for(int i = 0; i < orig.length; i++){
            for(int j = i+1; j < orig.length; j++){
                if(i == j)
                    return false;
            }
        }
        return true;
    }
}
