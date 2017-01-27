package ru.asemenov.Calculator.MenuCalc;

import ru.asemenov.Calculator.Calculator;
import ru.asemenov.Calculator.Input.Input;

import java.io.IOException;
/**
 * Class MenuScientificCalculator решение задачи части 004 урока 2.
 * @author asemenov
 * @version 1
 */
public class MenuScientificCalculator extends MenuCalculator {
    /**
     * MenuScientificCalculator constructor.
     * @param input input.
     * @param calculator calculator.
     */
    public MenuScientificCalculator(Input input, Calculator calculator) {
        super(input, calculator);
    }
    /**
     * Fill actions.
     */
    @Override
    public void fillActions() {
        this.actions.add(new Add());
        this.actions.add(new Sub());
        this.actions.add(new Mult());
        this.actions.add(new Div());
        this.actions.add(new Sin());
        this.actions.add(new Cos());
        this.actions.add(new Tan());
    }
    /**
     * Sin.
     */
    class Sin extends BaseAction {
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
    class Cos extends BaseAction {
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
    class Tan extends BaseAction {
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
