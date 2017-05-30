package ru.asemenov.JSP;

import java.sql.Timestamp;

/**
 * Class User решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class User {
    /**
     * Id.
     */
    private int id;
    /**
     * Name user.
     */
    private String name;
    /**
     * Login user.
     */
    private String login;
    /**
     * E-mail user.
     */
    private String email;
    /**
     * Create date.
     */
    private Timestamp createDate;

    /**
     * User constructor.
     * @param id int.
     * @param name String.
     * @param login String.
     * @param email String.
     * @param createDate Timestamp.
     */
    public User(int id, String name, String login, String email, Timestamp createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * toString.
     * @return String.
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", login='" + login + '\'' + ", email='" + email + '\'' + ", createDate=" + createDate + '}';
    }

    /**
     * Get id.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Get name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get login.
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Get email.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get Create date.
     * @return Timestamp.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
}
