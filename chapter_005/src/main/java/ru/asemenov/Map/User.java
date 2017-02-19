package ru.asemenov.Map;

import java.util.Calendar;
/**
 * Class User решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class User {
    /**
     * Name.
     */
    protected final String name;
    /**
     * Children.
     */
    protected final int children;
    /**
     * Birthday.
     */
    protected final Calendar birthday;

    /**
     * User constructor.
     * @param name user.
     * @param children user.
     * @param birthday user.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
