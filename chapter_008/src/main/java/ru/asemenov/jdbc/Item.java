package ru.asemenov.jdbc;

import java.sql.Timestamp;

/**
 * Class Item решение задачи части 002 урока 2.
 * @author asemenov
 * @version 1
 */
public class Item {
    /**
	* id заявки.
	*/
	private int id;
	/**
	* Имя заявки.
	*/
    private String name;
	/**
	* Описание заявки.
	*/
    private String description;
	/**
	* Дата создания заявки.
	*/
    private Timestamp date;

    /**
     * Item.
     * @param id this.
     * @param name this.
     * @param description this.
     * @param date this.
     */
    public Item(int id, String name, String description, Timestamp date) {
        this.id = id;
		this.name = name;
        this.description = description;
		this.date = date;
    }

    /**
     * Get id.
     * @return int.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get name.
     * @return String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get description.
     * @return String.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get create date.
     * @return date.
     */
    public Timestamp getDate() {
        return this.date;
    }
}