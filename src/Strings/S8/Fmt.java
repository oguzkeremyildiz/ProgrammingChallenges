package Strings.S8;/* Created by oguzkeremyildiz on 20.02.2020 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Fmt {
    private static void print(String added){
        String word = "";
        String remaining = "";
        int t = 0;
        if (added.charAt(0) == ' '){
            while (added.charAt(t) == ' '){
                remaining += " ";
                t++;
            }
        }
        for (int i = 0; i < added.length(); i++) {
            if (added.charAt(i) != ' '){
                word += added.charAt(i);
            } else {
                if (remaining.length() + word.length() < 72){
                    if (remaining.length() == 0){
                        remaining = word;
                    } else {
                        remaining += " " + word;
                    }
                } else {
                    System.out.println(remaining);
                    remaining = word;
                }
                word = "";
            }
        }
        if (word.length() != 0){
            remaining += " " + word;
        }
        System.out.println(remaining);
    }
    public static void main(String[]args){
        try {
            String line;
            String added = "";
            int i = 0;
            Scanner source = new Scanner(new File("Unix.txt"));
            while (true){
                line = source.nextLine();
                if (!line.equals("")){
                    if (i == 0){
                        added += "";
                        i++;
                    } else {
                        added += " ";
                    }
                    added += line;
                } else {
                    if (added.length() > 72){
                        print(added);
                        System.out.println();
                        added = "";
                         i = 0;
                    } else {
                        System.out.print(added);
                        added = "";
                        System.out.println();
                        i = 0;
                    }
                }
            }
        }catch (NoSuchElementException | FileNotFoundException e){
        }
    }
}
