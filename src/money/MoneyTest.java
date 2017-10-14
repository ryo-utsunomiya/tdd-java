package money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
        assertFalse(Money.dollar(5).equals(5));
        assertFalse(Money.dollar(5).equals(null));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    void testSimpleAddition() {
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        assertEquals(Money.dollar(10), new Bank().reduce(sum, "USD"));
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Sum sum = (Sum) five.plus(five);
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Money result = new Bank().reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Money result = new Bank().reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
}
