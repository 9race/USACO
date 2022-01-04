package com.company;

import com.sun.tools.corba.se.idl.StringGen;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Cow2019DecWhereAmI {
    public static void whereAmI() throws Exception{
        Scanner input = new Scanner(new File("whereami.in"));

        //String s
        //loop thru s.length() times
            //check if substring is valid

        int roadLength = input.nextInt();
        String road = input.next();
        int length = 0;

        for(int i = 1; i <= road.length(); i++){
            if(isValid(i, road)){
                length = i;
                break;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("whereami.out"));
        out.println(length);
        out.close();
        input.close();
    }

    public static boolean isValid(int length, String s){
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 0; i < s.length()-length+1; i++){
            if(strings.contains(s.substring(i, i+length)))
                return false;
            else strings.add(s.substring(i,i+length));
        }
        return true;
    }
}
