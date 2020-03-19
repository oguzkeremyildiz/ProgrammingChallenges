package GettingStarted.G7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckTheCheck {
    private  static void blackKnight(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'n'){
            if (number1 - 2 >= 0 && number2 + 1 < board[0].length) {
                if (board[number1 - 2][number2 + 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 - 2 >= 0 && number2 - 1 >= 0) {
                if (board[number1 - 2][number2 - 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 - 1 >= 0 && number2 - 2 >= 0) {
                if (board[number1 - 1][number2 - 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 - 1 >= 0 && number2 + 2 < board[0].length) {
                if (board[number1 - 1][number2 + 2] == 'K'){ 
                    System.out.println("white king is in check");
                }
            }
            if (number1 + 1 < board.length && number2 + 2 < board[0].length) {
                if (board[number1 + 1][number2 + 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 + 1 < board.length && number2 + 2 < board[0].length) {
                if (board[number1 + 1][number2 + 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 + 2 < board.length && number2 - 1 >= 0) {
                if (board[number1 + 2][number2 - 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 + 1 < board.length && number2 - 2 >= 0) {
                if (board[number1 + 1][number2 - 2] == 'K'){
                    System.out.println("white king is in check");
                }
            }
        }
    }
    private  static void whiteKnight(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'N'){
            if (number1 - 2 >= 0 && number2 + 1 < board[0].length) {
                if (board[number1 - 2][number2 + 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 - 2 >= 0 && number2 - 1 >= 0) {
                if (board[number1 - 2][number2 - 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 - 1 >= 0 && number2 - 2 >= 0) {
                if (board[number1 - 1][number2 - 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 - 1 >= 0 && number2 + 2 < board[0].length) {
                if (board[number1 - 1][number2 + 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 + 1 < board.length && number2 + 2 < board[0].length) {
                if (board[number1 + 1][number2 + 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 + 1 < board.length && number2 + 2 < board[0].length) {
                if (board[number1 + 1][number2 + 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 + 2 < board.length && number2 - 1 >= 0) {
                if (board[number1 + 2][number2 - 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 + 1 < board.length && number2 - 2 >= 0) {
                if (board[number1 + 1][number2 - 2] == 'k'){
                    System.out.println("black king is in check");
                }
            }
        }
    }
    private  static void blackPawn(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'p'){
            if (number1 - 1 > 0 && number2 - 1 > 0) {
                if (board[number1 - 1][number2 - 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
            if (number1 - 1 > 0 && number2 + 1 < board[0].length) {
                if (board[number1 - 1][number2 + 1] == 'K'){
                    System.out.println("white king is in check");
                }
            }
        }
    }
    private  static void whitePawn(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'P'){
            if (number1 - 1 > 0 && number2 - 1 > 0) {
                if (board[number1 - 1][number2 - 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
            if (number1 - 1 > 0 && number2 + 1 < board[0].length) {
                if (board[number1 - 1][number2 + 1] == 'k'){
                    System.out.println("black king is in check");
                }
            }
        }
    }
    private static void blackQueen(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'q'){
            int k = 1;
            while (number2 + k < board[0].length){
                if (board[number1][number2 + k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            int t = 1;
            while (number1 + t < board.length){
                if (board[number1 + t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 + t][number2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            k = 1;
            while (number2 - k >= 0){
                if (board[number1][number2 - k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            while (number1 - t >= 0){
                if (board[number1 - t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 - t][number2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 + t < board.length && number2 + k < board[0].length){
                if (board[number1 + t][number2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 + t][number2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 - t >= 0 && number2 + k < board[0].length){
                if (board[number1 - t][number2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 - t][number2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 - t >= 0 && number2 - k >= 0){
                if (board[number1 - t][number2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 - t][number2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 + t < board.length && number2 - k >= 0){
                if (board[number1 + t][number2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 + t][number2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void whiteQueen(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'Q'){
            int k = 1;
            while (number2 + k < board[0].length){
                if (board[number1][number2 + k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            int t = 1;
            while (number1 + t < board.length){
                if (board[number1 + t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 + t][number2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            k = 1;
            while (number2 - k >= 0){
                if (board[number1][number2 - k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            while (number1 - t >= 0){
                if (board[number1 - t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 - t][number2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 + t < board.length && number2 + k < board[0].length){
                if (board[number1 + t][number2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 + t][number2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 - t >= 0 && number2 + k < board[0].length){
                if (board[number1 - t][number2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 - t][number2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 - t >= 0 && number2 - k >= 0){
                if (board[number1 - t][number2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 - t][number2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 + t < board.length && number2 - k >= 0){
                if (board[number1 + t][number2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 + t][number2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void blackRook(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'r'){
            int x = 1;
            while (number2 + x < board[0].length){
                if (board[number1][number2 + x] == '.'){
                    x++;
                } else {
                    if (board[number1][number2 + x] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
        if (board[number1][number2] == 'r'){
            int y = 1;
            while (number1 + y < board.length){
                if (board[number1 + y][number2] == '.'){
                    y++;
                } else {
                    if (board[number1 + y][number2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
        if (board[number1][number2] == 'r'){
            int k = 1;
            while (number2 - k >= 0){
                if (board[number1][number2 - k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
        if (board[number1][number2] == 'r'){
            int t = 1;
            while (number1 - t >= 0){
                if (board[number1 - t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 - t][number2] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void whiteRook(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'R'){
            int k = 1;
            while (number2 + k < board[0].length){
                if (board[number1][number2 + k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 + k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
        if (board[number1][number2] == 'R'){
            int t = 1;
            while (number1 + t < board.length){
                if (board[number1 + t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 + t][number2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
        if (board[number1][number2] == 'R'){
            int k = 1;
            while (number2 - k >= 0){
                if (board[number1][number2 - k] == '.'){
                    k++;
                } else {
                    if (board[number1][number2 - k] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
        if (board[number1][number2] == 'R'){
            int t = 1;
            while (number1 - t >= 0){
                if (board[number1 - t][number2] == '.'){
                    t++;
                } else {
                    if (board[number1 - t][number2] == 'k'){
                        System.out.println("black king is in check");
                    }
                    break;
                }
            }
        }
    }
    private static void whiteBishop(char[][] board, int number1, int number2){
                if (board[number1][number2] == 'B'){
                    int t = 1;
                    int k = 1;
                    while (number1 + t < board.length && number2 + k < board[0].length){
                        if (board[number1 + t][number2 + k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (board[number1 + t][number2 + k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                    t = 1;
                    k = 1;
                    while (number1 - t >= 0 && number2 + k < board[0].length){
                        if (board[number1 - t][number2 + k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (board[number1 - t][number2 + k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                    t = 1;
                    k = 1;
                    while (number1 - t >= 0 && number2 - k >= 0){
                        if (board[number1 - t][number2 - k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (board[number1 - t][number2 - k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                    t = 1;
                    k = 1;
                    while (number1 + t < board.length && number2 - k >= 0){
                        if (board[number1 + t][number2 - k] == '.'){
                            t++;
                            k++;
                        } else {
                            if (board[number1 + t][number2 - k] == 'k'){
                                System.out.println("black king is in check");
                            }
                            break;
                        }
                    }
                }

    }
    private static void blackBishop(char[][] board, int number1, int number2){
        if (board[number1][number2] == 'b'){
            int t = 1;
            int k = 1;
            while (number1 + t < board.length && number2 + k < board[0].length){
                if (board[number1 + t][number2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 + t][number2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 - t >= 0 && number2 + k < board[0].length){
                if (board[number1 - t][number2 + k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 - t][number2 + k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 - t >= 0 && number2 - k >= 0){
                if (board[number1 - t][number2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 - t][number2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
            t = 1;
            k = 1;
            while (number1 + t < board.length && number2 - k >= 0){
                if (board[number1 + t][number2 - k] == '.'){
                    t++;
                    k++;
                } else {
                    if (board[number1 + t][number2 - k] == 'K'){
                        System.out.println("white king is in check");
                    }
                    break;
                }
            }
        }

    }
    public static void main(String[]args){
        int count = 0;
        try {
            Scanner source = new Scanner(new File("Chess.txt"));
            while (true){
                int board1 = source.nextInt();
                int board2 = source.nextInt();
                if (board1 == 0 && board2 == 0){
                    break;
                }
                char[][] board = new char[board1][board2];
                for (int i = 0; i < board.length; i++){
                    String line = source.next();
                    for (int j = 0; j < board[0].length; j++){
                        board[i][j] = line.charAt(j);
                    }
                }

                for (int z = 0; z < board.length; z++){
                    for (int t = 0; t < board[0].length; t++){
                        whiteBishop(board, z, t);
                        blackBishop(board, z, t);
                        whiteRook(board, z, t);
                        blackRook(board, z, t);
                        whiteQueen(board, z, t);
                        blackQueen(board, z, t);
                        whitePawn(board, z, t);
                        blackPawn(board, z, t);
                        whiteKnight(board, z, t);
                        blackKnight(board, z, t);
                    }
                }
                count++;
                System.out.println(count);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
