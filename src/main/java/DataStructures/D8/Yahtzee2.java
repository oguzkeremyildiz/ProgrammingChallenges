package DataStructures.D8;

import Cookies.Tuple.Triplet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Yahtzee2 {

    private static int[] solveDp(int index, HashMap<Triplet<String, Integer, Integer>, int[]> map, int[][] scores, String current, int currentScore, int onesCount) {
        if (index == 13) {
            return new int[15];
        }
        if (map.containsKey(new Triplet<>(current, index, index - onesCount))) {
            return map.get(new Triplet<>(current, index, index - onesCount));
        }
        int[] bestPoints = new int[15];
        for (int i = 0; i < 13; i++) {
            if (scores[index][i] > 0 && current.charAt(i) == '0') {
                String str = current.substring(0, i) + "1" + current.substring(i + 1);
                int plus = scores[index][i];
                if (index < 6 && currentScore < 63 && currentScore + scores[index][i] > 62) {
                    plus += 35;
                }
                int[] points = solveDp(index + 1, map, scores, str, currentScore + plus, onesCount + 1);
                map.put(new Triplet<>(str, index, index - onesCount), points);
                if (points[14] + plus > bestPoints[14]) {
                    bestPoints = points.clone();
                    bestPoints[14] = points[14] + plus;
                    if (plus - scores[index][i] > 0) {
                        bestPoints[13] = 35;
                    }
                    bestPoints[index] = scores[index][i];
                }
            }
        }
        int[] points = solveDp(index + 1, map, scores, current, currentScore, onesCount);
        map.put(new Triplet<>(current, index + 1, index + 1 - onesCount), points);
        if (points[14] > bestPoints[14]) {
            return points;
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
        int[] best = solveDp(0, new HashMap<>(), scores, "0000000000000", 0, 0);
        for (int i = 0; i < best.length; i++) {
            System.out.print(best[i]);
            if (i + 1 != best.length) {
                System.out.print(" ");
            }
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
