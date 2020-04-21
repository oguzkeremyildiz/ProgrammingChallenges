package Backtracking.B3;/* Created by oguzkeremyildiz on 7.04.2020 */

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Queue {
    private static int total;
    private static void constructCandidates(LinkedList<Integer> subsets, int people, LinkedList<Integer> sequence){
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : sequence) {
            set.add(integer);
        }
        for (int i = 1; i <= people; i++) {
            if (!set.contains(i)){
                subsets.add(i);
            }
        }
    }
    private static void backtrack(int people, int left, int right, LinkedList<Integer> sequence){
        LinkedList<Integer> subsets = new LinkedList<>();
        if (sequence.size() == people){
            if (isASolution(left, right, sequence)){
                total++;
            }
        } else {
            constructCandidates(subsets, people, sequence);
            for (Integer subset : subsets) {
                sequence.add(subset);
                backtrack(people, left, right, sequence);
                sequence.removeLast();
            }
        }
    }
    private static boolean isASolution(int left, int right, LinkedList<Integer> sequence){
        boolean bool = false;
        int checkLeft = 0;
        int checkRight = 0;
        boolean isLeft;
        boolean isRight;
        for (int i = 0; i < sequence.size(); i++) {
            isLeft = true;
            isRight = true;
            for (int j = 0; j < sequence.size(); j++) {
                if (i != j){
                    if (i < j){
                        if (sequence.get(i) < sequence.get(j)){
                            isRight = false;
                            break;
                        }
                    } else {
                        if (sequence.get(i) < sequence.get(j)){
                            isLeft = false;
                            j = i;
                        }
                    }
                }
            }
            if (isLeft){
                checkLeft++;
            }
            if (isRight){
                checkRight++;
            }
        }
        if (checkLeft == left){
            if (checkRight == right){
                bool = true;
            }
        }
        return bool;
    }
    public static void main(String[]args){
        try {
            Scanner source = new Scanner(new File("Queue.txt"));
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                total = 0;
                int people = source.nextInt();
                int left = source.nextInt();
                int right = source.nextInt();
                backtrack(people, left, right, new LinkedList<>());
                System.out.println(total);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
