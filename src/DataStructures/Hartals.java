package DataStructures;/* Created by oguzkeremyildiz on 18.01.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Hartals {
    private static int hartals(int days, ArrayList<Integer> numbers){
        HashSet<Integer> number = new HashSet<>();
        for (Integer integer : numbers) {
            for (int j = 1; j <= days; j++) {
                if (j % 7 != 0 && j % 7 != 6) {
                    if (j % integer == 0) {
                        number.add(j);
                    }
                }
            }
        }
        return number.size();
    }
    public static void main(String[]args){
        int times;
        int days;
        int party;
        int day;
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner source = new Scanner(new File("Hartals.txt"));
            times = source.nextInt();
            for (int i = 0; i < times; i++){
                days = source.nextInt();
                party = source.nextInt();
                for (int j = 0; j < party; j++){
                    day = source.nextInt();
                    numbers.add(day);

                }
                System.out.println(hartals(days,numbers));
                numbers.clear();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
