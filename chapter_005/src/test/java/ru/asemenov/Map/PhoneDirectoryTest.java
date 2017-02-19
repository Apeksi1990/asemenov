package ru.asemenov.Map;

import org.junit.Test;

import java.util.Iterator;

public class PhoneDirectoryTest {
    @Test
    public void whenAddPhoneThenReturnCorrectPhone() {
        Directory<Integer, String> directory = new PhoneDirectory<>(10);
        directory.insert(123456, "Alex");
        directory.insert(654321, "Olya");
        directory.insert(192837, "Putin");
        Iterator<String> iterator = directory.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}