package ru.asemenov.Calculator.MenuCalc;

import ru.asemenov.Calculator.Calculator;
import ru.asemenov.Calculator.Input.Input;

import java.io.IOException;
/**
 * Class MenuScientificCalculator решение задачи части 004 урока 2.
 * @author asemenov
 * @version 1
 */
public class MenuScientificCalculator extends MenuDecorator {
    /**
     * Calculator.
     */
    private Calculator calculator;
    /**
     * MenuScientificCalculator constructor.
     * @param menu menu.
     * @param calculator calculator.
     */
    public MenuScientificCalculator(InterfaceMenu menu, Calculator calculator) {
        super(menu);
        this.calculator = calculator;
    }
    /**
     * Fill actions.
     */
    @Override
    public void fillActions() {
        super.fillActions();
        super.addAction(new Sin());
        super.addAction(new Cos());
        super.addAction(new Tan());
    }
    /**
     * Sin.
     */
    private class Sin extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "sin";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Синус sin";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            calculator.sin(first);
        }
    }
    /**
     * Cos.
     */
    private class Cos extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "cos";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Косинус cos";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            calculator.cos(first);
        }
    }
    /**
     * Tan.
     */
    private class Tan extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "tan";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Тангенс tan";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            calculator.tan(first);
        }
    }
}
