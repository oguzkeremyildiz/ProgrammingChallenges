package Combinatorics.C6;/* Created by oguzkeremyildiz on 11.05.2020 */

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class ThePriestMathematician {
    public static void main(String[] args) {
        try {
            Scanner source = new Scanner(new File("Priest.txt"));
            BigInteger[] f = new BigInteger[10010];
            f[0] = new BigInteger("0");
            int k = 1, cnt = 0;
            BigInteger d = new BigInteger("1");
            for (int i = 1; i <= 10000; i ++) {
                f[i] = f[i - 1].add(d);
                cnt++;
                if (cnt == k) {
                    cnt = 0;
                    k++;
                    d = d.multiply(BigInteger.valueOf(2));
                }
            }
            while (source.hasNext()) {
                int n = source.nextInt();
                System.out.println(f[n]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
