package hr.fer.oop.testing.example1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringBuilderTest3 {

    @Test
    public void testProvokeException() {
        StringBuilder sb = null;
        sb.append("Some text");
        assertEquals("Some text", sb.toString());
    }
}
