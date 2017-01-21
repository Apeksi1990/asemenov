package ru.asemenov.NetworkFileManager;

import org.junit.Test;
import ru.asemenov.NetworkFileManager.Server.ServerSettings;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ServerTest {
    @Test
    public void getProperties() {
        ServerSettings ss = new ServerSettings();
        ss.setSettings();
        int port = ss.getPort();
        String homePath = ss.getHomePath();

        assertThat(port, is(5000));
        assertThat(homePath, is("C:\\"));
    }
}
