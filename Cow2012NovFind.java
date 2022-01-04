package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cow2012NovFind {
    public static void find() throws Exception{
        Scanner stdin = new Scanner(new File("cowfind.in"));
        ArrayList<Integer> hindIndices = new ArrayList<Integer>();
        ArrayList<Integer> frontIndices = new ArrayList<Integer>();
        String grass = stdin.next();
        int numPossible = 0;
        for(int i = 0; i < grass.length()-1; i++){
            if(grass.substring(i,i+2).equals("((")) {
                hindIndices.add(i);
                hindIndices.add(i + 1);
            }
            else if(grass.substring(i,i+2).equals("))")){
                frontIndices.add(i);
                frontIndices.add(i);
            }
        }
        for(int i = 0; i < hindIndices.size()-1; i=i+2){
            for(int j = 0; j < frontIndices.size()-1; j=j+2){
                if(hindIndices.get(i+1) < frontIndices.get(j))
                    numPossible++;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("cowfind.out"));
        out.println(numPossible);
        out.close();
        stdin.close();
    }
}
