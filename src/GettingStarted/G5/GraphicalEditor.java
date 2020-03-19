package GettingStarted.G5;

import java.util.Scanner;

public class GraphicalEditor {
    public static void print(String[][] region){
        for (String[] strings : region) {
            for (int j = 0; j < region[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    public static void charL(String [][] region){
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        String character = input.next();
        region[number2 - 1][number1 - 1] = character;

    }

    public static void charS(String [][] region){
        Scanner input = new Scanner(System.in);
        String sentence = input.next();
        System.out.println(sentence);
        print(region);
        for (int i = 0; i < region.length; i++){
            for (int j = 0; j < region[0].length; j++){
                region[i][j] = "O";
            }
        }
    }

    public static void charFRecursive(String[][] region, int number1, int number2, String character1, String character2){
        if (region[number1][number2].equals(character1)){
            region[number1][number2] = character2;
            if (number1 > 0){
                charFRecursive(region, number1 - 1, number2, character1, character2);
            }
            if (number1 < region.length - 1){
                charFRecursive(region, number1 + 1, number2, character1, character2);
            }
            if (number2 > 0){
                charFRecursive(region, number1, number2 - 1, character1, character2);
            }
            if (number2 < region[0].length - 1){
                charFRecursive(region, number1, number2 + 1, character1, character2);
            }
        }
    }

    public static void charF(String[][] region){
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        String character = input.next();
        charFRecursive(region, number2 - 1, number1 - 1, region[number2 - 1][number1 - 1], character);
    }

    public static void charV(String[][] region){
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();
        String character = input.next();
        for (int i = number2; i <= number3; i++){
            region[i - 1][number1 - 1] = character;
        }
    }

    public static void charC(String[][] region){
        for (int i = 0; i < region.length; i++){
            for (int j = 0; j < region[0].length; j++){
                region[i][j] = "O";
            }
        }
    }

    public static void charH(String[][] region){
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();
        String character = input.next();
        for (int i = number1; i <= number2; i++){
            region[number3 - 1][i - 1] = character;
        }
    }

    public static void charK(String[][] region){
        Scanner input = new Scanner(System.in);
        int X1 = input.nextInt();
        int Y1 = input.nextInt();
        int X2 = input.nextInt();
        int Y2 = input.nextInt();
        String character = input.next();
        for (int i = X1; i <= X2; i++){
            for (int j = Y1; j <= Y2; j++){
                region[j - 1][i - 1] = character;
            }
        }
    }
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        String[][] region = new String[0][0];
        String character = input.next();
        while (!character.equals("X")){
            switch (character) {
                case "I":
                    int region1 = input.nextInt();
                    int region2 = input.nextInt();
                    region = new String[region2][region1];
                    for (int i = 0; i < region.length; i++) {
                        for (int j = 0; j < region[0].length; j++) {
                            region[i][j] = "O";
                        }
                    }
                    break;
                case "L":
                    charL(region);
                    break;
                case "S":
                    charS(region);
                    break;
                case "F":
                    charF(region);
                    break;
                case "V":
                    charV(region);
                    break;
                case "C":
                    charC(region);
                    break;
                case "H":
                    charH(region);
                    break;
                case "K":
                    charK(region);
                    break;
                default:
                    break;
            }
            character = input.next();
        }
    }
}
