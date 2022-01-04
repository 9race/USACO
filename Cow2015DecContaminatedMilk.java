package com.company;

import java.io.*;
import java.util.*;

public class Cow2015DecContaminatedMilk {
    public static void main() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("badmilk.in"));
        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
        int numCows = Integer.parseInt(stringTokenizer.nextToken());
        int numTypes = Integer.parseInt(stringTokenizer.nextToken());
        int numRecords = Integer.parseInt(stringTokenizer.nextToken());
        int numSick = Integer.parseInt(stringTokenizer.nextToken());

        int[][] cowDrinks = new int[numRecords][3];
        for(int i = 0; i < numRecords; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            cowDrinks[i][0] = Integer.parseInt(st.nextToken());
            cowDrinks[i][1] = Integer.parseInt(st.nextToken());
            cowDrinks[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] sickCows = new int[numSick][2];
        for(int i = 0; i < numSick; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            sickCows[i][0] = Integer.parseInt(st.nextToken());
            sickCows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cowDrinks, Comparator.comparingInt(o -> o[2]));

        HashSet<Integer> possibleMilks = findPossibleMilks(cowDrinks, sickCows[0][0], sickCows[0][1]);

        for (int i = 1; i < numSick; i++) {
            HashSet<Integer> temp = findPossibleMilks(cowDrinks, sickCows[i][0], sickCows[i][1]);
            possibleMilks.retainAll(temp);
        }

        HashSet<Integer> antidotes = new HashSet<>();

        int numAntidotes = 0;
        for(int i = 0; i < numRecords; i++){
            if(possibleMilks.contains(cowDrinks[i][1]))
                antidotes.add(cowDrinks[i][0]);
        }

        numAntidotes = antidotes.size();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        out.println(numAntidotes);
        out.close();
        input.close();
    }

    public static HashSet<Integer> findPossibleMilks (int[][] cowDrinks, int sickCow, int time){
        int drinkRow = 0;
        HashSet<Integer> set = new HashSet<>();
        while(drinkRow < cowDrinks.length && cowDrinks[drinkRow][2] < time) {
            if(cowDrinks[drinkRow][0] == sickCow)
                set.add(cowDrinks[drinkRow][1]);
            drinkRow++;
        }
        return set;
    }
}
