package ru.asemenov.bank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Class BankTest.
 * @author asemenov
 * @version 1
 */
public class BankTest {
    /**
     * Bank visitors test.
     */
    @Test
    public void thenAddUserThenPrintMaxVisitorsAndTime() {
        Bank bank = new Bank();
        bank.addVisitor(new User("Sat Jan 03 09:00:00 MSK 2017", "Sat Jan 03 10:07:00 MSK 2017"));
        bank.addVisitor(new User("Sat Jan 03 10:20:00 MSK 2017", "Sat Jan 03 11:35:00 MSK 2017"));
        bank.addVisitor(new User("Sat Jan 03 12:00:00 MSK 2017", "Sat Jan 03 17:00:00 MSK 2017"));
        bank.addVisitor(new User("Sat Jan 03 11:00:00 MSK 2017", "Sat Jan 03 11:30:00 MSK 2017"));
        bank.addVisitor(new User("Sat Jan 03 11:20:00 MSK 2017", "Sat Jan 03 12:30:00 MSK 2017"));
        bank.addVisitor(new User("Sat Jan 03 11:30:00 MSK 2017", "Sat Jan 03 18:15:00 MSK 2017"));
        bank.findTime();
        System.out.println(bank.result());
        Assert.assertThat(bank.getMax(), is(4));
    }
}