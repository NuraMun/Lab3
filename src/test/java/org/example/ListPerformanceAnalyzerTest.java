package org.example;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListPerformanceAnalyzerTest {

    private static final int TEST_SIZE = 1000;

    /**
     * Тестирует операцию добавления элементов
     */
    @Test
    public void testMeasureAddPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        long arrayListTime = ListPerformanceAnalyzer.measureAddPerformance(arrayList, TEST_SIZE);

        assertTrue(arrayListTime > 0, "Время выполнения должно быть положительным");
        assertEquals(TEST_SIZE, arrayList.size(), "Размер списка должен соответствовать количеству добавленных элементов");
    }

    /**
     * Тестирует операцию удаления элементов
     */
    @Test
    public void testMeasureRemovePerformance() {
        List<Integer> linkedList = new LinkedList<>();
        ListPerformanceAnalyzer.fillList(linkedList, TEST_SIZE);

        long linkedListTime = ListPerformanceAnalyzer.measureRemovePerformance(linkedList, TEST_SIZE);

        assertTrue(linkedListTime > 0, "Время выполнения должно быть положительным");
        assertTrue(linkedList.isEmpty(), "Список должен быть пуст после удаления всех элементов");
    }

    /**
     * Тестирует операцию получения элементов
     */
    @Test
    public void testMeasureGetPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        ListPerformanceAnalyzer.fillList(arrayList, TEST_SIZE);

        long arrayListTime = ListPerformanceAnalyzer.measureGetPerformance(arrayList, TEST_SIZE);

        assertTrue(arrayListTime > 0, "Время выполнения должно быть положительным");
        assertEquals(TEST_SIZE, arrayList.size(), "Размер списка не должен измениться");
    }

    /**
     * Тестирует заполнение списка
     */
    @Test
    public void testFillList() {
        List<Integer> list = new ArrayList<>();
        ListPerformanceAnalyzer.fillList(list, TEST_SIZE);

        assertEquals(TEST_SIZE, list.size(), "Размер списка должен соответствовать количеству добавленных элементов");
        for (int i = 0; i < TEST_SIZE; i++) {
            assertEquals(i, list.get(i), "Элементы должны быть добавлены в правильном порядке");
        }
    }

}