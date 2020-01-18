package DataStructures;/* Created by oguzkeremyildiz on 18.01.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Hartals {
    private static int hartals(int days, ArrayList<Integer> number){
        int h = 0;
        for (int t = 0; t < number.size(); t++){
            for (int i = 1; i <= days; i++){
                if (i % 7 != 0 && i % 7 != 6){
                    if (t == 0){
                        if (i % number.get(t) == 0){
                            h++;
                        }
                    } else {
                        for (int z = 0; z < t; z++){
                            if (i % number.get(z) == 0){
                                    break;
                            } else {
                                if (z == t - 1){
                                    if (i % number.get(t) == 0){
                                        h++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return h;
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
