/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.topic11.example1;

import org.junit.Test;
import static org.junit.Assert.*;

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
