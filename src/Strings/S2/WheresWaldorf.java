package Strings.S2;/* Created by oguzkeremyildiz on 8.02.2020 */

import java.io.File;
import java.util.Scanner;

public class WheresWaldorf {
    private static void findWord(String[][] table, String[] words){
        int wordSize = 1;
        for (String word : words) {
            for (int j = 0; j < table.length; j++) {
                for (int k = 0; k < table[0].length; k++) {
                    if ((word.charAt(0) + "").equalsIgnoreCase((table[j][k].charAt(0) + ""))) {
                        if (j - 1 >= 0 && k - 1 >= 0) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j - 1][k - 1].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (j - m >= 0 && k - m >= 0) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j - m][k - m].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (j - 1 >= 0 && k + 1 <= table[0].length) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j - 1][k + 1].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (j - m >= 0 && k + m <= table[0].length) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j - m][k + m].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (j + 1 <= table.length && k - 1 >= 0) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j + 1][k - 1].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (j + m <= table.length && k - m >= 0) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j + m][k - m].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (j + 1 <= table.length && k + 1 <= table[0].length) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j + 1][k + 1].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (j + m <= table.length && k + m <= table[0].length) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j + m][k + m].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (j + 1 <= table.length) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j + 1][k].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (j + m <= table.length) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j + m][k].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (j - 1 >= 0) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j - 1][k].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (j - m >= 0) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j - m][k].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (k + 1 <= table[0].length) {
                            wordSize = 1;
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j][k + 1].charAt(0) + ""))) {
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (k + m <= table.length) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j][k + m].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                        if (k - 1 >= 0) {
                            if ((word.charAt(1) + "").equalsIgnoreCase((table[j][k - 1].charAt(0) + ""))) {
                                wordSize = 1;
                                for (int m = 1; m <= word.length() - 1; m++) {
                                    if (k - m >= 0) {
                                        if ((word.charAt(m) + "").equalsIgnoreCase((table[j][k - m].charAt(0) + ""))) {
                                            wordSize++;
                                        }
                                    }
                                }
                                if (wordSize == word.length()) {
                                    System.out.println(j + 1 + " " + (k + 1));
                                    break;
                                }
                            }
                        }
                    }
                }
                if (wordSize == word.length()) {
                    wordSize = 1;
                    break;
                }
            }
        }
    }
    public static void main(String[]args){
        int tables;
        int horizontal;
        int vertical;
        int wordsNumber;
        try {
            Scanner source = new Scanner(new File("Waldorf.txt"));
            tables = source.nextInt();
            String[][] table;
            String[] words;
            String question;
            String currentCharacter;
            for (int i = 0; i < tables; i++){
                vertical = source.nextInt();
                horizontal = source.nextInt();
                table = new String[vertical][horizontal];
                for (int j = 0; j < table.length; j++){
                    for (int k = 0; k < table[0].length; k++){
                        currentCharacter = source.next();
                        table[j][k] = currentCharacter;
                    }
                }
                wordsNumber = source.nextInt();
                words = new String[wordsNumber];
                for (int t = 0; t < wordsNumber; t++){
                    question = source.next();
                    words[t] = question;
                }
                findWord(table, words);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
