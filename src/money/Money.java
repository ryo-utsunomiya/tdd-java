package money;

abstract class Money {
    int amount;

    abstract Money times(int multiplier);

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (!(object instanceof Money)) {
            return false;
        }

        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }
}
