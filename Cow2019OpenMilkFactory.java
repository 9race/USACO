package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2019OpenMilkFactory {
    public static void milkFactory() throws Exception {
        Scanner input = new Scanner(new File("factory.in"));

        //create [][] of pointing
        //while still able to point
            //put value it doesn't point in arr

        int numStations = input.nextInt();
        ArrayList<Integer>[] pointers = new ArrayList[numStations];

        for(int i = 0; i < numStations-1; i++){
            int origStation = input.nextInt();
            if(pointers[origStation-1] == null)
                pointers[origStation-1] = new ArrayList<>();
            pointers[origStation-1].add(input.nextInt()-1);
        }

        int endStation = -1;
        ArrayList<Integer> endStations = new ArrayList<>();

        for(int i = 0; i < numStations; i++){
            int spot = i;
            while(pointers[spot] != null){
                spot = pointers[spot].get(0);
            }
            endStations.add(spot);
        }

        boolean same = true;
        for(int i = 0; i < endStations.size(); i++){
            for(int j = i+1; j < endStations.size(); j++){
                if(endStations.get(i) != endStations.get(j)){
                    same = false;
                    break;
                }
            }
        }

        if(same){
            endStation = endStations.get(0);
        }

        PrintWriter out = new PrintWriter(new FileWriter("factory.out"));
        if(endStation == -1)
            out.println(endStation);
        else out.println(endStation+1);
        out.close();
        input.close();
    }
}
