/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.topic11.example1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class StringBuilderTest4 {

    private StringBuilder sb;

    @Before
    public void setUp() {
        sb = new StringBuilder();
    }

    @Test
    public void testEmpty() {
        assertTrue(sb.toString().equals(""));
        assertTrue(sb.length() == 0);
    }

    @Test
    public void testAppend() {
        sb.append("Some text");
        assertEquals("Some text", sb.toString());
        assertEquals(9, sb.length());
    }

    @Test
    public void testReverse() {
        sb.append("Some text");
        sb.reverse();
        assertEquals("txet emoS", sb.toString());
        assertEquals(9, sb.length());
    }

    @Test
    public void testInsert() {
        sb.append("Some text");
        sb.insert(5, "other ");
        assertEquals("Some other text", sb.toString());
        assertEquals(15, sb.length());
    }

    @Test
    public void testDelete() {
        sb.append("Some text");
        sb.delete(4, 9);
        assertEquals("Some", sb.toString());
        assertEquals(4, sb.length());
    }
    
    @Test
    public void testDeleteChatAt() {
        sb.append("Some text");
        sb.deleteCharAt(4);
        assertEquals("Sometext", sb.toString());
        assertEquals(8, sb.length());
    }

    @Test
    public void testReplace() {
        sb.append("Some text");
        sb.replace(5, 9, "characters");
        assertEquals("Some characters", sb.toString());
        assertEquals(15, sb.length());
    }

    @Test
    public void testLastIndexOf() {
        sb.append("Some text with some other text");
        int li = sb.lastIndexOf("text");
        assertEquals(26, li);
        li = sb.lastIndexOf("text", 9);
        assertEquals(5, li);
        li = sb.lastIndexOf("text", 0);
        assertEquals(-1, li);
    }
}
