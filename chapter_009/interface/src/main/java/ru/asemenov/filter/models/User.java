package ru.asemenov.filter.models;

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
     * Role.
     */
    private Role role;
    /**
     * Password.
     */
    private String password;
    /**
     * Country.
     */
    private String country;
    /**
     * City.
     */
    private String city;

    /**
     * User constructor.
     * @param id int.
     * @param name String.
     * @param login String.
     * @param email String.
     */
    public User(int id, String name, String login, String password, String email, Role role, String city, String country) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = role;
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get role.
     * @return Role.
     */
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
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
}
