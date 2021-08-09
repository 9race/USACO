package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Cow2012NovTypo {
    public static void typo() throws Exception{
        Scanner stdin = new Scanner(new File("typo.in"));
        String s = stdin.next();

        int numOpen = 0;
        int numClosed = 0;

        String[] original = new String[s.length()];
        for (int i = 0; i < s.length(); i++){
            if(s.substring(i,i+1).equals("("))
                numOpen++;
            else numClosed++;
            original[i] = s.substring(i,i+1);
        }

        int possibleChanges = 0;
        ArrayList<String> temps = new ArrayList<String>();
        Stack<String> temp = new Stack<String>();
        if(numOpen > numClosed){
            for(int i = 0; i < s.length(); i++){
                if(original[i].equals("(")) {
                    String[] originalCopy = original.clone();
                    originalCopy[i] = ")";
                    if(isBalanced(originalCopy))
                        possibleChanges++;
                }
            }
        }
        else if(numClosed > numOpen){
            for(int i = 0; i < s.length(); i++){
                if(original[i].equals(")")) {
                    String[] originalCopy = original.clone();
                    originalCopy[i] = "(";
                    if(isBalanced(originalCopy))
                        possibleChanges++;
                }
            }
        }

        else if(numOpen == numClosed && isBalanced(original))
            possibleChanges = 0;


        PrintWriter out = new PrintWriter(new FileWriter("typo.out"));
        out.println(possibleChanges);
        out.close();
        stdin.close();
    }

    public static boolean isBalanced(String[] arr){
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("("))
                stack.push("(");
            else {
                if (stack.isEmpty())
                    return false;
                else stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;
    }
}
