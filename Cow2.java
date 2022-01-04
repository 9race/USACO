package com.company;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Cow2 {
    public static void main() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("cow2.in"));
        int numFlowers = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> petals = new ArrayList<Integer>();
        for (int i = 0; i < numFlowers; i++) {
            petals.add(Integer.parseInt(st.nextToken()));
        }

        int numAvg = numFlowers;
        for (int i = 0; i < numFlowers; i++) {
            for (int j = i + 1; j < numFlowers; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    temp.add(petals.get(k));
                    sum += petals.get(k);
                }
                if (sum % temp.size() == 0) {
                    int avg = sum / temp.size();
                    if (temp.contains(avg))
                        numAvg++;
                }

            }
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cow2.out")));
            out.println(numAvg);
            out.close();
            input.close();

        }
    }
}
