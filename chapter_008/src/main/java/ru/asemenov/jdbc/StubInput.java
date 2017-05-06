package ru.asemenov.jdbc;

/**
 * Class StubInput решение задачи части 002 урока 3.
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
	/**
     * Exception.
     * @param question question.
     * @param range range.
     * @return answer answer
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return exist ? key : -1;
    }
}
