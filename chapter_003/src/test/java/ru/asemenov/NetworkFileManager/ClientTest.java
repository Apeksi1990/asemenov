package ru.asemenov.NetworkFileManager;

import org.junit.Test;
import ru.asemenov.NetworkFileManager.Client.ClientSettings;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClientTest {
    @Test
    public void getProperties() {
        ClientSettings cs = new ClientSettings();
        cs.setSettings();
        int port = cs.getPort();
        String inetAddress = cs.getInetAddress();

        assertThat(port, is(5000));
        assertThat(inetAddress, is("127.0.0.1"));
    }
}
