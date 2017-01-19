package ru.asemenov.NetworkFileManager.Server;

import java.io.IOException;

/**
 * Class BaseAction решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public abstract class BaseAction {
    /**
     * Key.
     * @return key.
     */
    public abstract String key();
    /**
     * Info.
     * @return info.
     */
    public abstract String info();
    /**
     * Execute.
     * @param message message.
     * @throws IOException exception.
     */
    public abstract void execute(String[] message) throws IOException;
}
