package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutPut() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 1);
        simpleMap.put(2, 1);
        simpleMap.put(3, 1);
        simpleMap.put(4, 1);
        simpleMap.put(5, 1);
        simpleMap.put(6, 1);
        simpleMap.put(7, 1);
        simpleMap.put(8, 1);
        simpleMap.put(9, 1);
        assertTrue(simpleMap.put(10, 1));
        assertFalse(simpleMap.put(1, 1));
    }

    @Test
    public void whenGet() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 1);
        simpleMap.put(2, 2);
        simpleMap.put(3, 3);
        assertThat(simpleMap.get(1), is(1));
        assertThat(simpleMap.get(2), is(2));
        assertThat(simpleMap.get(3), is(3));
    }

    @Test
    public void whenRemove() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 1);
        simpleMap.put(3, 1);
        assertTrue(simpleMap.remove(1));
        assertFalse(simpleMap.remove(2));
        simpleMap.put(2, 1);
        assertTrue(simpleMap.remove(2));
    }
}