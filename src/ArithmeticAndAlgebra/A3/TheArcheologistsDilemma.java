package ArithmeticAndAlgebra.A3;/* Created by oguzkeremyildiz on 20.03.2020 */

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TheArcheologistsDilemma {
    private static void reserve(LinkedList<Integer> numbers, int number){
        while (number != 0){
            numbers.add(number % 10);
            number -= number % 10;
            number /= 10;
        }
    }
    private static boolean isSuitable(int number, int temporary){
        boolean bool = true;
        LinkedList<Integer> numbers = new LinkedList<>();
        LinkedList<Integer> temporaries = new LinkedList<>();
        reserve(numbers, number);
        reserve(temporaries, temporary);
        if (numbers.size() * 2 < temporaries.size()){
            for (int i = 0; i < numbers.size(); i++) {
                if (!numbers.get(numbers.size() - 1 - i).equals(temporaries.get(temporaries.size() - 1 - i))){
                    bool = false;
                    break;
                }
            }
        } else {
            bool = false;
        }
        return bool;
    }
    public static int power(int x, int y){
        int result = 1;
        if (y == 0){
            return 1;
        } else {
            for (int i = 1; i <= y; i++){
                result *= x;
            }
        }
        return result;
    }
    public static void main(String[]args){
        try {
            int number;
            int temporary;
            Scanner source = new Scanner(new File("Dilemma.txt"));
            while (source.hasNext()){
                number = source.nextInt();
                int i = 1;
                while (power(2, i) < 2147483647){
                    temporary = power(2, i);
                    if (isSuitable(number, temporary)){
                        System.out.println(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
