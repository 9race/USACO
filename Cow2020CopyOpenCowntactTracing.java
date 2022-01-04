package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Cow2020CopyOpenCowntactTracing {
    public static void main() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));

        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
        int numCows = Integer.parseInt(stringTokenizer.nextToken());
        int numInteractions = Integer.parseInt(stringTokenizer.nextToken());
        int[] cows = new int[numCows];
        StringTokenizer stringTokenizer1 = new StringTokenizer(input.readLine());
        String s = (stringTokenizer1.nextToken());
        for(int i = 0; i < numCows; i++){
            cows[i] = (int)s.charAt(i) - 48;
        }

        int[][] interactions = new int[numInteractions][3];
        for(int i = 0; i < numInteractions; i++){
            StringTokenizer stringTokenizer2 = new StringTokenizer(input.readLine());
            interactions[i][0] = Integer.parseInt(stringTokenizer2.nextToken());
            interactions[i][1] = Integer.parseInt(stringTokenizer2.nextToken());
            interactions[i][2] = Integer.parseInt(stringTokenizer2.nextToken());
        }

        Arrays.sort(interactions, Comparator.comparingInt(o -> o[0]));
        int[] infectedCows = Arrays.stream(cows).filter(x -> x > 0).toArray();

        if(infectedCows.length == 1){
            System.out.println(1);
            System.out.println(1);
            System.out.println("Infinity");
            System.out.close();
            input.close();
        }

        int mink = 0;
        for(int i = 0; i < numCows; i++){
            if(Arrays.equals(cows, simulateInfections(interactions, i, numCows))){
                System.out.print(1);
                System.out.print(" ");
                System.out.print(1);
                System.out.print(" ");
                System.out.print("Infinity");
                System.out.close();
                input.close();
                return;
            }
        }

        int[] infectedCows1 = Arrays.stream(cows).filter(x -> x > 0).toArray();
        System.out.println(infectedCows1.length);
        System.out.println(0);
        System.out.println(0);
        System.out.close();
        input.close();
    }

    public static int[] simulateInfections(int[][] interactions, int start, int numCows) {
        int[] cows = new int[numCows];
        cows[start] = 1;
        for(int i = 0; i < interactions.length; i++){
            if(cows[interactions[i][2]-1] == 1 || cows[interactions[i][1]-1] == 1){
                cows[interactions[i][2]-1] = 1;
                cows[interactions[i][1]-1] = 1;
            }
        }
        return cows;
    }
}
