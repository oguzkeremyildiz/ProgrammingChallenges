package Backtracking.B2;/* Created by oguzkeremyildiz on 5.04.2020 */

import java.io.File;
import java.util.*;

public class PuzzleProblem15 {

    private static boolean finished = false;
    private static HashMap<Long, String> traversedWithLength;

    private static void constructCandidates(ArrayList<String> subsets, Board board){
        int x = board.getX();
        int y = board.getY();
        ArrayList<Integer> points = new ArrayList<>();
        subsets.add("L");
        if (y - 1 > -1) {
            board.moveLeft();
            points.add(board.point());
            board.moveRight();
        } else {
            points.add(1000);
        }
        subsets.add("R");
        if (y + 1 < 4) {
            board.moveRight();
            points.add(board.point());
            board.moveLeft();
        } else {
            points.add(1000);
        }
        subsets.add("D");
        if (x + 1 < 4) {
            board.moveDown();
            points.add(board.point());
            board.moveUp();
        } else {
            points.add(1000);
        }
        subsets.add("U");
        if (x - 1 > -1) {
            board.moveUp();
            points.add(board.point());
            board.moveDown();
        } else {
            points.add(1000);
        }
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (points.get(i) < points.get(j)){
                    Collections.swap(points, i, j);
                    Collections.swap(subsets, i, j);
                }
            }
        }
        for (int i = 0; i < points.size(); i++){
            if (points.get(i) == 1000){
                points.remove(i);
                subsets.remove(i);
                i--;
            }
        }
    }

    private static void backtrack(Board board, ArrayList<String> moves, int maxPoint){
        if (moves.size() > maxPoint){
            return;
        }
        if (traversedWithLength.containsKey(board.hash())){
            if (traversedWithLength.get(board.hash()).length() < moves.toString().length()){
                return;
            } else {
                traversedWithLength.put(board.hash(), moves.toString());
            }
        } else {
            traversedWithLength.put(board.hash(), moves.toString());
        }
        ArrayList<String> subsets = new ArrayList<>();
        if (board.isASolution()){
            System.out.println(moves);
            finished = true;
        } else {
            if (!finished){
                constructCandidates(subsets, board);
                for (String subset : subsets) {
                    moves.add(subset);
                    Board boardClone = board.clone();
                    move(board, subset);
                    backtrack(board, moves, maxPoint);
                    moves.remove(moves.size() - 1);
                    board = boardClone.clone();
                }
            }
        }
    }


    private static void move(Board board, String move){
        switch (move) {
            case "L":
                board.moveLeft();
                break;
            case "R":
                board.moveRight();
                break;
            case "U":
                board.moveUp();
                break;
            case "D":
                board.moveDown();
                break;
        }
    }
    public static void main(String[]args){
        try {
            Scanner source = new Scanner(new File("Puzzle.txt"));
            int times = source.nextInt();
            for (int i = 0; i < times; i++) {
                Board board = new Board(source);
                traversedWithLength = new HashMap<>();
                finished = false;
                System.out.println(board.point());
                backtrack(board, new ArrayList<>(), board.point());
                if (!finished){
                    System.out.println("No Solution");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
