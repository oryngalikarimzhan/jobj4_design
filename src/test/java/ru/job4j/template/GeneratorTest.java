package ru.job4j.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

public class GeneratorTest {

    @Ignore
    @Test
    public void generatorTest() {
        Generator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String result = generator.produce(template, map);
        String expected = "I am a Petr Arsentev, Who are you? ";
        Assert.assertThat(result, is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void generatorTestTemplate() {
        Generator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        String result = generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void generatorTestValueMap() {
        Generator generator = new SimpleGenerator();
        String template = "I am a ${name}";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String result = generator.produce(template, map);
    }
}