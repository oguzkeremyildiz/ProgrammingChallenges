package DataStructures.D1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JollyJumpersTest {

    @Test
    void testJollyCount() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        boolean result = JollyJumpers.jollyCount(numbers);
        assertTrue(result);
    }
}