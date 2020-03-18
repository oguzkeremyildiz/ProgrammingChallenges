package ArithmeticAndAlgebra.A1;/* Created by oguzkeremyildiz on 18.03.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimaryArithmetic {
    private static void print(int number1, int number2){
        if (carry(number1, number2) >  1){
            System.out.println(carry(number1, number2) + " carry operations.");
        } else if (carry(number1, number2) == 1){
            System.out.println("1 carry operation.");
        } else {
            System.out.println("No carry.");
        }
    }
    private static int carry(int number1, int number2){
        int carry = 0;
        int t = 0;
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        reserve(numbers1, numbers2, number1, number2);
        if (numbers1.size() > numbers2.size()){
            for (int i = 0; i < numbers1.size(); i++) {
                if (i < numbers2.size()){
                    if (numbers1.get(i) + numbers2.get(i) + t > 9){
                        carry++;
                        t = 1;
                    } else {
                        t = 0;
                    }
                } else {
                    if (numbers1.get(i) + t > 9){
                        carry++;
                        t = 1;
                    } else {
                        t = 0;
                    }
                }
            }
        } else if (numbers2.size() > numbers1.size()){
            for (int i = 0; i < numbers2.size(); i++) {
                if (i < numbers1.size()){
                    if (numbers2.get(i) + numbers1.get(i) + t > 9){
                        carry++;
                        t = 1;
                    } else {
                        t = 0;
                    }
                } else {
                    if (numbers2.get(i) + t > 9){
                        carry++;
                        t = 1;
                    } else {
                        t = 0;
                    }
                }
            }
        } else {
            for (int i = 0; i < numbers1.size(); i++) {
                if (numbers1.get(i) + numbers2.get(i) + t > 9){
                    carry++;
                    t = 1;
                } else {
                    t = 0;
                }
            }
        }
        return carry;
    }
    private static void reserve(ArrayList<Integer> numbers1, ArrayList<Integer> numbers2, int number1, int number2){
        while (number1 != 0){
            numbers1.add(number1 % 10);
            number1 -= number1 % 10;
            number1 /= 10;
        }
        while (number2 != 0){
            numbers2.add(number2 % 10);
            number2 -= number2 % 10;
            number2 /= 10;
        }
    }
    public static void main(String[]args){
        try {
            Scanner source = new Scanner(new File("Arithmetic.txt"));
            int number1;
            int number2;
            while (true){
                number1 = source.nextInt();
                number2 = source.nextInt();
                if (number1 != 0 || number2 != 0){
                    print(number1, number2);
                } else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
