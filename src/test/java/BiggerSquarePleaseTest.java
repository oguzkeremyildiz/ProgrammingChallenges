import Backtracking.B8.BiggerSquarePlease;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiggerSquarePleaseTest extends BiggerSquarePlease {

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
        Assertions.assertEquals(10, BiggerSquarePlease.possibleSquareSize(board));
    }

}