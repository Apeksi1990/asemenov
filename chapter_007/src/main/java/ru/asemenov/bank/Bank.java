package ru.asemenov.bank;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class Bank.
 * @author asemenov
 * @version 1
 */
public class Bank {
    /**
     * Count visitors.
     */
    private int count = 0;
    /**
     * Max visitors.
     */
    private int max = 0;
    /**
     * Enter date.
     */
    private Date enter;
    /**
     * Exit date.
     */
    private Date exit;

    /**
     * All time enter and exit.
     */
    private Map<Date, Boolean> timeEnterAndExit;

    /**
     * Bank constructor.
     */
    public Bank() {
        this.timeEnterAndExit = new TreeMap<>();
    }

    /**
     * Add visitors.
     * @param user User.
     */
    void addVisitor(User user) {
        this.timeEnterAndExit.put(user.getEnter(), true);
        this.timeEnterAndExit.put(user.getExit(), false);
    }


    /**
     * Start find time and max visitors.
     */
    void findTime() {
        for (Date date : this.timeEnterAndExit.keySet()) {
            changeCount(date);
            setTime(date);
        }
    }

    /**
     * Change count.
     * @param date Date.
     */
    private void changeCount(Date date) {
        if (this.timeEnterAndExit.get(date).equals(true)) {
            this.count++;
        } else {
            this.count--;
        }
    }

    /**
     * Set time.
     * @param date Date.
     */
    private void setTime(Date date) {
        if (this.count > this.max) {
            this.enter = date;
            this.exit = null;
            this.max = this.count;
        } else if (this.count < this.max & this.exit == null) {
            this.exit = date;
        }
    }

    /**
     * Result.
     * @return String.
     */
    String result() {
        return String.format("Max visitors: %s. Enter time: %s. Exit time: %s", this.max, this.enter, this.exit);
    }

    /**
     * Max visitors.
     * @return int.
     */
    public int getMax() {
        return max;
    }
}