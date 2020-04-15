package Backtracking.B7;/* Created by oguzkeremyildiz on 14.04.2020 */

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class ColorHash {
    private static LinkedList<Integer> found;
    private static LinkedList<Integer> solution = new LinkedList<>();
    private static void addSolution() {
        solution.add(0);
        solution.add(3);
        solution.add(4);
        solution.add(3);
        solution.add(0);
        solution.add(5);
        solution.add(6);
        solution.add(5);
        solution.add(0);
        solution.add(1);
        solution.add(2);
        solution.add(1);
        solution.add(0);
        solution.add(7);
        solution.add(8);
        solution.add(7);
        solution.add(0);
        solution.add(9);
        solution.add(10);
        solution.add(9);
        solution.add(0);
        solution.add(1);
        solution.add(2);
        solution.add(1);
    }
    protected static int remaining(LinkedList<Integer> sequence) {
        int returning = -1;
        int remaining = 1;
        for (int i = 0; i < sequence.size(); i++) {
            if (i + 1 < sequence.size()) {
                if (sequence.get(i).equals(sequence.get(i + 1))) {
                    remaining++;
                } else {
                    remaining = 1;
                }
                if (remaining == 5 && i + 1 == sequence.size() - 1) {
                    returning = sequence.get(i);
                    break;
                }
            }
        }
        return returning;
    }
    private static void constructCandidates(LinkedList<Integer> subsets, LinkedList<Integer> sequence) {
        if (sequence.size() > 0) {
            switch (sequence.getLast()) {
                case 1:
                    if (remaining(sequence) != 1) {
                        subsets.add(1);
                    }
                    subsets.add(2);
                    subsets.add(4);
                    break;
                case 2:
                    if (remaining(sequence) != 2) {
                        subsets.add(2);
                    }
                    subsets.add(1);
                    subsets.add(3);
                    break;
                case 3:
                    if (remaining(sequence) != 3) {
                        subsets.add(3);
                    }
                    subsets.add(2);
                    subsets.add(4);
                    break;
                default:
                    if (remaining(sequence) != 4) {
                        subsets.add(4);
                    }
                    subsets.add(1);
                    subsets.add(3);
                    break;
            }
        } else {
            subsets.add(1);
            subsets.add(2);
            subsets.add(3);
            subsets.add(4);
        }
    }
    private static void backtrack(LinkedList<Integer> table, LinkedList<Integer> sequence) {
        if (found.size() == 16) {
            return;
        }
        if (found.size() > 0) {
            if (sequence.size() >= found.size()) {
                return;
            }
        }
        LinkedList<Integer> subsets = new LinkedList<>();
        LinkedList<Integer> tableClone;
        if (isASolution(table)) {
            if (sequence.size() > 0) {
                found.clear();
                found.addAll(sequence);
            } else {
                System.out.println("PUZZLE ALREADY SOLVED");
            }
        } else {
            constructCandidates(subsets, sequence);
            for (Integer subset : subsets) {
                sequence.add(subset);
                tableClone = new LinkedList<>();
                tableClone.addAll(table);
                rotate(table, subset);
                if (sequence.size() != 16) {
                    backtrack(table, sequence);
                } else {
                    if (isASolution(table)) {
                        found.clear();
                        found.addAll(sequence);
                    }
                }
                sequence.removeLast();
                table.clear();
                table.addAll(tableClone);
            }
        }
    }
    private static void rotate(LinkedList<Integer> table, int subset) {
        LinkedList<Integer> clone = new LinkedList<>(table);
       switch (subset) {
           case 1:
               for (int i = 0; i < 12; i++) {
                   if (i > 1) {
                       table.set(i, clone.get(i - 2));
                   } else if (i == 0) {
                       table.set(0, clone.get(10));
                   } else {
                       table.set(1, clone.get(11));
                   }
               }
               table.set(21, table.get(9));
               table.set(22, table.get(10));
               table.set(23, table.get(11));
               break;
           case 2:
               for (int i = 12; i < table.size(); i++) {
                   if (i < 22) {
                       table.set(i, clone.get(i + 2));
                   } else if (i == 22) {
                       table.set(22, clone.get(12));
                   } else {
                       table.set(23, clone.get(13));
                   }
               }
               table.set(9, table.get(21));
               table.set(10, table.get(22));
               table.set(11, table.get(23));
               break;
           case 3:
               for (int i = 0; i < 12; i++) {
                   if (i < 10) {
                       table.set(i, clone.get(i + 2));
                   } else if (i == 10) {
                       table.set(10, clone.get(0));
                   } else {
                       table.set(11, clone.get(1));
                   }
               }
               table.set(21, table.get(9));
               table.set(22, table.get(10));
               table.set(23, table.get(11));
               break;
           default:
               for (int i = 12; i < table.size(); i++) {
                   if (i > 13) {
                       table.set(i, clone.get(i - 2));
                   } else if (i == 12) {
                       table.set(12, clone.get(22));
                   } else {
                       table.set(13, clone.get(23));
                   }
               }
               table.set(9, table.get(21));
               table.set(10, table.get(22));
               table.set(11, table.get(23));
               break;
       }
    }
    private static boolean isASolution(LinkedList<Integer> table) {
        return table.equals(solution);
    }
    private static void print(LinkedList<Integer> table) {
        System.out.print(" " + table.get(6) + " " + table.get(7) + " " + table.get(8) + " " + table.get(20) + " " + table.get(19) + " " + table.get(18));
        System.out.println();
        System.out.print(table.get(5) + "     " + table.get(9) + "      " + table.get(17));
        System.out.println();
        System.out.print(table.get(4) + "     " + table.get(10) + "      " + table.get(16));
        System.out.println();
        System.out.print(table.get(3) + "     " + table.get(11) + "      " + table.get(15));
        System.out.println();
        System.out.print(" " + table.get(2) + " " + table.get(1) + " " + table.get(0) + " " + table.get(12) + " " + table.get(13) + " " + table.get(14));
        System.out.println();
    }
    public static void main(String[]args) {
        try {
            found = new LinkedList<>();
            addSolution();
            Scanner source = new Scanner(new File("ColorHash.txt"));
            LinkedList<Integer> table = new LinkedList<>();
            int times = source.nextInt();
            int hash;
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < 24; j++) {
                    hash = source.nextInt();
                    table.add(hash);
                }
                backtrack(table, new LinkedList<>());
                if (found.size() > 0 || isASolution(table)) {
                    if (found.size() > 0) {
                        System.out.println(found);
                    }
                } else {
                    System.out.println("NO SOLUTION WAS FOUND IN 16 STEPS");
                }
                found.clear();
                table.clear();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
