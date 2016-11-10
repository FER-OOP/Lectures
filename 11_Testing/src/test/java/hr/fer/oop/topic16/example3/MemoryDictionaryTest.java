package hr.fer.oop.topic16.example3;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class MemoryDictionaryTest {

    private Dictionary dictionary;

    @Before
    public void setUp() {
        dictionary = new MemoryDictionary("knjiga", "book", "stvar", "thing");
    }

    @Test
    public void testGet() {
        assertThat(dictionary.get("knjiga"), is("book"));
        assertThat(dictionary.get("stvar"), is("thing"));
    }

    @Test
    public void testAdd() {
        assertThat(dictionary.get("stol"), is(nullValue()));
        dictionary.add("stol", "table");
        assertThat(dictionary.get("stol"), is("table"));
    }

    @Test
    public void testRemove() {
        dictionary.remove("knjiga");
        assertThat(dictionary.get("knjiga"), is(nullValue()));
    }

    @Test
    public void testSize() {
        assertThat(dictionary.size(), is(2));
        dictionary.add("stol", "table");
        assertThat(dictionary.size(), is(3));
        dictionary.remove("knjiga");
        assertThat(dictionary.size(), is(2));        
    }
}
