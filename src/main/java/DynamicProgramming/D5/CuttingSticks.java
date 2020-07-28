package DynamicProgramming.D5;/* Created by oguzkeremyildiz on 16.07.2020 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class CuttingSticks {
    private static int calculateDp(int i, int j, int[][] dp, int[] array){
        if (dp[i][j] < 0){
            int min = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                min = Math.min(min, calculateDp(i, k, dp, array) + calculateDp(k, j, dp, array));
            }
            dp[i][j] = min + array[j] - array[i];
        }
        return dp[i][j];
    }
    private static int find(int[] array) {
        Arrays.sort(array);
        int[][] dp = new int[array.length][array.length];
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = 0;
            for (int j = i + 2; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < dp.length; i++){
            for (int j = i + 2; j < dp[0].length; j++) {
                calculateDp(i, j, dp, array);
            }
        }
        return dp[0][dp[0].length - 1];
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Sticks.txt"));
            while (source.hasNext()) {
                int totalMeter = source.nextInt();
                if (totalMeter > 0) {
                    int times = source.nextInt();
                    int[] array = new int[times + 2];
                    array[0] = 0;
                    for (int i = 0; i < times; i++) {
                        array[i] = source.nextInt();
                    }
                    array[times] = totalMeter;
                    System.out.println("The minimum cutting is " + find(array) + ".");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
