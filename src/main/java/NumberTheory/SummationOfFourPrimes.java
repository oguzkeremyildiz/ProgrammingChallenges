package NumberTheory;/* Created by oguzkeremyildiz on 30.04.2020 */

import Tuples.Pair;

import java.io.File;
import java.util.*;

public class SummationOfFourPrimes {
    private static boolean[] setPrimes() {
        boolean[] primes = new boolean[10000000];
        primes[0] = true;
        for (int i = 0; i < primes.length; i++) {
            if (!primes[i]) {
                int times = 2;
                while ((i + 1) * times < 10000000) {
                    primes[((i + 1) * times) - 1] = true;
                    times++;
                }
            }
        }
        return primes;
    }
    private static LinkedHashMap<Integer, Pair<Integer, Integer>> addMap(boolean[] primes) {
        LinkedHashMap<Integer, Pair<Integer, Integer>> couples = new LinkedHashMap<>();
        LinkedHashSet<Integer> primesSet = new LinkedHashSet<>();
        for (int i = 0; i < primes.length; i++) {
            if (!primes[i] && i != primes.length - 1) {
                primesSet.add(i + 1);
            }
        }
        for (int i = 6; i <= 5000000; i += 2) {
            for (Integer prime : primesSet) {
                if (prime <= i) {
                    if (primesSet.contains(i - prime)) {
                        Pair<Integer, Integer> element = new Pair<>(prime, i - prime);
                        couples.put(i, element);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return couples;
    }
    private static void print(LinkedHashMap<Integer, Pair<Integer, Integer>> couples, int number) {
        for (Integer key : couples.keySet()) {
            if (couples.containsKey(number - key)) {
                System.out.println(couples.get(key).getKey() + " " + couples.get(key).getValue() + " " + couples.get(number - key).getKey() + " " + couples.get(number - key).getValue());
                break;
            }
        }
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Primes.txt"));
            LinkedList<Integer> numbers = new LinkedList<>();
            LinkedHashMap<Integer, Pair<Integer, Integer>> couples;
            boolean[] primes;
            int number;
            while (source.hasNext()) {
                number = source.nextInt();
                numbers.add(number);
            }
            primes = setPrimes();
            couples = addMap(primes);
            for (Integer num : numbers) {
                print(couples, num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
