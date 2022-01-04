package com.company;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Cow2016FebMilkPails {
    public static void milkPails() throws Exception{
        Scanner input = new Scanner(new File("pails.in"));

        //int totalValue
        //take M and divide by (x+y)
        //add (x+y) to totalValue
        //take remainder from M/(x+y) and % x and % y
        //find result of division by whichever one has the smaller remainder (int d)
        //add (x or y)*d to totalValue


//
//
//        int totalValue = 0;
//        totalValue += (m/(x+y)) * (x+y);
//        int bothRemainder = m%(x+y);
//        if(x > bothRemainder) {
//            int yRemainder = bothRemainder % y;
//            totalValue += (bothRemainder/y) * y;
//        }
//        else if(y > bothRemainder) {
//            int xRemainder = bothRemainder % x;
//            totalValue += (bothRemainder/x) * x;
//        }
//        else{
//            int xRemainder = bothRemainder % x;
//            int yRemainder = bothRemainder % y;
//            if(xRemainder < yRemainder)
//                totalValue += (bothRemainder/x) * x;
//            else totalValue += (bothRemainder/y) * y;
//        }
//
//
//        if(m % x == 0 || m % y == 0)
//            totalValue = m;

        //int total val
        //loop thru m/x (i)
            //loop thru m/y (j)
                //add x*i and y*j
                //if sum > totalVal and < m
                    //set total to sum

        int x = input.nextInt();
        int y = input.nextInt();
        int m = input.nextInt();

        int totalValue = 0;
        int xRange = m/x;
        int yRange = m/y;

        for(int i = 0; i < xRange; i++){
            for(int j = 0; j < yRange; j++){
                if((x*i + y*j) > totalValue && ((x*i + y*j) <= m))
                    totalValue = (x*i + y*j);
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("pails.out"));
        out.println(totalValue);
        out.close();
        input.close();
    }
}
