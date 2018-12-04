package hr.fer.oop.testing.example1;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringBuilderTest1 {

    @Test
    public void testEmpty() {
        StringBuilder sb = new StringBuilder();
        assertTrue(sb.toString().equals(""));
        assertTrue(sb.length() == 0);
    }

    @Test
    public void testAppend() {
        StringBuilder sb = new StringBuilder();
        sb.append("Some text");
        assertEquals("Some text", sb.toString());
        assertEquals(9, sb.length());
    }
}
