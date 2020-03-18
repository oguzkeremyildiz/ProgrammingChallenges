package ArithmeticAndAlgebra.A2;

import ArithmeticAndAlgebra.A2.ReverseAndAdd;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAndAddTest {

    @org.junit.jupiter.api.Test
    void testPower() {
        int result = ReverseAndAdd.power(5, 2);
        assertEquals(25, result);
    }

}