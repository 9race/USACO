package com.company;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Cow2016JanPromotion {
    public static void promote() throws Exception{
        Scanner divisions = new Scanner(new File("promote.in"));
        int[] beforeContest = new int[4];
        int[] afterContest = new int[4];
        int[] change = new int[4];
        for(int i = 3; i >= 0; i--){
            beforeContest[i] = divisions.nextInt();
            afterContest[i] = divisions.nextInt();
            change[i] = afterContest[i] - beforeContest[i];
        }
        int numGoldPromo = change[0];
        int numSilverPromo = change[0] + change[1];
        int numBronzePromo = change[0] + change[1] + change[2];

        PrintWriter out = new PrintWriter(new FileWriter("promote.out"));
        out.println(numBronzePromo);
        out.println(numSilverPromo);
        out.println(numGoldPromo);
        out.close();
        divisions.close();
    }
}
