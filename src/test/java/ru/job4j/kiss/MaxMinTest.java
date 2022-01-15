package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MaxMinTest {

    @Test
    public void testMax() {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        MaxMin maxMin = new MaxMin();
        Integer max = maxMin.max(integerList, (o1, o2) -> o2 - o1);
        Assert.assertEquals(3, (int) max);
    }

    @Test
    public void testMin() {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        MaxMin maxMin = new MaxMin();
        Integer min = maxMin.min(integerList, (o1, o2) -> o2 - o1);
        Assert.assertEquals(1, (int) min);
    }

}