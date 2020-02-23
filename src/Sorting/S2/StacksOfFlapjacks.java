package Sorting.S2;/* Created by oguzkeremyildiz on 23.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StacksOfFlapjacks {
    private static void swap(ArrayList<Integer> pancakes, int i, int j){
        int tmp;
        tmp = pancakes.get(i);
        pancakes.set(i, pancakes.get(j));
        pancakes.set(j, tmp);
    }
    private static int partition(ArrayList<Integer> pancakes, int first, int last){
        int x = pancakes.get(last);
        int i = first - 1, j;
        for (j = first; j < last; j++){
            if (pancakes.get(j) <= x){
                i++;
                swap(pancakes, i, j);
            }
        }
        swap(pancakes, i + 1, last);
        return i + 1;
    }
    private static void quickSort(ArrayList<Integer> pancakes, int first, int last){
        int pivot;
        if (first < last){
            pivot = partition(pancakes, first, last);
            quickSort(pancakes, first, pivot - 1);
            quickSort(pancakes, pivot + 1, last);
        }
    }
    private static void flip(ArrayList<Integer> pancakes, int index){
        int tmp;
        int checkFirst;
        int checkSecond;
        if (pancakes.size() > index){
            for (int i = 0; i < index; i++){
                checkFirst = i;
                checkSecond = index - i;
                if (checkSecond > checkFirst){
                    tmp = pancakes.get(i);
                    pancakes.set(i, pancakes.get(index - i));
                    pancakes.set(index - i, tmp);
                } else {
                    break;
                }
            }
        }
    }
    private static void find(ArrayList<Integer> pancakes, int i, ArrayList<Integer> results){
        int tmp = 0;
        int element;
        ArrayList<Integer> realPancakes = new ArrayList<>(pancakes);
        quickSort(realPancakes, 0, realPancakes.size() - 1);
        if (!pancakes.get(0).equals(realPancakes.get(realPancakes.size() - 1 - i))){
            element = realPancakes.get(realPancakes.size() - 1 - i);
        } else {
            element = pancakes.get(0);
        }
        if (!pancakes.get(pancakes.size() - 1 - i).equals(element)){
            for (int j = 0; j < pancakes.size(); j++){
                if (pancakes.get(j).equals(element)){
                    tmp = j;
                    break;
                }
            }
            flip(pancakes, tmp);
            flip(pancakes, pancakes.size() - 1 - i);
            results.add(1 + i);
        }
        i++;
        if (i < pancakes.size()){
            if (!realPancakes.equals(pancakes)){
                find(pancakes, i, results);
            } else {
                results.add(0);
                System.out.println(pancakes);
            }
        }
    }
    public static void main(String[]args){
        try {
            String line;
            int pancake;
            String[] split;
            Scanner source = new Scanner(new File("Pancakes.txt"));
            ArrayList<Integer> pancakes = new ArrayList<>();
            ArrayList<Integer> results = new ArrayList<>();
            while (source.hasNext()){
                pancakes.clear();
                results.clear();
                line = source.nextLine();
                split = line.split(" ");
                for (String s : split) {
                    pancake = Integer.parseInt(s);
                    pancakes.add(pancake);
                }
                find(pancakes, 0, results);
                for (Integer result : results) {
                    System.out.print(result + " ");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
