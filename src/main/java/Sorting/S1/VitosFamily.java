package Sorting.S1;/* Created by oguzkeremyildiz on 21.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VitosFamily {

    private static void choose(ArrayList<Integer> streets) {
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < streets.size(); i++) {
            int total = 0;
            for (int j = 0; j < streets.size(); j++) {
                if (i != j) {
                    total += Math.abs(streets.get(i) - streets.get(j));
                }
            }
            if (total < best) {
                best = total;
            }
        }
        System.out.println(best);
    }

    public static void main(String[]args) {
       try {
           int testCase;
           int number;
           int street;
           ArrayList<Integer> streets = new ArrayList<>();
           Scanner source = new Scanner(new File("Vito.txt"));
           testCase = source.nextInt();
           for (int i = 0; i < testCase; i++) {
               number = source.nextInt();
               for (int j = 0; j < number; j++) {
                   street = source.nextInt();
                   streets.add(street);
               }
               choose(streets);
               streets.clear();
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
