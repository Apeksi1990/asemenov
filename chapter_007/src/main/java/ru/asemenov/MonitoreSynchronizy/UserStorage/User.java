package ru.asemenov.MonitoreSynchronizy.UserStorage;
/**
 * Class User решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * Amount.
     */
    private int amount = 10;

    /**
     * User constructor.
     * @param name user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Get name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get amount.
     * @return int.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set amount.
     * @param amount int.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Override toString.
     * @return string.
     */
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", amount=" + amount + '}';
    }
}
