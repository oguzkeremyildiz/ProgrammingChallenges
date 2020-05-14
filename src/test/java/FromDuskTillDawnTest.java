import GraphTraversal.G7.FromDuskTillDawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FromDuskTillDawnTest extends FromDuskTillDawn {
    @Test
    void testSetTime() {
        Assertions.assertEquals(10, FromDuskTillDawn.setTime(15, 19));
    }
    @Test
    void testCheckTime() {
        for (int i = 1; i <= 24; i++) {
            if (i > 17 || i < 7) {
                assertTrue(FromDuskTillDawn.checkTime(i));
            } else {
                assertFalse(FromDuskTillDawn.checkTime(i));
            }
        }
    }
    @Test
    void testDrink() {
        assertTrue(FromDuskTillDawn.drink(9, 14));
    }
    @Test
    void testDrinkForTransportation() {
        assertTrue(FromDuskTillDawn.drinkForTransportation(18, 12));
    }
}