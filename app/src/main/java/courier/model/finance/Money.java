package courier.model.finance;

public class Money {
    public final int amount;
    public final Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
