package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2011DecEscape {
    public static void cowEscape() throws Exception {

        Scanner input = new Scanner(new File("escape.in"));
        int numWeights = input.nextInt();
        int[] data = new int[numWeights];
        for(int i = 0; i < numWeights; i++){
            data[i] = input.nextInt();
        }
        int largestSize = 0;
        boolean hasCarries = false;
        for(int i = 26; i < Math.pow(2, numWeights); i++){
            int sum = 0;
            int size = 0;
            int lastBit = -1;
            for(int bit = 0; bit < numWeights; bit++){
                lastBit = i >> bit;
                lastBit = lastBit % 2;
                if(lastBit != 0) {
                    if(checkCarries(data[data.length-1-bit], sum)) {
                        sum += data[data.length-1-bit];
                        size++;
                    }
                    else hasCarries = true;
                }
            }
            if(!hasCarries && size > largestSize){
                largestSize = size;
                hasCarries = false;
            }
        }

        // Ta da!
        PrintWriter out = new PrintWriter(new FileWriter("escape.out"));
        out.println(largestSize);
        out.close();
        input.close();
    }
    public static boolean checkCarries(int num, int sum){
        int digits = 0;
        int numDigits = 0;
        int sumDigits = 0;
        int n = num;
        int s = sum;
        while(n > 0){
            n /= 10;
            numDigits++;
        }
        while(s > 0){
            s /= 10;
            sumDigits++;
        }
        if(numDigits > sumDigits)
            digits = numDigits;
        else digits = sumDigits;
        for(int i = 0; i < digits; i++) {
            if (!((num % 10 + sum % 10) < 10)) {
                return false;
            }
            num /= 10;
            sum /= 10;
        }
        return true;
    }
}
