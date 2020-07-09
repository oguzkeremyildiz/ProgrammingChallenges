package DynamicProgramming.D3;/* Created by oguzkeremyildiz on 28.06.2020 */

import Cookies.Tuple.Pair;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class WeightsAndMeasures {
    private static void sort(LinkedList<Turtle> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).getPair().getKey() < list.get(j).getPair().getKey()) {
                    Turtle temporary = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temporary);
                }
            }
        }
    }
    private static int find(LinkedList<Turtle> list) {
        int best = 0;
        int[] total = new int[list.size()];
        for (int i = 0; i < total.length; i++) {
            total[i] = list.get(i).getPair().getKey();
        }
        int[] array = new int[list.size()];
        Arrays.fill(array, 1);
        for (int i = 1; i < list.size(); i++) {
            int index = -1;
            int totalWeight = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (index > -1) {
                    if (array[j] >= array[index] && list.get(i).getPair().getValue() >= total[j] + list.get(index).getPair().getKey()) {
                        if (array[j] == array[index]) {
                            if (totalWeight >= total[j] + list.get(index).getPair().getKey()) {
                                totalWeight = total[j];
                                index = j;
                            }
                        } else {
                            totalWeight = total[j];
                            index = j;
                        }
                    }
                } else {
                    if (array[j] >= array[i] && list.get(i).getPair().getValue() >= total[j] + list.get(i).getPair().getKey()) {
                        totalWeight = total[j];
                        index = j;
                    }
                }
            }
            if (index > -1) {
                array[i] = array[index] + 1;
                total[i] += totalWeight;
            }
        }
        for (int value : array) {
            if (value > best) {
                best = value;
            }
        }
        return best;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Weights.txt"));
            LinkedList<Turtle> list = new LinkedList<>();
            int index = -1;
            while (source.hasNext()) {
                index++;
                list.add(new Turtle(index, new Pair<>(source.nextInt(), source.nextInt())));
            }
            sort(list);
            System.out.println(find(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
