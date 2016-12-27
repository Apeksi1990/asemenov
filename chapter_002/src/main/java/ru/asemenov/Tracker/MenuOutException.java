package ru.asemenov.Tracker;
/**
 * Обработка исключения.
 */
public class MenuOutException extends RuntimeException {
    /**
	 * Обработка исключения.
	 * @param msg msg.
	 */
	public MenuOutException(String msg) {
        super(msg);
    }
}
