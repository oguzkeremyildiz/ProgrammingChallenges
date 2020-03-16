package GettingStarted.G1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class The3nPlus1 {
    private static int rule(int number1, int number2){
        int biggest = 0;
        int count = 0;
        if (number2 > number1){
            for (int i = number1; i <= number2; i++){
                int temporary = i;
                count++;
                while (temporary != 1){
                    if (temporary % 2 == 0){
                        temporary /= 2;
                        count++;
                    } else{
                        temporary *= 3;
                        temporary += 1;
                        count++;
                    }
                }
                if (count > biggest){
                    biggest = count;
                }
                count = 0;
            }
        }
        return biggest;
    }

    public static void main(String[]args){
        int i = 0;
        ArrayList<Integer> number = new ArrayList<>();
        try {
            Scanner source = new Scanner(new File("Numbers.txt"));
            while (source.hasNext()){
                i++;
                number.add(source.nextInt());
                if (i % 2 == 0){
                    System.out.println(number.get(i - 2) + " " + number.get(i - 1) + " " + rule(number.get(i - 2), number.get(i - 1)));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
