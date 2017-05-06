package ru.asemenov.jdbc;
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
