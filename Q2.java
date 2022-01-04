/*
8 2
ABBAABCB
3 6
1 4
 */

package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());

        int numSegments = Integer.parseInt(stringTokenizer.nextToken());
        int numRanges = Integer.parseInt(stringTokenizer.nextToken());

        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
        String s = input.readLine();
        for (int i = 0; i < numRanges; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(stringTokenizer1.nextToken());
            int end = Integer.parseInt(stringTokenizer1.nextToken());
            String sub1 = s.substring(0, start - 1);
            String sub2 = s.substring(end, numSegments);
            int count1 = 0;
            if (numbers.get(sub1) == null) {
                count1 = numStrokes(sub1.toCharArray());
                numbers.put(sub1, count1);
            }
            else {
                count1 = numbers.get(sub1).intValue();
            }
            int count2 = 0;
            if (numbers.get(sub2) == null) {
                count2 = numStrokes(sub2.toCharArray());
                numbers.put(sub2, count2);
            }
            else {
                count2 = numbers.get(sub2).intValue();
            }
            int count = count1 + count2;
            System.out.println(count);
        }
    }

    public static int numStrokes (char[] segments) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < segments.length; i++) {
            if(!stack.isEmpty()) {
                if (stack.peek() != segments[i]) {
                    while (!stack.isEmpty() && stack.peek() > segments[i]) {
                        stack.pop();
                        count++;
                    }
                    if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < segments[i])) {
                        stack.push(segments[i]);
                    }
                }
            }
            else {
                stack.push(segments[i]);
            }
        }

        if (!stack.isEmpty()) {
            count = count + stack.size();
        }
        return count;
    }
}
