package money;

abstract class Money {
    int amount;

    public boolean equals(Object object) {
        return object instanceof Money && amount == ((Money) object).amount;
    }
}
