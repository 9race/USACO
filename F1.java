package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 10
 2 2
 2 1
 1 2
 1 1
 2 3
 3 1
 4 1
 4 2
 3 3
 3 2
* */
public class F1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[][] matrix = new int[n][2];
        int count = 0;
        //StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            matrix[i][0] = Integer.parseInt(tokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(tokenizer.nextToken());;
        }


        HashMap<String, Integer> map =  new HashMap();
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            String key = matrix[i][0] + "," + matrix[i][1];
            if (map.containsKey(key)) {
                count--;
            }
            else {
                insertANode(map, matrix[i][0], matrix[i][1], queue);

                // prints [3, 2, 1]
                while (!queue.isEmpty()) {
                    int[] val = queue.pop();
                    if (! map.containsKey(val[0]+","+(val[1]+1))) {insertANode(map, val[0], val[1]+1 , queue); }
                    else if (! map.containsKey(val[0]+","+(val[1]-1))) {insertANode(map, val[0], val[1]-1 , queue); }
                    else if (! map.containsKey((val[0]+1)+","+val[1])) {insertANode(map, val[0]+1, val[1] , queue); }
                    else {insertANode(map, val[0]-1, val[1] , queue); }

                    count++;
                }
            }
            //out.append(count).append('\n');
            System.out.println(count);
        }

        //System.out.print(out);



    }

    public static void insertANode(HashMap<String, Integer> map, int x, int y, Deque<int[]> queue) {
        String key = Integer.toString(x) + "," + Integer.toString(y);
        int neighbour = 0;
        String north = Integer.toString(x) + "," + Integer.toString(y + 1);
        if (map.containsKey(north)) {
            int newCount = map.get(north) + 1;
            neighbour++;
            map.put(north, newCount);
            if (newCount == 3) {
                //throw it to stack
                queue.add(new int[] {x, y+1});
            }
        }
        String south = Integer.toString(x) + "," + Integer.toString(y - 1);
        if (map.containsKey(south)) {
            int newCount = map.get(south) + 1;
            neighbour++;
            map.put(south, newCount);
            if (newCount == 3) {
                //throw it to stack
                queue.add(new int[] {x, y-1});
            }
        }
        String east = Integer.toString(x+1) + "," + Integer.toString(y);
        if (map.containsKey(east)) {
            int newCount = map.get(east) + 1;
            neighbour++;
            map.put(east, newCount);
            if (newCount == 3) {
                //throw it to stack
                queue.add(new int[] {x+1, y});
            }
        }
        String west = Integer.toString(x-1) + "," + Integer.toString(y);
        if (map.containsKey(west)) {
            int newCount = map.get(west) + 1;
            neighbour++;
            map.put(west, newCount);
            if (newCount == 3) {
                //throw it to stack
                queue.add(new int[] {x-1, y});
            }
        }
        map.put(key, neighbour);
        if (neighbour == 3) {
            //throw it to stack
            queue.add(new int[] {x, y});
        }
    }
}

