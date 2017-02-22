package ru.asemenov.Map;

import java.util.Calendar;

/**
 * Class UserEquals решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class UserEquals extends User {
    /**
     * UserEquals constructor.
     * @param name user.
     * @param children user.
     * @param birthday user.
     */
    public UserEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
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
        if (super.getChildren() != user.getChildren()) {
            return false;
        }
        if (super.getName() != null ? !super.getName().equals(user.getName()) : user.getName() != null) {
            return false;
        }
        return super.getBirthday() != null ? super.getBirthday().equals(user.getBirthday()) : user.getBirthday() == null;
    }

    /**
     * HashCode.
     * @return hash.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
