package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2019FebHerding {
    public static void herding() throws Exception{
        Scanner input = new Scanner(new File("herding.in"));
        PrintWriter out = new PrintWriter(new FileWriter("herding.out"));

        //put positions into arr
        //check if they are consecutive
        //check if any differ by 2
        //

        int[] positions = new int[3];
        for(int i = 0; i < positions.length; i++){
            positions[i] = input.nextInt();
        }

        if(positions[0] + 1 == positions[1] && positions[1] + 1 == positions[2]){
            out.println(0);
            out.println(0);
            out.close();
            input.close();
        }

        else{
            if(positions[0] + 2 == positions[1] || positions[1] + 2 == positions[2])
                out.println(1);
            else out.println(2);
            int maxDifference = 0;
            if(Math.abs(positions[0] - positions[1]) > maxDifference)
                maxDifference = Math.abs(positions[0] - positions[1]);
            if(Math.abs(positions[2] - positions[1]) > maxDifference)
                maxDifference = Math.abs(positions[2] - positions[1]);
            out.println(maxDifference - 1);
            out.close();
            input.close();
        }

    }

}
