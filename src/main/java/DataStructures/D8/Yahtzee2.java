package DataStructures.D8;

import Cookies.Tuple.Triplet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Yahtzee2 {

    private static int onesCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    private static int[] solveDp(int index, HashMap<Triplet<String, Integer, Integer>, int[]> map, int[][] scores, String current, int currentScore) {
        int onesCount = onesCount(current);
        if (map.containsKey(new Triplet<>(current, index, onesCount))) {
            return map.get(new Triplet<>(current, index, onesCount));
        }
        int bestIndex = -1;
        int bestPoint = 0;
        int[] currentPoints = new int[15];
        for (int i = 0; i < 13; i++) {
            if (scores[index][i] > 0 && current.charAt(i) == '0') {
                String str = current.substring(0, i) + "1" + current.substring(i + 1);
                if (index < 12) {
                    int plus = scores[index][i];
                    if (index < 6 && currentScore < 63 && currentScore + scores[index][i] > 62) {
                        plus += 35;
                    }
                    int[] points = solveDp(index + 1, map, scores, str, currentScore + plus);
                    map.put(new Triplet<>(str, index, onesCount(current)), points);
                    if (points[14] + plus > bestPoint) {
                        bestIndex = i;
                        bestPoint = points[14] + plus;
                        currentPoints = points.clone();
                    }
                } else {
                    if (scores[index][i] > bestPoint) {
                        bestIndex = i;
                        bestPoint = scores[index][i];
                    }
                }
            }
        }
        if (index < 12) {
            int[] points = solveDp(index + 1, map, scores, current, currentScore);
            map.put(new Triplet<>(current, index + 1, onesCount(current)), points);
            if (points[14] > bestPoint) {
                return points;
            }
        }
        if (bestIndex == -1) {
            return currentPoints;
        }
        int[] bestPoints = currentPoints.clone();
        bestPoints[index] = scores[index][bestIndex];
        bestPoints[14] = bestPoint;
        if (index < 6 && currentScore < 63 && currentScore + scores[index][bestIndex] > 62) {
            bestPoints[13] = 35;
        }
        return bestPoints;
    }

    private static void solve(ArrayList<Round> rounds) {
        int[][] scores = new int[13][13];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                scores[j][i] = rounds.get(i).calculate(j);
            }
        }
        int[] best = solveDp(0, new HashMap<>(), scores, "0000000000000", 0);
        for (int j : best) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            ArrayList<Round> rounds = new ArrayList<>();
            Scanner source = new Scanner(new File("Yahtzee.txt"));
            while (source.hasNext()) {
                for (int i = 0; i < 13; i++) {
                    rounds.add(new Round(source.nextLine()));
                }
                solve(rounds);
                rounds.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
