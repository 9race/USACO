package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F1v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] coords = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());;
        }

        HashMap<String, Integer> map =  new HashMap();
        Queue<int[]> queue = new ArrayDeque<int[]>();
    }
}
