package GraphAlgorithms.G5;/* Created by oguzkeremyildiz on 23.05.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class War {

    private static void displaySets(Disjoint<Integer> set, int size){
        for (int i = 0; i < size; i++){
            if (set.findSet(i) == i){
                int count = 0;
                for (int j = 0; j < size; j++){
                    if (set.findSet(j) == i){
                        count++;
                    }
                }
                if (count > 1){
                    System.out.println("SET: " + i);
                    for (int j = 0; j < size; j++){
                        if (set.findSet(j) == i){
                            System.out.print(j + " ");
                        }
                    }
                    System.out.println();
                }
                if (set.getEnemies().get(i).size() > 0){
                    System.out.println("ENEMIES: " + i);
                    for (int enemy : set.getEnemies().get(i)){
                        System.out.print(enemy + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void setDisjoint(Disjoint<Integer> set, int command, int nodeOne, int nodeTwo) {
        switch (command) {
            case 1:
                if (set.isEnemy(nodeOne, nodeTwo)) {
                    System.out.println("-1");
                } else {
                    if (set.findSet(nodeOne) != set.findSet(nodeTwo)){
                        set.union(nodeOne, nodeTwo);
                    }
                }
                break;
            case 2:
                if (set.findSet(nodeOne) == set.findSet(nodeTwo)) {
                    System.out.println("-1");
                } else {
                    if (!set.isEnemy(nodeOne, nodeTwo)){
                        set.setEnemies(nodeOne, nodeTwo);
                    }
                }
                break;
            case 3:
                if (set.findSet(nodeOne) == set.findSet(nodeTwo)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
                break;
            case 4:
                if (set.isEnemy(nodeOne, nodeTwo)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Friend.txt"));
            int size = source.nextInt();
            ArrayList<Integer> elements = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                elements.add(i);
            }
            Disjoint<Integer> set = new Disjoint<>(elements);
            while (source.hasNext()) {
                int command = source.nextInt();
                int nodeOne = source.nextInt();
                int nodeTwo = source.nextInt();
                if (command == 0 && nodeOne == 0 && nodeTwo == 0) {
                    break;
                } else {
                    setDisjoint(set, command, nodeOne, nodeTwo);
                    //displaySets(set, size);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
