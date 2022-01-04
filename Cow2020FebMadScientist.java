package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020FebMadScientist {
    public static void flip() throws Exception{
        Scanner input = new Scanner(new File("breedflip.in"));

        int numCows = input.nextInt();
        char[] a = new char[numCows];
        char[] b = new char[numCows];

        String first = input.next();
        String second = input.next();

        for(int i = 0; i < numCows; i++){
            a[i] = first.charAt(i);
        }

        for(int i = 0; i < numCows; i++){
            b[i] = second.charAt(i);
        }

        int numRanges = 0;
        if(b[0] != a[0])
            numRanges = 1;

        for(int i = 1; i < numCows; i++){
            if(a[i-1] == b[i-1] && a[i] != b[i])
                numRanges++;
        }

        PrintWriter out = new PrintWriter(new FileWriter("breedflip.out"));
        out.print(numRanges);
        out.close();
        input.close();

        //int[] a
        //int[] b
        //loop thru b
            // if a[i-1] is equal to b && a[i-1] != b
    }
}
