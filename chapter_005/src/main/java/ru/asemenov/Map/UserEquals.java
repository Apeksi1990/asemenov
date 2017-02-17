package ru.asemenov.Map;

import java.util.Calendar;

public class UserEquals extends User {
    public UserEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        return  true;
    }
}
