package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2017DecBillboard {
    public static void billboard() throws Exception{
        Scanner input = new Scanner(new File("billboard.in"));

        int[] firstBillboard = new int[4];
        int[] secondBillboard = new int[4];
        int[] truck = new int[4];

        for(int i = 0; i < 4; i++){
            firstBillboard[i] = input.nextInt();
        }
        for(int i = 0; i < 4; i++){
            secondBillboard[i] = input.nextInt();
        }
        for(int i = 0; i < 4; i++){
            truck[i] = input.nextInt();
        }

        int[] bottomLeft1 = compareBottom(firstBillboard[0], firstBillboard[1], truck[0], truck[1]);
        int[] topRight1 = compareTop(firstBillboard[2], firstBillboard[3], truck[2], truck[3]);
        int intersection1 = (topRight1[0] - bottomLeft1[0]) * (topRight1[1] - bottomLeft1[1]);
        if(bottomLeft1[0] > topRight1[0] || bottomLeft1[1] > topRight1[1])
            intersection1 = 0;

        int[] bottomLeft2 = compareBottom(secondBillboard[0], secondBillboard[1], truck[0], truck[1]);
        int[] topRight2 = compareTop(secondBillboard[2], secondBillboard[3], truck[2], truck[3]);
        int intersection2 = (topRight2[0] - bottomLeft2[0]) * (topRight2[1] - bottomLeft2[1]);
        if(bottomLeft2[0] > topRight2[0] || bottomLeft2[1] > topRight2[1])
            intersection2 = 0;

        int billboard1 = (firstBillboard[2] - firstBillboard[0]) * (firstBillboard[3] - firstBillboard[1]);
        int billboard2 = (secondBillboard[2] - secondBillboard[0]) * (secondBillboard[3] - secondBillboard[1]);

        int first = billboard1 - intersection1 < 0 ? 0 : billboard1 - intersection1;
        int second = billboard2 - intersection2 < 0 ? 0 : billboard2 - intersection2;

        PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
        out.println(first + second);
        out.close();
        input.close();

        //put coordinates into arrays
        //coordinates1 = compare(bottom coordinates)
        //coordinates2 = compare(top coordinates)
        //find area by multiplying difference in x with difference in y



        //compare two coordiantes
            //compare x vals
            //compare y Vals
                //return bigger x, bigger y


    }

    public static int[] compareBottom(int x1, int y1, int x2, int y2){
        int[] newCoordinates = new int[2];

        if(x1 > x2)
            newCoordinates[0] = x1;
        else newCoordinates[0] = x2;
        if(y1 > y2)
            newCoordinates[1] = y1;
        else newCoordinates[1] = y2;

        return newCoordinates;
    }
    public static int[] compareTop(int x1, int y1, int x2, int y2){
        int[] newCoordinates = new int[2];

        if(x1 < x2)
            newCoordinates[0] = x1;
        else newCoordinates[0] = x2;
        if(y1 < y2)
            newCoordinates[1] = y1;
        else newCoordinates[1] = y2;

        return newCoordinates;
    }
}
