package ru.asemenov.Calculator.MenuCalc;

import ru.asemenov.Calculator.Calculator;
import ru.asemenov.Calculator.Input.Input;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Class MenuCalculator решение задачи части 004 урока 1.
 * @author asemenov
 * @version 1
 */
public class MenuCalculator {
    /**
     * Input.
     */
    private Input input;
    /**
     * Calculator.
     */
    protected Calculator calculator;
    /**
     * MenuCalculator constructor.
     * @param input input.
     * @param calculator calculator.
     */
    public MenuCalculator(Input input, Calculator calculator) {
        this.input = input;
        this.calculator = calculator;
    }
    /**
     * Actions.
     */
    protected ArrayList<BaseAction> actions = new ArrayList<>();
    /**
     * Add action.
     * @param action action.
     */
    public void addAction(BaseAction action) {
        this.actions.add(action);
    }
    /**
     * Fill actions.
     */
    public void fillActions() {
        this.actions.add(new Add());
        this.actions.add(new Sub());
        this.actions.add(new Mult());
        this.actions.add(new Div());
    }
    /**
     * Home page.
     * @throws IOException exception.
     */
    public void homePage() throws IOException {
        System.out.println("1. Help actions.");
        System.out.println("2. Start calculation.");
        String message = input.ask("Select number: ");
        if (message.equals("1")) {
            showAction();
        } else if (message.equals("2")) {
            start();
        } else {
            System.out.println("Select correct number.");
        }
    }
    /**
     * Start.
     * @throws IOException exception.
     */
    private void start() throws IOException {
        try {
            double first = input.askDouble("First value: ");
            String action = symbolSelect();
            select(action, first);
            continueCount();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
    /**
     * Continue count.
     * @throws IOException exception.
     */
    private void continueCount() throws IOException {
        String action;
        boolean next = false;
        while (!next) {
            action = input.ask("Continue action: ");
            if ("=".equals(action)) {
                result();
                next = true;
            } else if (checkKey(action) != null) {
                select(action, calculator.getResult());
            } else {
                System.out.println("Enter correct action");
            }
        }
    }
    /**
     * Show result.
     */
    private void result() {
        System.out.println(String.format("Result: %s", calculator.getResult()));
    }
    /**
     * Show actions.
     */
    private void showAction() {
        for (BaseAction action : this.actions) {
            if (action != null) {
                this.showInfo(action);
            }
        }
    }
    /**
     * Show info.
     * @param action action.
     */
    private void showInfo(BaseAction action) {
        System.out.println(action.info());
    }
    /**
     * Correct symbol select.
     * @return action.
     */
    private String symbolSelect() {
        String action;
        while (checkKey(action = input.ask("Action: ")) == null) {
            System.out.println("Enter correct action");
        }
        return action;
    }
    /**
     * Select action.
     * @param string action.
     * @param first first.
     * @throws IOException exception.
     */
    private void select(String string, double first) throws IOException {
        BaseAction action = checkKey(string);
        if (action != null) {
            action.execute(first, this.input);
        }
    }
    /**
     * Check key.
     * @param message message.
     * @return action.
     */
    private BaseAction checkKey(String message) {
        BaseAction result = null;
        for (BaseAction action : this.actions) {
            if (message.equals(action.key())) {
                result = action;
            }
        }
        return result;
    }
    /**
     * Add.
     */
    class Add extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "+";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Сложение +";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            double second = input.askDouble("Next value: ");
            calculator.add(first, second);
        }
    }
    /**
     * Sub.
     */
    class Sub extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "-";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Вычитание -";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            double second = input.askDouble("Next value: ");
            calculator.sub(first, second);
        }
    }
    /**
     * Mult.
     */
    class Mult extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "*";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Умножение *";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            double second = input.askDouble("Next value: ");
            calculator.mult(first, second);
        }
    }
    /**
     * Div.
     */
    class Div extends BaseAction {
        /**
         * Key.
         * @return key.
         */
        public String key() {
            return "/";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Деление /";
        }
        /**
         * Execute.
         * @param first first.
         * @param input input.
         * @throws IOException exception.
         */
        public void execute(double first, Input input) throws IOException {
            double second = input.askDouble("Next value: ");
            calculator.div(first, second);
        }
    }
}
