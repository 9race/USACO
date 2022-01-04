package com.company;

/*
ID: your_id_here
LANG: JAVA
TASK: paint
*/

import java.io.*;
import java.util.StringTokenizer;

public class Cow2015DecFencePainting {
    public static void main() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("paint.in"));

        int[] fj = new int[2];
        int[] bessie = new int[2];

        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
        fj[0] = Integer.parseInt(stringTokenizer.nextToken());
        fj[1] = Integer.parseInt(stringTokenizer.nextToken());

        StringTokenizer stringTokenizer2 = new StringTokenizer(input.readLine());
        bessie[0] = Integer.parseInt(stringTokenizer2.nextToken());
        bessie[1] = Integer.parseInt(stringTokenizer2.nextToken());

        int area;
        area = fj[1] - fj[0] + bessie[1] - bessie[0];
        if(overlap(fj, bessie)) {
            int largest = largest(fj[0], bessie[0]);
            int smallest = smallest(fj[1], bessie[1]);
            area -= smallest - largest;
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        out.println(area);
        out.close();
        input.close();
    }

    public static boolean overlap (int[] fj, int[] bessie) {
        if((fj[0] >= bessie[0] && fj[0] <= bessie[1]) || (fj[1] >=bessie[0] && fj[1] <= bessie[1]))
            return true;
        else if((bessie[0] >= fj[0] && bessie[0] <= fj[1]) || (bessie[1] >= fj[0] && bessie[1] <= fj[1]))
            return true;
        return false;
    }

    public static int largest (int a, int b){
        if(a > b)
            return a;
        return b;
    }

    public static int smallest (int a, int b){
        if(a < b)
            return a;
        return b;
    }

    //arr fj
    //arr bessie

    //public boolean findOverlap
        //if fj[1] < bessie[0]
            //return

    //public boolean overlap
        //if fj[1] > bessie[0] or fj[0] < bessie[1]
            //true
        //false
}
