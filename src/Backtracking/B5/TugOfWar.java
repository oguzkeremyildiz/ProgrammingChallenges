package Backtracking.B5;/* Created by oguzkeremyildiz on 11.04.2020 */

import javafx.util.Pair;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TugOfWar {
    private static boolean finished;
    private static int smallest, bestDifference;
    private static Pair<LinkedList<Integer>, LinkedList<Integer>> pair = new Pair<>(new LinkedList<>(), new LinkedList<>());
    private static void constructCandidates(LinkedList<Integer> persons, LinkedList<Integer> sequence, LinkedList<Integer> subsets) {
        int sum1 = 0, sum2 = 0, sumRemaining = 0;
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) == 0) {
                sum1 += persons.get(i);
            } else {
                sum2 += persons.get(i);
            }
        }
        for (int j = sequence.size(); j < persons.size(); j++){
            sumRemaining += persons.get(j);
        }
        if (Math.min(sum1, sum2) + sumRemaining < Math.max(sum1, sum2)){
            return;
        }
        subsets.add(1);
        subsets.add(0);
    }
    private static void smallestDifference(LinkedList<Integer> persons) {
        if (persons.stream().mapToInt(Integer::intValue).sum() % 2 == 0){
            smallest = 0;
        } else {
            smallest = 1;
        }
    }
    private static void backtrack(LinkedList<Integer> persons, LinkedList<Integer> sequence) {
        if (bestDifference <= smallest && pair.getKey().size() > 0 && pair.getValue().size() > 0) {
            return;
        }
        LinkedList<Integer> subsets = new LinkedList<>();
        if (sequence.size() == persons.size()) {
            if (isASolution(sequence, persons).getKey()) {
                pair = isASolution(sequence, persons).getValue();
            }
            finished = true;
        } else {
            if (!finished){
                constructCandidates(persons, sequence, subsets);
                for (Integer subset : subsets) {
                    sequence.add(subset);
                    backtrack(persons, sequence);
                    sequence.removeLast();
                    finished = false;
                }
            }
        }
    }
    private static int difference(Pair<LinkedList<Integer>, LinkedList<Integer>> pair) {
        return Math.abs(pair.getKey().stream().mapToInt(Integer::intValue).sum() - pair.getValue().stream().mapToInt(Integer::intValue).sum());
    }
    private static Pair<Boolean, Pair<LinkedList<Integer>, LinkedList<Integer>>> isASolution(LinkedList<Integer> sequence, LinkedList<Integer> persons) {
        Pair<LinkedList<Integer>, LinkedList<Integer>> returning = new Pair<>(new LinkedList<>(), new LinkedList<>());
        boolean bool;
        bool = pair.getValue().size() == 0 && pair.getKey().size() == 0;
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) == 0) {
                returning.getKey().add(persons.get(i));
            } else {
                returning.getValue().add(persons.get(i));
            }
        }
        if (!bool) {
            if (difference(returning) < bestDifference) {
                bestDifference = difference(returning);
                bool = true;
            }
        }
        return new Pair<>(bool, returning);
    }
    private static void print() {
        int totalKey = 0;
        int totalValue = 0;
        for (int i = 0; i < pair.getKey().size(); i++) {
            totalKey += pair.getKey().get(i);
        }
        for (int i = 0; i < pair.getValue().size(); i++) {
            totalValue += pair.getValue().get(i);
        }
        System.out.println(totalKey + " " + totalValue);
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("War.txt"));
            int times = source.nextInt();
            int person = source.nextInt();
            int next;
            LinkedList<Integer> persons = new LinkedList<>();
            for (int i = 0; i < times; i++) {
                finished = false;
                for (int j = 0; j < person; j++) {
                    next = source.nextInt();
                    persons.add(next);
                }
                Collections.sort(persons);
                smallestDifference(persons);
                bestDifference = 1000;
                backtrack(persons, new LinkedList<>());
                System.out.println(pair.getKey() + " " + pair.getValue());
                print();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
