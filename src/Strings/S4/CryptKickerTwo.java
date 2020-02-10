package Strings.S4;/* Created by oguzkeremyildiz on 10.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CryptKickerTwo {
    private static void print(ArrayList<String> codes, HashMap<Character, Character> convert){
        for (String code : codes) {
            for (int j = 0; j < code.length(); j++) {
                System.out.print(convert.get(code.charAt(j)));
            }
            System.out.print(" ");
        }
    }
    private static boolean isSuitable(ArrayList<String> currentCodes, ArrayList<String> words){
        boolean bool = false;
        HashSet<Character> codesHash = new HashSet<>();
        HashSet<Character> wordsHash = new HashSet<>();
        for (int i = 0; i < currentCodes.size(); i++){
            for (int j = 0; j < currentCodes.get(i).length(); j++){
                wordsHash.add(words.get(i).charAt(j));
                codesHash.add(currentCodes.get(i).charAt(j));
            }
        }
        if (wordsHash.size() == codesHash.size()){
            bool = true;
        }
        return bool;
    }
    private static void findCharacter(ArrayList<String> words, ArrayList<String> codes, HashMap<Character, Character> convert){
        int j = 0;
        int start = 0;
        int m = 0;
        ArrayList<String> currentCodes = new ArrayList<>();
        for (int i = 0; i < codes.size(); i++){
            if (j == words.size()){
                if (isSuitable(currentCodes, words)){
                    break;
                } else {
                    j = 0;
                }
            }
            if (words.get(j).length() == codes.get(i).length()){
                j++;
                if (j == 1){
                    start = i;
                }
                currentCodes.add(codes.get(i));
            } else {
                j = 0;
                currentCodes.clear();
                if (words.get(j).length() == codes.get(i).length()){
                    j++;
                    if (j == 1){
                        start = i;
                    }
                    currentCodes.add(codes.get(i));
                }
            }
        }
        for (int t = start; t < codes.size() + start; t++){
            if (m == 9){
                break;
            }
            for (int n = 0; n < codes.get(t).length(); n++){
                if (!convert.containsKey(codes.get(t).charAt(n))){
                    convert.put(codes.get(t).charAt(n), words.get(m).charAt(n));
                }
            }
            m++;
        }
    }
    public static void main(String[]args){
        try {
            String code;
            ArrayList<String> words = new ArrayList<>();
            ArrayList<String> codes = new ArrayList<>();
            HashMap<Character, Character> convert = new HashMap<>();
            words.add("the");
            words.add("quick");
            words.add("brown");
            words.add("fox");
            words.add("jumps");
            words.add("over");
            words.add("the");
            words.add("lazy");
            words.add("dog");
            Scanner source = new Scanner(new File("CryptTwo.txt"));
            while (source.hasNext()){
                code = source.next();
                codes.add(code);
            }
            findCharacter(words, codes, convert);
            print(codes, convert);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
