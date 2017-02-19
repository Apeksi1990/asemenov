package ru.asemenov.Map;

import java.util.Calendar;
/**
 * Class UserHashEquals решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class UserHashEquals extends User {
    /**
     * UserHashEquals constructor.
     * @param name user.
     * @param children user.
     * @param birthday user.
     */
    public UserHashEquals(String name, int children, Calendar birthday) {
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

    /**
     * Override equals.
     * @param obj user.
     * @return boolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
}
