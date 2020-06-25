package DynamicProgramming.D2;/* Created by oguzkeremyildiz on 24.06.2020 */

import java.io.File;
import java.util.Scanner;

public class DistinctSubsequences {
    private static int find(String first, String second) {
        int[][] array = new int[first.length()][second.length()];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    if (j > 0) {
                        if (i > 0) {
                            array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                        } else {
                            array[i][j] = 0;
                        }
                    } else {
                        if (i > 0) {
                            array[i][j] = array[i - 1][j] + 1;
                        } else {
                            array[i][j]++;
                        }
                    }
                } else {
                    if (i > 0) {
                        array[i][j] = array[i - 1][j];
                    }
                }
            }
        }
        return array[first.length() - 1][second.length() - 1];
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Sequence.txt"));
            int times = Integer.parseInt(source.next());
            for (int i = 0; i < times; i++) {
                String first = source.next();
                String second = source.next();
                System.out.println(find(first, second));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
