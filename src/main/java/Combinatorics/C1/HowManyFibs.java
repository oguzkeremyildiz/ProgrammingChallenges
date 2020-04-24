package Combinatorics.C1;/* Created by oguzkeremyildiz on 24.04.2020 */

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class HowManyFibs {
    private static void addFibonacci(LinkedList<LinkedList<Integer>> fibonacciNumbers) {
        int number = 0;
        int current = 0;
        fibonacciNumbers.add(new LinkedList<>());
        for (int j = 0; j < fibonacciNumbers.get(fibonacciNumbers.size() - 3).size(); j++) {
            LinkedList<Integer> listOne = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
            LinkedList<Integer> listTwo = fibonacciNumbers.get(fibonacciNumbers.size() - 3);
            number += current;
            number += listOne.get(listOne.size() - j - 1);
            number += listTwo.get(listTwo.size() - j - 1);
            current = 0;
            if (number < 10) {
                fibonacciNumbers.getLast().add(number);
            } else {
                current = 1;
                fibonacciNumbers.getLast().add(number % 10);
            }
            number = 0;
        }
        if (fibonacciNumbers.get(fibonacciNumbers.size() - 2).size() != fibonacciNumbers.get(fibonacciNumbers.size() - 3).size()) {
            number += current;
            LinkedList<Integer> listOne = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
            number += listOne.getFirst();
            fibonacciNumbers.getLast().add(number);
        } else if (current == 1) {
            fibonacciNumbers.getLast().add(1);
        }
        Collections.reverse(fibonacciNumbers.getLast());
    }
    private static int sum(LinkedList<LinkedList<Integer>> fibonacciNumbers, LinkedList<Integer> numberOneList, LinkedList<Integer> numberTwoList) {
        int sum = 0;
        while (isSmaller(fibonacciNumbers.getLast(), numberTwoList)) {
            if (isBigger(fibonacciNumbers.getLast(), numberOneList)) {
                sum++;
            }
            addFibonacci(fibonacciNumbers);
        }
        return sum;
    }
    private static boolean isSmaller(LinkedList<Integer> fibonacciNumber, LinkedList<Integer> number) {
        if (fibonacciNumber.size() < number.size()) {
            return true;
        } else if (fibonacciNumber.size() > number.size()) {
            return false;
        } else {
            for (int i = 0; i < fibonacciNumber.size(); i++) {
                if (fibonacciNumber.get(i) > number.get(i)) {
                    return false;
                } else if (fibonacciNumber.get(i) < number.get(i)){
                    return true;
                }
            }
        }
        return true;
    }
    private static boolean isBigger(LinkedList<Integer> fibonacciNumber, LinkedList<Integer> number) {
        if (fibonacciNumber.size() > number.size()) {
            return true;
        } else if (fibonacciNumber.size() < number.size()) {
            return false;
        } else {
            for (int i = 0; i < fibonacciNumber.size(); i++) {
                if (fibonacciNumber.get(i) < number.get(i)) {
                    return false;
                } else if (fibonacciNumber.get(i) > number.get(i)) {
                    return true;
                }
            }
        }
        return true;
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Fibs.txt"));
            while (true) {
                String numberOne = source.next();
                String numberTwo = source.next();
                LinkedList<Integer> numberOneList = new LinkedList<>();
                LinkedList<Integer> numberTwoList = new LinkedList<>();
                LinkedList<LinkedList<Integer>> fibonacciNumbers = new LinkedList<>();
                fibonacciNumbers.add(0, new LinkedList<>());
                fibonacciNumbers.get(0).add(1);
                fibonacciNumbers.add(1, new LinkedList<>());
                fibonacciNumbers.get(1).add(1);
                fibonacciNumbers.add(2, new LinkedList<>());
                fibonacciNumbers.get(2).add(2);
                if (numberOne.equals("0") && numberTwo.equals("0")) {
                    break;
                } else {
                    for (int i = 0; i < numberOne.length(); i++) {
                        numberOneList.add(Integer.parseInt((numberOne.charAt(i)) + ""));
                    }
                    for (int i = 0; i < numberTwo.length(); i++) {
                        numberTwoList.add(Integer.parseInt((numberTwo.charAt(i)) + ""));
                    }
                }
                System.out.println(sum(fibonacciNumbers, numberOneList, numberTwoList));
                numberOneList.clear();
                numberTwoList.clear();
                fibonacciNumbers.clear();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
