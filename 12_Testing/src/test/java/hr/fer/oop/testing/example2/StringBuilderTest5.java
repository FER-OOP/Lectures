package hr.fer.oop.testing.example2;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringBuilderTest5 {

    private StringBuilder sb;

    @BeforeEach
    public void setUp() {
        sb = new StringBuilder();
    }

    @Test
    public void testEmpty() {
        assertThat(sb.toString(), is(""));
        assertThat(sb.length(), is(0));
    }

    @Test
    public void testAppend() {
        sb.append("Some text");
        assertThat(sb.toString(), is("Some text"));
        assertThat(sb.length(), is(9));
    }

    @Test
    public void testReverse() {
        sb.append("Some text");
        sb.reverse();
        assertThat(sb.toString(), is("txet emoS"));
        assertThat(sb.length(), is(9));
    }

    @Test
    public void testInsert() {
        sb.append("Some text");
        sb.insert(5, "other ");
        assertThat(sb.toString(), is("Some other text"));
        assertThat(sb.toString(), containsString("other"));
        assertThat(sb.length(), is(15));
    }

    @Test
    public void testDelete() {
        sb.append("Some text");
        sb.delete(4, 9);
        assertThat(sb.toString(), is("Some"));
        assertThat(sb.toString(), not(containsString("text")));
        assertThat(sb.length(), is(4));
    }

    @Test
    public void testDeleteCharAt() {
        sb.append("Some text");
        sb.deleteCharAt(4);
        assertThat(sb.toString(), is("Sometext"));
        assertThat(sb.toString(), not(containsString(" ")));
        assertThat(sb.length(), is(8));
    }

    @Test
    public void testReplace() {
        sb.append("Some text");
        sb.replace(5, 9, "characters");
        assertThat(sb.toString(), not(containsString("text")));
        assertThat(sb.toString(), containsString("characters"));
        assertThat(sb.toString(), is("Some characters"));
        assertThat(sb.length(), is(15));
    }

    @Test
    public void testLastIndexOf() {
        sb.append("Some text with some other text");
        int li = sb.lastIndexOf("text");
        assertThat(li, is(26));
        li = sb.lastIndexOf("text", 9);
        assertThat(li, is(5));
        li = sb.lastIndexOf("text", 0);
        assertThat(li, is(-1));
    }
}
