package Sorting.S5;/* Created by oguzkeremyildiz on 7.03.2020 */

import Cookies.Util.Permutation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoemakersProblem {
    public static void tryAll(ArrayList<Shoe> shoes, int size){
        Permutation p = new Permutation(size);
        ArrayList<Integer> currentShoesIndex = new ArrayList<>();
        ArrayList<Integer> shoesIndex = new ArrayList<>();
        int wholeTime;
        int wholeCent = 0;
        int currentWholeCent;
        do{
            int[] list = p.get();
            currentShoesIndex.clear();
            wholeTime = 0;
            currentWholeCent = 0;
            for (int value : list) {
                currentWholeCent += wholeTime * shoes.get(value).getCent();
                wholeTime += shoes.get(value).getTime();
                currentShoesIndex.add(shoes.get(value).getIndex());
            }
            if (wholeCent == 0){
                wholeCent = currentWholeCent;
                shoesIndex.addAll(currentShoesIndex);
            } else if (currentWholeCent < wholeCent){
                wholeCent = currentWholeCent;
                shoesIndex.clear();
                shoesIndex.addAll(currentShoesIndex);
            }
        }while (p.next());
        System.out.println(shoesIndex);
    }
    public static void main(String[]args){
        try {
            int scenario;
            int shoesTimes;
            int time;
            int cent;
            Scanner source = new Scanner(new File("Shoes.txt"));
            scenario = source.nextInt();
            ArrayList<Shoe> shoes;
            for (int i = 0; i < scenario; i++){
                shoesTimes = source.nextInt();
                shoes = new ArrayList<>();
                for (int j = 0; j < shoesTimes; j++){
                    time = source.nextInt();
                    cent = source.nextInt();
                    shoes.add(new Shoe(time, cent, j + 1));
                }
                tryAll(shoes, shoesTimes);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
