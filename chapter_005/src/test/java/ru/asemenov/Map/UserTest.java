package ru.asemenov.Map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void UserNotOverride() {
        User first  = new User("Alex", 0, new GregorianCalendar(1990, 7, 30));
        User second  = new User("Alex", 0, new GregorianCalendar(1990, 7, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
        //хеш и equals не равны, значит записываются два элемента в карту
    }

    @Test
    public void UserOverrideHash() {
        UserHash first  = new UserHash("Alex", 0, new GregorianCalendar(1990, 7, 30));
        UserHash second  = new UserHash("Alex", 0, new GregorianCalendar(1990, 7, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
        //хеш одинаковый но ключи разные, в карту записываются два элемента
    }
}