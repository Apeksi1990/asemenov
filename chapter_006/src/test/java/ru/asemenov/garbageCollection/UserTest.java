package ru.asemenov.garbageCollection;

import org.junit.Test;
/**
 * Class UserTest решение задачи части 006.
 * @author asemenov
 * @version 1
 */
public class UserTest {
    /**
     * Memory test.
     */
    @Test
    public void userMemoryTest() {
        User user;
        for (int i = 0; i < 100; i++) {
            user = new User("Name" + i);
            System.out.println(user);
            user.info();
        }
    }
}
