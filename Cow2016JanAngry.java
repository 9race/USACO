package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Cow2016JanAngry {
    public static void angryCows() throws Exception{
        Scanner positions = new Scanner(new File("angry.in"));

        int numHayBales = positions.nextInt();
        int[] balesPositions = new int[numHayBales];
        for(int i = 0; i < numHayBales; i++){
            balesPositions[i] = positions.nextInt();
        }
        Arrays.sort(balesPositions);

        int maxExpo = 0;
        for(int i = 0; i < numHayBales; i++){
            int nextExpos = nextExplosions(i, balesPositions);
            int prevExpos =  prevExplosions(i, balesPositions);
            int totalExpo = nextExpos + prevExpos + 1;
            if(totalExpo > maxExpo)
                maxExpo = totalExpo;
        }
        PrintWriter out = new PrintWriter(new FileWriter("angry.out"));
        out.println(maxExpo);
        out.close();
        positions.close();
    }

    public static int nextExplosions(int index, int[] arr){
        int radius = 1;
        int origIndex = index;
        index = getNextExpo(index, radius, arr);
        if (index == origIndex) return 0;
        int preIndex = -1;

        while (index < arr.length -1 && index >= 0 && preIndex != index) {
            radius++;
            preIndex = index;
            index = getNextExpo(index, radius, arr);
        }
        return index - origIndex;
    }

    public static int getNextExpo(int index, int radius, int[] arr){
        int origIndex = index;
        while(index < arr.length - 1 && arr[index+1] <= radius+arr[origIndex]){
            index++;
        }
        return index;
    }

    public static int prevExplosions(int index, int[] arr){
        int radius = 1;
        int origIndex = index;
        index = getPrevExpo(index, radius, arr);
        if (index == origIndex) return 0;
        int preIndex = -1;

        while (index > 0 && index >= 0 && preIndex != index) {
            radius++;
            preIndex = index;
            index = getPrevExpo(index, radius, arr);
        }
        return origIndex - index;
    }

    public static int getPrevExpo(int index, int radius, int[] arr){
        int origIndex = index;
        while(index > 0 && arr[index-1] >= arr[origIndex] - radius){
            index--;
        }
        return index;
    }
}
