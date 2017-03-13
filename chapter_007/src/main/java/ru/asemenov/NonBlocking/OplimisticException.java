package ru.asemenov.NonBlocking;
/**
 * Class OplimisticException решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class OplimisticException extends RuntimeException {
    /**
     * Exception.
     */
    public OplimisticException() {
        super("Incorrect version");
    }
}
