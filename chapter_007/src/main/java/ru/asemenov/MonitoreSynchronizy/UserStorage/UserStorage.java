package ru.asemenov.MonitoreSynchronizy.UserStorage;

import java.util.HashMap;
import java.util.Map;
/**
 * Class UserStorage решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class UserStorage {
    /**
     * Storage.
     */
    private Map<String, User> storage;

    /**
     * UserStorage constructor.
     */
    public UserStorage() {
        this.storage = new HashMap<>();
    }

    /**
     * Add user.
     * @param user new.
     */
    public synchronized void add(User user) {
        this.storage.put(user.getName(), user);
    }

    /**
     * Delete User.
     * @param userName name.
     * @return boolean.
     */
    public synchronized boolean delete(String userName) {
        User user = this.storage.get(userName);
        if (user != null) {
            this.storage.remove(userName);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Edit user.
     * @param userName old.
     * @param newName new.
     */
    public synchronized void edit(String userName, String newName) {
        User newUser = new User(newName);
        newUser.setAmount(this.storage.get(userName).getAmount());
        add(newUser);
        delete(userName);
    }

    /**
     * Read User.
     * @param userName name.
     * @return String.
     */
    public synchronized String readUser(String userName) {
        return this.storage.get(userName).toString();
    }

    /**
     * Get user.
     * @param userName user.
     * @return User.
     */
    public synchronized User getUser(String userName) {
        return this.storage.get(userName);
    }

    /**
     * Transfer to.
     * @param firstUser user.
     * @param secondUser user.
     * @param amount int.
     */
    public synchronized void transferTo(String firstUser, String secondUser, int amount) {
        User first = this.storage.get(firstUser);
        User second = this.storage.get(secondUser);

        if (first.getAmount() < amount) {
            System.out.println("So much is not");
        } else {
            first.setAmount(first.getAmount() - amount);
            second.setAmount(second.getAmount() + amount);
        }
    }
}
