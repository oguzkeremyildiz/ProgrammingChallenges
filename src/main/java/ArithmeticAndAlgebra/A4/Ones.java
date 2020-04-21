package ArithmeticAndAlgebra.A4;/* Created by oguzkeremyildiz on 21.03.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ones {
    private static int digit(int number){
        int i = 0;
        while (number != 0){
            i++;
            number -= number % 10;
            number /= 10;
        }
        return i;
    }
    private static void addList(ArrayList<Integer> temporary){
        temporary.add(1);
    }
    private static int addDigit(int number, int iterator){
        int temporary = number;
        if (iterator != 0){
            temporary = number * 10;
            temporary++;
        }
        return temporary;
    }
    private static boolean isDividable(ArrayList<Integer> temporary, int number){
        boolean bool = false;
        int willDivide = 1;
        int remaining = 0;
        int iterator = 0;
        int i = 0;
        if (temporary.size() > digit(number)){
            ArrayList<Integer> copy = new ArrayList<>(temporary);
            while (digit(number) + 1 != iterator){
                willDivide = addDigit(willDivide, iterator);
                copy.remove(0);
                iterator++;
            }
            while (copy.size() != 0){
                if (i == 0){
                    remaining = (willDivide % number) * 10;
                } else {
                    remaining = (remaining % number) * 10;
                }
                remaining++;
                copy.remove(0);
                i++;
                if (copy.size() == 0){
                    if (remaining % number == 0){
                        bool = true;
                        break;
                    }
                }
            }
        }
        return bool;
    }
    private static int divide(int number){
        ArrayList<Integer> temporary = new ArrayList<>();
        while (true){
            if (isDividable(temporary, number)){
                break;
            } else {
                addList(temporary);
            }
        }
        return temporary.size();
    }
    public static void main(String[]args){
        try {
            int number;
            Scanner source = new Scanner(new File("Ones.txt"));
            while (source.hasNext()){
                number = source.nextInt();
                System.out.println(divide(number));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
