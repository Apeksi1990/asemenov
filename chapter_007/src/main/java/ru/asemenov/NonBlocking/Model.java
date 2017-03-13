package ru.asemenov.NonBlocking;
/**
 * Class Model решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Model {
    /**
     * Index.
     */
    private int index;
    /**
     * Version model.
     */
    private volatile int version = 0;

    /**
     * Model constructor.
     * @param index model.
     */
    public Model(int index) {
        this.index = index;
    }

    /**
     * Get index.
     * @return int.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get version.
     * @return int.
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Set version.
     */
    public void setVersion() {
        this.version++;
    }

    /**
     * Override toString.
     * @return String.
     */
    @Override
    public String toString() {
        return "Model{" + "index=" + index + ", version=" + version + '}';
    }
}
