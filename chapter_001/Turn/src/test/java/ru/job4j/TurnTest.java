package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TurnTest решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class TurnTest {
	/**
	* One.
	*/
	private final int one = 1;
	/**
	* Two.
	*/
	private final int two = 2;
	/**
	* Three.
	*/
	private final int three = 3;
	/**
	* Four.
	*/
	private final int four = 4;
	/**
	* Массив для тестирования.
	*/
	private int[] massiv = new int[]{one, two, three, four};
	/**
	* Ожидаемый результат теста.
	*/
	private int[] massivtest = new int[]{four, three, two, one};
	/**
	* Тест переворота массива.
	*/
	@Test
	public void whenGiveMassivThenGiveBackMassiv() {
		Turn turn = new Turn();
		assertThat(turn.back(massiv), is(massivtest));
	}
}