package com.company;

import java.io.File;
import java.util.Scanner;

public class Cow2017CopyDecMilkMeasurement {
    public static void milkMeasurement() throws Exception {

        Scanner input = new Scanner(new File("measurement.in"));

        int numChanges = input.nextInt();
        int[] cowMilkUpdates = {7, 7, 7};
        int[] days = new int[numChanges];
        String[] cowUpdates = new String[numChanges];
        int[] amountUpdated = new int[numChanges];

        for (int i = 0; i < numChanges; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    days[i] = input.nextInt();
                else if (j == 1)
                    cowUpdates[i] = input.next();
                else amountUpdated[i] = input.nextInt();
            }
        }
    }
}
