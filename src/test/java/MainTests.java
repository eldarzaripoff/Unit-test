import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTests {
    @Test
    public void testTaxEarningsMinusSpendings() {
        int earnings = 1000;
        int spendings = 100;
        int expectedTax = 135;

        int taxEmS = (earnings - spendings) * 15 / 100;

        Assertions.assertEquals(expectedTax, taxEmS);
    }

    @Test
    public void testForNull() {

        assertThrows(NullPointerException.class,()->{
            throw new NullPointerException();
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000})
    public void testTaxEarnings(int earning) {
        assertTrue(earning > 0);
    }
}
