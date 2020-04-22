package Backtracking.B8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiggerSquarePleaseTest {

    @Test
    void testPossibleSquareSize(){
        int[][] board = new int[][]
                {
                        {2, 2, 1, 0, 0, 0, 2, 2, 1, 0, 0, 0},
                        {2, 2, 1, 0, 0, 0, 2, 2, 1, 1, 0, 0},
                        {2, 2, 1, 0, 0, 0, 2, 2, 1, 0, 0, 0},
                        {2, 2, 1, 0, 0, 0, 2, 2, 1, 1, 0, 0},
                        {2, 2, 1, 0, 0, 0, 2, 2, 1, 0, 0, 0},
                };
        assertEquals(7, BiggerSquarePlease.possibleSquareSize(board));
    }

}