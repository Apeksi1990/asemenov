package ru.job4j;

/**
 * Class Paint решение задачи части 001 урока 4.
 * @author asemenov
 * @version 1
 */
public class Paint {
	/**
	* Метод построения пирамиды.
	* @author asemenov
	* @version 1
	* @return пирамида.
	* @param h высота пирамиды.
	*/
    public StringBuilder pyramid(int h) {
        StringBuilder sb = new StringBuilder();
        String pyramid = "^ ";
        for (int i = 1; i <= h; i++) {
            for (int y = i; y < h; y++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                sb.append(pyramid);
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb;
    }
}