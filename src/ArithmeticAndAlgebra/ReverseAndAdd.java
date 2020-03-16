package ArithmeticAndAlgebra;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseAndAdd {
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
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int numberT = number;
        int temporary;
        ArrayList<Integer> digitReverse = new ArrayList<>();
        while (number != 0){
            temporary = number % 10;
            number = (number - temporary) / 10;
            digitReverse.add(temporary);
        }
        int numberTReverse = 0;

        for (int i = 0; i < digitReverse.size(); i++){
            numberTReverse += digitReverse.get(digitReverse.size() - i - 1) * power(10,i);
        }
        int output = numberT + numberTReverse;
        System.out.println("total: " + output);
    }
}
