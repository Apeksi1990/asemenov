package ru.asemenov.garbageCollection;
/**
 * Class User решение задачи части 006.
 * @author asemenov
 * @version 1
 */
public class User {
    /**
     * Name.
     */
    private String name;

    /**
     * User constructor.
     * @param name name.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Override finalize.
     * @throws Throwable throw.
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("destroy object user " + this);
    }

    /**
     * Info.
     */
    public void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Info");
        System.out.println("User Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Free Memory: " + runtime.freeMemory() / mb);
        System.out.println("Total Memory: " + runtime.totalMemory() / mb);
    }

    /**
     * Override toString.
     * @return name.
     */
    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        User user;
        for (int i = 0; i < 300; i++) {
            user = new User("Name" + i);
            System.out.println(user);
            user.info();
        }
    }
}
