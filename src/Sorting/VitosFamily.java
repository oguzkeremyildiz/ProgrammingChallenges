package Sorting;/* Created by oguzkeremyildiz on 21.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VitosFamily {
    private static void choose(ArrayList<Integer> streets){
        int smallest = 0;
        int current;
        int smallestValue = 0;
        if (streets.size() == 2){
            System.out.println(streets.get(0));
        }else {
            for (int i = 0; i < streets.size(); i++){
                if (i != 0 || i != streets.size() - 1){
                    current = streets.get(i) - streets.get(0);
                    if (streets.get(streets.size() - 1) - streets.get(i) > current){
                        current = streets.get(streets.size() - 1) - streets.get(i);
                    }
                    if (smallest == 0){
                        smallest = current;
                        smallestValue = streets.get(i);
                    } else if (current < smallest){
                        smallest = current;
                        smallestValue = streets.get(i);
                    }
                }
            }
            System.out.println(smallestValue);
        }
    }
    private static void sort(ArrayList<Integer> streets){
        Collections.sort(streets);
    }
    public static void main(String[]args){
       try {
           int testCase;
           int number;
           int street;
           ArrayList<Integer> streets = new ArrayList<>();
           Scanner source = new Scanner(new File("Vito.txt"));
           testCase = source.nextInt();
           for (int i = 0; i < testCase; i++){
               number = source.nextInt();
               for (int j = 0; j < number; j++){
                   street = source.nextInt();
                   streets.add(street);
               }
               sort(streets);
               choose(streets);
               streets.clear();
           }
       } catch (Exception e){
           e.printStackTrace();
       }
    }
}
