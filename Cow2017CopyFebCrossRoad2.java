//package com.company;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Cow2017CopyFebCrossRoad2 {
//    public static void cowsCrossRoad2() throws Exception {
//        Scanner input = new Scanner(new File("circlecross.in"));
//
//        Stack<Character> cows = new Stack<Character>();
//
//        String s = input.next();
//
//        cows.push(s.charAt(0));
//        for (int i = 1; i < 52; i++) {
//            if (!cows.isEmpty() && cows.peek() == s.charAt(i))
//                cows.pop();
//            else cows.push(s.charAt(i));
//        }
//
//        ArrayList<Character> crossingCows = new ArrayList(cows);
//
//        int numCrossPairs = 0;
//
//        while (crossingCows.size() > 0) {
//            int[] indices1 = findIndices(crossingCows.get(0), crossingCows);
//            for (int i = indices1[0] + 1; i < indices1[1]; i++) {
//                int[] indices2 = findIndices(crossingCows.get(i), crossingCows);
//                if ((indices1[0] < indices2[0] && indices1[1] < indices2[1]) || (indices1[0] > indices2[0] && indices1[1] > indices2[1])) {
//                    numCrossPairs++;
//                }
//            }
//            crossingCows.remove(indices1[1]);
//            crossingCows.remove(indices1[0]);
//        }
//    }
//}
