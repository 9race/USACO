package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cow2019DecLineup {
    private static ArrayList<String> cowPermutations = new ArrayList<>();
    private static String[][] allPairs = new String[0][2];
    private static ArrayList<String> stringPairs = new ArrayList<>();

    public static void lineup() throws Exception{
        Scanner input = new Scanner(new File("lineup.in"));

        //arraylist[]
        //add the pairs
        //String[]
        //loop thru alphabetical order
            //if has one other
                //put it after
            //if it has none
                //put it n
            //if has two
                    //loop thru other two
                        //put in order

        // Beatrice,Belinda,Bella,Bessie,Betsy,Blue,Buttercup,Sue

        String[] cows = {"Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
        int numPairs = input.nextInt();
        String[][] pairs = new String[numPairs][2];

        for(int i = 0; i < numPairs; i++){
            pairs[i][0] = input.next();
            input.next();
            input.next();
            input.next();
            input.next();
            pairs[i][1] = input.next();
        }

        allPairs = pairs;

        printAllRecursive(8, cows, ',');

        ArrayList<String> concatenatedPairs = new ArrayList<>();

        for(int i = 0; i < allPairs.length; i++){
            concatenatedPairs.add(allPairs[i][0] + "," + allPairs[i][1]);
            concatenatedPairs.add(allPairs[i][1] + "," + allPairs[i][0]);
        }

        stringPairs = concatenatedPairs;

        String lineup = valid();

        PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
        String temp = "";
        for(int i = 0; i < lineup.length(); i++){
            if(lineup.charAt(i) != ',')
                temp += lineup.charAt(i);
            else{
                out.println(temp);
                temp = "";
            }
        }

        out.close();
        input.close();

//        int numPairs = input.nextInt();
//        ArrayList<String>[] cowPairs = new ArrayList[8];
//
//        for(int i = 0; i < 8; i++){
//            cowPairs[i] = new ArrayList<>();
//        }
//
//        for(int i = 0; i < numPairs; i++) {
//            String first = input.next();
//            input.next();
//            input.next();
//            input.next();
//            input.next();
//            String second = input.next();
//
//            if (first.compareTo(second) > 0) {
//                String s = second;
//                second = first;
//                first = s;
//            }
//
//        }
    }

    public static String valid(){
        String lineup = "z";
        for(int i = 0; i < cowPermutations.size(); i++){
            int temp = 1;
            for(int j = 0; j < stringPairs.size(); j = j+2){
                boolean match1 = cowPermutations.get(i).contains(stringPairs.get(j));
                boolean match2 = cowPermutations.get(i).contains(stringPairs.get(j+1));
                if(!(match1) && !(match2)) {
                    temp = -1;
                    break;
                }
            }
            if (temp > 0) {
                if(cowPermutations.get(i).compareTo(lineup) < 0)
                    lineup = cowPermutations.get(i);
            }
        }
        return lineup;
    }

//    public static int findIndex(int startingIndex, String string){
//        for(int i = 0; i < 7; i++){
//            if(cowPermutations.get(startingIndex+i).equals(string)){
//                return startingIndex+i;
//            }
//        }
//        return -1;
//    }

    public static void printAllRecursive(
            int n, java.lang.String[] elements, char delimiter) {

        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }
    public static void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    public static void printArray(String[] input) {
        System.out.print('\n');
        String permutation = "";
        for(int i = 0; i < input.length; i++) {
            String tempString = input[i] + ",";
            System.out.print(tempString);
            permutation += tempString;
        }
        cowPermutations.add(permutation);
    }
}

//if(first.equals("Beatrice")){
//        cowPairs[0].add(second);
//        }
//
//        else if(first.equals("Belinda")){
//        cowPairs[1].add(second);
//        }
//
//        else if(first.equals("Bella")){
//        cowPairs[2].add(second);
//        }
//
//        else if(first.equals("Bessie")){
//        cowPairs[3].add(second);
//        }
//
//        else if(first.equals("Betsy")){
//        cowPairs[4].add(second);
//        }
//
//        else if(first.equals("Blue")){
//        cowPairs[5].add(second);
//        }
//
//        else if(first.equals("Buttercup")){
//        cowPairs[6].add(second);
//        }
//
//        else if(first.equals("Sue")){
//        cowPairs[7].add(second);
//        }
//        }
//
//        ArrayList<String> origLineup = new ArrayList<String>(Arrays.asList("Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"));
//        ArrayList<String> lineup = new ArrayList<String>(Arrays.asList("Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"));
//
//        for(int i = 0; i < 8; i++){
//        if(cowPairs[i].size() == 0){
//        }
//        else if(cowPairs[i].size() == 1){
//        int index = findIndex(lineup, cowPairs[i].get(0));
//        lineup.remove(index);
//        if(i+1 >= lineup.size())
//        lineup.add(cowPairs[i].get(0));
//        else{
//        int otherIndex = findIndex(lineup,origLineup.get(i));
//        lineup.add(otherIndex+1, cowPairs[i].get(0));
//        }
//
//        }
//        else{
//        String first = cowPairs[i].get(0);
//        String second = cowPairs[i].get(1);
//        String orig = origLineup.get(i);
//        if(first.compareTo(second) > 0){
//        String s = second;
//        second = first;
//        first = s;
//        }
//        int index = findIndex(lineup, orig);
//        lineup.remove(index);
//        lineup.remove(findIndex(lineup, first));
//
//
//        lineup.add(findIndex(lineup,second), first);
//        lineup.add(findIndex(lineup,second),orig);
//        }
//        }
//
//        PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
//        for(int i = 0; i < 8; i++){
//        out.println(lineup.get(i));
//        }
//        out.close();
//        input.close();
//        }
//
//public static int findIndex(ArrayList<String> origLineup, String s){
//        for (int i = 0; i < origLineup.size(); i++){
//        if(origLineup.get(i).equals(s))
//        return i;
//        }
//        return -1;
//        }























/*
for(int i = 0; i < numPairs; i++){
        String first = input.next();
        input.next();
        input.next();
        input.next();
        input.next();
        String second = input.next();

        if(first.equals("Beatrice")){
        cowPairs[0].add(second);
        }

        else if(first.equals("Belinda")){
        cowPairs[1].add(second);
        }

        else if(first.equals("Bella")){
        cowPairs[2].add(second);
        }

        else if(first.equals("Bessie")){
        cowPairs[3].add(second);
        }

        else if(first.equals("Betsy")){
        cowPairs[4].add(second);
        }

        else if(first.equals("Blue")){
        cowPairs[5].add(second);
        }

        else if(first.equals("Buttercup")){
        cowPairs[6].add(second);
        }

        else if(first.equals("Sue")){
        cowPairs[7].add(second);
        }


        if(second.equals("Beatrice")){
        cowPairs[0].add(first);
        }

        else if(second.equals("Belinda")){
        cowPairs[1].add(first);
        }

        else if(second.equals("Bella")){
        cowPairs[2].add(first);
        }

        else if(second.equals("Bessie")){
        cowPairs[3].add(first);
        }

        else if(second.equals("Betsy")){
        cowPairs[4].add(first);
        }

        else if(second.equals("Blue")){
        cowPairs[5].add(first);
        }

        else if(second.equals("Buttercup")){
        cowPairs[6].add(first);
        }

        else if(second.equals("Sue")){
        cowPairs[7].add(first);
        }
        }*/
