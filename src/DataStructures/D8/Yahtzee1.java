package DataStructures.D8;/* Created by oguzkeremyildiz on 30.01.2020 */

import Util.Permutation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee1 {
    private static String[] items = {"ones", "twos", "threes", "fours", "fives", "sixes",
    "chance", "threeOfAKind", "fourOfAKind", "fiveOfAKind", "shortStraight", "longStraight", "fullHouse"};

    public static void main(String[]args){
        try {
            int i;
            ArrayList<Round> rounds = new ArrayList<>();
            Scanner source = new Scanner(new File("Yahtzee.txt"));
            String readNext;
            int[] points = new int[13];
            i = 0;
            while (source.hasNext()){
                i++;
                readNext = source.nextLine();
                rounds.add(new Round(readNext));
                if (i % 13 == 0){
                    Permutation permutation = new Permutation(13);
                    int bestPoint = 0;
                    do{
                       int[] assignments = permutation.get();
                       int point = 0;
                       for (int k = 0; k < 13; k++){
                           Round currentRound = rounds.get(k);
                           points[assignments[k]] = currentRound.calculate(assignments[k]);
                           point += points[assignments[k]];
                       }
                        int bonusPoint = 0;
                        for (int k = 0; k < 6; k++){
                            bonusPoint += points[k];
                        }
                        if (bonusPoint > 62){
                            point += 35;
                        }
                       if (point > bestPoint){
                           for (int k = 0; k < 13; k++){
                               rounds.get(k).print(items[assignments[k]]);
                           }
                           bestPoint = point;
                           for (int k = 0; k < 13; k++){
                               System.out.print(points[k] + " ");
                           }
                           if (bonusPoint > 62){
                               System.out.println("35 " + bestPoint);
                           } else {
                               System.out.println("0 " + bestPoint);
                           }
                       }
                    }while(permutation.next());
                    rounds.clear();
                    i = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
