package DynamicProgramming.D4;/* Created by oguzkeremyildiz on 11.07.2020 */

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class UnidirectionalTSP {
    private static void fillMatrix(Number[][] array, Number[][] dp, int x, int y, HashMap<Number, Number> map) {
        Number bestValue = new Number(-1, -1, Integer.MAX_VALUE);
        if (bestValue.getValue() > dp[x][y - 1].getValue()) {
            bestValue = dp[x][y - 1];
        }
        if (x + 1 < dp.length) {
            if (bestValue.getValue() > dp[x + 1][y - 1].getValue()) {
                bestValue = dp[x + 1][y - 1];
            }
        } else {
            if (bestValue.getValue() > dp[0][y - 1].getValue()) {
                bestValue = dp[0][y - 1];
            }
        }
        if (x - 1 > -1) {
            if (bestValue.getValue() > dp[x - 1][y - 1].getValue()) {
                bestValue = dp[x - 1][y - 1];
            }
        } else {
            if (bestValue.getValue() > dp[dp.length - 1][y - 1].getValue()) {
                bestValue = dp[dp.length - 1][y - 1];
            }
        }
        dp[x][y] = new Number(x, y, bestValue.getValue() + array[x][y].getValue());
        map.put(array[x][y], array[bestValue.getX()][bestValue.getY()]);
    }
    private static void findBestPath(Number[][] array) {
        HashMap<Number, Number> map = new HashMap<>();
        Number[][] dp = new Number[array.length][array[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = array[i][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 0; j < dp.length; j++) {
                fillMatrix(array, dp, j, i, map);
            }
        }
        Number best = new Number(-1, -1, Integer.MAX_VALUE);
        int bestValue = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            Number[] ints = dp[i];
            if (bestValue > ints[dp[0].length - 1].getValue()) {
                bestValue = ints[dp[0].length - 1].getValue();
                best = array[i][array[0].length - 1];
            }
        }
        Number current = best;
        System.out.print(current.getX() + 1);
        do {
            System.out.print(" " + (map.get(current).getX() + 1));
            if (map.containsKey(map.get(current))) {
                current = map.get(current);
            } else {
                current = null;
            }
        } while (current != null);
        System.out.println();
        System.out.println(bestValue);
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Unidirectional.txt"));
            while (source.hasNext()) {
                Number[][] array = new Number[source.nextInt()][source.nextInt()];
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        array[i][j] = new Number(i, j, source.nextInt());
                    }
                }
                findBestPath(array);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
