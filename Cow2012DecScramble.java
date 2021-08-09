package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Cow2012DecScramble {
    public static void scramble() throws Exception {
        Scanner stdin = new Scanner(new File("scramble.in"));

        int numCows = stdin.nextInt();
        String[] cowNames = new String[numCows];
        String[] alphabetizedNames = new String[numCows];
        String[] reversedNames = new String[numCows];
        for(int i = 0; i < numCows; i++){
            cowNames[i] = stdin.next();
            alphabetizedNames[i] = alphabetizeString(cowNames[i]);
            reversedNames[i] = reverseAlphabetizeString(cowNames[i]);
        }
        alphabetizedNames = alphabetizeArr(alphabetizedNames);
        reversedNames = alphabetizeArr(reversedNames);
        int[] minIndices = new int[numCows];
        int[] maxIndices = new int[numCows];
        for(int i = 0; i < numCows; i++){
            minIndices[i] = compareSmallToLarges(alphabetizeString(cowNames[i]), reversedNames);
        }
        for(int i = 0; i < numCows; i++){
            maxIndices[i] = compareLargeToSmalls(reverseAlphabetizeString(cowNames[i]), alphabetizedNames);
        }
//        for(int numCow = 0; numCow < numCows; numCow++){
//            for(int alphabetical = 0; alphabetical < 2; alphabetical++){
//                if(alphabetical==0)
//                    results[numCow][alphabetical] = getNewIndex(cowNames[numCow],alphabetizedNames,true) + 1;
//                else results[numCow][alphabetical] = getNewIndex(cowNames[numCow], reversedNames, false) + 1;
//            }
//        }

        PrintWriter out = new PrintWriter(new FileWriter("scramble.out"));
        for(int i = 0; i < numCows; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0)
                    out.print(minIndices[i] + " ");
                else out.println(maxIndices[i]);
            }
        }
        out.close();
        stdin.close();
    }

    public static String alphabetizeString(String str){
        char[] alphabetical = str.toCharArray();
        Arrays.sort(alphabetical);
        return new String(alphabetical);
    }

    public static String reverseAlphabetizeString(String str){
        String a = alphabetizeString(str);
        String reverse = "";
        for(int i = str.length()-1; i >= 0; i--){
            reverse += a.substring(i,i+1);
        }
        return reverse;
    }

    public static String[] alphabetizeArr(String[] arr){
        List<String> list = Arrays.asList(arr);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String[] arr2 = new String[list.size()];
        list.toArray(arr2);
        return arr2;
    }

    public static String[] reverseAlphabetizeArr(String[] arr){
        String[] a = alphabetizeArr(arr);
        String[] result = new String[arr.length];
        int spot = 0;
        for(int i = a.length-1; i >= 0; i--){
            result[spot] = a[i];
            spot++;
        }
        return result;
    }

    public static int compareSmallToLarges(String str, String[] arr){
        int numBefore = 0;
        for(int i = 0; i < arr.length; i++){
            if(str.compareTo(arr[i]) > 0)
                numBefore++;
        }
        return numBefore+1;
    }

    public static int compareLargeToSmalls(String str, String[] arr){
        int numAfter = arr.length;
        for(int i = 0; i < arr.length; i++){
            if(str.compareTo(arr[i]) < 0)
                numAfter--;
        }
        return numAfter;
    }



    //        String[] highestLetters = new String[numCows];
//        String[] lowestLetters = new String[numCows];
//        for(int i = 0; i < numCows; i++){
//            highestLetters[i] = highestLetter(cowNames[i]);
//            lowestLetters[i] = lowestLetter(cowNames[i]);
//        }
//        String firstLetter = highestLetters[0];
//        int firstIndex = 0;
//        int lastIndex = 0;
//        String lastLetter = lowestLetters[0];
//        for(int i = 1; i < numCows; i++){
//            if(highestLetters[i].compareTo(firstLetter) > 0) {
//                firstLetter = highestLetters[i];
//                firstIndex = i;
//            }
//        }
//        for(int i = 1; i < numCows; i++){
//            if(lowestLetters[i].compareTo(lastLetter) < 0) {
//                lastIndex = i;
//                lastLetter = lowestLetters[i];
//            }
//        }
//    public static String highestLetter(String str){
//        String max = str.substring(0,1);
//        for(int i = 1; i < str.length(); i++){
//            if(str.substring(i,i+1).compareTo(max) > 0)
//                max = str.substring(i,i+1);
//        }
//        return max;
//    }
//    public static String lowestLetter(String str){
//        String min = str.substring(0,1);
//        for(int i = 1; i < str.length(); i++){
//            if(str.substring(i,i+1).compareTo(min) < 0)
//                min = str.substring(i,i+1);
//        }
//        return min;
//    }

//    public static int getNewIndex(String str, String[] arr, boolean alphabetize){
//        for(int i = 0; i < arr.length; i++){
//            if (alphabetize) {
//                if(alphabetizeString(str).equals(arr[i]))
//                    return i;
//            }
//            else{
//             if(reverseAlphabetizeString(str).equals(arr[i]))
//                return i;
//            }
//        }
//        return -1;
//    }

    //        for(int i = 0; i < arr.length; i++){
//            String currentString = arr[i];
//            int j;
//            for(j = i - 1; j >= 0 && arr[j].compareTo(currentString) > 0; j--){
//                arr[j+1] = arr[j];
//            }
//            arr[j+1] = currentString;
//        }
//        return arr;
}
