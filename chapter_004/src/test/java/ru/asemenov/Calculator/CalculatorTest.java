package ru.asemenov.Calculator;

import org.junit.Test;
import ru.asemenov.Calculator.Input.Input;
import ru.asemenov.Calculator.Input.StubInput;
import ru.asemenov.Calculator.MenuCalc.MenuCalculator;
import ru.asemenov.Calculator.MenuCalc.MenuScientificCalculator;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Class CalculatorTest решение задачи части 004 урока 1.
 * @author asemenov
 * @version 1
 */
public class CalculatorTest {
    /**
     * Calculator test.
     * @throws IOException exception.
     */
    @Test
    public void calculatorTest() throws IOException {
        Input input = new StubInput(new String[]{"2", "4", "+", "4", "=", "y"});
        Calculator calculator = new Calculator();
        MenuCalculator mc = new MenuCalculator(input, calculator);
        mc.fillActions();
        InteractCalc ic = new InteractCalc(input, mc);
        ic.init();
        double result = 8.0;

        assertThat(calculator.getResult(), is(result));
    }
    /**
     * Engeener calculator test.
     * @throws IOException exception.
     */
    @Test
    public void engenerCalculatorTest() throws IOException {
        Input input = new StubInput(new String[]{"2", "60", "tan", "=", "y"});
        Calculator calculator = new Calculator();
        MenuCalculator mc = new MenuScientificCalculator(input, calculator);
        mc.fillActions();
        InteractCalc ic = new InteractCalc(input, mc);
        ic.init();
        double result = 1.73;

        assertThat(calculator.getResult(), closeTo(result, 0.01));
    }
}
