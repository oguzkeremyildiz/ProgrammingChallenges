package DataStructures.D8;/* Created by oguzkeremyildiz on 30.01.2020 */

import Util.Permutation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee1 {

    public static void main(String[]args){
        try {
            int i;
            ArrayList<Round> rounds = new ArrayList<>();
            Scanner source = new Scanner(new File("Yahtzee.txt"));
            String readNext;
            String split[];
            int[] points = new int[13];
            int splitInt;
            i = 0;
            while (source.hasNext()){
                i++;
                readNext = source.nextLine();
                split = readNext.split(" ");
                ArrayList<Integer> dices = new ArrayList<>();
                for (int t = 0; t < split.length; t++){
                    splitInt = Integer.parseInt(split[t]);
                    dices.add(splitInt);
                }
                rounds.add(new Round(dices));
                if (i % 13 == 0){
                    Permutation permutation = new Permutation(13);
                    int bestPoint = 0;
                    do{
                       int[] assignments = permutation.get();
                       for (int k = 0; k < 13; k++){
                           Round currentRound = rounds.get(k);
                           switch (assignments[k]){
                               case 0:
                                   points[assignments[k]] = currentRound.basicCategories(1);
                                   break;
                               case 1:
                                   points[assignments[k]] = currentRound.basicCategories(2);
                                   break;
                               case 2:
                                   points[assignments[k]] = currentRound.basicCategories(3);
                                   break;
                               case 3:
                                   points[assignments[k]] = currentRound.basicCategories(4);
                                   break;
                               case 4:
                                   points[assignments[k]] = currentRound.basicCategories(5);
                                   break;
                               case 5:
                                   points[assignments[k]] = currentRound.basicCategories(6);
                                   break;
                               case 6:
                                   points[assignments[k]] = currentRound.sum();
                                   break;
                               case 7:
                                   points[assignments[k]] = currentRound.threeOfAKind();
                                   break;
                               case 8:
                                   points[assignments[k]] = currentRound.fourOfAKind();
                                   break;
                               case 9:
                                   points[assignments[k]] = currentRound.fiveOfAKind();
                                   break;
                               case 10:
                                   points[assignments[k]] = currentRound.shortStraight();
                                   break;
                               case 11:
                                   points[assignments[k]] = currentRound.longStraight();
                                   break;
                               case 12:
                                   points[assignments[k]] = currentRound.fullHouse();
                                   break;
                           }
                       }
                        int point = 0, bonusPoint = 0;
                        for (int k = 0; k < 13; k++){
                            point += points[k];
                        }
                        for (int k = 0; k < 6; k++){
                            bonusPoint += points[k];
                        }
                        if (bonusPoint > 62){
                            point += 35;
                        }
                       if (point > bestPoint){
                           for (int k = 0; k < 13; k++){
                               switch (assignments[k]){
                                   case 0:
                                       rounds.get(k).print("ones");
                                       break;
                                   case 1:
                                       rounds.get(k).print("twos");
                                       break;
                                   case 2:
                                       rounds.get(k).print("threes");
                                       break;
                                   case 3:
                                       rounds.get(k).print("fours");
                                       break;
                                   case 4:
                                       rounds.get(k).print("fives");
                                       break;
                                   case 5:
                                       rounds.get(k).print("sixes");
                                       break;
                                   case 6:
                                       rounds.get(k).print("chance");
                                       break;
                                   case 7:
                                       rounds.get(k).print("threeOfAKind");
                                       break;
                                   case 8:
                                       rounds.get(k).print("fourOfAKind");
                                       break;
                                   case 9:
                                       rounds.get(k).print("fiveOfAKind");
                                       break;
                                   case 10:
                                       rounds.get(k).print("shortStraight");
                                       break;
                                   case 11:
                                       rounds.get(k).print("longStraight");
                                       break;
                                   case 12:
                                       rounds.get(k).print("fullHouse");
                                       break;
                               }
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
