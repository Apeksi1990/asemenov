package ru.asemenov.Calculator.MenuCalc;

import ru.asemenov.Calculator.Input.Input;

import java.io.IOException;
/**
 * Class BaseAction решение задачи части 004 урока 1.
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
     * @param first first.
     * @param input input.
     * @throws IOException exception.
     */
    public abstract void execute(double first, Input input) throws IOException;
}
