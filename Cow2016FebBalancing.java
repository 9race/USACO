package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2016FebBalancing {
    public static void balance() throws Exception{
        Scanner input = new Scanner(new File("balancing.in"));
        int numCows = input.nextInt();
        int b = input.nextInt();
        int[] xValues = new int[numCows];
        int[] yValues = new int[numCows];

        for(int i = 0; i < numCows; i++){
            xValues[i] = input.nextInt();
            yValues[i] = input.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < numCows; i++) {
            for(int j = 0; j < numCows; j++) {
                int m = findM(xValues[i]+1,yValues[j] + 1,xValues, yValues);
                if (m < min)
                    min = m;
            }
        }

        // put all values into two arrays
        // loop thru 0 to b
            //loop thru to b
                //x = i
                //y = j
                //find numMax
        //find numMax
            // int underL
            //int underR
            //int overL
            //int overR
            //loop thru both arrays
                //if x is less than xB and y is less than yB
                    //increment underL
                //else if x is greater than xB and y is less than yB
                    //increment overL
                //else if...
            //loop thru under and over
                //find max

        PrintWriter out = new PrintWriter(new FileWriter("balancing.out"));
        out.println(min);
        out.close();
        input.close();
    }

    public static int findM(int xB, int yB, int[] xVal, int[] yVal){
        int underL = 0;
        int underR = 0;
        int overL = 0;
        int overR = 0;

        for(int m = 0; m < xVal.length; m++) {
            if (xVal[m] < xB && yVal[m] < yB)
                underL++;
            else if (xVal[m] > xB && yVal[m] < yB)
                underR++;
            else if (xVal[m] < xB && yVal[m] > yB)
                overL++;
            else if (xVal[m] > xB && yVal[m] > yB)
                overR++;
        }

        int[] vals = {underL, underR, overL, overR};
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++){
            if(vals[i] > max)
                max = vals[i];
        }
        return max;
    }
}
