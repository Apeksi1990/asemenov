package ru.asemenov.Calculator;

import ru.asemenov.Calculator.Input.ConsoleInput;
import ru.asemenov.Calculator.Input.Input;
import ru.asemenov.Calculator.MenuCalc.InterfaceMenu;
import ru.asemenov.Calculator.MenuCalc.MenuCalculator;
import ru.asemenov.Calculator.MenuCalc.MenuScientificCalculator;

import java.io.IOException;
/**
 * Class StartCalculator решение задачи части 004 урока 1.
 * @author asemenov
 * @version 1
 */
public class StartCalculator {
    /**
     * Main.
     * @param args args.
     * @throws IOException exception.
     */
    public static void main(String[] args) throws IOException {
        Input input = new ConsoleInput();
        Calculator calculator = new Calculator();
        InterfaceMenu menuCalculator = new MenuScientificCalculator(new MenuCalculator(input, calculator), calculator);
        InteractCalc ic = new InteractCalc(input, menuCalculator);
        menuCalculator.fillActions();
        ic.init();
    }
}
