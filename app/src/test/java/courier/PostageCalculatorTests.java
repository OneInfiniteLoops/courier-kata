package courier;

import courier.model.finance.Currency;
import courier.model.finance.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PostageCalculatorTests {
    private final PostageCalculator objectUnderTest = new PostageCalculator();

    @ParameterizedTest
    @CsvFileSource(resources = "/parcel-dimensions.csv", numLinesToSkip = 1)
    public void that_calculate_cost_in_gbp_for_a_parcel_when_no_currency_is_inputted(int weight, int height, int width, int depth, int expectedCost) {
        Money expectedValue = new Money(expectedCost, Currency.GBP);

        Money valueOfParcel = objectUnderTest.calculate(weight, height, width, depth);

        assertThat(valueOfParcel).isEqualToComparingFieldByField(expectedValue);
    }

    @Test
    public void that_returns_the_cost_in_the_requested_currency_and_adds_the_20_gbp_tax_to_it() {
        Money expectedValue = new Money(166, Currency.EUR);

        Money valueOfParcelInEuros = objectUnderTest.calculate(10,10,10,10,  Currency.EUR);

        assertThat(valueOfParcelInEuros).isEqualToComparingFieldByField(expectedValue);
    }
}
