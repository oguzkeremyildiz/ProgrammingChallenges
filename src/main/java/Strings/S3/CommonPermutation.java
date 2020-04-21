package Strings.S3;/* Created by oguzkeremyildiz on 9.02.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CommonPermutation {
    public static void commonCharacters(ArrayList<Character> charactersList1, ArrayList<Character> charactersList2){
        int i = 0;
        int j = 0;
        while (i < charactersList1.size() && j < charactersList2.size()){
            if (charactersList1.get(i).equals(charactersList2.get(j))){
                System.out.print(charactersList1.get(i));
                i++;
                j++;
            } else if (charactersList1.get(i) < charactersList2.get(j)){
                i++;
            } else if (charactersList2.get(j) < charactersList1.get(i)){
                j++;
            }
        }
    }
    public static void sort(ArrayList<Character> list){
        Collections.sort(list);
    }
    public static void main(String[]args){
        try {
            String firstWord;
            ArrayList<Character> charactersList1 = new ArrayList<>();
            String secondWord;
            ArrayList<Character> charactersList2 = new ArrayList<>();
            Scanner source = new Scanner(new File("Permutation.txt"));
            while (source.hasNext()){
                firstWord = source.next();
                for (int i = 0; i < firstWord.length(); i++){
                    charactersList1.add(firstWord.charAt(i));
                }
                secondWord = source.next();
                for (int j = 0; j < secondWord.length(); j++){
                    charactersList2.add(secondWord.charAt(j));
                }
                sort(charactersList1);
                sort(charactersList2);
                commonCharacters(charactersList1, charactersList2);
                System.out.println();
                charactersList1.clear();
                charactersList2.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
