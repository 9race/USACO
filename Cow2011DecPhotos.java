package com.company;
import java.util.*;
import java.io.*;

public class Cow2011DecPhotos {
    public static void cowPhoto() throws Exception {
        ArrayList<Integer> cows = new ArrayList<Integer>();
        Scanner positions = new Scanner(new File("photo.in"));
        int numCows = positions.nextInt();
        for(int i = 0; i < numCows; i++){
            cows.add(positions.nextInt());
        }
        int[] firstPhoto = new int[numCows];
        int[] secondPhoto = new int[numCows];
        int[] thirdPhoto = new int[numCows];
        int[] fourthPhoto = new int[numCows];
        int[] fifthPhoto = new int[numCows];
        int[][] photos = {firstPhoto, secondPhoto, thirdPhoto, fourthPhoto, fifthPhoto};
        Scanner stdin = new Scanner(new File("photo.in"));
        stdin.nextInt();
        for(int numPhoto = 0; numPhoto < 5; numPhoto++){
            for(int cowPosition = 0; cowPosition < numCows; cowPosition++){
                photos[numPhoto][cowPosition] = stdin.nextInt();
            }
        }
        Collections.sort(cows, new Comparator<Integer>() {
            @Override
            public int compare(Integer c1, Integer c2) {
                int firstCounter = 0;
                int secondCounter = 0;
                for(int photo = 0; photo < 5; photo++){
                    if(findIndex(c1, photos[photo]) > findIndex(c2, photos[photo])){
                        firstCounter++;
                    }
                    else secondCounter++;
                }
                if(firstCounter >= 3)
                    return 1;
                else if(secondCounter >= 3) return -1;
                return 0;
            }
        });
        PrintWriter out = new PrintWriter(new FileWriter("photo.out"));
        out.println(cows);
        out.close();
        stdin.close();
    }

    public static int findIndex(int val, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
}
