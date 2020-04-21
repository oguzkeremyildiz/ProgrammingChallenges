package GettingStarted.G2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Minesweeper {
    private static void leftSide(int number1, int number2, int[][] mine){
        if (number2 - 1 > -1){
            mine[number1][number2 - 1]++;
        }
    }

    private static void upSide(int number1, int number2, int[][] mine){
        if (number1 - 1 > -1){
            mine[number1 - 1][number2]++;
        }
    }

    private static void leftUpSide(int number1, int number2, int[][] mine){
        if (number1 - 1 > -1 && number2 - 1 > -1){
            mine[number1 - 1][number2 - 1]++;
        }
    }

    private static void underSide(int number1, int number2, int[][] mine, int[][] area){
        if (number1 + 1 < area.length){
            mine[number1 + 1][number2]++;
        }
    }

    private static void rightSide(int number1, int number2, int[][] mine, int[][] area){
        if (number2 + 1 < area[0].length){
            mine[number1][number2 + 1]++;
        }
    }

    private static void rightUpSide(int sayi1, int sayi2, int[][] mine, int[][] area){
        if (sayi1 - 1 > -1 && sayi2 + 1 < area[0].length){
            mine[sayi1 - 1][sayi2 + 1]++;
        }
    }

    private static void rightUnderSide(int number1, int number2, int[][] mine, int[][] area){
        if (number1 + 1 < area.length && number2 + 1 < area[0].length){
            mine[number1 + 1][number2 + 1]++;
        }
    }

    private static void leftUnderSide(int number1, int number2, int[][] mine, int[][] area){
        if (number1 + 1 < area.length && number2 - 1 > -1){
            mine[number1 + 1][number2 - 1]++;
        }
    }

    public static void main(String[]args){
        int count = 0;
        try {
            Scanner source = new Scanner(new File("Minesweeper.txt"));
            while (true){
                int area1 = source.nextInt();
                int area2 = source.nextInt();
                if (area1 == 0 && area2 == 0){
                    break;
                }
                int[][] area = new int[area1][area2];
                int[][] mine = new int[area1][area2];
                count += 1;
                System.out.println(count);
                String line;
                for (int t = 0; t < area.length; t++){
                    line = source.next();
                    for (int j = 0; j < area[0].length; j++){
                            if (line.charAt(j) == '*'){
                                area[t][j] = 1;
                            }
                    }
                }
                for (int z = 0; z < area.length; z++){
                    for (int k = 0; k < area[0].length; k++){
                        if (area[z][k] == 1){
                            leftSide(z ,k, mine);
                            rightSide(z, k, mine, area);
                            rightUpSide(z,k,mine,area);
                            leftUpSide(z,k,mine);
                            upSide(z, k, mine);
                            underSide(z,k,mine,area);
                            rightUnderSide(z,k,mine,area);
                            leftUnderSide(z,k,mine,area);
                        }
                    }
                }
                for (int t = 0; t < area.length; t++){
                    for (int j = 0; j < area[0].length; j++){
                        if (area[t][j] == 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(mine[t][j]);
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
