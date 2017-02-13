package ru.asemenov.Generic;
/**
 * Class User решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class User extends Base {
    /**
     * ID.
     */
    private String id;

    /**
     * User constructor.
     * @param id user.
     */
    public User(String id) {
        this.id = id;
    }

    /**
     * Get id.
     * @return id.
     */
    @Override
    String getId() {
        return this.id;
    }

    /**
     * Set id.
     * @param id set.
     */
    @Override
    void setId(String id) {
        this.id = id;
    }
}
