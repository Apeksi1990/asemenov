package ru.asemenov.TestTask;
/**
 * Class StartTaskTest решение задачи части 003.
 * @author asemenov
 * @version 1
 */
public class StartTaskTest {
    /**
     * Main.
     * @param args args.
     */
    public static void main(String[] args) {
        int[] massive = new int[]{1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 3, 3, 4, 5, 1};
        TestTask tt = new TestTask();
        massive = tt.del(massive);
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i]);
        }
    }
}
