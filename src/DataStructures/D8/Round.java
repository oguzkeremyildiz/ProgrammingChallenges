package DataStructures.D8;/* Created by oguzkeremyildiz on 1.02.2020 */

import java.util.ArrayList;
import java.util.Collections;

public class Round {
    ArrayList<Integer> dices;

    public Round(ArrayList<Integer> dices){
        this.dices = dices;
        sort();
    }

    public int getDice(int index){
        return dices.get(index);
    }

    public void sort(){
        Collections.sort(dices);
    }

    public int sum(){
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

    public int basicCategories(int dice){
        int sum = 0;
        for (int i = 0; i < dices.size(); i++){
            if (dices.get(i) == dice){
                sum += dice;
            }
        }
        return sum;
    }

    public int maxOfAKind(){
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

    public int fiveOfAKind(){
        if (maxOfAKind() == 5){
            return 50;
        } else {
            return 0;
        }
    }

    public int fourOfAKind(){
        if (maxOfAKind() >= 4){
            return sum();
        } else {
            return 0;
        }
    }

    public int threeOfAKind(){
        if (maxOfAKind() >= 3){
            return sum();
        } else {
            return 0;
        }
    }

    public int longStraight(){
        for (int i = 0; i < dices.size() - 1; i++){
            if (dices.get(i) + 1 != dices.get(i + 1)){
                return 0;
            }
        }
        return 35;
    }

    public int shortStraight(){
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

    public int fullHouse(){
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

}
