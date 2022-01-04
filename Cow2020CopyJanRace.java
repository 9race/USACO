package com.company;

/*
ID: gra.luo0122@gmail.com
LANG: JAVA
TASK: race
*/

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020CopyJanRace {
    public static void race() throws Exception {
        Scanner input = new Scanner(new File("race.in"));

        int distance = input.nextInt();
        int numX = input.nextInt();
        int[] minSpeeds = new int[numX];

        for(int i = 0; i < numX; i++){
            minSpeeds[i] = input.nextInt();
        }

        PrintWriter out = new PrintWriter(new FileWriter("race.out"));
        for(int i = 0; i < numX; i++){
            out.println(findTime(distance, minSpeeds[i]));
        }
        out.close();
        input.close();
    }

    public static int findTime(int distance, int minSpeed){
        int leftDist = 0;
        int rightDist = 0;
        int timeLapse = 0;

        for(int currSpeed = 1; ; currSpeed++){
            leftDist += currSpeed;
            timeLapse++;
            if(leftDist + rightDist >= distance)
                return timeLapse;
            if (currSpeed >= minSpeed) {
                rightDist += currSpeed;
                timeLapse++;

                if(leftDist + rightDist >= distance)
                    return timeLapse;
            }
        }
    }
}
