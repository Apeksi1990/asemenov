package ru.asemenov.garbageCollection;
/**
 * Class MemoryUsage решение задачи части 006.
 * @author asemenov
 * @version 1
 */
public class MemoryUsage {
    /**
     * Class user.
     */
    private static class User {
        /**
         * Name.
         */
        private String name;

        /**
         * User constructor.
         * @param name name.
         */
        User(String name) {
            this.name = name;
        }

        /**
         * Override finalize.
         * @throws Throwable throw.
         */
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(String.format("destroy object user " + this));
        }

        /**
         * Override toString.
         * @return name.
         */
        @Override
        public String toString() {
            return "User{name = " + name + "}";
        }
    }

    /**
     * Main.
     * @param args arg.
     */
    public static void main(String[] args) {
        System.out.println("Start");
        User user = new User("Test");
        System.out.printf(user.toString());
        System.out.println();
        user  = null;
        System.gc();
        System.out.println("Finish");
    }

    /**
     * Info.
     */
    public static void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Info");
        System.out.println("User Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Free Memory: " + runtime.freeMemory() / mb);
        System.out.println("Total Memory: " + runtime.totalMemory() / mb);
        System.out.println("Max Memory: " + runtime.maxMemory() / mb);
    }
}
