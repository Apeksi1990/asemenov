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
        int result = super.getName() != null ? super.getName().hashCode() : 0;
        result = 31 * result + super.getChildren();
        result = 31 * result + (super.getBirthday() != null ? super.getBirthday().hashCode() : 0);
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
        if (super.getChildren() != user.getChildren()) {
            return false;
        }
        if (super.getName() != null ? !super.getName().equals(user.getName()) : user.getName() != null) {
            return false;
        }
        return super.getBirthday() != null ? super.getBirthday().equals(user.getBirthday()) : user.getBirthday() == null;
    }
}
