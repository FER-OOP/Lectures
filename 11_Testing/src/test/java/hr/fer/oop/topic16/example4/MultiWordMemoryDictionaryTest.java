package hr.fer.oop.topic16.example4;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MultiWordMemoryDictionaryTest {

    private MultiWordMemoryDictionary dictionary;

    @Before
    public void setUp() {
        dictionary = new MultiWordMemoryDictionary("osjećaj", "feeling", "osjećaj", "emotion");
    }

    @Test
    public void testGet() {
        assertThat(dictionary.get("osjećaj"), containsString("feeling"));
        assertThat(dictionary.get("osjećaj"), containsString("emotion"));
    }

    @Test
    public void testAdd() {
        assertThat(dictionary.get("miris"), is(nullValue()));
        dictionary.add("miris", "odor");
        dictionary.add("miris", "smell");
        assertThat(dictionary.get("miris"), allOf(containsString("odor"), containsString("smell")));//konjunkcija oba uspoređivača
    }

    @Test
    public void testRemove() {
        dictionary.remove("osjećaj","feeling");
        assertThat(dictionary.get("osjećaj"), not(containsString("feeling")));
        assertThat(dictionary.get("osjećaj"), containsString("emotion"));
    }

    @Test
    public void testSize() {
        assertThat(dictionary.size(), is(1));
        dictionary.add("stol", "table");
        assertThat(dictionary.size(), is(2));
        dictionary.remove("osjećaj","emotion");
        assertThat(dictionary.size(), is(2));        
    }
}
