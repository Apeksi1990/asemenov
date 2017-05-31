package ru.asemenov.echo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * Class UserStorage решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class UserStorage {
    /**
     * Instance.
     */
    private static final UserStorage INSTANCE = new UserStorage();
    /**
     * List users.
     */
    private List<User> users = new CopyOnWriteArrayList<>();

    /**
     * Constructor.
     */
    private UserStorage() {
        this.users.add(new User("root", "root@root", "root"));
    }

    /**
     * Get INSTANCE.
     * @return UserStorage.
     */
    public static UserStorage getInstance() {
        return INSTANCE;
    }

    /**
     * Add user.
     * @param user USer.
     */
    public void add(User user) {
        this.users.add(user);
    }

    /**
     * Get users.
     * @return List<User>.
     */
    public List<User> getUsers() {
        return this.users;
    }

    /**
     * Is credentional.
     * @param login String.
     * @param password String.
     * @return boolean.
     */
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
