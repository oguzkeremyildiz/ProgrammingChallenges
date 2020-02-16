package Strings.S7;/* Created by oguzkeremyildiz on 16.02.2020 */

import java.io.File;
import java.util.*;

public class Doublets {
    private static int difference(String word, String current){
        int difference = 0;
        if (word.length() == current.length()){
            for (int i = 0; i < current.length(); i++){
                if (word.charAt(i) != current.charAt(i)){
                    difference++;
                }
            }
        }
        return difference;
    }
    private static void setListForOnes(HashMap<Integer, ArrayList<String>> matches, ArrayList<String> dictionary, List<String> words){
        matches.put(0, new ArrayList<>());
        for (String s : dictionary) {
            if (difference(words.get(0), s) == 1) {
                matches.get(0).add(s);
            }
        }
    }
    private static void setListForInfinities(HashMap<Integer, ArrayList<String>> matches, ArrayList<String> dictionary, List<String> words){
        matches.put(10000, new ArrayList<>());
        for (String s : dictionary) {
            if (!matches.get(0).contains(s)) {
                if (!s.equals(words.get(0))) {
                    matches.get(10000).add(s);
                }
            }
        }
    }
    private static void setList(HashMap<Integer, ArrayList<String>> matches, int index, ArrayList<String> listInfinities, String word, ArrayList<String> dictionary){
        int current;
        matches.put(index, new ArrayList<>());
        ArrayList<String> listOnes = new ArrayList<>(matches.get(index - 1));
        for (String listOne : listOnes) {
            for (int j = 0; j < listInfinities.size(); j++) {
                if (difference(listOne, listInfinities.get(j)) == 1) {
                    matches.get(index).add(listInfinities.get(j));
                    listInfinities.remove(listInfinities.get(j));
                }
            }
        }
        if (matches.containsKey(dictionary.size() + 2)){
            System.out.println("No solution.");
            listInfinities.clear();
        }
        for (int t = 0; t < listInfinities.size(); t++){
            current = difference(word, listInfinities.get(t));
            if (matches.containsKey(current)){
                if (matches.get(current).size() > 0){
                    listInfinities.remove(listInfinities.get(t));
                }
            }
        }
    }
    private static void print(HashMap<Integer, ArrayList<String>> matches, List<String> words, int check){
        if (check == 0)
        if (matches.get(matches.size() - 2).get(0).equals(words.get(1))){
            String current = matches.get(matches.size() - 2).get(0);
            System.out.println(current);
            for (int i = 0; i < matches.size() - 1; i++){
                for (int j = 0; j < matches.get(matches.size() - 2 - i).size(); j++){
                    if (difference(matches.get(matches.size() - 2 - i).get(j), current) == 1){
                        System.out.println(matches.get(matches.size() - 2 - i).get(j));
                        current = matches.get(matches.size() - 2 - i).get(j);
                    }
                }
            }
            System.out.println(words.get(0));
        }
    }
    public static void main(String[]args){
        try {
            int index;
            int check;
            int i = 0;
            String current;
            HashMap<Integer, ArrayList<String>> matches = new HashMap<>();
            ArrayList<String> dictionary = new ArrayList<>();
            ArrayList<String> listInfinities;
            List<String> words = new ArrayList<>();
            String[] split;
            Scanner source = new Scanner(new File("Doublets.txt"));
            while (source.hasNext()){
                    if (i == 0){
                        current = source.nextLine();
                        if (!current.equals("-")){
                            dictionary.add(current);
                        } else {
                            i++;
                        }
                    }
                if (i > 0){
                    words.clear();
                    index = 0;
                    check = 0;
                    current = source.nextLine();
                    split = current.split(" ");
                    words = new ArrayList<>(Arrays.asList(split));
                    matches.clear();
                    setListForOnes(matches, dictionary, words);
                    setListForInfinities(matches, dictionary, words);
                    listInfinities = new ArrayList<>(matches.get(10000));
                    while (listInfinities.size() != 0){
                        if (matches.containsKey(dictionary.size() + 1)){
                           check = 1;
                        }
                        index++;
                        setList(matches, index, listInfinities, words.get(0), dictionary);
                    }
                    matches.get(10000).removeAll(matches.get(10000));
                    print(matches, words, check);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
