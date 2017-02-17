package ru.asemenov.Map;

import java.util.Calendar;

public class User {
    public final String name;
    public final int children;
    public final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
