package ru.asemenov.Map;

import java.util.Calendar;
/**
 * Class UserHash решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class UserHash extends User {
    /**
     * UserHash constructor.
     * @param name user.
     * @param children user.
     * @param birthday user.
     */
    public UserHash(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    /**
     * Override hashCode.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
