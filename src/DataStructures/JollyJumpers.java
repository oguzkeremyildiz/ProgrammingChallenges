package DataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JollyJumpers {
    public static void isJolly(ArrayList<Integer> numbers, ArrayList<Integer> count){
        for (int i = 1; i < numbers.size(); i++){
            if (count.get(i - 1) != i){
                System.out.println("Not jolly");
                break;
            }
            if (i == numbers.size() - 1){
                System.out.println("Jolly");
            }
        }
    }
    public static void sortCount(ArrayList<Integer> count){
        int current;
        for (int i = 0; i < count.size(); i++){
            for (int j = i; j < count.size(); j++){
                if (i != j){
                    if (count.get(i) > count.get(j)){
                        current = count.get(i);
                        count.set(i, count.get(j));
                        count.set(j, current);
                    }
                }
            }
        }
    }
    public static void jollyCount(ArrayList<Integer> numbers, ArrayList<Integer> count){
        for (int i = 0; i < numbers.size(); i++){
            if (i + 1 < numbers.size()){
                if (numbers.get(i) < numbers.get(i + 1)){
                    count.add(numbers.get(i + 1) - numbers.get(i));
                } else {
                    count.add(numbers.get(i) - numbers.get(i + 1));
                }
            }
        }
    }
    public static void main(String[]args){
        int number;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("Jolly.txt"));
            while (scan.hasNext()){
                int times = scan.nextInt();
                for (int i = 0; i < times; i++){
                    number = scan.nextInt();
                    numbers.add(number);
                }
                jollyCount(numbers, count);
                sortCount(count);
                isJolly(numbers, count);
                numbers.clear();
                count.clear();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
