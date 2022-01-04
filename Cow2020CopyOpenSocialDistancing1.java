package com.company;

/*
ID: gra.luo1
LANG: JAVA
TASK:
EMAIL: gra.luo0122@gmail.com
*/

//DOES NOT WORK
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cow2020CopyOpenSocialDistancing1 {
    public static void socialDistancing() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("socdist1.in"));
        int numCows = Integer.parseInt(input.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
        String token = stringTokenizer.nextToken();

        int[] cowStalls = new int[numCows];
        for(int i = 0; i < numCows; i++){

            cowStalls[i] = (int)(token.charAt(i)) - 48;
        }

        boolean firstCow = false;
        boolean lastCow = false;

        if(cowStalls[0] == 1) firstCow = true;
        if(cowStalls[numCows - 1] == 1) lastCow = true;

        ArrayList<Integer> sets = new ArrayList<>();
        boolean set = false;
        int numInSet = 0;
        for(int i = 0; i < numCows; i++){
            if(cowStalls[i] == 0){
                if(!set){
                    set = true;
                }
                numInSet++;
            }
            else{
                if(set){
                    sets.add(numInSet);
                }
                set = false;
                numInSet = 0;
            }
        }

        if(sets.size() == 0){
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
            out.println((numInSet + 1)/3);
            out.close();
            input.close();
            return;
        }
        int first = 0;
        int last = 0;
        if(!firstCow){
            first = sets.get(0);

            sets.remove(0);
        }
        if(!lastCow){
            last = numInSet;
        }

        if(sets.size() == 0){
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
            int largestMin = Math.max(first,last);
            out.println((largestMin - 1)/2 + 1);
            out.close();
            input.close();
            return;
        }

        if(sets.size() == 1){
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
            ArrayList<Integer> twoLargest = new ArrayList<>();
            twoLargest.add(sets.get(0));

            ArrayList<Integer> diffSets = new ArrayList<>();
            ArrayList<Integer> sameSet = new ArrayList<>();

            diffSets.add((twoLargest.get(0) - 1)/2 + 1);
            diffSets.add(first);
            diffSets.add(last);

            sameSet.add((twoLargest.get(0) + 1)/3);
            sameSet.add((first - 1)/2 + 1);
            sameSet.add((last - 1)/2 + 1);

            ArrayList<Integer> diffTwo = findTwoLargest(diffSets);
            ArrayList<Integer> sameTwo = findTwoLargest(sameSet);

            int largestMin = diffTwo.get(1);
            if(sameTwo.get(1) > largestMin) largestMin = sameTwo.get(1);

            out.println((largestMin - 1)/2 + 1);
            out.close();
            input.close();
            return;
        }

        ArrayList<Integer> twoLargest = findTwoLargest(sets);

        ArrayList<Integer> diffSets = new ArrayList<>();
        ArrayList<Integer> sameSet = new ArrayList<>();

        diffSets.add((twoLargest.get(0) - 1)/2 + 1);
        diffSets.add((twoLargest.get(1) - 1)/2 + 1);
        diffSets.add(first);
        diffSets.add(last);

        sameSet.add((twoLargest.get(1) + 1)/3);
        sameSet.add((twoLargest.get(1) + 1)/3);
        sameSet.add((first - 1)/2 + 1);
        sameSet.add((last - 1)/2 + 1);

        ArrayList<Integer> diffTwo = findTwoLargest(diffSets);
        ArrayList<Integer> sameTwo = findTwoLargest(sameSet);

        int largestMin = diffTwo.get(1);
        if(sameTwo.get(1) > largestMin) largestMin = sameTwo.get(1);


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
        out.println(largestMin);
        out.close();
        input.close();
    }

    private static ArrayList<Integer> findTwoLargest(ArrayList<Integer> sets){
        ArrayList<Integer> twoLargest = new ArrayList<>();

        int maxIndex = 0;
        for(int i = 0; i < sets.size(); i++){
            if(sets.get(i) > sets.get(maxIndex)){
                maxIndex = i;
            }
        }
        twoLargest.add(sets.get(maxIndex));
        sets.remove(maxIndex);
        int secondMaxIndex = 0;
        for(int i = 0; i < sets.size(); i++){
            if(sets.get(i) > sets.get(secondMaxIndex)){
                secondMaxIndex = i;
            }
        }
        twoLargest.add(sets.get(secondMaxIndex));

        return twoLargest;
    }
}



//BufferedReader input = new BufferedReader(new FileReader("socdist1.in"));
//
//        int numCows = Integer.parseInt(input.readLine());
//        int[] cowStalls = new int[numCows];
//        StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
//
//        for(int i = 0; i < numCows; i++){
//            cowStalls[i] = Integer.parseInt(stringTokenizer.nextToken());
//        }
//
//        int minDist = 0;
//        int firstIndex = 0;
//        int lastIndex = 0;
//
//        for ()









//        ArrayList<Integer> diffSets = new ArrayList<>();
//        ArrayList<Integer> sameSet = new ArrayList<>();
//
//        for(int i = 0; i < sets.size(); i++){
//            diffSets.add((sets.get(i)-1)/2 + 1);
//        }
//
//        for(int i = 0; i < sets.size(); i++){
//            sameSet.add((sets.get(i)-1)/2 + 1);
//        }












//        int first = -1;
//        int last = -1;
//        ArrayList<Integer> fourLargest = new ArrayList<>();
//
//        int x = 0;
//        int y = sets.size() - 1;
//        if(!firstCow) {
//            first = sets.get(0);
//            x = 1;
//        }
//        if(!lastCow){
//            last = sets.get(sets.size()-1);
//            y = sets.size() - 2;
//        }
//        int maxIndex = 0;
//        for(int i = x; i < y; i++){
//            if(sets.get(i) > sets.get(maxIndex)){
//                maxIndex = i;
//            }
//        }
//        fourLargest.add(sets.get(maxIndex));
//        sets.remove(maxIndex);
//        int secondMaxIndex = 0;
//        for(int i = x; i < y - 1; i++){
//            if(sets.get(i) > sets.get(secondMaxIndex)){
//                secondMaxIndex = i;
//            }
//        }
//        fourLargest.add(sets.get(secondMaxIndex));
//        fourLargest.add(first);
//        fourLargest.add(last);
//
//        int index = 0;
//        for(int i = 0; i < 4; i++){
//            if(fourLargest.get(i) > fourLargest.get(index)){
//                index = i;
//            }
//        }
//        ArrayList<Integer> twoLargest = new ArrayList<>();
//        twoLargest.add(fourLargest.get(index));
//
//        int secondIndex = 0;
//        for(int i = 0; i < 4; i++){
//            if(fourLargest.get(i) > fourLargest.get(secondIndex)){
//                secondIndex = i;
//            }
//        }
//        twoLargest.add(fourLargest.get(secondIndex));
//
//        return twoLargest;
