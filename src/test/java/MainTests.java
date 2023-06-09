import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
    public void testTaxEarningsMinusSpendingWithHamcrest() {
        int earnings = 1000;
        int spendings = 100;
        int expectedTax = 135;

        int taxEmS = (earnings - spendings) * 15 / 100;

        assertThat(expectedTax, equalTo(taxEmS));
    }
    @Test
    public void testTheBestOption() {
        int TaxEmS = 2000;
        int TaxEarn = 1800;
        int difference = Math.abs(TaxEarn - TaxEmS);
        int expected = 200;

        Assertions.assertEquals(expected, difference);

    }

    @Test
    public void testTheBestOptionWithHamcrest() {
        int TaxEmS = 2000;
        int TaxEarn = 1800;
        int difference = Math.abs(TaxEarn - TaxEmS);
        int expected = 200;

        assertThat(difference, equalTo(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 200, 2000})
    public void testTaxEarningsWithHamcrest(int earning) {
        assertThat(earning, greaterThanOrEqualTo(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000})
    public void testTaxEarnings(int earning) {
        assertTrue(earning > 0);
    }
}
