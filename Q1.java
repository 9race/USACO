/*
5 4
1 3
1 2
2 3
2 4
 */

package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
        int numCows = Integer.parseInt(stringTokenizer.nextToken());
        int numSwaps = Integer.parseInt(stringTokenizer.nextToken());

        int[] origCows = new int[numCows];
        int[] changedPositions = new int[numCows];
        for(int i = 0; i < numCows; i++) {
            origCows[i] = i;
            changedPositions[i] = i;
        }

        int[][] swaps = new int[numSwaps][2];
        for(int i = 0; i < numSwaps; i++) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(input.readLine());
            int firstIndex = Integer.parseInt(stringTokenizer2.nextToken());
            int secondIndex = Integer.parseInt(stringTokenizer2.nextToken());
            swaps[i][0] = firstIndex - 1;
            swaps[i][1] = secondIndex - 1;
        }

        HashMap<Integer, Boolean>[] indicesReached =  new HashMap[numCows];
        for (int i = 0; i < numCows; i++) {
            indicesReached[i] = new HashMap<Integer, Boolean>();
            indicesReached[i].put(i, true);
        }
        while (true) {
            for(int i = 0; i < swaps.length; i++) {
                int firstIndex = swaps[i][0];
                int secondIndex = swaps[i][1];
                int val = changedPositions[firstIndex];
                changedPositions[firstIndex] = changedPositions[secondIndex];
                changedPositions[secondIndex] = val;
                int index = changedPositions[firstIndex];
                indicesReached[index].put(firstIndex, true);
                indicesReached[changedPositions[secondIndex]].put(secondIndex, true);
                if(origCows[firstIndex] == changedPositions[firstIndex] && origCows[secondIndex] == changedPositions[secondIndex]) {
                    if (same(origCows, changedPositions)) {
                        for (int p = 0; p < numCows; p++) {
                            System.out.println(indicesReached[p].size());
                        }
                        return;
                    }
                }
            }
        }
    }

    public static boolean same (int[] orig, int[] changed) {
        for (int i = 0; i < orig.length; i++) {
            if (orig[i] != changed[i]) return false;
        }
        return true;
    }
}


