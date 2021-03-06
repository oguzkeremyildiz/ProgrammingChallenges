package DataStructures.D1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class JollyJumpers {
    protected static boolean jollyCount(ArrayList<Integer> numbers){
        HashSet<Integer> count = new HashSet<>();
        for (int i = 0; i < numbers.size() - 1; i++){
            if (numbers.get(i) < numbers.get(i + 1)){
                if (numbers.get(i + 1) - numbers.get(i) < numbers.size() && numbers.get(i + 1) - numbers.get(i) != 0){
                    if (!count.contains(numbers.get(i + 1) - numbers.get(i))){
                        count.add(numbers.get(i + 1) - numbers.get(i));
                    } else {
                        return false;
                    }
                }
            } else {
                if (numbers.get(i) - numbers.get(i + 1) < numbers.size() && numbers.get(i) - numbers.get(i + 1) != 0){
                    if (!count.contains(numbers.get(i) - numbers.get(i + 1))){
                        count.add(numbers.get(i) - numbers.get(i + 1));
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[]args){
        int number;
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("Jolly.txt"));
            while (scan.hasNext()){
                int times = scan.nextInt();
                for (int i = 0; i < times; i++){
                    number = scan.nextInt();
                    numbers.add(number);
                }
                if (jollyCount(numbers)){
                    System.out.println("Jolly");
                }else {
                    System.out.println("Not jolly");
                }
                numbers.clear();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
