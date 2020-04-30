import Combinatorics.C8.Steps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StepsTest extends Steps {

    @Test
    void testNumberTotal() {
        Assertions.assertEquals(15, Steps.numberTotal(5));
    }
}