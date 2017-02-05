package ru.asemenov.SimpleGenerator;
/**
 * Обработка исключения.
 */
public class KeyException extends RuntimeException {
    /**
	 * Обработка исключения.
	 * @param msg msg.
	 */
	public KeyException(String msg) {
        super(msg);
    }
}
