package ru.asemenov.filter.models;

public class City {
    /**
     * Id.
     */
    private int id;
    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     * @param id int.
     * @param name String.
     */
    public City(int id, String name) {
        this.id = id;
        this.name = name;
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
}
