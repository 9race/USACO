//package com.company;

/*
ID: graceluo
LANG: JAVA
TASK: BronzeDaisyChains
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dec2020Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numFlowers = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> petals = new ArrayList<>();
        for (int i = 0; i < numFlowers; i++) {
            petals.add(Integer.parseInt(st.nextToken()));
        }

        int numAvg = numFlowers;
/*
        for (int i1 = 0; i1 < numFlowers; i1++) {
            for (int j1 = 0; j1 < numFlowers-i1; j1++) {
                temp.add(petals.get(i1+j1));
                sum += petals.get(i1+j1);

            }
        }
        */

        for (int i = 0; i < numFlowers; i++) {
            for (int j = i + 1; j < numFlowers; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                int sum = 0;
                for (int k = i; k <= j; k++) {

                }
                if (sum % temp.size() == 0) {
                    int avg = sum / temp.size();
                    if (temp.contains(avg))
                        numAvg++;
                }
            }
        }
        System.out.println(numAvg);
    }
}
