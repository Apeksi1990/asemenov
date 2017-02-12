package ru.asemenov.Generic;

public class User extends Base {
    /**
     * ID.
     */
    private String id;

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
