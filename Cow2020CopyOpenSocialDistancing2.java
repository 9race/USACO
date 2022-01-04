package com.company;

import java.io.*;
import java.util.*;

public class Cow2020CopyOpenSocialDistancing2 {
    public static void main() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("socdist2.in"));
        int numCows = Integer.parseInt(input.readLine());
        int[][] cowPositions = new int[numCows][2];

        ArrayList<Integer> infected = new ArrayList<>();

        for(int i = 0; i < numCows; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
            int pos = Integer.parseInt(stringTokenizer.nextToken());
            cowPositions[i][0] = pos;
            int infect = Integer.parseInt(stringTokenizer.nextToken());
            if(infect == 1) infected.add(pos);
            cowPositions[i][1] = infect;
        }

        Arrays.sort(cowPositions, Comparator.comparingInt(o -> o[0]));

        Collections.sort(infected);

        int radius = Integer.MAX_VALUE;
        for(int i = 0; i < numCows - 1; i++){
            if((cowPositions[i][1] == 0 && cowPositions[i+1][1] == 1) || (cowPositions[i][1] == 1 && cowPositions[i+1][1] == 0)){
                if(cowPositions[i+1][0] - cowPositions[i][0] < radius)
                    radius = cowPositions[i+1][0] - cowPositions[i][0];
            }
        }
        radius--;

        int minInfected = 1;
        if(infected.size() == 0) minInfected = 0;


        for(int i = 0; i < infected.size() - 1; i++){
            if(infected.get(i+1) - infected.get(i) > radius){
                minInfected++;
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
        out.println(minInfected);
        out.close();
        input.close();
    }
}
