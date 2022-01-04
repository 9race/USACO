package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2020JanWordProcessor {
    public static void wordProcessor() throws Exception{
        Scanner input = new Scanner(new File("word.in"));

        //int numWords
        //int maxChar
        //int[] wordSizes
        //loop thru arr
            //findMaxWords
                //add val to arrList
                    //add int -1
                //increment i


        int numWords = input.nextInt();
        int maxChars = input.nextInt();

        int[] wordSizes = new int[numWords];
        String[] words = new String[numWords];

        for(int i = 0; i < numWords; i++){
            words[i] = input.next();
            wordSizes[i] = words[i].length();
        }

        ArrayList<String> organizedWords = new ArrayList<>();
        for(int i = 0; i < numWords; i++){
            int maxWords = findMaxWords(maxChars, wordSizes, i);
            while(i <= maxWords){
                organizedWords.add(words[i]);
                i++;
            }
            organizedWords.add("10");
            i--;
        }

        PrintWriter out = new PrintWriter(new FileWriter("word.out"));
        for(int i = 0; i < organizedWords.size(); i++){
            if(!(organizedWords.get(i).equals("10"))){
                if(i != organizedWords.size()-1){
                    if(organizedWords.get(i+1).equals("10"))
                        out.println(organizedWords.get(i));
                    else{
                        out.print(organizedWords.get(i));
                        out.print(" ");
                    }
                }
                else{
                    out.print(organizedWords.get(i));
                    out.print(" ");
                }
            }
        }
        out.close();
        input.close();
    }

    public static int findMaxWords(int maxChars, int[] wordSizes, int startingIndex){
        int sum = 0;
        for(int i = startingIndex; i < wordSizes.length; i++){
            sum += wordSizes[i];
            if(sum > maxChars){
                return (i-1);
            }
            else if(sum == maxChars){
                return i;
            }
        }
        return wordSizes.length - 1;
    }
}
