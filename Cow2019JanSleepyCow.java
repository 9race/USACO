package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Cow2019JanSleepyCow {
    /*
        create an [][] with animal and traits
        loop thru animals
            numIntersection
            find max with numIntersection


        numIntersection
            int max
            int numIntersect[]
            loop thru arr
                loop thru traits
                    loop thru the rest
                        loop thru the traits
                            numIntersect[i]++


     */

    public static void sleepyCows() throws Exception{
        Scanner input = new Scanner(new File("guess.in"));

        int numAnimals = input.nextInt();
        ArrayList<String>[] animals = new ArrayList[numAnimals];

        for(int i = 0; i < numAnimals; i++){
            if(animals[i] == null) {
                animals[i] = new ArrayList<>();
            }
            animals[i].add(input.next());
            int numTraits = input.nextInt();
            for(int j = 0; j < numTraits; j++){
                String trait = input.next();
                animals[i].add(trait);
            }
        }

        int maxIntersections = numIntersections(animals);

        PrintWriter out = new PrintWriter(new FileWriter("guess.out"));
        out.println(maxIntersections+1);
        out.close();
        input.close();
    }

    public static int numIntersections(ArrayList<String>[] animals){
        ArrayList<Integer> numIntersections = new ArrayList<>();
        for(int i = 0; i < animals.length * (animals.length-1)/2; i++) {
            numIntersections.add(0);
        }
        int spot = 0;
        for(int i = 0; i < animals.length; i++){
            for(int m = i + 1; m < animals.length; m++) {
                for (int trait = 1; trait < animals[i].size(); trait++) {
                    String description = animals[i].get(trait);
                    for (int otherTrait = 1; otherTrait < animals[m].size(); otherTrait++){
                        String otherDescription = animals[m].get(otherTrait);
                        if(description.equals(otherDescription)){
                            numIntersections.set(spot,numIntersections.get(spot)+1);
                        }
                    }
                }
                spot++;
            }

        }
        int maxIntersect = 0;
        for(int i = 0; i < numIntersections.size(); i++){
            if (numIntersections.get(i) > maxIntersect)
                maxIntersect = numIntersections.get(i);
        }
        return maxIntersect;
    }
}
