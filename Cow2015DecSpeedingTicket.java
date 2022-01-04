package com.company;

/*
ID: your_id_here
LANG: JAVA
TASK: speeding
*/

import java.io.*;
import java.util.StringTokenizer;

public class Cow2015DecSpeedingTicket {
    public static void main() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("speeding.in"));

        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
        int nSegments = Integer.parseInt(stringTokenizer.nextToken());
        int mSegments = Integer.parseInt(stringTokenizer.nextToken());

        int[] speedLimits = new int[100];
        int[] bessieSpeeds = new int[100];

        int count = 0;
        for (int i = 0; i < nSegments; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int numMiles = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for(int mile = 0; mile < numMiles; mile++) {
                speedLimits[count] = speed;
                count++;
            }
        }

        count = 0;
        for (int i = 0; i < mSegments; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int numMiles = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for(int mile = 0; mile < numMiles; mile++) {
                bessieSpeeds[count] = speed;
                count++;
            }
        }

        int maxDifference = 0;
        for (int i = 0; i < 100; i++) {
            if(bessieSpeeds[i] - speedLimits[i] > maxDifference)
                maxDifference = bessieSpeeds[i] - speedLimits[i];
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        out.println(maxDifference);
        out.close();
        input.close();
    }
}
