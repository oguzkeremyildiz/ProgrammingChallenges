package Sorting.S3;/* Created by oguzkeremyildiz on 26.02.2020 */

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Bridge {
    private static void swap(LinkedList<Integer> pancakes, int i, int j){
        int tmp;
        tmp = pancakes.get(i);
        pancakes.set(i, pancakes.get(j));
        pancakes.set(j, tmp);
    }
    private static int partition(LinkedList<Integer> pancakes, int first, int last){
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
    private static void quickSort(LinkedList<Integer> pancakes, int first, int last){
        int pivot;
        if (first < last){
            pivot = partition(pancakes, first, last);
            quickSort(pancakes, first, pivot - 1);
            quickSort(pancakes, pivot + 1, last);
        }
    }
    private static int bridge(LinkedList<Integer> start, LinkedList<Integer> finish){
        quickSort(start, 0, start.size() - 1);
        int index = 0;
        int sum = 0;
        if (start.size() % 2 == 0){
            //sum += start.get(0);
            sum += start.get(1);
            System.out.print(start.get(0) + " " + start.get(1));
            finish.add(start.get(0));
            finish.add(start.get(1));
        } else {
            sum += start.get(0);
            sum += start.get(1);
            sum += start.get(2);
            System.out.print(start.get(0) + " " + start.get(1));
            System.out.println();
            System.out.print(start.get(0));
            System.out.println();
            System.out.print(start.get(0) + " " + start.get(2));
            finish.add(start.get(0));
            finish.add(start.get(1));
            finish.add(start.get(2));
        }
        while (finish.size() != start.size()){
            sum += finish.getFirst();
            System.out.println();
            System.out.print(finish.getFirst());
            finish.removeFirst();
            sum += start.get(start.size() - 1 - index);
            finish.add(start.get(start.size() - 1 - index));
            finish.add(start.get(start.size() - 2 - index));
            System.out.println();
            System.out.print(start.get(start.size() - 2 - index) + " " + start.get(start.size() - 1 - index));
            sum += finish.getFirst();
            System.out.println();
            System.out.print(finish.getFirst());
            System.out.println();
            System.out.print(start.getFirst() + " " + finish.getFirst());
            sum += finish.getFirst();
            finish.add(start.getFirst());
            index += 2;
            quickSort(finish, 0, finish.size() - 1);
        }
        System.out.println();
        return sum;
    }
    public static void main(String[]args){
        try {
            int timesOne, timesSecond, lines;
            Scanner source = new Scanner(new File("Bridge.txt"));
            timesOne = source.nextInt();
            LinkedList<Integer> start = new LinkedList<>();
            LinkedList<Integer> finish = new LinkedList<>();
            for (int i = 0; i < timesOne; i++){
                timesSecond = source.nextInt();
                start.clear();
                finish.clear();
                for (int j = 0; j < timesSecond; j++){
                    lines = source.nextInt();
                    start.add(lines);
                }
                System.out.println(bridge(start, finish));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
