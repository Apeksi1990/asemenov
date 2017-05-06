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


    public Item(int id, String name, String description, Timestamp date) {
        this.id = id;
		this.name = name;
        this.description = description;
		this.date = date;
    }

    public int getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public String getDescription() {
        return this.description;
    }

    public Timestamp getDate() {
        return this.date;
    }
}