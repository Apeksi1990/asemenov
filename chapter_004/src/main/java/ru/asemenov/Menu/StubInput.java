package ru.asemenov.Menu;

/**
 * Class StubInput решение задачи части 004 урока 4.
 * @author asemenov
 * @version 1
 */
public class StubInput implements Input {
    /**
     * this.answer.
     */
	private String[] answers;
	/**
     * position.
     */
    private int position = 0;
	/**
     * Конструктор принимающий значения ответов.
	 * @param answers ответы.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
	/**
     * Получения значения из массива answer.
	 * @param question question.
	 * @return answer answer.
     */
    public String ask(String question) {
        return answers[position++];
    }
}
