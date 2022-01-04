package com.company;

/*
ID: graceluo
LANG: JAVA
TASK: BronzeRut
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dec2020Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        int numberOfCows = Integer.parseInt(s);
        ArrayList<String> directions = new ArrayList<String>();
        ArrayList<int[]> cords1 = new ArrayList<int[]>();
        ArrayList<int[]> cords2 = new ArrayList<int[]>();
        ArrayList<Boolean> stucks = new ArrayList<Boolean>();


        for (int i = 0; i < numberOfCows; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
            String direction = stringTokenizer.nextToken();
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            directions.add(direction);
            cords1.add(new int[]{x, y});
            cords2.add(new int[]{x, y});
            stucks.add(false);
        }


        while (true) {
            ArrayList<int[]> tempCords = new ArrayList<int[]>();
            int smallestPace = 1; //findSmallestPace(cords1, cords2, stucks, directions);
            for (int i = 0; i < cords1.size(); i++) {
                int x1 = cords1.get(i)[0];
                int y1 = cords1.get(i)[1];
                int x2 = cords2.get(i)[0];
                int y2 = cords2.get(i)[1];
                if (directions.get(i).equals("E")) {
                    if (stucks.get(i)) {
                        tempCords.add(new int[]{x2, y2});
                    }
                    else {
                        if (isEaten(x2 + smallestPace, y2, cords1, cords2)) {
                            stucks.set(i, true);
                        }
                        tempCords.add(new int[] {x2 + smallestPace, y2});
                    }
                }

                if (directions.get(i).equals("N")) {
                    if (stucks.get(i)) {
                        tempCords.add(new int[] {x2, y2});
                    }
                    else {
                        if (isEaten(x2, y2 + smallestPace, cords1, cords2)) {
                            stucks.set(i, true);
                        }
                        tempCords.add(new int[]{x2, y2 + smallestPace});
                    }
                }
            }

            for (int i = 0; i < cords1.size(); i++) {
                int x2 = tempCords.get(i)[0];
                int y2 = tempCords.get(i)[1];

                cords2.set(i, new int[]{x2,y2});
            }
            if (noMoreIntersect(cords1, cords2, stucks, directions)) break;
        }

        for (int i = 0; i < stucks.size(); i++) {
            if (stucks.get(i)) {
                int x1 = cords1.get(i)[0];
                int y1 = cords1.get(i)[1];
                int x2 = cords2.get(i)[0];
                int y2 = cords2.get(i)[1];
                System.out.println(x2-x1+y2-y1);
            }
            else {
                System.out.println("Infinity");
            }
        }
    }

    public static Boolean isEaten(int x, int y, ArrayList<int[]> cords1, ArrayList<int[]> cords2) {
        for (int i = 0; i < cords1.size(); i++) {
            int x1 = cords1.get(i)[0];
            int y1 = cords1.get(i)[1];
            int x2 = cords2.get(i)[0];
            int y2 = cords2.get(i)[1];
            if (x>=x1 && x<=x2 && y>=y1 && y<=y2) {
                return true;
            }
        }

        return false;
    }



    public static Boolean noMoreIntersect(ArrayList<int[]> coords1, ArrayList<int[]> coords2, ArrayList<Boolean> stucks, ArrayList<String> directions) {
        for (int i = 0; i < coords1.size(); i++) {
            int ix1 = coords1.get(i)[0];
            int iy1 = coords1.get(i)[1];
            int ix2 = coords2.get(i)[0];
            int iy2 = coords2.get(i)[1];
            if (!stucks.get(i)) {
                for (int j = 0; j < coords1.size(); j++) {
                    int jx1 = coords1.get(j)[0];
                    int jy1 = coords1.get(j)[1];
                    int jx2 = coords2.get(j)[0];
                    int jy2 = coords2.get(j)[1];
                    if (directions.get(i).equals("E")) {
                        if (directions.get(j).equals("N")) {
                            if (iy1 > jy1 && ix2 < jx2) return false;
                        }
                    }

                    if (directions.get(i).equals("N")) {
                        if (directions.get(j).equals("E")) {
                            if (ix1 > jx1 && iy2 < jy2) return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static int findSmallestPace(ArrayList<int[]> coords1, ArrayList<int[]> coords2, ArrayList<Boolean> stucks, ArrayList<String> directions) {
        int smallestPace = 2147483647;
        for(int i = 0; i < coords1.size(); i++){
            int ix2 = coords2.get(i)[0];
            int iy2 = coords2.get(i)[1];
            if (!stucks.get(i)) {
                for (int j = 0; j < coords1.size(); j++) {
                    int jx2 = coords1.get(j)[0];
                    int jy2 = coords2.get(j)[1];
                    if (!stucks.get(j)) {
                        if (directions.get(i).equals("E")) {
                            if (directions.get(j).equals("N")) {
                                int distanceX = Math.abs(ix2 - jx2);
                                int distanceY = Math.abs(iy2 - jy2);
                                int smaller = Integer.min(distanceX, distanceY);
//                                if (intersect(coords1, coords2, i, j)) {
//                                    smaller = 1;
//                                    //smallestPace = Integer.min(smaller, smallestPace);
//                                }
                                if (findBlocker(coords1, coords2, ix2, iy2, jx2, jy2)) smaller = 1;
                                smallestPace = Integer.min(smaller, smallestPace);
                            }
                        }
                        if (directions.get(i).equals("N")) {
                            if (directions.get(j).equals("E")) {
                                int distanceX = Math.abs(ix2 - jx2);
                                int distanceY = Math.abs(iy2 - jy2);
                                int smaller = Integer.min(distanceX, distanceY);
//                                if (intersect(coords1, coords2, j, i)) {
//                                    smaller = 1;
//                                    //smallestPace = Integer.min(smaller, smallestPace);
//                                }
                                if (findBlocker(coords1, coords2, ix2, iy2, jx2, jy2)) smaller = 1;
                                smallestPace = Integer.min(smaller, smallestPace);
                            }
                        }
                    }
                }
            }
        }

        if (smallestPace == 2147483647 || smallestPace  == 0)
            smallestPace = 1;
        //if (smallestPace > 10000) smallestPace /= 2;
        return smallestPace;
    }

    public static boolean intersect(ArrayList<int[]> coords1, ArrayList<int[]> coords2, int index1, int index2){
        int ix1 = coords1.get(index1)[0];
        int iy1 = coords1.get(index1)[1];
        int jx1 = coords1.get(index2)[0];
        int jy1 = coords1.get(index2)[1];
        int intersectX = jx1;
        int intersectY = iy1;

        for(int i = 0; i < coords1.size(); i++) {
            int ax1 = coords1.get(i)[0];
            int ay1 = coords1.get(i)[1];
            int ax2 = coords2.get(i)[0];
            int ay2 = coords2.get(i)[1];
            if((ix1 <= ax1 && intersectX >= ax1 && ay1 <= iy1 && ay2 >= iy1) || (ax1 <= jx1 && ax2 >= jx1 && jy1 <= ay1 && intersectY >= ay1))
                return true;
        }
        return false;
//        int ix1;
//        int iy1;
//        int ix2;
//        int iy2;
//        int jx1;
//        int jy1;
//        int jx2;
//        int jy2;
//        if (directions.get(index1).equals("E")) {
//            ix1 = coords1.get(index1)[0];
//            iy1 = coords1.get(index1)[1];
//            ix2 = coords2.get(index1)[0];
//            iy2 = coords2.get(index1)[1];
//            jx1 = coords1.get(index2)[0];
//            jy1 = coords1.get(index2)[1];
//            jx2 = coords2.get(index2)[0];
//            jy2 = coords2.get(index2)[1];
//        } else {
//            ix1 = coords1.get(index2)[0];
//            iy1 = coords1.get(index2)[1];
//            ix2 = coords2.get(index2)[0];
//            iy2 = coords2.get(index2)[1];
//            jx1 = coords1.get(index1)[0];
//            jy1 = coords1.get(index1)[1];
//            jx2 = coords2.get(index1)[0];
//            jy2 = coords2.get(index1)[1];
//        }


//        if(ix1 <= jx1 && ix2 >= jx2 && jy1 <= iy2 && jy2 >= iy2)
//            return true;
//        return false;
    }

    public static Boolean findBlocker (ArrayList<int[]> coords1, ArrayList<int[]> coords2, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < coords1.size(); i++) {
            int ix1 = coords1.get(i)[0];
            int iy1 = coords1.get(i)[1];
            int ix2 = coords2.get(i)[0];
            int iy2 = coords2.get(i)[1];

            if (ix1 == ix2 && y1 == y2) {
                if ((y2 >= iy1 && y2 <= iy2 && ix1 >= x1 && ix1 <= x2)) {
                    return true;
                }
            }

            if (iy1 == iy2 && x1 == x2) {
                if ((iy2 >= y1 && iy2 <= y2 && x1 >= ix1 && x1 <= ix2)) {
                    return true;
                }
            }
        }

        return false;
    }
}
