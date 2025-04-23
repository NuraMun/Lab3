package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceAnalyzer {

    private static final int TEST_SIZE = 2000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Анализ производительности ArrayList vs LinkedList");
        System.out.println("Тестовый размер: " + TEST_SIZE + " операций\n");

        // Заголовок таблицы
        printTableHeader();

        // Тестирование операций
        testAddOperation();
        testRemoveOperation();
        testGetOperation();
    }

    private static void printTableHeader() {
        System.out.println("+----------------+----------------+------------------+------------------+");
        System.out.println("|    Операция    | Кол-во вызовов | ArrayList (нс)   | LinkedList (нс)  |");
        System.out.println("+----------------+----------------+------------------+------------------+");
    }

    private static void printTableRow(String operation, int calls, long arrayListTime, long linkedListTime) {
        System.out.printf("| %-14s | %-14d | %-16d | %-16d |\n",
                operation, calls, arrayListTime, linkedListTime);
        System.out.println("+----------------+----------------+------------------+------------------+");
    }

    private static void testAddOperation() {
        // ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - start;

        // LinkedList
        List<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - start;

        printTableRow("add()", TEST_SIZE, arrayListTime, linkedListTime);
    }

    private static void testRemoveOperation() {
        // Подготовка данных
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // ArrayList
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.remove(arrayList.size() - 1);
        }
        long arrayListTime = System.nanoTime() - start;

        // LinkedList
        start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
        long linkedListTime = System.nanoTime() - start;

        printTableRow("remove()", TEST_SIZE, arrayListTime, linkedListTime);
    }

    private static void testGetOperation() {
        // Подготовка данных
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // ArrayList
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.get(random.nextInt(TEST_SIZE));
        }
        long arrayListTime = System.nanoTime() - start;

        // LinkedList
        start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.get(random.nextInt(TEST_SIZE));
        }
        long linkedListTime = System.nanoTime() - start;

        printTableRow("get()", TEST_SIZE, arrayListTime, linkedListTime);
    }
}