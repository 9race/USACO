package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2016DecBlocks {
    public static void blocks() throws Exception{
        Scanner blocks = new Scanner(new File("blocks.in"));
        int[] alphabet = new int[26];
        int numWords = blocks.nextInt();

        for(int word = 0; word < numWords; word++){
            String leftWord = blocks.next();
            String rightWord = blocks.next();
            int[] leftLetters = new int[26];
            int[]rightLetters = new int[26];
            for(int letter = 0; letter < leftWord.length(); letter++){
                leftLetters[(int)leftWord.charAt(letter) - 97]++;
            }
            for(int letter = 0; letter < rightWord.length(); letter++){
                rightLetters[(int)rightWord.charAt(letter) - 97]++;
            }
            int[] mergedArr = merge(leftLetters,rightLetters);
            for(int i = 0; i < 26; i++){
                alphabet[i] = alphabet[i] + mergedArr[i];
            }
        }



        PrintWriter out = new PrintWriter(new FileWriter("blocks.out"));
        for(int i = 0; i < 26; i++){
            out.println(alphabet[i]);
        }
        out.close();
        blocks.close();

    }

    public static int[] merge(int[] arr1, int[] arr2){
        int[] newArr = new int[26];
        for(int i = 0; i < 26; i++){
            if(arr1[i] > arr2[i])
                newArr[i] = arr1[i];
            else newArr[i] = arr2[i];
        }
        return newArr;
    }
}
