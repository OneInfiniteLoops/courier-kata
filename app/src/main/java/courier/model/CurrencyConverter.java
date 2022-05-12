package courier.model;

import courier.model.finance.Currency;
import courier.model.finance.Money;

public class CurrencyConverter {
    private static final double GBP_TO_EUR_RATE = 1.19;
    private static final double GBP_TO_USD_RATE = 1.25;

    public static Money poundToEuro(Money moneyToConvert) {
        int convertedAmount = (int) (moneyToConvert.amount * GBP_TO_EUR_RATE);
        return new Money(convertedAmount, Currency.EUR);
    }

    public static Money poundToUSDollar(Money moneyToConvert) {
        int convertedAmount = (int) (moneyToConvert.amount * GBP_TO_USD_RATE);
        return new Money(convertedAmount, Currency.USD);
    }

    public static Money convert(Money moneyToConvert, Currency currency) {
        if (currency == Currency.EUR) {
            return poundToEuro(moneyToConvert);
        }
        if (currency == Currency.USD) {
            return poundToUSDollar(moneyToConvert);
        }
        return moneyToConvert;
    }
}
