package Combinatorics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepsTest {

    @Test
    void testNumberTotal() {
        assertEquals(15, Steps.numberTotal(5));
    }
}