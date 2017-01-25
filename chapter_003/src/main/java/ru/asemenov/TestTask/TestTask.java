package ru.asemenov.TestTask;

import java.util.ArrayList;
/**
 * Class TestTask решение задачи части 003.
 * @author asemenov
 * @version 1
 */
public class TestTask {
    /**
     * Delete sequence.
     * @param massive massive.
     * @return result.
     */
    public int[] del(int[] massive) {
        ArrayList<Integer> result = new ArrayList<>();
        if (massive[0] != massive[1]) {
            result.add(massive[0]);
        }
        for (int i = 1; i < massive.length - 1; i++) {
            if (massive[i] != massive[i - 1] & massive[i] != massive[i + 1]) {
                result.add(massive[i]);
            }
        }
        if (massive[massive.length - 1] != massive[massive.length - 2]) {
            result.add(massive[massive.length - 1]);
        }
        int[] finish = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finish[i] = result.get(i);
        }
        return finish;
    }
}
