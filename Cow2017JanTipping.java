package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2017JanTipping {
    public static void tipCows() throws Exception {
        Scanner input = new Scanner(new File("cowtip.in"));

        int fieldDimensions = input.nextInt();
        int[][] cowField = new int[fieldDimensions][fieldDimensions];

        for(int r = 0; r < fieldDimensions; r++){
            String next = input.next();
            for (int c = 0; c < fieldDimensions; c++){
                cowField[r][c] = Character.getNumericValue(next.charAt(c));
            }
        }

        int numTips = 0;

        while(!allStanding(cowField)) {
            for(int row = cowField.length - 1; row >= 0; row--){
                for (int col = cowField[0].length - 1; col >= 0; col--){
                    if(cowField[row][col] == 1){
                        toggle(cowField, row, col);
                        numTips++;
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("cowtip.out"));
        out.println(numTips);
        out.close();
        input.close();

        //create int[n][n] of the cows
        //int numTips
        //while(!allStanding)
            //loop thru rows backwards
            //loop thru cols backwards
                //find farthest untipped cows to the bottom in last row
                    //increment numTips
                    //toggle(row, col)

    }

    public static boolean allStanding(int[][] field){
        for(int r = 0; r < field.length; r++){
            for(int c = 0; c < field[0].length; c++){
                if(field[r][c] == 1)
                    return false;
            }
        }
        return true;
    }

    public static void toggle(int[][] field, int rowBound, int colBound){
        for(int r = 0; r < rowBound + 1; r++){
            for(int c = 0; c < colBound + 1; c++){
                if(field[r][c] == 0)
                    field[r][c] = 1;
                else field[r][c] = 0;
            }
        }
    }
}

//create reverse arr so that the last row is first, do not reverse col

//toggle (rowBounds, colBounds)
    //loop thru rowBounds
        //loop thru colBounds
            //toggle

//allStanding(int[][] field)
    //loop thru rows
        //loop thru cols
            //if(1)
                //return false
    //return true;

//Test Cases:
    //all standing
    //all tipped
    //bottom row all standing
    //only bottom row tipped