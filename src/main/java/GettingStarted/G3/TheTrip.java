package GettingStarted.G3;

import java.util.ArrayList;
import java.util.Scanner;

public class TheTrip {
    public static void moneyTransfer(ArrayList<Integer> moneys){
        int transfer = 0;
        int total = 0;

        for (Integer integer : moneys) {
            total += integer;
        }
        total = total / moneys.size();
        for (int z = 0; z < moneys.size(); z++){
            if (moneys.get(z) < total){
                transfer += total - moneys.get(z);
            }
            if (moneys.get(z) > total){
                moneys.set(z, total);
            }
        }
        System.out.println("$" + transfer / 100.00);
        moneys.clear();
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> moneys = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int number = input.nextInt();
        System.out.println("Enter the moneys:");
        for (int i = 0; i < number; i++){
            moneys.add((int) (input.nextDouble() * 100));
        }
        moneyTransfer(moneys);
        moneys.clear();
        while (number != 0){
            System.out.println("Enter the number of people:");
            number = input.nextInt();
            if (number != 0){
                System.out.println("Enter the moneys:");
                for (int i = 0; i < number; i++){
                    moneys.add((int) (input.nextDouble() * 100.00));
                }
                moneyTransfer(moneys);
            }
        }
    }
}
