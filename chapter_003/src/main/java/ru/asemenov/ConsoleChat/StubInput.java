package ru.asemenov.ConsoleChat;
/**
 * Class StubInput решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class StubInput implements Input {
    /**
     * Answers.
     */
    private String[] answers;
    /**
     * position in answers.
     */
    private int position = 0;
    /**
     * Конструктор StubInput.
     * @param answers answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Message Input.
     * @return answer.
     */
    public String message() {
        return answers[position++];
    }
}
