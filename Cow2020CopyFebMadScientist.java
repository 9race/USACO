package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cow2020CopyFebMadScientist {
    public static void madScientist() throws Exception {

        BufferedReader input = new BufferedReader(new FileReader("breedflip.in"));
        // Use StringTokenizer vs. readLine/split -- lots faster
        //StringTokenizer st = new StringTokenizer(input.readLine());

        int numCows = Integer.parseInt(input.readLine());
        String original = input.readLine();
        String rearranged = input.readLine();

        int[] a = new int[numCows];
        int[] b = new int[numCows];

        for(int i = 0; i < numCows; i++){
            a[i] = original.charAt(i);
        }

        for(int i = 0; i < numCows; i++){
            b[i] = rearranged.charAt(i);
        }

        boolean set = false;
        int numFlips = 0;
        for(int i = 0; i < numCows; i++){
            if(a[i] != b[i]){
                if(!set){
                    set = true;
                    numFlips++;
                }
            }
            else{
                if(set){
                    set = false;
                }
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        out.print(numFlips);
        out.close();
        input.close();
    }
}
