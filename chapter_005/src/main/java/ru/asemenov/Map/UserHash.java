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
        int result = super.getName() != null ? super.getName().hashCode() : 0;
        result = 31 * result + super.getChildren();
        result = 31 * result + (super.getBirthday() != null ? super.getBirthday().hashCode() : 0);
        return result;
    }
}
