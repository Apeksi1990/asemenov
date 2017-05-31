package ru.asemenov.echo;
/**
 * Class User решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class User {
    /**
     * Login.
     */
    private String login;
    /**
     * E-mail.
     */
    private String email;
    /**
     * Password.
     */
    private String password;

    /**
     * Constructor.
     * @param login String.
     * @param email String.
     * @param password String.
     */
    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    /**
     * Get login.
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Get e-mail.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }
}
