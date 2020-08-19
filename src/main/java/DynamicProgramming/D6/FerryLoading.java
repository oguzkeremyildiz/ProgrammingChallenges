package DynamicProgramming.D6;/* Created by oguzkeremyildiz on 5.08.2020 */

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class FerryLoading {
    private static LinkedList<Boolean> best;
    private static LinkedList<Boolean> constructCandidates(int current, LinkedList<Boolean> sequence, int ferry, LinkedList<Integer> list) {
        LinkedList<Boolean> subsets = new LinkedList<>();
        if (sequence.size() > 0) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < sequence.size(); i++) {
                if (sequence.get(i)) {
                    sum1 += list.get(i);
                } else {
                    sum2 += list.get(i);
                }
            }
            if (sum1 + current <= ferry) {
                subsets.add(true);
            }
            if (sum2 + current <= ferry) {
                subsets.add(false);
            }
        } else {
            subsets.add(true);
            subsets.add(false);
        }
        return subsets;
    }
    private static boolean isASolution(LinkedList<Boolean> sequence, LinkedList<Integer> list, int ferry) {
        if (sequence.size() > 0) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < sequence.size(); i++) {
                if (sequence.get(i)) {
                    sum1 += list.get(i);
                } else {
                    sum2 += list.get(i);
                }
            }
            return ferry >= sum1 && ferry >= sum2;
        }
        return false;
    }
    private static void backtrack(LinkedList<Integer> list, int ferry, LinkedList<Boolean> sequence, int iterate) {
        if (sequence.size() > best.size() && isASolution(sequence, list, ferry)) {
            best = (LinkedList<Boolean>) sequence.clone();
        }
        if (iterate < list.size()) {
            LinkedList<Boolean> subsets = constructCandidates(list.get(iterate), sequence, ferry, list);
            for (Boolean subset : subsets) {
                sequence.add(subset);
                backtrack(list, ferry, sequence, iterate + 1);
                sequence.removeLast();
            }
        }
    }
    private static void print() {
        System.out.println(best.size());
        for (Boolean element : best) {
            if (element) {
                System.out.println("port");
            } else {
                System.out.println("starboard");
            }
        }
        System.out.println();
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Ferry.txt"));
            LinkedList<Integer> list = new LinkedList<>();
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                int ferry = source.nextInt();
                int current = Integer.MAX_VALUE;
                while (current != 0) {
                    current = source.nextInt();
                    if (current != 0) {
                        list.add(current);
                    }
                }
                best = new LinkedList<>();
                backtrack(list, ferry * 100, new LinkedList<>(), 0);
                print();
                list.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
