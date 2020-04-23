package Backtracking.B8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiggerSquarePleaseTest {

    @Test
    void testPossibleSquareSize(){
        int[][] board = new int[][]
                {
                        {1, 5, 5, 5, 5, 5, 0},
                        {0, 5, 5, 5, 5, 5, 0},
                        {0, 5, 5, 5, 5, 5, 0},
                        {0, 5, 5, 5, 5, 5, 0},
                        {0, 5, 5, 5, 5, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                };
        assertEquals(12, BiggerSquarePlease.possibleSquareSize(board));
    }

}