package ru.asemenov.echo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStorage {

    private static final UserStorage instance = new UserStorage();

    private List<User> users = new CopyOnWriteArrayList<>();

    private UserStorage() {
        this.users.add(new User("root", "root@root", "root"));
    }

    public static UserStorage getInstance() {
        return instance;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public boolean isCredentional(String login, String password) {
        boolean exist = false;
        for (User user : this.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
