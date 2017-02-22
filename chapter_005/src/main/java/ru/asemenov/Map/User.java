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
    private final String name;
    /**
     * Children.
     */
    private final int children;
    /**
     * Birthday.
     */
    private final Calendar birthday;

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

    /**
     * Get name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get children.
     * @return children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Get birthday.
     * @return birthday.
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
