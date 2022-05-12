package courier;

import courier.model.finance.Currency;
import courier.model.CurrencyConverter;
import courier.model.finance.Money;
import courier.model.postages.Parcel;

public class PostageCalculator {
    private static final int CONVERSION_TAX = 20;

    public Money calculate(int weight, int height, int width, int depth) {
        int amountInDefaultCurrency = Parcel.withDimensions(weight, height, width, depth).postageCostInDefaultCurrency();
        return new Money(amountInDefaultCurrency, Currency.GBP);
    }

    public Money calculate(int weight, int height, int width, int depth, Currency currency) {
        Money moneyInDefaultCurrency = calculate(weight, height, width, depth);
        moneyInDefaultCurrency = addConversionTax(moneyInDefaultCurrency);
        return CurrencyConverter.convert(moneyInDefaultCurrency, currency);
    }

    private Money addConversionTax(Money money) {
        return new Money(money.amount + CONVERSION_TAX, money.currency);
    }
}
