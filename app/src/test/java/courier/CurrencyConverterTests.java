package courier;

import courier.model.finance.Currency;
import courier.model.CurrencyConverter;
import courier.model.finance.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CurrencyConverterTests {
    @Test
    public void that_can_convert_from_gbp_to_eur() {
        Money moneyToConvert = new Money(120, Currency.GBP);

        Money convertedMoney = CurrencyConverter.poundToEuro(moneyToConvert);

        Money expectedConversion = new Money(142, Currency.EUR);
        assertThat(convertedMoney).isEqualToComparingFieldByField(expectedConversion);
    }

    @Test
    public void that_can_convert_from_gbp_to_usd() {
        Money moneyToConvert = new Money(120, Currency.GBP);

        Money convertedMoney = CurrencyConverter.poundToUSDollar(moneyToConvert);

        Money expectedConversion = new Money(150, Currency.USD);
        assertThat(convertedMoney).isEqualToComparingFieldByField(expectedConversion);
    }
}
