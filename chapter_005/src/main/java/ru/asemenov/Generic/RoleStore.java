package ru.asemenov.Generic;
/**
 * Class RoleStore решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <Role> generic.
 */
public class RoleStore<Role extends Base> extends AbstractStore<Role> {
    /**
     * RoleStore constructor.
     * @param size store.
     */
    public RoleStore(int size) {
        super(size);
    }
}
