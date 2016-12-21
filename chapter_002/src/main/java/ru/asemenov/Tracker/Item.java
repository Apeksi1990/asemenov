package ru.asemenov.Tracker;

/**
 * Class Item решение задачи части 002 урока 2.
 * @author asemenov
 * @version 1
 */
public class Item {
    /**
	* id заявки.
	*/
	private String id;
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
    private long date;
	/**
	* Комментарии заявки.
	*/
    private String[] comments = new String[5];
	/**
	* Кол-во комментариев.
	*/
    private int commentCount = 0;

	/**
	* Метод принимающий новую заявку.
	* @param name имя заявки.
	* @param description описание заявки.
	*/
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
	/**
	* Отправить номер заявки.
	* @return id вернуть id
	*/
    public String getId() {
        return this.id;
    }
	/**
	* Установить новый id заявки.
	* @param id новое id.
	*/
    public void setId(String id) {
        this.id = id;
    }
	/**
	* Отправить имя заявки.
	* @return name вернуть имя.
	*/
    public String getName() {
        return this.name;
    }
	/**
	* Установить новое имя заявки.
	* @param name новое имя.
	*/
    public void setName(String name) {
        this.name = name;
    }
	/**
	* Отправить описание заявки.
	* @return description вернуть описание.
	*/
    public String getDescription() {
        return this.description;
    }
	/**
	* Установить новое описание заявки.
	* @param description новое описание.
	*/
    public void setDescription(String description) {
        this.description = description;
    }
	/**
	* Отправить дату создания заявки.
	* @return date вернуть дату.
	*/
    public long getDate() {
        return this.date;
    }
	/**
	* Установить новую дату заявки.
	* @param date нова дата.
	*/
    public void setDate(long date) {
        this.date = date;
    }
	/**
	* Отправить комментарии заявки.
	* @return comment возвратить комментарии.
	*/
    public String[] getComments() {
        return this.comments;
    }
	/**
	* Добавить новый комментарий.
	* @param comment новый комментарий.
	*/
    public void addComments(String comment) {
        this.comments[commentCount++] = comment;
    }
}