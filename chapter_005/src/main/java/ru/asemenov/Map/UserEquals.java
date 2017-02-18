package ru.asemenov.Map;

import java.util.Calendar;

public class UserEquals extends User {
    public UserEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
}
