package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2020CopyJanWordProcessor {
    public static void wordProcessor() throws Exception {
        Scanner input = new Scanner(new File("word2.in"));
        int numWords = input.nextInt();
        int limit = input.nextInt();

        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < numWords; i++){
            words.add(input.next());
        }
        int[] wordLengths = new int[numWords];
        for(int i = 0; i < numWords; i++){
            wordLengths[i] = words.get(i).length();
        }

        ArrayList<String> output = new ArrayList<>();

        int tempSum = 0;
//        output.add(words.get(0));
        for(int i = 0; i < numWords; i++){
            tempSum += wordLengths[i];
            if (tempSum == limit){
                output.add(words.get(i));
                output.add(" ");

                tempSum = 0;
            }
            else if (tempSum > limit){
                output.add(" ");
                output.add(words.get(i));

                tempSum = wordLengths[i];
            }
            else {

                output.add(words.get(i));
            }

        }

        PrintWriter out = new PrintWriter(new FileWriter("word2.out"));
        for(int i = 0; i < output.size(); i++) {
            if(output.get(i).equals(" "))
                out.println();
            else out.print(output.get(i) + " ");
        }
        out.close();
        input.close();
    }

}
