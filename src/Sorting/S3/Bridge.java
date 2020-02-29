package Sorting.S3;/* Created by oguzkeremyildiz on 26.02.2020 */

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Bridge {
    private static void sort(LinkedList<Integer> list){
        Collections.sort(list);
    }
    private static int bridge(LinkedList<Integer> start, LinkedList<Integer> finish){
        sort(start);
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
            sort(finish);
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
