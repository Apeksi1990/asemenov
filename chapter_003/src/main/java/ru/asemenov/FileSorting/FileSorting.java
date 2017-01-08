package ru.asemenov.FileSorting;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSorting {
    /**
     * Метод внешний сортировки.
     * @param sourse sourse.
     * @param distance distance.
     */
    void sort(File sourse, File distance) {
        try {
            RandomAccessFile read = new RandomAccessFile(sourse, "r");
            RandomAccessFile write = new RandomAccessFile(distance, "rw");
            boolean result;
            String line;
            while ((line = read.readLine()) != null) {
                write.writeBytes(line + "\r\n");
            }
            do {
                File firstFile = new File("First.txt");
                File secondFile = new File("Second.txt");

                dividedDistance(distance, firstFile, secondFile);

                write.close();
                distance.delete();
                distance = new File(distance.getName());
                write = new RandomAccessFile(distance, "rw");

                result = mergerFiles(distance, firstFile, secondFile);

                firstFile.delete();
                secondFile.delete();


            }while (!result);

        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
    /**
     * Метод разбития на два файла.
     * @param distance distance.
     * @param first firstFile.
     * @param second secondFile.
     */
    private void dividedDistance(File distance, File first, File second) {
        try {
            RandomAccessFile dist = new RandomAccessFile(distance, "rw");
            RandomAccessFile firstFile = new RandomAccessFile(first, "rw");
            RandomAccessFile secondFile = new RandomAccessFile(second, "rw");

            String line;
            String lastLine = "";
            int fileNumber = 0; // 0 = firstFile, 1 = secondFile
            if ((line = dist.readLine()) != null) {
                firstFile.writeBytes(line  + "\r\n");
                lastLine = line;
            }
            while ((line = dist.readLine()) != null) {
                if (fileNumber == 0) {
                    if (line.length() > lastLine.length()) {
                        firstFile.writeBytes(line + "\r\n");
                    } else {
                        secondFile.writeBytes(line + "\r\n");
                        fileNumber = 1;
                    }
                } else {
                    if (line.length() > lastLine.length()) {
                        secondFile.writeBytes(line + "\r\n");
                    } else {
                        firstFile.writeBytes(line + "\r\n");
                        fileNumber = 0;
                    }
                }
                lastLine = line;
            }
        } catch (IOException exc) {
            System.out.println(exc);
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
        try {
            RandomAccessFile dist = new RandomAccessFile(distance, "rw");
            RandomAccessFile firstFile = new RandomAccessFile(first, "rw");
            RandomAccessFile secondFile = new RandomAccessFile(second, "rw");

            String lineOne = firstFile.readLine();
            String lineTwo = secondFile.readLine();
            String lastLine = "";

            if (lineTwo == null) {
                dist.writeBytes(lineOne + "\r\n");
                while ((lineOne = firstFile.readLine()) != null) {
                    dist.writeBytes(lineOne + "\r\n");
                }
                return true;
            }

            while (lineOne != null & lineTwo != null) {
                if (lineOne != null & lineTwo == null) {
                    dist.writeBytes(lineOne + "\r\n");
                    lineOne = firstFile.readLine();
                }
                else if (lineTwo != null & lineOne == null) {
                    dist.writeBytes(lineTwo + "\r\n");
                    lineTwo = secondFile.readLine();
                }
                else if (lineOne.length() < lineTwo.length()) {
                    if (lineOne.length() > lastLine.length()) {
                        dist.writeBytes(lineOne + "\r\n");
                        lastLine = lineOne;
                        lineOne = firstFile.readLine();
                    } else {
                        dist.writeBytes(lineTwo + "\r\n");
                        lastLine = lineTwo;
                        lineTwo = secondFile.readLine();
                    }
                }
                else if (lineOne.length() > lineTwo.length()) {
                    if (lineTwo.length() > lastLine.length()) {
                        dist.writeBytes(lineTwo + "\r\n");
                        lastLine = lineTwo;
                        lineTwo = secondFile.readLine();
                    } else {
                        dist.writeBytes(lineOne + "\r\n");
                        lastLine = lineOne;
                        lineOne = firstFile.readLine();
                    }
                }
            }

        } catch (IOException exc) {
            System.out.println(exc);
        }
        return false;
    }
}