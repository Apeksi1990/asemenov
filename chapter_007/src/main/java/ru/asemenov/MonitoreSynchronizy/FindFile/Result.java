package ru.asemenov.MonitoreSynchronizy.FindFile;

public class Result {
    /**
     * Result.
     */
    private boolean result = false;

    /**
     * Get result.
     * @return boolean.
     */
    public synchronized boolean isResult() {
        return result;
    }

    /**
     * Set result.
     */
    public synchronized void setResult() {
        this.result = true;
    }
}
