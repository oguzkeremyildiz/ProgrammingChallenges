package DataStructures.D8;/* Created by oguzkeremyildiz on 1.02.2020 */

import java.util.ArrayList;
import java.util.Collections;

public class Round {
    ArrayList<Integer> dices;

    public Round(String readNext){
        String[] split = readNext.split(" ");
        dices = new ArrayList<>();
        for (int t = 0; t < split.length; t++){
            int splitInt = Integer.parseInt(split[t]);
            dices.add(splitInt);
        }
        sort();
    }

    private void sort(){
        Collections.sort(dices);
    }

    private int sum(){
        int sum = 0;
        for (Integer dice : dices){
            sum += dice;
        }
        return sum;
    }

    public void print(String head){
        for (Integer dice : dices){
            System.out.print(dice + " ");
        }
        System.out.println(head);
    }

    private int basicCategories(int dice){
        int sum = 0;
        for (int i = 0; i < dices.size(); i++){
            if (dices.get(i) == dice){
                sum += dice;
            }
        }
        return sum;
    }

    private int maxOfAKind(){
        int count = 1;
        int max = 0;
        int previous = dices.get(0);
        for (int i = 1; i < dices.size(); i++){
            if (dices.get(i) == previous){
                count++;
            } else {
                if (count > max){
                    max = count;
                }
                count = 1;
                previous = dices.get(i);
            }
        }
        if (count > max){
            max = count;
        }
        return max;
    }

    private int fiveOfAKind(){
        if (maxOfAKind() == 5){
            return 50;
        } else {
            return 0;
        }
    }

    private int fourOfAKind(){
        if (maxOfAKind() >= 4){
            return sum();
        } else {
            return 0;
        }
    }

    private int threeOfAKind(){
        if (maxOfAKind() >= 3){
            return sum();
        } else {
            return 0;
        }
    }

    private int longStraight(){
        for (int i = 0; i < dices.size() - 1; i++){
            if (dices.get(i) + 1 != dices.get(i + 1)){
                return 0;
            }
        }
        return 35;
    }

    private int shortStraight(){
        boolean flag = true;
        for (int i = 0; i < dices.size() - 2; i++){
            if (dices.get(i) + 1 != dices.get(i + 1)){
                flag = false;
                break;
            }
        }
        if (flag){
            return 25;
        }
        for (int i = 1; i < dices.size() - 1; i++){
            if (dices.get(i) + 1 != dices.get(i + 1)){
                return 0;
            }
        }
        return 25;
    }

    private int fullHouse(){
        if (dices.get(0).equals(dices.get(1)) && dices.get(3).equals(dices.get(4))){
            if (dices.get(1).equals(dices.get(2)) && !dices.get(2).equals(dices.get(3))){
                return 40;
            }
            if (!dices.get(1).equals(dices.get(2)) && dices.get(2).equals(dices.get(3))){
                return 40;
            }
        }
        return 0;
    }

    public int calculate(int type){
        switch (type){
            case 0:
                return basicCategories(1);
            case 1:
                return basicCategories(2);
            case 2:
                return basicCategories(3);
            case 3:
                 return basicCategories(4);
            case 4:
                return basicCategories(5);
            case 5:
                return basicCategories(6);
            case 6:
                return sum();
            case 7:
                return threeOfAKind();
            case 8:
                return fourOfAKind();
            case 9:
                return fiveOfAKind();
            case 10:
                return shortStraight();
            case 11:
                return longStraight();
            case 12:
                return fullHouse();
        }
        return 0;
    }

}
