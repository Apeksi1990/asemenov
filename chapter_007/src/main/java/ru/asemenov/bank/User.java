package ru.asemenov.bank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * Class User.
 * @author asemenov
 * @version 1
 */
public class User {
    /**
     * Date format.
     */
    private DateFormat format;
    /**
     * Enter time.
     */
    private String enter;
    /**
     * Exit time.
     */
    private String exit;

    /**
     * User constructor.
     * @param enter String.
     * @param exit String.
     */
    public User(String enter, String exit) {
        this.enter = enter;
        this.exit = exit;
        format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
    }

    /**
     * Get enter date.
     * @return Date.
     */
    Date getEnter() {
        Date date = null;
        try {
            date = format.parse(enter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Get exit date.
     * @return Date.
     */
    Date getExit() {
        Date date = null;
        try {
            date = format.parse(exit);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
