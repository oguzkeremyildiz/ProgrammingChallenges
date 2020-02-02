package Strings;/* Created by oguzkeremyildiz on 2.02.2020 */

import java.io.File;
import java.util.Scanner;

public class WERTYU {
    public static void main(String[]args){
        try {
            String strings;
            char[] characters;
            char[] keyboard = {'\'', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
            Scanner source = new Scanner(new File("Keyboard.txt"));
            while (source.hasNext()){
                strings = source.next();
                characters = strings.toCharArray();
                for (int i = 0; i < characters.length; i++){
                    for (int j = 0; j < keyboard.length; j++){
                        if (characters[i] == keyboard[j]) {
                            System.out.print(keyboard[j - 1]);
                        }
                    }
                }
                System.out.print(" ");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
