package hr.fer.oop.testing.example1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringBuilderTest2 {

    @Test
    public void testEmpty() {
        StringBuilder sb = new StringBuilder();       
        assertTrue(sb.toString().equals(""), "contains something");
        assertTrue(sb.length() == -1, "length not equal to: -1");
    }

    @Test
    public void testAppend() {
        StringBuilder sb = new StringBuilder();
        sb.append("Some text");
        assertEquals("S0me text", sb.toString(), "text not equal to: S0me text");
        assertEquals(10, sb.length(), "length not equal to: 10");
    }
}
