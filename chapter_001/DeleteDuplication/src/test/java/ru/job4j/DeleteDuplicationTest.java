package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DeleteDuplicationTest решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class DeleteDuplicationTest {
	/**
	* Тест удаления дубликатов из массива.
	*/
	@Test
	public void whenDuplicationMassivThenDeleteDuplicationMassiv() {
		DeleteDuplication deldup = new DeleteDuplication();
        String[] massiv = new String[]{"один", "два", "один", "три", "три", "пять", "два", "шесть", "семь", "один", "пять", "три", "десять", "двадцать", "тридцать"};
        String[] massivtest = new String[]{"один", "два", "тридцать", "три", "двадцать", "пять", "десять", "шесть", "семь"};
        massiv = deldup.deldup(massiv);
        assertThat(massiv, is(massivtest));
	}
}