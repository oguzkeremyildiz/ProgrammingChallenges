package DataStructures.D4;/* Created by oguzkeremyildiz on 19.01.2020 */

import Tuples.Pair;

import java.io.File;
import java.util.*;

public class CryptKicker {

    private static HashMap<Integer, ArrayList<String>> createWordLists(ArrayList<String> words){
        HashMap<Integer, ArrayList<String>> list = new HashMap<>();
        for (String word : words){
            ArrayList<String> wordList;
            if (list.containsKey(word.length())){
                wordList = list.get(word.length());
            } else {
                wordList = new ArrayList<>();
            }
            if (!wordList.contains(word)){
                wordList.add(word);
            }
            list.put(word.length(), wordList);
        }
        return list;
    }

    private static void print(ArrayList<String> codes, HashMap<Character, Character> codesExplain){
        for (String code : codes) {
            for (int m = 0; m < code.length(); m++) {
                if (codesExplain.get(code.charAt(m)) == null) {
                    System.out.print("*");
                } else {
                    System.out.print(codesExplain.get(code.charAt(m)));
                }
            }
            System.out.print("  ");
        }
    }

    private static void solveForSingleWords(HashMap<Integer, ArrayList<String>> wordList, HashMap<Integer, ArrayList<String>> codeList, HashMap<Character, Character> codesExplain){
        HashSet<Integer> keySet = new HashSet<>();
        for (Integer value : wordList.keySet()){
            keySet.add(value);
        }
        for (Integer key : keySet){
            ArrayList<String> normalList = wordList.get(key);
            ArrayList<String> encryptedList = codeList.get(key);
            if (normalList.size() == 1){
                for (int i = 0; i < normalList.get(0).length(); i++){
                    codesExplain.put(encryptedList.get(0).charAt(i), normalList.get(0).charAt(i));
                }
                wordList.remove(key);
                codeList.remove(key);
            }
        }
    }

    private static ArrayList<Pair<Integer, Integer>> containsRepeatingLetters(String word){
        ArrayList<Pair<Integer, Integer>> repeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++){
            for (int j = i + 1; j < word.length(); j++){
                if (word.charAt(i) == word.charAt(j)){
                    repeating.add(new Pair<>(i, j));
                }
            }
        }
        return repeating;
    }

    private static void solveForRepeatingLetters(HashMap<Integer, ArrayList<String>> wordList, HashMap<Integer, ArrayList<String>> codeList, HashMap<Character, Character> codesExplain){
        for (Integer key : wordList.keySet()){
            ArrayList<String> normalList = wordList.get(key);
            ArrayList<String> encryptedList = codeList.get(key);
            for (String normalWord : normalList){
                ArrayList<Pair<Integer, Integer>> normalPairs = containsRepeatingLetters(normalWord);
                if (normalPairs.size() > 0){
                    for (String encryptedWord : encryptedList){
                        ArrayList<Pair<Integer, Integer>> encryptedPairs = containsRepeatingLetters(encryptedWord);
                        if (encryptedPairs.equals(normalPairs)){
                            for (int i = 0; i < normalWord.length(); i++){
                                codesExplain.put(encryptedWord.charAt(i), normalWord.charAt(i));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void removeFromCandidateList(ArrayList<String> candidateList, int index, Character ch){
        ArrayList<String> removed = new ArrayList<>();
        for (String word : candidateList){
            if (word.charAt(index) != ch){
                removed.add(word);
            }
        }
        candidateList.removeAll(removed);
    }

    private static void solveForRemaining(HashMap<Integer, ArrayList<String>> wordList, HashMap<Integer, ArrayList<String>> codeList, HashMap<Character, Character> codesExplain){
        for (Integer key : wordList.keySet()){
            ArrayList<String> encryptedList = codeList.get(key);
            for (String encryptedWord : encryptedList){
                ArrayList<String> candidateList = (ArrayList<String>) wordList.get(key).clone();
                for (int i = 0; i < encryptedWord.length(); i++){
                    if (codesExplain.containsKey(encryptedWord.charAt(i))){
                        removeFromCandidateList(candidateList, i, codesExplain.get(encryptedWord.charAt(i)));
                    }
                }
                if (candidateList.size() == 1){
                    for (int i = 0; i < encryptedWord.length(); i++){
                        codesExplain.put(encryptedWord.charAt(i), candidateList.get(0).charAt(i));
                    }
                }
            }
        }
    }

    public static void main(String[]args){
        int wordCount;
        String word;
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> codes;
        try {
            Scanner source = new Scanner(new File("Crypt.txt"));
            wordCount = Integer.parseInt(source.nextLine());
            for (int i = 0; i < wordCount; i++){
                word = source.nextLine();
                words.add(word);
            }
            while (source.hasNextLine()){
                String codeLine = source.nextLine();
                codes = new ArrayList<>();
                String[] codeArray = codeLine.split(" ");
                codes.addAll(Arrays.asList(codeArray));
                HashMap<Integer, ArrayList<String>> wordList = createWordLists(words);
                HashMap<Integer, ArrayList<String>> codeList = createWordLists(codes);
                HashMap<Character, Character> codesExplain = new HashMap<>();
                solveForSingleWords(wordList, codeList, codesExplain);
                solveForRepeatingLetters(wordList, codeList, codesExplain);
                solveForRemaining(wordList, codeList, codesExplain);
                print(codes, codesExplain);
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
