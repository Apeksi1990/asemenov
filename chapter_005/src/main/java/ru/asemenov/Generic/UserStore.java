package ru.asemenov.Generic;
/**
 * Class UserStore решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <User> generic.
 */
public class UserStore<User extends Base> extends AbstractStore<Role> {
    /**
     * UserStore constructor.
     * @param size store.
     */
    public UserStore(int size) {
        super(size);
    }
}
