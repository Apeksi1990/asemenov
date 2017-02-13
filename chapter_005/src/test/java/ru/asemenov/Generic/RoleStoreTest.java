package ru.asemenov.Generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class RoleStoreTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class RoleStoreTest {
    /**
     * Role store.
     */
    private RoleStore roleStore;

    /**
     * Before test.
     */
    @Before
    public void beforeTest() {
        roleStore = new RoleStore(5);
        Role roleOne = new Role("121");
        Role roleTwo = new Role("431");
        roleStore.add(roleOne);
        roleStore.add(roleTwo);
    }

    /**
     * Add and Get test.
     */
    @Test
    public void whenAddNewRoleThenReturnThisRole() {
        Role result = roleStore.get("121");
        assertThat(result.getId(), is("121"));
    }

    /**
     * Update test.
     */
    @Test
    public void whenUpdateRoleThenReturnNewRole() {
        Role newRole = new Role("739");
        roleStore.update("431", newRole);
        Role result = roleStore.get("739");
        assertThat(result.getId(), is("739"));
    }

    /**
     * Delete test.
     */
    @Test
    public void whenDeleteRoleThenReturnNull() {
        roleStore.delete("121");
        Role result = roleStore.get("431");
        assertThat(result.getId(), is("431"));
    }
}