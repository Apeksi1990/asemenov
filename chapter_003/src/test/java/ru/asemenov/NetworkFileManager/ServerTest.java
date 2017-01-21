package ru.asemenov.NetworkFileManager;

import org.junit.Test;
import ru.asemenov.NetworkFileManager.Server.BaseAction;
import ru.asemenov.NetworkFileManager.Server.MenuServer;
import ru.asemenov.NetworkFileManager.Server.ServerSettings;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
/**
 * Class ServerTest решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class ServerTest {
    /**
     * Get correct properties.
     */
    @Test
    public void getProperties() {
        ServerSettings ss = new ServerSettings();
        ss.setSettings();
        int port = ss.getPort();
        String homePath = ss.getHomePath();

        assertThat(port, is(5000));
        assertThat(homePath, is("C:\\"));
    }

    /**
     * Correct check key.
     * @throws IOException exception.
     */
    @Test
    public void checkKey() throws IOException {
        MenuServer menuServer = new MenuServer();
        menuServer.fillActions();
        BaseAction baseAction = menuServer.checkKey("cd..");
        assertNotNull(baseAction);

    }
}
