package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cow2020CopyFebTriangles {
    public static void triangles() throws Exception {
        Scanner input = new Scanner(new File("triangles.in"));
        int numCoordinates = input.nextInt();
        int[][] coordinates = new int[numCoordinates][2];

        for(int i = 0; i < numCoordinates; i++){
            for(int j = 0; j < 2; j++){
                coordinates[i][j] = input.nextInt();
            }
        }

        int maxArea = 0;

        for(int first = 0; first < numCoordinates; first++){
            for(int second = first+1; second < numCoordinates; second++){
                for(int third = second+1; third < numCoordinates; third++){
                    int[] one = coordinates[first];
                    int[] two = coordinates[second];
                    int[] three = coordinates[third];

                    if(isValid(one, two, three)){
                        int area = findArea(one, two, three);
                        if(area > maxArea)
                            maxArea = area;
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("triangles.out"));
        out.println(maxArea);
        out.close();
        input.close();
    }

    public static boolean isValid(int[] one, int[] two, int[] three) {
        if((one[0] == two[0] && one[1] == three[1]) || (one[1] == two[1] && one[0] == three[0]))
            return true;
        else if((two[0] == one[0] && two[1] == three[1]) || (one[1] == two[1] && two[0] == three[0]))
            return true;
        else if((three[0] == one[0] && two[1] == three[1]) || (one[1] == three[1] && two[0] == three[0]))
            return true;
        else return false;
    }

    public static int findArea(int[] one, int[] two, int[] three) {
        int area = 0;
        if ((one[0] == two[0] && one[1] == three[1]) || (one[1] == two[1] && one[0] == three[0])){
            if((one[0] == two[0] && one[1] == three[1]))
                area = Math.abs((two[1] - one[1])) * Math.abs((three[0] - one[0]));
            else area = Math.abs((two[0] - one[0])) * Math.abs((three[1] - one[1]));
        }
        else if((two[0] == one[0] && two[1] == three[1]) || (one[1] == two[1] && two[0] == three[0])) {
            if ((two[0] == one[0] && two[1] == three[1]))
                area = Math.abs((two[1] - one[1])) * Math.abs((three[0] - two[0]));
            else area = Math.abs((two[0] - one[0])) * Math.abs((three[1] - two[1]));
        }
        else {
            if(three[0] == one[0] && two[1] == three[1])
                area = Math.abs((three[1] - one[1])) * Math.abs((three[0] - two[0]));
            else area = Math.abs((three[0] - one[0])) * Math.abs((three[1] - two[1]));
        }
        return area;
    }
}

//array[][] coordinates
//loop thru
