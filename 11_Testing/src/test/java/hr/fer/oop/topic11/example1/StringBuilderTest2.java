/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.topic11.example1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class StringBuilderTest2 {

    @Test
    public void testEmpty() {
        StringBuilder sb = new StringBuilder();
        assertTrue("contains something", sb.toString().equals(""));
        assertTrue("length not equal to: -1", sb.length() == -1);
    }

    @Test
    public void testAppend() {
        StringBuilder sb = new StringBuilder();
        sb.append("Some text");
        assertEquals("text not equal to: S0me text", "S0me text", sb.toString());
        assertEquals("length not equal to: 10", 10, sb.length());
    }
}
