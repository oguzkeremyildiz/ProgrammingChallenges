import Backtracking.B7.ColorHash;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ColorHashTest extends ColorHash {

    @Test
    void testRemaining() {
        LinkedList<Integer> sequence = new LinkedList<>();
        sequence.add(2);
        sequence.add(2);
        sequence.add(2);
        sequence.add(3);
        sequence.add(2);
        sequence.add(4);
        sequence.add(1);
        sequence.add(3);
        sequence.add(3);
        sequence.add(3);
        sequence.add(3);
        sequence.add(3);
        sequence.add(1);
        sequence.add(1);
        sequence.add(1);
        sequence.add(2);
        sequence.add(2);
        sequence.add(6);
        sequence.add(6);
        sequence.add(6);
        sequence.add(6);
        sequence.add(6);
        int result = ColorHash.remaining(sequence);
        assertEquals(6, result);
    }
}