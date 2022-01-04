package com.company;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Cow2016DecSignal {
    public static void signal() throws Exception{
        Scanner signal = new Scanner(new File("cowsignal.in"));
        int rows = signal.nextInt();
        int columns = signal.nextInt();
        int multiple = signal.nextInt();
        String[][] characters = new String[rows * multiple][columns * multiple];


        for(int row = 0; row < rows; row++){
            String s = signal.next();
            for(int col = 0; col < columns; col++){
                String temp = s.substring(col, col + 1);
                for(int rPos = 0; rPos < multiple; rPos++) {
                    for(int cPos = 0; cPos < multiple; cPos++) {
                        characters[row * multiple + rPos][col * multiple + cPos] = temp;
                    }
                }
            }
        }


//        for(int i = 0; i < rows; i++){
//            int spot = 0;
//            String[] partialSignal = new String[columns*rows];
//            for(int section = columns; section < columns; section++) {
//                partialSignal[section] = chars.get(spot);
//                spot++;
//            }
//            int j = 0;
//            for(int x = 4; x < columns*rows; x++){
//                chars.add(x,partialSignal[j]);
//                if(x == )
//                j++;
//            }
//        }

        PrintWriter out = new PrintWriter(new FileWriter("cowsignal.out"));
//        for(int row = 0; row < rows; row++){
//            for(int col = columns*row; col < columns*(row + 1); col++){
//                if(col != columns*(row+1) - 1)
//                    out.print(chars.get(col));
//                else out.println(chars.get(col));
//            }
//        }
        for(int i = 0; i < rows*multiple; i++){
            for(int j = 0; j < columns*multiple; j++){
                if(j != columns*multiple - 1)
                    out.print(characters[i][j]);
                else out.println(characters[i][j]);
            }
        }

        out.close();
        signal.close();
    }
}
