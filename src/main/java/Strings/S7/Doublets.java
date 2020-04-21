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
    private static void setList(HashMap<Integer, ArrayList<String>> matches, int index, ArrayList<String> listInfinities, String word, List<String> words, ArrayList<String> dictionary){
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
        if (matches.get(index).contains(words.get(1))){
            listInfinities.clear();
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
    private static void addList(HashMap<Integer, ArrayList<String>> matches, List<String> words, int check, ArrayList<String> outputs){
        String current = "";
        ArrayList<String> removed = new ArrayList<>();
        if (check == 0){
            for (int t = 0; t < matches.get(matches.size() - 2).size(); t++){
                if (matches.get(matches.size() - 2).get(t).equals(words.get(1))){
                    current  = matches.get(matches.size() - 2).get(t);
                } else {
                    removed.add(matches.get(matches.size() - 2).get(t));
                }
            }
            for (String s : removed) {
                matches.get(matches.size() - 2).remove(s);
            }
            outputs.add(current);
            for (int i = 0; i < matches.size() - 1; i++){
                for (int j = 0; j < matches.get(matches.size() - 2 - i).size(); j++){
                    if (difference(matches.get(matches.size() - 2 - i).get(j), current) == 1){
                        outputs.add(matches.get(matches.size() - 2 - i).get(j));
                        current = matches.get(matches.size() - 2 - i).get(j);
                    }
                }
            }
            outputs.add(words.get(0));
        }
    }
    private static void print(ArrayList<String> outputs){
        for (int i = 0; i < outputs.size(); i++){
            System.out.println(outputs.get(outputs.size() - 1 - i));
        }
    }
    public static void main(String[]args){
        try {
            int index;
            int check;
            int i = 0;
            String current;
            HashMap<Integer, ArrayList<String>> matches = new HashMap<>();
            ArrayList<String> outputs = new ArrayList<>();
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
                    outputs.clear();
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
                        setList(matches, index, listInfinities, words.get(0), words, dictionary);
                    }
                    matches.get(10000).removeAll(matches.get(10000));
                    addList(matches, words, check, outputs);
                    print(outputs);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
