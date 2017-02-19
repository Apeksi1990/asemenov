package ru.asemenov.Map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/**
 * Class UserTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class UserTest {
    /**
     * User test.
     */
    @Test
    public void userNotOverride() {
        User first  = new User("Alex", 0, new GregorianCalendar(1990, 7, 30));
        User second  = new User("Alex", 0, new GregorianCalendar(1990, 7, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }

    /**
     * User override hash test.
     */
    @Test
    public void userOverrideHash() {
        UserHash first  = new UserHash("Alex", 0, new GregorianCalendar(1990, 7, 30));
        UserHash second  = new UserHash("Alex", 0, new GregorianCalendar(1990, 7, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }

    /**
     * User override equals test.
     */
    @Test
    public void userOverrideEquals() {
        UserEquals first  = new UserEquals("Alex", 0, new GregorianCalendar(1990, 7, 30));
        UserEquals second  = new UserEquals("Alex", 0, new GregorianCalendar(1990, 7, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }

    /**
     * User override hash and equals test.
     */
    @Test
    public void userOverrideEqualsAndHash() {
        UserHashEquals first  = new UserHashEquals("Alex", 0, new GregorianCalendar(1990, 7, 30));
        UserHashEquals second  = new UserHashEquals("Alex", 0, new GregorianCalendar(1990, 7, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}