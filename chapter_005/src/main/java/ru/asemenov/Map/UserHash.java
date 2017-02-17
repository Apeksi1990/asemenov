package ru.asemenov.Map;

import java.util.Calendar;

public class UserHash extends User {
    public UserHash(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
