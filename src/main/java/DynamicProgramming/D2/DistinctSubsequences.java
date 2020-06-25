package DynamicProgramming.D2;/* Created by oguzkeremyildiz on 24.06.2020 */

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class DistinctSubsequences {
    private static void find(String first, String second) {
        BigInteger[][] dp = new BigInteger[first.length()][second.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new BigInteger("0");
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    if (j > 0) {
                        if (i > 0) {
                            dp[i][j] = dp[i][j].add(dp[i - 1][j - 1]);
                            dp[i][j] = dp[i][j].add(dp[i - 1][j]);
                        } else {
                            dp[i][j] = new BigInteger("0");
                        }
                    } else {
                        if (i > 0) {
                            dp[i][j] = new BigInteger(dp[i - 1][j].toString());
                        }
                        dp[i][j] = dp[i][j].add(new BigInteger("1"));
                    }
                } else {
                    if (i > 0) {
                        dp[i][j] = new BigInteger(dp[i - 1][j].toString());
                    }
                }
            }
        }
        System.out.println(dp[first.length() - 1][second.length() - 1]);
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Sequence.txt"));
            int times = Integer.parseInt(source.next());
            for (int i = 0; i < times; i++) {
                String first = source.next();
                String second = source.next();
                find(first, second);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
