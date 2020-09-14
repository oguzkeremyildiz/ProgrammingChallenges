package DynamicProgramming.D7;/* Created by oguzkeremyildiz on 24.08.2020 */

import Cookies.Tuple.Pair;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Chopsticks {
    private static boolean isThereAChopstick(int[] array, int currentIndex) {
        array[currentIndex + 1] = -1;
        for (int i = currentIndex; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = -1;
                return true;
            }
        }
        return false;
    }
    private static boolean suitable(boolean[] visited, Chopstick chopstick1, Chopstick chopstick2) {
        if (!visited[chopstick1.getIndex()] && !visited[chopstick2.getIndex()]) {
            int[] array = new int[visited.length];
            for (int i = 0; i < array.length; i++) {
                if (visited[i] || chopstick1.getIndex() == i || chopstick2.getIndex() == i) {
                    array[i] = 1;
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1) {
                    if (!isThereAChopstick(array, i)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    private static Pair<Chopstick, Chopstick> findPair(LinkedList<Chopstick> list, Chopstick current, Chopstick first, Chopstick second, boolean[] visited) {
        list.add(current);
        if (list.size() > 1) {
            Chopstick returning1 = first;
            Chopstick returning2 = second;
            for (int i = 0; i < list.size() - 1; i++) {
                if (Math.abs(returning1.getChopstick() - returning2.getChopstick()) > Math.abs(current.getChopstick() - list.get(i).getChopstick()) && suitable(visited, current, list.get(i))) {
                    returning1 = current;
                    returning2 = list.get(i);
                }
            }
            return new Pair<>(returning1, returning2);
        }
        return null;
    }
    private static void fill(int[][] dp, Chopstick first, Chopstick second, int i, Chopstick[] chopstick) {
        if (i - 1 > -1) {
            System.arraycopy(dp[i - 1], 0, dp[i], 0, dp[0].length);
        }
        if (Math.abs(first.getIndex() - second.getIndex()) != 1) {
            if (first.getIndex() > second.getIndex()) {
                int index = dp[i][first.getIndex() - 1];
                int compare1 = chopstick[first.getIndex() - 1].getChopstick();
                int compare2 = chopstick[second.getIndex() + 1].getChopstick();
                if (Math.pow(first.getChopstick() - compare1, 2) + Math.pow(compare2 - second.getChopstick(), 2) < Math.pow(compare1 - compare2, 2) + Math.pow(first.getChopstick() - second.getChopstick(), 2)) {
                    dp[i][first.getIndex()] = i + 1;
                    dp[i][first.getIndex() - 1] = i + 1;
                    dp[i][second.getIndex()] = index;
                    dp[i][second.getIndex() + 1] = index;
                } else {
                    dp[i][first.getIndex()] = i + 1;
                    dp[i][second.getIndex()] = i + 1;
                }
            } else {
                int index = dp[i][second.getIndex() - 1];
                int compare1 = chopstick[second.getIndex() - 1].getChopstick();
                int compare2 = chopstick[first.getIndex() + 1].getChopstick();
                if (Math.pow(second.getChopstick() - compare1, 2) + Math.pow(compare2 - first.getChopstick(), 2) < Math.pow(compare1 - compare2, 2) + Math.pow(second.getChopstick() - first.getChopstick(), 2)) {
                    dp[i][second.getIndex()] = i + 1;
                    dp[i][second.getIndex() - 1] = i + 1;
                    dp[i][first.getIndex()] = index;
                    dp[i][first.getIndex() + 1] = index;
                } else {
                    dp[i][second.getIndex()] = i + 1;
                    dp[i][first.getIndex()] = i + 1;
                }
            }
        } else {
            dp[i][first.getIndex()] = i + 1;
            dp[i][second.getIndex()] = i + 1;
        }
    }
    private static int find(Chopstick[] chopstick, int people) {
        int[][] dp = new int[people][chopstick.length];
        boolean[] visited = new boolean[chopstick.length];
        for (int i = 0; i < dp.length; i++) {
            LinkedList<Chopstick> list = new LinkedList<>();
            Chopstick first = new Chopstick(-1, Integer.MAX_VALUE);
            Chopstick second = new Chopstick(-1, 0);
            for (int j = 0; j < dp[0].length; j++) {
                Pair<Chopstick, Chopstick> pair = findPair(list, chopstick[j], first, second, visited);
                if (pair != null) {
                    first = pair.getKey();
                    second = pair.getValue();
                }
            }
            fill(dp, first, second, i, chopstick);
            visited[first.getIndex()] = true;
            visited[second.getIndex()] = true;
        }
        return findBadness(dp, chopstick);
    }
    private static int findBadness(int[][] dp, Chopstick[] chopstick) {
        int badness = 0;
        HashMap<Integer, LinkedList<Chopstick>> map = new HashMap<>();
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[dp.length - 1][i] != 0) {
                if (!map.containsKey(dp[dp.length - 1][i])) {
                    map.put(dp[dp.length - 1][i], new LinkedList<>());
                }
                map.get(dp[dp.length - 1][i]).add(chopstick[i]);
            }
        }
        for (Integer key : map.keySet()) {
            badness += Math.pow(Math.abs(map.get(key).getFirst().getChopstick() - map.get(key).getLast().getChopstick()), 2);
        }
        return badness;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Chopstick.txt"));
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                int people = source.nextInt();
                int chopsticks = source.nextInt();
                Chopstick[] chopstick = new Chopstick[chopsticks];
                for (int j = 0; j < chopsticks; j++) {
                    chopstick[j] = new Chopstick(j, source.nextInt());
                }
                System.out.println(find(chopstick, people + 8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
