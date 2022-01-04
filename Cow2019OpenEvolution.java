package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2019OpenEvolution {
    public static void evolution() throws Exception{
        //create array of arrayList to store values
        //bool valid = true
        //loop thru i
            //loop thru i+1
                //if intersection
                    //valid = false
                    //break

        Scanner input = new Scanner(new File("evolution.in"));

        int numPopulations = input.nextInt();
//        ArrayList<String>[] allTraits = new ArrayList[numPopulations];
        ArrayList<String> traits = new ArrayList<String>();
        for(int i = 0; i < numPopulations; i++){
            int numTraits = input.nextInt();
            for(int j = 0; j < numTraits; j++){
                String trait = input.next();
                if(!(traits.contains(trait)))
                    traits.add(trait);
            }
        }

        input.close();

        Scanner input2 = new Scanner(new File("evolution.in"));
        input2.nextInt();
        ArrayList<Integer>[] populations = new ArrayList[traits.size()];

        for(int i = 0; i < numPopulations; i++){
            int num = Integer.valueOf(input2.next());
            for(int j = 0; j < num; j++){

            }
        }
    }

    public static int findIndex(String str, ArrayList<String> traits){
        for(int i = 0; i < traits.size(); i++){
            if(str.equals(traits.get(i)))
                return i;
        }
        return -1;
    }
}
