package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2012DecGreeting {
    public static void main(String[] args){}
    public static void cowGreeting() throws Exception{

        // Read the grid.
        Scanner stdin = new Scanner(new File("greetings.in"));

        // Read in permutation backwards.
        int bMajorSteps = stdin.nextInt();
        int eMajorSteps = stdin.nextInt();
        int totalSteps = 14;
        int[] bessie = new int[totalSteps];
        int[] elsie = new int[totalSteps];
        boolean headingLeft = true;

        int bMinorStep = 0;
        for (int bMajorStep = 0; bMajorStep < bMajorSteps; bMajorStep++) {
            int subSteps = stdin.nextInt();
            if(stdin.next().charAt(0) == 'R') headingLeft = false;
            else headingLeft = true;
            for (int subStep = 0; subStep < subSteps; subStep++){
                if (bMinorStep == 0) {
                    bessie[bMinorStep] = headingLeft ? -1 : 1;
                } else {
                    bessie[bMinorStep] = bessie[bMinorStep - 1] + (headingLeft ? -1 : 1);
                }
                bMinorStep++;
            }
        }

        int eMinorStep = 0;
        for (int eMajorStep = 0; eMajorStep < eMajorSteps; eMajorStep++) {
            int subSteps = stdin.nextInt();
            if(stdin.next().charAt(0) == 'R') headingLeft = false;
            else headingLeft = true;
            for (int subStep = 0; subStep < subSteps; subStep++){
                if (eMinorStep == 0) {
                    elsie[eMinorStep] = headingLeft ? -1 : 1;
                } else {
                    elsie[eMinorStep] = elsie[eMinorStep - 1] + (headingLeft ? -1 : 1);
                }
                eMinorStep++;
            }
        }

        if(totalSteps == eMinorStep){
            for(int x = 0; x < (eMinorStep-bMinorStep); x++){
                bessie[bMinorStep+x] = bessie[bMinorStep-1];
            }
        }
        else{
            for(int x = 0; x < (bMinorStep-eMinorStep); x++){
                elsie[eMinorStep+x] = elsie[eMinorStep-1];
            }
        }

        int numMoos = 0;
        boolean together = false;

        for(int x = 0; x < totalSteps; x++){
            if (bessie[x] == elsie[x] && !together) {
                numMoos++;
                together = true;
            } else if(bessie[x] == elsie[x]) {
                together = true;
            } else together = false;
        }

        // Ta da!
        PrintWriter out = new PrintWriter(new FileWriter("greetings.out"));
        out.println(numMoos);
        out.close();
        stdin.close();
    }
}
