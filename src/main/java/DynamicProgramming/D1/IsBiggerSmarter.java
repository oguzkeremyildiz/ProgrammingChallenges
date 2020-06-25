package DynamicProgramming.D1;/* Created by oguzkeremyildiz on 11.06.2020 */

import DynamicProgramming.D1.Elephant;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class IsBiggerSmarter {
    private static void sort(LinkedList<Elephant> elephantList) {
        LinkedList<Elephant> removeList = new LinkedList<>();
        for (int i = 0; i < elephantList.size(); i++) {
            for (int j = 0; j < elephantList.size(); j++) {
                if (i != j) {
                    if (elephantList.get(i).getWeight() < elephantList.get(j).getWeight()) {
                        Elephant temporary = elephantList.get(i);
                        elephantList.set(i, elephantList.get(j));
                        elephantList.set(j, temporary);
                    } else if (elephantList.get(i).getWeight() == elephantList.get(j).getWeight()) {
                        if (elephantList.get(i).getIq() > elephantList.get(j).getIq()) {
                            removeList.add(elephantList.get(j));
                            Elephant temporary = elephantList.get(i);
                            elephantList.set(i, elephantList.get(j));
                            elephantList.set(j, temporary);
                        }
                    }
                }
            }
        }
        elephantList.removeAll(removeList);
    }
    private static LinkedList<Integer> longestDecreasingSequence(LinkedList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[list.size()];
        LinkedList<Integer> longest;
        Arrays.fill(array, 1);
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(i) && array[i] <= array[j]) {
                    map.put(list.get(i), list.get(j));
                    array[i] = array[j] + 1;
                }
            }
        }
        int best = 0;
        int bestNumber = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value > best) {
                bestNumber = list.get(i);
                best = value;
            }
        }
        System.out.println(best);
        longest = setLongest(bestNumber, map);
        return longest;
    }
    private static LinkedList<Integer> setLongest(int start, HashMap<Integer, Integer> map) {
        LinkedList<Integer> list = new LinkedList<>();
        int current = start;
        while (map.containsKey(current)) {
            list.add(current);
            current = map.get(current);
        }
        list.add(current);
        return list;
    }
    private static LinkedList<Integer> setList(LinkedList<Elephant> elephantList) {
        LinkedList<Integer> list = new LinkedList<>();
        for (Elephant elephant : elephantList) {
            list.add(elephant.getIq());
        }
        return list;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Smart.txt"));
            LinkedList<Elephant> elephantList = new LinkedList<>();
            LinkedList<Integer> list;
            int iterator = 0;
            while (source.hasNext()) {
                iterator++;
                elephantList.add(new Elephant(source.nextInt(), source.nextInt(), iterator));
            }
            sort(elephantList);
            list = setList(elephantList);
            LinkedList<Integer> longest = longestDecreasingSequence(list);
            System.out.println(longest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
