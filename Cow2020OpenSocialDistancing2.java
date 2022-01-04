package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cow2020OpenSocialDistancing2 {
    public static void cowvid() throws Exception{
        Scanner input = new Scanner(new File("socdist2.in"));
        int numCows = input.nextInt();
        ArrayList<Integer> infected = new ArrayList<>();
        ArrayList<Integer> safe = new ArrayList<>();

        for(int i = 0; i < numCows; i++){
            int index = input.nextInt();
            int diseased = input.nextInt();
            if(diseased == 0){
                safe.add(index);
            }
            else infected.add(index);
        }

        int minDistance = Integer.MAX_VALUE;;

        for(int i = 0; i < infected.size(); i++){
            for(int j = 0; j < safe.size(); j++){
                if(Math.abs(infected.get(i) - safe.get(j)) < minDistance)
                    minDistance = Math.abs(infected.get(i) - safe.get(j));
            }
        }

        int minInfected = 1;
        int[] infectedArr = new int[infected.size()];
        for(int i = 0; i < infected.size(); i++){
            infectedArr[i] = infected.get(i);
        }
        Arrays.sort(infectedArr);

        for(int i = 0; i < infected.size() - 1; i++){
            if(Math.abs(infectedArr[i] - infectedArr[i+1]) >= minDistance)
                minInfected++;
        }

        PrintWriter out = new PrintWriter(new FileWriter("socdist2.out"));
        out.println(minInfected);
        out.close();
        input.close();
    }
}
