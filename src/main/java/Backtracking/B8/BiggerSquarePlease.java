package Backtracking.B8;/* Created by oguzkeremyildiz on 17.04.2020 */

import Tuples.Pair;
import Tuples.Triplet;

import java.io.File;
import java.util.*;

public class BiggerSquarePlease {
    private static int totalSquare;
    private static int[][] bestBoard;
    private static int[] minimumSquares;
    private static int numberOfPossibilities;

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
    private static LinkedList<Pair<Integer, Triplet<Integer, Integer, Integer>>> lengthForPossibilities(int[][] board, int i) {
        LinkedList<Pair<Integer, Triplet<Integer, Integer, Integer>>> list = new LinkedList<>();
        int length = 0;
        int start = 0;
        int finish;
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == 0) {
                length++;
                if (k + 1 >= board[0].length) {
                    finish = board[0].length - 1;
                    list.add(new Pair<>(i, new Triplet<>(length, start, finish)));
                }
            } else {
                if (length > 0) {
                    finish = k - 1;
                    list.add(new Pair<>(i, new Triplet<>(length, start, finish)));
                }
                length = 0;
                start = k + 1;
            }
        }
        return list;
    }
    protected static int possibleSquareSize(int[][] board) {
        LinkedList<Pair<Integer, Triplet<Integer, Integer, Integer>>> lengthList = new LinkedList<>();
        HashSet<Pair<Integer, Triplet<Integer, Integer, Integer>>> lengthSet = new HashSet<>();
        boolean check;
        int currentLine;
        int times;
        int square = 0;
        for (int i = 0; i < board.length; i++) {
            lengthList.addAll(lengthForPossibilities(board, i));
        }
        for (int j = 0; j < lengthList.size(); j++) {
            if (!lengthSet.contains(lengthList.get(j))) {
                check = false;
                times = 1;
                currentLine = lengthList.get(j).getKey();
                for (int i = 0; i < lengthList.size(); i++) {
                    if (!lengthSet.contains(lengthList.get(i))) {
                        if (i != j && times != lengthList.get(j).getValue().getA()) {
                            if (lengthList.get(i).getValue().equals(lengthList.get(j).getValue())) {
                                if (currentLine + 1 == lengthList.get(i).getKey()) {
                                    times++;
                                    if (!check) {
                                        square++;
                                    }
                                    check = true;
                                    lengthSet.add(lengthList.get(i));
                                    currentLine = lengthList.get(i).getKey();
                                }
                            }
                        }
                    }
                }
                lengthSet.add(lengthList.get(j));
                if (!check) {
                    square++;
                }
            }
        }
        return square;
    }
    private static int allSquareOfTheNumber(LinkedList<Integer> sequence) {
        int sum = 0;
        for (Integer element : sequence) {
            sum += element * element;
        }
        return sum;
    }
    private static void constructCandidates(int[][] board, LinkedList<Integer> subsets, LinkedList<Integer> sequence) {
        numberOfPossibilities++;
        int sum = 0;
        for (Integer integer : sequence) {
            sum += integer * integer;
        }
        int difference = board.length * board.length - sum;
        if (sequence.size() + minimumSquares[difference] >= totalSquare){
            return;
        }
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
                                if (allSquareOfTheNumber(sequence) + ((k + 1) * (k + 1)) <= board.length * board[0].length) {
                                    subsets.add(k + 1);
                                }
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
        if (sequence.size() > 5 && allSquareOfTheNumber(sequence) == (board.length * board[0].length) && isASolution(board)) {
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

    private static void findMinimumSquares(){
        minimumSquares = new int[2500];
        minimumSquares[0] = 0;
        minimumSquares[1] = 1;
        minimumSquares[2] = 2;
        minimumSquares[3] = 3;
        minimumSquares[4] = 1;
        int min;
        for (int i = 5; i < 2500; i++){
            if (i == ((int) Math.sqrt(i)) * ((int) Math.sqrt(i))){
                min = 1;
            } else {
                min = minimumSquares[i - 1] + 1;
            }
            int j = 2;
            while (i - j * j > 1){
                if (minimumSquares[i - j * j] + 1 < min){
                    min = minimumSquares[i - j * j] + 1;
                }
                j++;
            }
            minimumSquares[i] = min;
        }
    }

    public static void main(String[]args) {
        try {
            findMinimumSquares();
            Scanner source = new Scanner(new File("Square.txt"));
            int times = source.nextInt();
            int size;
            for (int i = 0; i < times; i++) {
                totalSquare = 10000;
                numberOfPossibilities = 0;
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
//                System.out.println(finishDate.getTime() - currentDate.getTime());
                System.out.println(numberOfPossibilities);
                System.out.println(totalSquare);
                print();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
