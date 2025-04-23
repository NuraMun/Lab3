package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Класс для сравнения производительности ArrayList и LinkedList.
 * Тестирует основные операции: добавление, удаление и получение элементов.
 */
public class ListPerformanceAnalyzer {

    private static final int DEFAULT_TEST_SIZE = 2000;
    private static final Random random = new Random();

    /**
     * Точка входа в программу. Запускает тесты производительности и выводит результаты.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("Анализ производительности ArrayList vs LinkedList");
        System.out.println("Тестовый размер: " + DEFAULT_TEST_SIZE + " операций\n");

        printTableHeader();

        testAddOperation(DEFAULT_TEST_SIZE);
        testRemoveOperation(DEFAULT_TEST_SIZE);
        testGetOperation(DEFAULT_TEST_SIZE);
    }

    /**
     * Выводит заголовок таблицы результатов
     */
    private static void printTableHeader() {
        System.out.println("+----------------+----------------+------------------+------------------+");
        System.out.println("|    Операция    | Кол-во вызовов | ArrayList (нс)   | LinkedList (нс)  |");
        System.out.println("+----------------+----------------+------------------+------------------+");
    }

    /**
     * Выводит строку с результатами тестирования
     *
     * @param operation название операции
     * @param calls количество вызовов
     * @param arrayListTime время выполнения для ArrayList (нс)
     * @param linkedListTime время выполнения для LinkedList (нс)
     */
    private static void printTableRow(String operation, int calls, long arrayListTime, long linkedListTime) {
        System.out.printf("| %-14s | %-14d | %-16d | %-16d |\n",
                operation, calls, arrayListTime, linkedListTime);
        System.out.println("+----------------+----------------+------------------+------------------+");
    }

    /**
     * Тестирует операцию добавления элементов
     *
     * @param testSize количество операций для тестирования
     */
    public static void testAddOperation(int testSize) {
        List<Integer> arrayList = new ArrayList<>();
        long arrayListTime = measureAddPerformance(arrayList, testSize);

        List<Integer> linkedList = new LinkedList<>();
        long linkedListTime = measureAddPerformance(linkedList, testSize);

        printTableRow("add()", testSize, arrayListTime, linkedListTime);
    }

    /**
     * Тестирует операцию удаления элементов
     *
     * @param testSize количество операций для тестирования
     */
    public static void testRemoveOperation(int testSize) {
        List<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, testSize);
        long arrayListTime = measureRemovePerformance(arrayList, testSize);

        List<Integer> linkedList = new LinkedList<>();
        fillList(linkedList, testSize);
        long linkedListTime = measureRemovePerformance(linkedList, testSize);

        printTableRow("remove()", testSize, arrayListTime, linkedListTime);
    }

    /**
     * Тестирует операцию получения элементов
     *
     * @param testSize количество операций для тестирования
     */
    public static void testGetOperation(int testSize) {
        List<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, testSize);
        long arrayListTime = measureGetPerformance(arrayList, testSize);

        List<Integer> linkedList = new LinkedList<>();
        fillList(linkedList, testSize);
        long linkedListTime = measureGetPerformance(linkedList, testSize);

        printTableRow("get()", testSize, arrayListTime, linkedListTime);
    }

    /**
     * Замеряет время выполнения операции добавления
     *
     * @param list список для тестирования
     * @param iterations количество итераций
     * @return время выполнения в наносекундах
     */
    public static long measureAddPerformance(List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    /**
     * Замеряет время выполнения операции удаления
     *
     * @param list список для тестирования
     * @param iterations количество итераций
     * @return время выполнения в наносекундах
     */
    public static long measureRemovePerformance(List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.remove(list.size() - 1);
        }
        return System.nanoTime() - start;
    }

    /**
     * Замеряет время выполнения операции получения элемента
     *
     * @param list список для тестирования
     * @param iterations количество итераций
     * @return время выполнения в наносекундах
     */
    public static long measureGetPerformance(List<Integer> list, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.get(random.nextInt(list.size()));
        }
        return System.nanoTime() - start;
    }

    /**
     * Заполняет список тестовыми данными
     *
     * @param list список для заполнения
     * @param count количество элементов
     */
    public static void fillList(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }
}