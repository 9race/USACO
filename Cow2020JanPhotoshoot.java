package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020JanPhotoshoot {
    public static void photoshoot() throws Exception{
        Scanner input = new Scanner(new File("photo.in"));

        int numCows = input.nextInt();
        int[] bessiePermutation = new int[numCows - 1];

        for(int i = 0; i < numCows-1; i++){
            bessiePermutation[i] = input.nextInt();
        }

        int[] finalPermutation = new int[numCows];

        for(int i = 0; i < numCows; i++){
            int[] perm = createPermutation(i+1, bessiePermutation);
            if(!(hasNegativeNumbers(perm)) && !(hasRepeats(perm)) && increments(perm)) {
                finalPermutation = perm;
                break;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("photo.out"));
        for(int i = 0; i < finalPermutation.length; i++) {
            out.print(finalPermutation[i]);
            out.print(" ");
        }
        out.close();
        input.close();

        //loop thru i times


        //createPermutation


        //hasNegativeNumbers

        //hasIncrements
            //loop thru
                //contains i

        //hasRepeats
    }

    public static int[] createPermutation(int startNum, int[] bessiePermutation){
        int[] finalPerm = new int[bessiePermutation.length+1];
        finalPerm[0] = startNum;

        for(int i = 1; i <= bessiePermutation.length; i++){
            finalPerm[i] = bessiePermutation[i-1] - finalPerm[i-1];
        }

        return finalPerm;
    }

    public static boolean hasNegativeNumbers(int[] permutation){
        for(int i = 0; i < permutation.length; i++){
            if(permutation[i] <= 0){
                return true;
            }
        }
        return false;
    }

    public static boolean hasRepeats(int[] permutation){
        for(int i = 0; i < permutation.length; i++){
            for(int j = i+1; j < permutation.length; j++){
                if(permutation[i] == permutation[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean increments(int[] permutation){
        int[] hasNum = new int[permutation.length];
        for(int i = 0; i < permutation.length; i++){
            for(int j = 0; j < permutation.length; j++){
                if(permutation[j] == i+1)
                    hasNum[i]++;
            }
        }
        for(int i = 0; i < hasNum.length; i++){
            if(hasNum[i] == 0)
                return false;
        }
        return true;
    }
}
