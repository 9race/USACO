package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Cow2019JanGuessAnimal {
    public static void guess() throws Exception {
        Scanner input = new Scanner(new File("guess.in"));

        int numAnimals = input.nextInt();
        ArrayList<String>[] animals = new ArrayList[numAnimals];

        for(int i = 0; i < numAnimals; i++){
            input.next();
            int numTraits = Integer.valueOf(input.next());
            for(int j = 0; j < numTraits; j++){
                if(animals[i] == null)
                    animals[i] = new ArrayList<>();
                animals[i].add(input.next());
            }
        }

        ArrayList<Integer> intersections = new ArrayList<>();

        for(int i = 0; i < animals.length; i++) {
            for(int j = i+1; j < animals.length; j++){
                intersections.add(findNumIntersect(animals[i], animals[j]));
            }
        }

        int maxIntersect = 0;
        for(int i = 0; i < intersections.size(); i++){
            if(intersections.get(i) > maxIntersect)
                maxIntersect = intersections.get(i);
        }

        PrintWriter out = new PrintWriter(new FileWriter("guess.out"));
        out.println(maxIntersect + 1);
        out.close();
        input.close();
    }

    public static int findNumIntersect(ArrayList<String> a, ArrayList<String> b){
        int numIntersect = 0;
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                if(a.get(i).equals(b.get(j))){
                    numIntersect++;
                    break;
                }
            }
        }
        return numIntersect;
    }
}
//String[][] traits
//int[] numIntersections

//findNumIntersect
    //numIntersect
    //loop thru first arr
        //loop thru second arr
            //if equal
                //numIntersect++
                //break