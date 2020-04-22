package Backtracking.B8;/* Created by oguzkeremyildiz on 17.04.2020 */

import Tuples.Pair;

import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class BiggerSquarePlease {
    private static int totalSquare;
    private static int[][] bestBoard;
    private static boolean check(int[][] board, int i, int j, int length) {
        boolean bool = true;
        for (int k = 0; k < length; k++) {
            for (int l = 0; l < length; l++) {
                if (i + k < board.length) {
                    if (board[i + k][j + l] > 0) {
                        bool = false;
                        break;
                    }
                } else {
                    bool = false;
                    break;
                }
            }
        }
        return bool;
    }
    private static int length(int[][] board,int t, int j) {
        int length = 0;
        for (int i = 0; i < board[0].length - j; i++) {
            if (board[t][j + i] == 0) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
    private static Pair<Integer, Integer> lengthForPossibilities(int[][] board, int i) {
        int length = 0;
        int current = -2;
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == 0) {
                length++;
                if (k + 1 >= board[0].length) {
                    current = board[0].length - 1;
                }
            } else {
                current = k - 1;
                length = 0;
            }
        }
        return new Pair<>(length, current);
    }
    protected static int possibleSquareSize(int[][] board) {
        LinkedList<Pair<Integer, Integer>> lengthList = new LinkedList<>();
        int square = 0;
        for (int i = 0; i < board.length; i++) {
            lengthList.add(lengthForPossibilities(board, i));
        }
        for (int j = 0; j < lengthList.size(); j++) {
            if (lengthList.get(j).getKey() > 0) {
                if (j > 1) {
                    if (!lengthList.get(j).equals(lengthList.get(j - 1))) {
                        square++;
                    }
                } else {
                    square++;
                }
            }
        }
        return square;
    }
    private static void constructCandidates(int[][] board, LinkedList<Integer> subsets, LinkedList<Integer> sequence) {
        if (sequence.size() + possibleSquareSize(board) >= totalSquare) {
            if (totalSquare > 0) {
                return;
            }
        }
        boolean check = false;
        int length;
        if (sequence.size() > 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) {
                        length = length(board, i , j);
                        for (int k = 0; k < length; k++) {
                            if (check(board, i , j, k + 1)) {
                                subsets.add(k + 1);
                            }
                        }
                        check = true;
                        break;
                    }
                }
                if (check) {
                    break;
                }
            }
        } else {
            for (int i = 1; i < board.length; i++) {
                subsets.add(i);
            }
            if (subsets.size() > 2) {
                if (board.length % 3 == 0) {
                    Collections.swap(subsets, (board.length / 3) * 2 - 1, subsets.size() - 1);
                } else {
                    Collections.swap(subsets,subsets.size() / 2,subsets.size() - 1);
                }
            }
        }
        Collections.reverse(subsets);
    }
    private static void backtrack(int[][] board, LinkedList<Integer> sequence) {
        if (board.length % 3 == 0) {
            if (totalSquare == 6) {
                return;
            }
        } else {
            if (totalSquare == 8) {
                return;
            }
        }
        if (totalSquare < sequence.size()) {
            return;
        }
        int[][] boardClone;
        LinkedList<Integer> subsets = new LinkedList<>();
        if (sequence.size() > 5 && isASolution(board)) {
            if (sequence.size() < totalSquare) {
                totalSquare = sequence.size();
                bestBoard = board;
            }
        } else {
            constructCandidates(board, subsets, sequence);
            for (Integer subset : subsets) {
                sequence.add(subset);
                boardClone = board.clone();
                for (int i = 0; i < board.length; i++){
                    boardClone[i] = board[i].clone();
                }
                fill(board, subset);
                backtrack(board, sequence);
                sequence.removeLast();
                board = boardClone;
            }
        }
    }
    private static void fill(int[][] board, int subset) {
        boolean check = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 0; k < subset; k++) {
                        for (int l = 0; l < subset; l++) {
                            board[i + k][j + l] = subset;
                        }
                    }
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
    }
    private static boolean isASolution(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print() {
        for (int[] ints : bestBoard) {
            for (int j = 0; j < bestBoard[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }
    private static void fillForTwo(int size) {
        int element = size / 2;
        for (int i = 0; i < bestBoard.length; i++) {
            for (int j = 0; j < bestBoard[0].length; j++) {
                bestBoard[i][j] = element;
            }
        }
    }
    public static void main(String[]args) {
        try {
            Scanner source = new Scanner(new File("Square.txt"));
            int times = source.nextInt();
            int size;
            for (int i = 0; i < times; i++) {
                totalSquare = 10000;
                Date currentDate = new Date();
                size = source.nextInt();
                int[][] board = new int[size][size];
                bestBoard = new int[size][size];
                if (size % 2 == 1) {
                    backtrack(board, new LinkedList<>());
                } else {
                    totalSquare = 4;
                    fillForTwo(size);
                }
                Date finishDate = new Date();
                System.out.println(finishDate.getTime() - currentDate.getTime());
                System.out.println(totalSquare);
                print();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
