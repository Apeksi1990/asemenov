package ru.asemenov.Calculator;

import ru.asemenov.Calculator.Input.Input;
import ru.asemenov.Calculator.MenuCalc.MenuCalculator;

import java.io.IOException;

/**
 * Class InteractCalc решение задачи части 004 урока 1.
 * @author asemenov
 * @version 1
 */
public class InteractCalc {
    /**
     * Input.
     */
    private Input input;
    /**
     * Menu calculator.
     */
    private MenuCalculator mc;
    /**
     * InteractCalc constructor.
     * @param input input.
     * @param mc mc.
     */
    InteractCalc(Input input, MenuCalculator mc) {
        this.input = input;
        this.mc = mc;
    }
    /**
     * Init.
     * @throws IOException exception.
     */
    void init() throws IOException {
        do {
            mc.homePage();
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }
}
