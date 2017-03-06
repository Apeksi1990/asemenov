package ru.asemenov.MonitoreSynchronizy;

import org.junit.Before;
import org.junit.Test;
import ru.asemenov.MonitoreSynchronizy.UserStorage.User;
import ru.asemenov.MonitoreSynchronizy.UserStorage.UserStorage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class UserStorageTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class UserStorageTest {
    /**
     * Storage.
     */
    private UserStorage storage;

    /**
     * Before.
     */
    @Before
    public void beforeTest() {
        this.storage = new UserStorage();
        for (int i = 0; i < 10; i++) {
            this.storage.add(new User("Name" + i));
        }
    }

    /**
     * UserStorageTest.
     */
    @Test
    public void whenAddUserThenReturnCorrectUser() {
        boolean result = this.storage.readUser("Name3") != null;
        assertThat(result, is(true));
    }

    /**
     * UserStorageTest.
     */
    @Test
    public void whenDeleteUsetThenDeleteCorrectUser() {
        boolean result = this.storage.delete("Name5");
        assertThat(result, is(true));
    }

    /**
     * UserStorageTest.
     */
    @Test
    public void whenEditUserThenCorrectEdit() {
        storage.edit("Name4", "NewName4");
        boolean result = this.storage.readUser("NewName4") != null;
        assertThat(result, is(true));
    }

    /**
     * UserStorageTest.
     */
    @Test
    public void whenTransferAmountThenTrueTransfer() {
        storage.transferTo("Name1", "Name2", 5);
        int result = this.storage.getUser("Name2").getAmount();
        assertThat(result, is(15));
    }
}
