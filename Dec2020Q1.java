//package com.company;

/*
ID: graceluo
LANG: JAVA
TASK: BronzeABCs
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Dec2020Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i<7; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);
        int max = numbers.remove(6);
        int a = numbers.remove(0);
        int b = numbers.remove(0);

        for(int i=0;i<4; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == max * 2) {
                        numbers.remove(i);
                        numbers.remove(j - 1);
                        numbers.remove(k - 2);
                        int c = numbers.get(0);
                        System.out.print(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }
    }
}
