package Combinatorics;

import java.util.ArrayList;
import java.util.Scanner;

public class Steps {
    public static int numberTotal(int number){
        int total = 0;
        if (number == 0){
            return 0;
        }else {
            for (int i = 1; i <= number; i++){
                total += i;
            }
        }
        return total;
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int numberOfEntries = input.nextInt();
        for (int i = 1; i <= numberOfEntries; i++){
            int number1 = input.nextInt();
            int number2 = input.nextInt();
            int number = number2 - number1;
            int numberYD = 0;
            ArrayList<Integer> shortCut = new ArrayList<>();
            if (number2 > number1){
                while (number != 0){
                    while (numberTotal(numberYD) < number){
                        numberYD++;
                        if (numberTotal(numberYD) < number){
                            if (numberYD != 0){
                                number -= numberYD;
                                shortCut.add(numberYD);
                            }
                        }
                    }while (numberTotal(numberYD) == number){
                        number -= numberYD;
                        if (numberYD != 0){
                            shortCut.add(numberYD);
                        }
                    }while (numberTotal(numberYD) > number){
                        numberYD--;
                        if (numberYD != 0){
                            number -= numberYD;
                            shortCut.add(numberYD);
                        }
                    }
                }
            }
            System.out.print(shortCut.size());
        }
    }
}
