import DataStructures.D1.JollyJumpers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JollyJumpersTest extends JollyJumpers {

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