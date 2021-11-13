package ru.job4j.iterator;

import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        Predicate<Integer> predicate = p -> p % 2 == 0;
        ListUtils.removeIf(input, predicate);
        assertThat(input, is(List.of(1)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        Predicate<Integer> predicate = p -> p % 2 == 0;
        ListUtils.replaceIf(input, predicate, 1);
        assertThat(input, is(List.of(1, 1, 1)));
    }

    @Test
    public void whenRemoveAllSame() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        List<Integer> controlList = new ArrayList<>(Arrays.asList(0, 1));
        ListUtils.removeAll(input, controlList);
        assertThat(input, is(List.of(2, 3)));
    }
}