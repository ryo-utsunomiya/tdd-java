package money;

abstract class Money {
    int amount;

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (!(object instanceof Money)) {
            return false;
        }

        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }
}
