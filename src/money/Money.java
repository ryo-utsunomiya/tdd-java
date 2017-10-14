package money;

class Money implements Expression {
    int amount;
    private String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(currency, to), to);
    }

    String currency() {
        return currency;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Money)) return false;

        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public String toString() {
        return amount + " " + currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
}
