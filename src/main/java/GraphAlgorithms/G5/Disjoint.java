package GraphAlgorithms.G5;/* Created by oguzkeremyildiz on 25.05.2020 */

import Cookies.Set.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Disjoint<T> extends DisjointSet<T> {

    private HashMap<Integer, HashSet<Integer>> enemies;

    public Disjoint(ArrayList<T> elements) {
        super(elements);
        enemies = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            enemies.put(i, new HashSet<>());
        }
    }

    public HashMap<Integer, HashSet<Integer>> getEnemies() {
        return enemies;
    }

    public void commonEnemyMakesFriend(){
        for (Integer item1 : enemies.keySet()) {
            for (Integer item2 : enemies.keySet()) {
                if (!item1.equals(item2)){
                    HashSet<Integer> enemyList = (HashSet<Integer>) enemies.get(item1).clone();
                    for (int enemy : enemyList){
                        if (enemies.get(item2).contains(enemy)){
                            union(item1, item2);
                        }
                    }
                }
            }
        }
    }

    public void updateEnemyList(){
        for (int i = 0; i < enemies.keySet().size(); i++){
            HashSet<Integer> removeList = new HashSet<>();
            HashSet<Integer> addedList = new HashSet<>();
            for (Integer item1 : enemies.get(i)){
                int representative = findSet(item1);
                if (item1 != representative){
                    removeList.add(item1);
                }
                addedList.add(representative);
            }
            enemies.get(i).removeAll(removeList);
            enemies.get(i).addAll(addedList);
        }
    }

    public void setEnemies(int element1, int element2) {
        int set1 = findSet(element1);
        int set2 = findSet(element2);
        enemies.get(set1).add(set2);
        enemies.get(set2).add(set1);
        commonEnemyMakesFriend();
        updateEnemyList();
    }

    public boolean isEnemy(int element1, int element2) {
        int set1 = findSet(element1);
        int set2 = findSet(element2);
        return enemies.get(set1).contains(set2);
    }

    @Override
    public void union(int element1, int element2) {
        int set1 = findSet(element1);
        int set2 = findSet(element2);
        super.union(element1, element2);
        int newSet = findSet(element1);
        if (set1 == newSet) {
            enemies.get(newSet).addAll(enemies.get(set2));
            enemies.get(set2).clear();
        } else {
            enemies.get(newSet).addAll(enemies.get(set1));
            enemies.get(set1).clear();
        }
        commonEnemyMakesFriend();
        updateEnemyList();
    }
}
