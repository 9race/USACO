package com.company;

import sun.tools.tree.ArrayAccessExpression;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Cow2017FebCrossRoad2 {
    public static void cowsCrossRoad2() throws Exception{
        Scanner input = new Scanner(new File("circlecross.in"));

        Stack<Character> cows = new Stack<Character>();

        String s = input.next();

        cows.push(s.charAt(0));
        for(int i = 1; i < 52; i++){
            if(!cows.isEmpty() && cows.peek()== s.charAt(i))
                cows.pop();
            else cows.push(s.charAt(i));
        }

        ArrayList<Character> crossingCows = new ArrayList(cows);

        int numCrossPairs = 0;

        while(crossingCows.size() > 0){
            int[] indices1 = findIndices(crossingCows.get(0), crossingCows);
            for(int i = indices1[0]+1; i < indices1[1]; i++){
                int[] indices2 = findIndices(crossingCows.get(i), crossingCows);
                if((indices1[0] < indices2[0] && indices1[1] < indices2[1]) || (indices1[0] > indices2[0] && indices1[1] > indices2[1])){
                    numCrossPairs++;
                }
            }
            crossingCows.remove(indices1[1]);
            crossingCows.remove(indices1[0]);
        }

//        for(int i = 0; i < crossingCows.size(); i++){
//            int[] indices1 = findIndices(crossingCows[i], crossingCows);
//            for (int j = indices1[0]+1; j < indices1[1]; j++){
//                int[] indices2 = findIndices(crossingCows[j], crossingCows);
//                if((indices1[0] < indices2[0] && indices1[1] < indices2[1]) || (indices1[0] > indices2[0] && indices1[1] > indices2[1])){
//                    numCrossPairs++;
//                }
//            }
//        }

        PrintWriter out = new PrintWriter(new FileWriter("circlecross.out"));
        out.println(numCrossPairs);
        out.close();
        input.close();


        //create new stack
        //stack.push("A")
        //loop thru 52
            //if peek == nextChar
                //pop
            //else push
        //stack.ToArray();
        //int crossPairs
        //loop thru arr
            //loop thru i+1
                //int[] indices1 = findIndices(i)
                //int[] indices2 = findIndices(j)
                    //if((indices1[0] < indices2[0] && indices1[1] < indices2[1]) || (indices1[0] > indices2[0] && indices1[1] > indices2[1]))
                        //crossPairs++;
    }

    public static int[] findIndices(Object val, ArrayList<Character> arrList){
        int[] indices = new int[2];
        int index = 0;
        for(int i = 0; i < arrList.size(); i++){
            if(arrList.get(i).equals(val)){
                indices[index] = i;
                index++;
            }
        }
        return indices;
    }
}

//Testing Cases:
    //none cross
    //mirror
    //everything cross