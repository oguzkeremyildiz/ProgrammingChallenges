package Backtracking.B2;/* Created by oguzkeremyildiz on 6.04.2020 */

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    int[][] items;
    int x, y;

    public Board(){
        items = new int[4][4];
    }

    public Board(Scanner input){
        items = new int[4][4];
        for (int j = 0; j < items.length; j++) {
            for (int k = 0; k < items[0].length; k++) {
                items[j][k] = input.nextInt();
                if (items[j][k] == 0){
                    x = j;
                    y = k;
                }
            }
        }
    }

    public int point(){
        int[][] solvedBoard = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0},
        };
        int point = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                int item = solvedBoard[i][j];
                boolean found = false;
                for (int k = 0; k < 4; k++){
                    for (int l = 0; l < 4; l++){
                        if (item == items[k][l]){
                            point += Math.abs(i - k) + Math.abs(j - l);
                            found = true;
                            break;
                        }
                    }
                    if (found){
                        break;
                    }
                }
            }
        }
        return point;
    }

    public long hash(){
        long code = 1;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                code = code * 16 + items[i][j];
            }
        }
        return code;
    }

    public boolean isASolution(){
        int[][] solvedBoard = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0},
        };
        return Arrays.deepEquals(solvedBoard, items);
    }

    public Board clone(){
        Board clone = new Board();
        clone.items = items.clone();
        for (int i = 0; i < 4; i++){
            clone.items[i] = items[i].clone();
        }
        clone.x = x;
        clone.y = y;
        return clone;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void moveLeft(){
        int tmp = items[x][y];
        items[x][y] = items[x][y - 1];
        items[x][y - 1] = tmp;
        y--;
    }

    public void moveRight(){
        int tmp = items[x][y];
        items[x][y] = items[x][y + 1];
        items[x][y + 1] = tmp;
        y++;
    }

    public void moveUp(){
        int tmp = items[x][y];
        items[x][y] = items[x - 1][y];
        items[x - 1][y] = tmp;
        x--;
    }

    public void moveDown(){
        int tmp = items[x][y];
        items[x][y] = items[x + 1][y];
        items[x + 1][y] = tmp;
        x++;
    }
}
