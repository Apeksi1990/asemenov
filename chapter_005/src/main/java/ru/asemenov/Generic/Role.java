package ru.asemenov.Generic;
/**
 * Class Role решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class Role extends Base {
    /**
     * ID.
     */
    private String id;

    /**
     * Role constructor.
     * @param id role.
     */
    public Role(String id) {
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
