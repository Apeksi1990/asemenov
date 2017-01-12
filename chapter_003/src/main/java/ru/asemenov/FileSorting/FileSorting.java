package ru.asemenov.FileSorting;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * Class FileSorting решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class FileSorting {
    /**
     * Separator.
     */
    private String separator = System.getProperty("line.separator");
    /**
     * Метод внешний сортировки.
     * @param sourse sourse.
     * @param distance distance.
     */
    void sort(File sourse, File distance) {
        try (RandomAccessFile read = new RandomAccessFile(sourse, "r");
            RandomAccessFile write = new RandomAccessFile(distance, "rw")) {

            File firstFile = new File("FirstFile.txt");
            File secondFile = new File("SecondFile.txt");
            RandomAccessFile firstRaf = new RandomAccessFile(firstFile, "rw");
            RandomAccessFile secondRaf = new RandomAccessFile(secondFile, "rw");

            boolean result;

            String line;
            while ((line = read.readLine()) != null) {
                write.writeBytes(line);
                write.writeBytes(separator);
            }
            do {
                dividedDistance(distance, firstFile, secondFile);
                write.setLength(0);
                result = mergerFiles(distance, firstFile, secondFile);
                firstRaf.setLength(0);
                secondRaf.setLength(0);
            } while (!result);

            firstRaf.close();
            firstFile.delete();
            secondRaf.close();
            secondFile.delete();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    /**
     * Метод разбития на два файла.
     * @param distance distance.
     * @param first firstFile.
     * @param second secondFile.
     */
    private void dividedDistance(File distance, File first, File second) {
        try (RandomAccessFile dist = new RandomAccessFile(distance, "rw");
             RandomAccessFile firstFile = new RandomAccessFile(first, "rw");
             RandomAccessFile secondFile = new RandomAccessFile(second, "rw");) {

            String line;
            String lastLine = "";
            int fileNumber = 0; // 0 = firstFile, 1 = secondFile
            if ((line = dist.readLine()) != null) {
                firstFile.writeBytes(line);
                firstFile.writeBytes(separator);
                lastLine = line;
            }
            while ((line = dist.readLine()) != null) {
                if (fileNumber == 0) {
                    if (line.length() >= lastLine.length()) {
                        firstFile.writeBytes(line);
                        firstFile.writeBytes(separator);
                    } else {
                        secondFile.writeBytes(line);
                        secondFile.writeBytes(separator);
                        fileNumber = 1;
                    }
                } else {
                    if (line.length() >= lastLine.length()) {
                        secondFile.writeBytes(line);
                        secondFile.writeBytes(separator);
                    } else {
                        firstFile.writeBytes(line);
                        firstFile.writeBytes(separator);
                        fileNumber = 0;
                    }
                }
                lastLine = line;
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    /**
     * Метод сляния.
     * @param distance distance.
     * @param first firstFile.
     * @param second secondFile.
     * @return result.
     */
    private boolean mergerFiles(File distance, File first, File second) {
        try (RandomAccessFile dist = new RandomAccessFile(distance, "rw");
            RandomAccessFile firstFile = new RandomAccessFile(first, "rw");
            RandomAccessFile secondFile = new RandomAccessFile(second, "rw");) {

            String lineOne = firstFile.readLine();
            String lineTwo = secondFile.readLine();
            if (lineTwo == null) {
                dist.writeBytes(lineOne);
                dist.writeBytes(separator);
                while ((lineOne = firstFile.readLine()) != null) {
                    dist.writeBytes(lineOne);
                    dist.writeBytes(separator);
                }
                return true;
            }
            while (lineOne != null & lineTwo != null) {
                if (lineOne.length() <= lineTwo.length()) {
                    dist.writeBytes(lineOne);
                    dist.writeBytes(separator);
                    lineOne = firstFile.readLine();
                } else {
                    dist.writeBytes(lineTwo);
                    dist.writeBytes(separator);
                    lineTwo = secondFile.readLine();
                }
            }
            while (lineOne != null) {
                dist.writeBytes(lineOne);
                dist.writeBytes(separator);
                lineOne = firstFile.readLine();
            }
            while (lineTwo != null) {
                dist.writeBytes(lineTwo);
                dist.writeBytes(separator);
                lineTwo = secondFile.readLine();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return false;
    }
}